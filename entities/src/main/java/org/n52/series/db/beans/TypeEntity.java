package org.n52.series.db.beans;

public abstract class TypeEntity<T> extends PkidEntity {

    public static final String TYPE = "type";

    private String type;

    public String getType() {
        return this.type;
    }

    @SuppressWarnings("unchecked")
    public T setType(String type) {
        this.type = type;
        return (T)this;
    }

    public boolean isSetType() {
        return getType() != null && !getType().isEmpty();
    }
}
