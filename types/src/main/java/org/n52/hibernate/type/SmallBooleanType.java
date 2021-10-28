/*
 * Copyright 2015-2021 52°North Spatial Information Research GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.hibernate.type;

import java.io.Serializable;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.PrimitiveType;
import org.hibernate.type.descriptor.java.BooleanTypeDescriptor;
import org.hibernate.type.descriptor.sql.SmallIntTypeDescriptor;

public class SmallBooleanType extends AbstractSingleColumnStandardBasicType<Boolean>
        implements PrimitiveType<Boolean>, DiscriminatorType<Boolean> {

    public static final SmallBooleanType INSTANCE = new SmallBooleanType();

    private static final long serialVersionUID = 5426388285620763702L;

    private String name = "small_boolean";

    public SmallBooleanType() {
        super(new SmallIntTypeDescriptor(), BooleanTypeDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<?> getPrimitiveClass() {
        return Boolean.class;
    }

    @Override
    public Serializable getDefaultValue() {
        return Boolean.FALSE;
    }

    @Override
    public Boolean stringToObject(String string) {
        return fromString(string);
    }

    @Override
    public String objectToSQLString(Boolean value, Dialect dialect) {
        return value ? "1" : "0";
    }

}
