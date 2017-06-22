package org.n52.series.db.beans;

public abstract class PkidEntity {

    public static final String PROPERTY_PKID = "pkid";

    /**
     * A serial primary key.
     */
    private Long pkid;

    public Long getPkid() {
        return pkid;
    }

    public void setPkid(Long pkid) {
        this.pkid = pkid;
    }
}
