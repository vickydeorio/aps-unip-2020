package com.aps.cc.unip.model;

import com.aps.cc.unip.enums.TipoCurso;

import java.util.Objects;

public class Curso {
    private String courseName;
    private TipoCurso courseType;
    private int courseYear;

    private int id;

    public int getStudentId(){
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String studentName) {
        this.courseName = studentName;
    }

    public TipoCurso getCourseType() {
        return courseType;
    }

    public void setCourseType(TipoCurso courseType) {
        this.courseType = courseType;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return courseYear == curso.courseYear &&
                Objects.equals(courseName, curso.courseName) &&
                courseType == curso.courseType;
    }

    @Override
    public String toString() {
        return "Curso " + courseName + ": " + courseType + ", " + courseYear;
    }
}
