package com.demo.timetable.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="credit_P")
public class CreditP {

    @Id
    private Integer cr_id;
    private Integer credit;
    private Integer LT;
    private Integer P;

    public CreditP(){
        super();
    }
    public CreditP(Integer cr_id,Integer credit,Integer LT,Integer P){
        this.cr_id=cr_id;
        this.credit=credit;
        this.LT=LT;
        this.P=P;
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

    /**
     * @return Integer return the credit
     */
    public Integer getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    /**
     * @return Integer return the LT
     */
    public Integer getLT() {
        return LT;
    }

    /**
     * @param LT the LT to set
     */
    public void setLT(Integer LT) {
        this.LT = LT;
    }

    /**
     * @return Integer return the P
     */
    public Integer getP() {
        return P;
    }

    /**
     * @param P the P to set
     */
    public void setP(Integer P) {
        this.P = P;
    }

}
