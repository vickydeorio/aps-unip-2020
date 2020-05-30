package main.java.com.aps.cc.unip.model;

public class Nota extends Aluno{
    private double grade;

    private double min;
    private double max;

    public Nota(){
        new Nota(0d, 0d, 10d);
    }

    public Nota(Double grade){
        new Nota(grade, 0d, 10d);
    }

    public Nota(Double grade, Double min, Double max){
        setGrade(grade);
        setMin(min);
        setMax(max);
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if(grade >= getMin() && grade <= getMax()) {
            this.grade = grade;
        }
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
