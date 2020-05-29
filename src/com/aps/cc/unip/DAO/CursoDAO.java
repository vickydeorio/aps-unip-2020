package com.aps.cc.unip.DAO;

import com.aps.cc.unip.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoDAO implements Dao<Curso> {
    private List<Curso> courses = new ArrayList<>();

    public void insert(List<Curso> courses){
        this.courses = courses;
    }

    @Override
    public Curso get(long id) {
        for (Curso c: courses){
            if (c.getStudentId() == id){
                return c;
            }
        }

        return null;
    }

    public Curso get(Curso curso){
        for (Curso c:
             courses) {
            if(c.equals(curso)){
                return c;
            }
        }

        return null;
    }

    @Override
    public List<Curso> getAll() {
        return courses;
    }

    @Override
    public void save(Curso curso) {
        if(!courses.contains(curso)){
            courses.add(curso);
        }
    }

    @Override
    public void delete(Curso curso) {
        courses.remove(curso);
    }
}
