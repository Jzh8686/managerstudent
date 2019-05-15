package com.example.majormanage.entity;

import javax.persistence.*;

@Entity
public class School {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int schoolid;
    @Column(name = "schoolname")
    String schoolname;
    @Column(name = "schooljianpin")
    String schooljianpin;

    public int getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getSchooljianpin() {
        return schooljianpin;
    }

    public void setSchooljianpin(String schooljianpin) {
        this.schooljianpin = schooljianpin;
    }
}
