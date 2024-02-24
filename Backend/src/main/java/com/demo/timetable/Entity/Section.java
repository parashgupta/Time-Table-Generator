package com.demo.timetable.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="section")
public class Section {

    @Id
    private Integer sec_id;
    private String sec_name;
    private Integer csid_f;

    public Section()
    {
        super();
    }

    public Section(Integer sec_id,String sec_name,Integer csid_f)
    {
        this.sec_id=sec_id;
        this.sec_name=sec_name;
        this.csid_f=csid_f;
    }

    
    

    /**
     * @return Integer return the sec_id
     */
    public Integer getSec_id() {
        return sec_id;
    }

    /**
     * @param sec_id the sec_id to set
     */
    public void setSec_id(Integer sec_id) {
        this.sec_id = sec_id;
    }

    /**
     * @return String return the sec_name
     */
    public String getSec_name() {
        return sec_name;
    }

    /**
     * @param sec_name the sec_name to set
     */
    public void setSec_name(String sec_name) {
        this.sec_name = sec_name;
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
