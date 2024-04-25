package com.demo.timetable.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="allotment")
public class Allotment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer al_id;
    private String fid_fk;
    private String sid_fk;
    private Integer csid_fk;
    private String time;

    public Allotment()
    {
        super();

    }
    public Allotment(Integer al_id,String fid_fk,String sid_fk,Integer csid_fk,String time)
    {
        this.al_id=al_id;
        this.fid_fk=fid_fk;
        this.sid_fk=sid_fk;
        this.csid_fk=csid_fk;
        this.time=time;
    }

    

    /**
     * @return Integer return the al_id
     */
    public Integer getAl_id() {
        return al_id;
    }

    /**
     * @param al_id the al_id to set
     */
    public void setAl_id(Integer al_id) {
        this.al_id = al_id;
    }

    /**
     * @return String return the fid_fk
     */
    public String getFid_fk() {
        return fid_fk;
    }

    /**
     * @param fid_fk the fid_fk to set
     */
    public void setFid_fk(String fid_fk) {
        this.fid_fk = fid_fk;
    }

    /**
     * @return String return the sid_fk
     */
    public String getSid_fk() {
        return sid_fk;
    }

    /**
     * @param sid_fk the sid_fk to set
     */
    public void setSid_fk(String sid_fk) {
        this.sid_fk = sid_fk;
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
     * @return String return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

}
