package org.markandey.springsecuritydemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.markandey.springsecuritydemo.Model.StudentClass;
import org.markandey.springsecuritydemo.service.StudentService;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stud")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }

//    @GetMapping("csrf-token")
//    public CsrfToken getCsrfToken(HttpServletRequest request){
//        return (CsrfToken) request.getAttribute("_csrf");
//    }

    @GetMapping("load")
    public String load(){
        service.loadData();
        return "Loaded Successfully";
    }

    @GetMapping("students")
    public List<StudentClass> loadAll(){
        return service.showAll();
    }

    @GetMapping("student/{id}")
    public StudentClass show(@PathVariable int id){
        return service.StudentFindById(id);
    }

    @PostMapping("student")
    public StudentClass studentAdd(@RequestBody StudentClass student){
        service.StudentAdd(student);
        return service.StudentFindById(student.getStudent_id());
    }

    @PutMapping("student")
    public StudentClass studentupdate(@RequestBody StudentClass student){
        service.updateStudent(student);
        return service.StudentFindById(student.getStudent_id());
    }

    @DeleteMapping("student/{id}")
    public void studentdelete(@PathVariable int id){
        service.deleteStudentById(id);
    }
}
