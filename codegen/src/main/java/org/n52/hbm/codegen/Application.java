
package org.n52.hbm.codegen;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Provider;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.boot.model.TypeContributor;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.spi.TypeContributorList;
import org.hibernate.type.BasicType;
import org.n52.hibernate.type.SmallBooleanType;
import org.n52.series.db.beans.QFeatureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.querydsl.jpa.codegen.JPADomainExporter;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.codegen.SQLCodegenModule;
import com.querydsl.sql.codegen.SpatialSupport;
import com.querydsl.sql.spatial.PostGISTemplates;
import com.querydsl.sql.spring.SpringConnectionProvider;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Autowired
    @Qualifier("entityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean
    public Configuration querydslConfiguration() {
        SQLTemplates templates = PostGISTemplates.builder()
                .build();
        return new Configuration(templates);
    }
    
    @Bean
    public SQLQueryFactory queryFactory(DataSource dataSource) {
        Provider<Connection> provider = new SpringConnectionProvider(dataSource);
        return new SQLQueryFactory(querydslConfiguration(), provider);
    }
    
    @Bean
    @Primary
    public SessionFactory sessionFactory() {
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource datasource, JpaProperties properties)
            throws IOException {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setJpaPropertyMap(addCustomTypes(properties));
        emf.setDataSource(datasource);
        emf.afterPropertiesSet();
        return emf.getNativeEntityManagerFactory();
    }
    
    private Map<String, Object> addCustomTypes(JpaProperties jpaProperties) {
        Map<String, Object> properties = new HashMap<>(jpaProperties.getProperties());
        properties.put(EntityManagerFactoryBuilderImpl.TYPE_CONTRIBUTORS, createTypeContributorsList());
        return properties;
    }

    private TypeContributorList createTypeContributorsList() {
        return (TypeContributorList) () -> Arrays.asList(toTypeContributor(SmallBooleanType.INSTANCE, "small_boolean"));
    }

    private <T extends BasicType> TypeContributor toTypeContributor(T type, String... keys) {
        return (typeContributions, serviceRegistry) -> typeContributions.contributeType(type, keys);
    }

    @Override
    public void run(String... args) throws Exception {
        createExporter("Q").execute();
    }

    private JPADomainExporter createExporter(String prefix) {
//        SpatialSupport.addSupport(new SQLCodegenModule());
        return new JPADomainExporter(prefix, new File("src/main/java"), entityManagerFactory.getMetamodel());
    }

}
