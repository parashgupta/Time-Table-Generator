package com.demo.timetable.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {
    
    @Id
	private Integer cid;
	private String cname;

    public Course()
    {
        super();
    }
    
    public Course(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }
    
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

}
