package spring_boot_3.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses()
    {
    return Arrays.asList(
    new Course(1,"In this course you will learn AWS","AWS_Instructor"),
    new Course(2,"In this course you will learn DevOps","DevOps_Instructor"),
    new Course(3,"In this course you will learn Java","Java_Instructor"));
    }
}