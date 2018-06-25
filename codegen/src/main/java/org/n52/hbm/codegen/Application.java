
package org.n52.hbm.codegen;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.Metamodel;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.boot.model.TypeContributor;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.spi.TypeContributorList;
import org.hibernate.type.BasicType;
import org.n52.hibernate.type.SmallBooleanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.querydsl.jpa.codegen.JPADomainExporter;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    @Qualifier("entityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

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
        final Metamodel metamodel = entityManagerFactory.getMetamodel();
//        return new JPADomainExporter(prefix, new File("target/generated-sources/java"), metamodel);
        return new JPADomainExporter(prefix, new File("src/main/java"), metamodel);
    }

}
