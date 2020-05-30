package com.aps.cc.unip.DAO;

import com.aps.cc.unip.model.Aluno;
import com.aps.cc.unip.model.Rendimento;

import java.util.ArrayList;
import java.util.List;

public class RendimentoDAO implements Dao<Rendimento> {
    List<Rendimento> grades = new ArrayList<>();

    public Rendimento getByStudent(Aluno aluno){
        for (Rendimento r: grades){
            if(r.getStudentId() == aluno.getStudentId()){
                return r;
            }
        }

        return null;
    }

    @Override
    public void save(Rendimento rendimento) {
        if(!grades.contains(rendimento)){
            grades.add(rendimento);
        }
    }

    public void update(Rendimento rendimento){
        for(Rendimento r: grades){
            if(r.getStudentId() == rendimento.getStudentId() &&
                r.getCurso().equals(rendimento.getCurso())){

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
    public Rendimento get(long id) {
        return null;
    }
}
