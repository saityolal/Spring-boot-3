package com.springboot.jpahibernate.course.jpa;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class courseJpaRepository {
    private EntityManager entityManager;
}
