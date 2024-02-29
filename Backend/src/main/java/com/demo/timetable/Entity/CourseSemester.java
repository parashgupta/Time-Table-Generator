package com.demo.timetable.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="course_semester")
public class CourseSemester {
    
    @Id
    private Integer csid;
    private Integer cid_f;
    private String semester;
    private Boolean section;

    @ManyToOne
    @JoinColumn(name = "cid_f", referencedColumnName="cid", insertable = false, updatable = false)
    private Course course;

    public CourseSemester()
    {
        super();
    }
    public CourseSemester(Integer csid,Integer cid_f,String semester,Boolean section)
    {
        this.csid=csid;
        this.cid_f=cid_f;
        this.semester=semester;
        this.section=section;
    }

    


    /**
     * @return Integer return the csid
     */
    public Integer getCsid() {
        return csid;
    }

    /**
     * @param csid the csid to set
     */
    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    /**
     * @return Integer return the cid_f
     */
    public Integer getCid_f() {
        return cid_f;
    }

    /**
     * @param cid_f the cid_f to set
     */
    public void setCid_f(Integer cid_f) {
        this.cid_f = cid_f;
    }

    /**
     * @return String return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * @return Boolean return the section
     */
    public Boolean isSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(Boolean section) {
        this.section = section;
    }

}
