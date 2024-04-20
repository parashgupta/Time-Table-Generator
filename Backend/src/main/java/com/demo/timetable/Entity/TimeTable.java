package com.demo.timetable.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="timetable")
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ttid_pk;
    private Integer tableid_fk;
    private String day;
    private String ten;
    private String eleven;
    private String twelve;
    private String one;
    private String two;
    private String three;

    public TimeTable()
    {
        super();
    }

    public TimeTable(Integer ttid_pk,Integer tableid_fk,String day,String ten,String eleven,String twelve,String one,String two,String three)
    {
        this.ttid_pk=ttid_pk;
        this.tableid_fk=tableid_fk;
        this.day=day;
        this.ten=ten;
        this.eleven=eleven;
        this.twelve=twelve;
        this.one=one;
        this.two=two;
        this.three=three;
    }

    


    /**
     * @return Integer return the ttid_pk
     */
    public Integer getTtid_pk() {
        return ttid_pk;
    }

    /**
     * @param ttid_pk the ttid_pk to set
     */
    public void setTtid_pk(Integer ttid_pk) {
        this.ttid_pk = ttid_pk;
    }

    /**
     * @return Integer return the tableid_fk
     */
    public Integer getTableid_fk() {
        return tableid_fk;
    }

    /**
     * @param tableid_fk the tableid_fk to set
     */
    public void setTableid_fk(Integer tableid_fk) {
        this.tableid_fk = tableid_fk;
    }

    /**
     * @return String return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return String return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return String return the eleven
     */
    public String getEleven() {
        return eleven;
    }

    /**
     * @param eleven the eleven to set
     */
    public void setEleven(String eleven) {
        this.eleven = eleven;
    }

    /**
     * @return String return the twelve
     */
    public String getTwelve() {
        return twelve;
    }

    /**
     * @param twelve the twelve to set
     */
    public void setTwelve(String twelve) {
        this.twelve = twelve;
    }

    /**
     * @return String return the one
     */
    public String getOne() {
        return one;
    }

    /**
     * @param one the one to set
     */
    public void setOne(String one) {
        this.one = one;
    }

    /**
     * @return String return the two
     */
    public String getTwo() {
        return two;
    }

    /**
     * @param two the two to set
     */
    public void setTwo(String two) {
        this.two = two;
    }

    /**
     * @return String return the three
     */
    public String getThree() {
        return three;
    }

    /**
     * @param three the three to set
     */
    public void setThree(String three) {
        this.three = three;
    }

}
