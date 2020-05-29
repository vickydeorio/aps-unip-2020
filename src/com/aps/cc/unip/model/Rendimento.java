package com.aps.cc.unip.model;

import com.aps.cc.unip.enums.TipoCurso;

public class Rendimento extends Aluno{
    private Double[] efficiency;

    private int studentId;

    private Double np1;
    private Double np2;
    private Double sub;
    private Double ex;

    private Nota average;

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
        return average.getGrade() >= 5d;
    }

    public void calculateAverage(){

        if(sub > np1 || sub > np2){
            //Retorna o menor entre os dois valoress
            setSub(Math.min(np1, np2));
        }

        //Média entre as notas da np1 e np2
        double initialAverage = (np1 + np2) / 2d;
        double finalAverage;
        double cut = getCourseType().equals(TipoCurso.graduacao) ? 7d: 5d;

        if(initialAverage >= cut){
            finalAverage = initialAverage;
        }else{
            finalAverage = ex + initialAverage / 2d;

            if(getCourseType().equals(TipoCurso.pos_graduacao)){
                finalAverage = Math.min(finalAverage, 5d);
            }
        }

        average = new Nota(finalAverage);

    }

    public Double[] getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Double[] efficiency) {
        this.efficiency = efficiency;
    }

    public Double getNp1() {
        return np1;
    }

    public void setNp1(Double np1) {
        this.np1 = np1;
    }

    public Double getNp2() {
        return np2;
    }

    public void setNp2(Double np2) {
        this.np2 = np2;
    }

    public Double getSub() {
        return sub;
    }

    public void setSub(Double sub) {
        this.sub = sub;
    }

    public Double getEx() {
        return ex;
    }

    public void setEx(Double ex) {
        this.ex = ex;
    }

    @Override
    public int getStudentId() {
        return studentId;
    }

    @Override
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Id Aluno: " + studentId +
                ", NP1: " + np1 +
                ", NP2: " + np2 +
                ", Sub: " + sub +
                ", Ex: " + ex;
    }
}
