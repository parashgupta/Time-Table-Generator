package com.demo.timetable.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sub_mapping")
public class SubMapping {
    
    @Id
    private Integer id;
    private String sid_f;
    private Integer csid_f;

    public SubMapping()
    {
        super();
    }

    public SubMapping(Integer id,String sid_f,Integer csid_f)
    {
        this.id=id;
        this.sid_f=sid_f;
        this.csid_f=csid_f;
    }

    

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the sid_f
     */
    public String getSid_f() {
        return sid_f;
    }

    /**
     * @param sid_f the sid_f to set
     */
    public void setSid_f(String sid_f) {
        this.sid_f = sid_f;
    }

    /**
     * @return Integer return the csid_f
     */
    public Integer getCsid_f() {
        return csid_f;
    }

    /**
     * @param csid_f the csid_f to set
     */
    public void setCsid_f(Integer csid_f) {
        this.csid_f = csid_f;
    }

}
