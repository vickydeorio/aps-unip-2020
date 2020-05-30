package com.aps.cc.unip.utils;

import com.aps.cc.unip.model.Aluno;

import java.util.List;

public class IdGenerator {
    private int id;

    public IdGenerator(){
        this.setId(0);
    }

    public int getId(){
        this.id++;

        return this.id;
    }

    public void AtuId(List<Aluno> student)
    {

        for(Aluno s : student)
        {
            setId(s.getStudentId());
        }
    }

    public void setId(int id) {
        this.id = id;
    }
}
