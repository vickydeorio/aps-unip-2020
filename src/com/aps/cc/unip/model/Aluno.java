package com.aps.cc.unip.model;

public class Aluno{
    private int studentId;
    private String studentName;

    public Aluno(int studentId, String studentName){
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public Aluno(){}

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Aluno " + studentName + ", ID: " + studentId;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Aluno)){
            return false;
        }

        Aluno aluno = (Aluno) o;

        if(this.studentId == aluno.studentId) {
            return true;
        }

        return false;
    }
}
