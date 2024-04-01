package com.springboot.jpahibernate.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface courseSpringDataJpa extends JpaRepository<course, Integer> {

    List<course> findByInstructor(String instructor); // findBy- must continue with fields of entity
}
