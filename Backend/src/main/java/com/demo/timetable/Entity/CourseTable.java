package com.demo.timetable.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="coursetable")
public class CourseTable {

    @Id
    private Integer tableid_pk;
    private Integer csid_fk;
    private Integer secid_fk;

    public CourseTable()
    {
        super();
    }

    public CourseTable(Integer tableid_pk,Integer csid_fk,Integer secid_fk)
    {
        this.tableid_pk=tableid_pk;
        this.csid_fk=csid_fk;
        this.secid_fk=secid_fk;
    }
    


    /**
     * @return Integer return the tableid_pk
     */
    public Integer getTableid_pk() {
        return tableid_pk;
    }

    /**
     * @param tableid_pk the tableid_pk to set
     */
    public void setTableid_pk(Integer tableid_pk) {
        this.tableid_pk = tableid_pk;
    }

    /**
     * @return Integer return the csid_fk
     */
    public Integer getCsid_fk() {
        return csid_fk;
    }

    /**
     * @param csid_fk the csid_fk to set
     */
    public void setCsid_fk(Integer csid_fk) {
        this.csid_fk = csid_fk;
    }

    /**
     * @return Integer return the secid_fk
     */
    public Integer getSecid_fk() {
        return secid_fk;
    }

    /**
     * @param secid_fk the secid_fk to set
     */
    public void setSecid_fk(Integer secid_fk) {
        this.secid_fk = secid_fk;
    }

}
