package com.demo.timetable.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
    
    @Id
    private String sid;
    private String sname;
    private Boolean practical;
    private Integer credit_NP;
    private Integer cr_id;

    public Subject()
    {
        super();
    }
    public Subject(String sid,String sname,Boolean practical,Integer credit_NP,Integer cr_id)
    {
        this.sid=sid;
        this.sname=sname;
        this.practical=practical;
        this.credit_NP=credit_NP;
        this.cr_id=cr_id;
    }

    

    /**
     * @return String return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * @return String return the sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * @param sname the sname to set
     */
    public void setSname(String sname) {
        this.sname = sname;
    }

    /**
     * @return Boolean return the practical
     */
    public Boolean isPractical() {
        return practical;
    }

    /**
     * @param practical the practical to set
     */
    public void setPractical(Boolean practical) {
        this.practical = practical;
    }

    /**
     * @return Integer return the credit_NP
     */
    public Integer getCredit_NP() {
        return credit_NP;
    }

    /**
     * @param credit_NP the credit_NP to set
     */
    public void setCredit_NP(Integer credit_NP) {
        this.credit_NP = credit_NP;
    }

    /**
     * @return Integer return the cr_id
     */
    public Integer getCr_id() {
        return cr_id;
    }

    /**
     * @param cr_id the cr_id to set
     */
    public void setCr_id(Integer cr_id) {
        this.cr_id = cr_id;
    }

}
