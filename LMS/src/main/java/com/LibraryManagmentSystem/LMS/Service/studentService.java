package com.LibraryManagmentSystem.LMS.Service;

import com.LibraryManagmentSystem.LMS.DTO.RequestStudentDto;
import com.LibraryManagmentSystem.LMS.DTO.StudentResponseDto;
import com.LibraryManagmentSystem.LMS.Entity.Student;
import com.LibraryManagmentSystem.LMS.Entity.libraryCard;
import com.LibraryManagmentSystem.LMS.Enum.Status;
import com.LibraryManagmentSystem.LMS.Repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {
    @Autowired
    studentRepo repo;
   public void add(RequestStudentDto student){
       Student student1=new Student();
       student1.setName(student.getName());
       student1.setEmailId(student.getEmailId());
       student1.setDepartment(student.getDepartment());
       libraryCard card=new libraryCard();
       card.setExpiryDate("29/03/2024");
       card.setStudent(student1);
       card.setStatus(Status.ACTIVATED);
       student1.setCard(card);
       repo.save(student1);
   }
   public StudentResponseDto getStudentByEmailId(String emailId){
       Student student=repo.findByEmailId(emailId);
       StudentResponseDto studentResponseDto=new StudentResponseDto();
       studentResponseDto.setEmailId(student.getEmailId());
       studentResponseDto.setName(student.getName());
       return studentResponseDto;
   }
   public void upadateStudentEmailId(int id,String newEmail){
       Student student=repo.findById(id).get();
       student.setEmailId(newEmail);
       repo.save(student);
   }
   public void deleteStudentById(int id){
       repo.deleteById(id);
   }
   public List<Student> findAll(){
       return repo.findAll();
   }
}
