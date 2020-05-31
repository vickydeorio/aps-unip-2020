package com.aps.cc.unip.model;

import com.aps.cc.unip.enums.TipoCurso;

public class Rendimento extends Aluno{
    private Curso curso;

    private Double np1;
    private Double np2;
    private Double sub;
    private Double ex;

    private Double average;

    public Rendimento(int studentId, Double np1, Double np2, Double sub, Double ex){
        setStudentId(studentId);
        setNp1(np1);
        setNp2(np2);
        setSub(sub);
        setEx(ex);
    }

    public Rendimento(String studentId, String np1, String np2, String sub, String ex){
        this(Integer.parseInt(studentId),
                Double.parseDouble(np1),
                Double.parseDouble(np2),
                Double.parseDouble(sub),
                Double.parseDouble(ex));
    }

    public Boolean isApproved(){
        calculateAverage();
        double cut = getCurso().getCourseType().equals(TipoCurso.graduacao) ? 7d: 5d;

        return average >= cut;
    }

    public void calculateAverage(){

        if(np1 == 0){
            np1 = sub;
        }else if(np2 == 0){
            np2 = sub;
        }

        //Média entre as notas da np1 e np2
        double initialAverage = (np1 + np2) / 2d;
        double finalAverage;
        double cut = getCurso().getCourseType().equals(TipoCurso.graduacao) ? 7d: 5d;

        if(initialAverage >= cut){
            finalAverage = initialAverage;
        }else{
            finalAverage = ex + initialAverage / 2d;

            if(curso.getCourseType().equals(TipoCurso.pos_graduacao)){
                finalAverage = Math.min(finalAverage, 5d);
            }
        }

        average = finalAverage;

    }

    public Double getNp1() {
        return np1;
    }

    public void setNp1(Double np1) {

        if (np1 >= 0d && np1 <= 10d){
            this.np1 = np1;
        }

    }

    public Double getNp2() {
        return np2;
    }

    public void setNp2(Double np2) {

        if (np2 >= 0d && np2 <= 10d){
            this.np2 = np2;
        }
    }

    public Double getSub() {
        return sub;
    }

    public void setSub(Double sub) {
        if(sub >= 0d && sub <= 10d)
        {
            this.sub = sub;
        }
    }

    public Double getEx() {
        return ex;
    }

    public void setEx(Double ex) {

        if(ex >= 0d && ex <= 10d)
        {
            this.ex = ex;
        }

    }

    @Override
    public String toString() {
        return "Id Aluno: " + super.getStudentId() +
                ", NP1: " + np1 +
                ", NP2: " + np2 +
                ", Sub: " + sub +
                ", Ex: " + ex;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String[] toArray(){
        String[] arr = new String[5];

        arr[0] = getStudentId() + "";
        arr[1] = getNp1() + "";
        arr[2] = getNp2() + "";
        arr[3] = getSub() + "";
        arr[4] = getEx() + "";

        return arr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rendimento rendimento = (Rendimento) o;
        return rendimento.getStudentId() == this.getStudentId() &&
                rendimento.getCurso().equals(this.getCurso());
    }
}
