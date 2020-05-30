package com.aps.cc.unip.DAO;

import com.aps.cc.unip.exceptions.AlunoInvalidoException;
import com.aps.cc.unip.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO implements Dao<Aluno> {
    private List<Aluno> students = new ArrayList<>();

    public void insert(List<Aluno> students){
        this.students = students;
    }

    @Override
    public Aluno get(int id) {
        for (Aluno a: students){
            if (a.getStudentId() == id){
                return a;
            }
        }

        return null;
    }

    @Override
    public List<Aluno> getAll() {
        return students;
    }

    @Override
    public void save(Aluno aluno) {
        for(Aluno a: students){
            if(a.equals(aluno)){
                return;
            }
        }

        students.add(aluno);
    }

    public void update(int studentId, String newName) throws AlunoInvalidoException {
        for(Aluno a: students){
            if(a.getStudentId() == studentId){
                a.setStudentName(newName);
                return;
            }
        }

        throw new AlunoInvalidoException();
    }

    @Override
    public void delete(Aluno aluno) throws AlunoInvalidoException {
        boolean isRemoved = students.remove(aluno);

        if(!isRemoved){
            throw new AlunoInvalidoException();
        }
    }
}
