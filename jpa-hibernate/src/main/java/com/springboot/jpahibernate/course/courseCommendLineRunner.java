package com.springboot.jpahibernate.course;

import com.springboot.jpahibernate.course.jdbc.courseJdbcRepository;
import com.springboot.jpahibernate.course.jpa.courseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class courseCommendLineRunner implements CommandLineRunner {

    @Autowired
    private courseJdbcRepository repository_jdbc;

    @Autowired
    private courseJpaRepository repository_jpa;

    @Autowired
    private courseSpringDataJpa repository_springDataJpa;

    @Override
    public void run(String... args) throws Exception {

        repository_jdbc.insertCourse(new course(1, "Learn AWS", "AWS_Instructor"));
        repository_jdbc.insertCourse(new course(2, "Learn DevOps", "DevOps_Instructor"));
        repository_jdbc.insertCourse(new course(3, "Learn Java", "Java_Instructor"));
        repository_jdbc.insertCourse(new course(4, "Learn Python", "Python_Instructor"));

        //courseJdbcRepository.deleteCourse(2);

        course c1 = repository_jdbc.findCourseById(3);

        repository_jpa.InsertCourse(new course(5, "Learn Spring", "Spring_Instructor"));

        System.out.print(repository_jdbc.findCourseById(5));
        List<course> courses = repository_springDataJpa.findAll();
        for (course name : courses) {
            System.out.println(name + "\n");

        }
        repository_springDataJpa.save(new course(5, "Learn C++", "C++_Instructor"));

        System.out.println(repository_springDataJpa.findByInstructor("C++_Instructor"));
    }

}
