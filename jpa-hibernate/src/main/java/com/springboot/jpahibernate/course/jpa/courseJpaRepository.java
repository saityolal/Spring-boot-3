package com.springboot.jpahibernate.course.jpa;

import com.springboot.jpahibernate.course.course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class courseJpaRepository {
    private EntityManager entityManager;

    @Autowired
    courseJpaRepository(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public void InsertCourse(course course) {
        entityManager.merge(course);
    }

    public course findCourseById(int id) {
        return entityManager.find(course.class, id);
    }
}
