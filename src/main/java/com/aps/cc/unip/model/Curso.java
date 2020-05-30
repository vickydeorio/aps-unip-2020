package main.java.com.aps.cc.unip.model;

import main.java.com.aps.cc.unip.enums.TipoCurso;

public class Curso {
    private String courseName;
    private TipoCurso courseType;
    private int courseYear;

    public Curso(String courseName, TipoCurso courseType, int courseYear){
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseYear = courseYear;
    }

    public Curso(){}

    private int id;

    public int getId(){
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
                courseName.equals(curso.getCourseName()) &&
                courseType == curso.courseType;
    }

    @Override
    public String toString() {
        return "Curso " + courseName + ": " + courseType + ", " + courseYear;
    }

    public String strGrade(){
        return courseName + "_" + courseType + "_" + courseYear + ".csv";
    }

    public String[] toArray(){
        String[] arr = new String[3];

        arr[0] = getCourseName();
        arr[1] = getCourseType() + "";
        arr[2] = getCourseYear() + "";

        return arr;
    }
}
