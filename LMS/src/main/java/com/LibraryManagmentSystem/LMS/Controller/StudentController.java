package com.LibraryManagmentSystem.LMS.Controller;

import com.LibraryManagmentSystem.LMS.DTO.RequestStudentDto;
import com.LibraryManagmentSystem.LMS.DTO.StudentResponseDto;
import com.LibraryManagmentSystem.LMS.Entity.Student;
import com.LibraryManagmentSystem.LMS.Service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    studentService service;
    @PostMapping("/add")
    public String addStudent(@RequestBody RequestStudentDto student){
        service.add(student);
        return "Student added ";
    }
    @GetMapping("/get")
    public StudentResponseDto findByEmailId(@RequestParam("emailId") String emailId){
        return service.getStudentByEmailId(emailId);
    }
    @PutMapping("/Update")
    public ResponseEntity updateStudentEmailId(@RequestParam("rollNo") int rollNo, @RequestParam("emailId") String emailId){
        try {
            service.upadateStudentEmailId(rollNo, emailId);
            return new ResponseEntity("Updated Successfuly", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping("delete-by-Id")
    public ResponseEntity deleteStudentById(@RequestParam("Id") int id){
        try{
            service.deleteStudentById(id);
            return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("get-all-students")
    public List<Student> findAllStudents(){
        return service.findAll();
    }
}
