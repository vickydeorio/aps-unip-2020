package com.aps.cc.unip.DAO;

import com.aps.cc.unip.model.Aluno;
import com.aps.cc.unip.model.Curso;
import com.aps.cc.unip.model.Rendimento;

import java.util.ArrayList;
import java.util.List;

public class RendimentoDAO implements Dao<Rendimento> {
    List<Rendimento> grades = new ArrayList<>();

    public void insert(List<Rendimento> grades){
        this.grades = grades;
    }

    public Rendimento getByStudent(Aluno aluno){
        for (Rendimento r: grades){
            if(r.getStudentId() == aluno.getStudentId()){
                return r;
            }
        }

        return null;
    }

    public List<Rendimento> getByCourse(Curso curso){
        List<Rendimento> gradesTemp = new ArrayList<>();

        for (Rendimento r: grades){
            if(r.getCurso().equals(curso)){
                gradesTemp.add(r);
            }
        }

        return !gradesTemp.isEmpty()? gradesTemp: null;
    }

    @Override
    public void save(Rendimento rendimento) {

        for(Rendimento r: grades){
            if (!r.equals(rendimento)){
                grades.add(rendimento);
                return;
            }
        }
    }

    public void update(Rendimento rendimento){
        for(Rendimento r: grades){
            if(r.equals(rendimento)){

                r.setNp1(rendimento.getNp1());
                r.setNp2(rendimento.getNp2());
                r.setSub(rendimento.getSub());
                r.setEx(rendimento.getEx());

                r.calculateAverage();
            }
        }
    }

    @Override
    public void delete(Rendimento rendimento) {
        grades.remove(rendimento);
    }

    @Override
    public List<Rendimento> getAll() {
        return grades;
    }

    @Override
    public Rendimento get(int id) {
        return null;
    }
}
