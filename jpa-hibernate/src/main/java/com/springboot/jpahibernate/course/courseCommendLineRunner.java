package com.springboot.jpahibernate.course;

import com.springboot.jpahibernate.course.jdbc.courseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class courseCommendLineRunner implements CommandLineRunner {

    @Autowired
    private courseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.insertCourse(new course(1,"Learn AWS","AWS_Instructor"));
        repository.insertCourse(new course(2,"Learn DevOps","DevOps_Instructor"));
        repository.insertCourse(new course(3,"Learn Java","Java_Instructor"));
        repository.insertCourse(new course(4,"Learn Python","Python_Instructor"));

        //courseJdbcRepository.deleteCourse(2);

       course c1 =repository.findCourseById(3);
        System.out.print(repository.findCourseById(3));
    }

}
