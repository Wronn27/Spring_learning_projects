package org.markandey.springsecuritydemo.service;

import org.markandey.springsecuritydemo.Model.StudentClass;
import org.markandey.springsecuritydemo.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepo repo;

    public StudentService(StudentRepo repo) {
        this.repo=repo;
    }

    public void loadData(){
        List<StudentClass> list=new ArrayList<>(Arrays.asList(

                new StudentClass(1,"Markandey","Backend development"),
                new StudentClass(2,"Rajesh","PAinting"),
                new StudentClass(3,"Markandey","Medicine")
        ));
        repo.saveAll(list);
    }

    public void StudentAdd(StudentClass student){
        repo.save(student);
    }

    public StudentClass StudentFindById(int id){
        return repo.findById(id).orElse(new StudentClass());
    }

    public List<StudentClass> showAll(){
        return repo.findAll();
    }

    public StudentClass updateStudent(StudentClass student){
        return repo.save(student);
    }

    public void deleteStudentById(int id){
        repo.deleteById(id);
    }

}
