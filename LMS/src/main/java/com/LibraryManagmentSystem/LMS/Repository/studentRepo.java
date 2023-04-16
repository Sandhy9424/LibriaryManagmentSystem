package com.LibraryManagmentSystem.LMS.Repository;

import com.LibraryManagmentSystem.LMS.Entity.Student;
import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<Student,Integer> {
    Student findByEmailId(String emailId);
}
