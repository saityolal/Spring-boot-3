package com.springboot.jpahibernate.course.jdbc;

import com.springboot.jpahibernate.course.course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class courseJdbcRepository {
//  repository -> JDBC template -> database
    @Autowired
    JdbcTemplate springJdbcTemplate;

    private  String INSERT_QUERY = """
            insert into course(id, definition, instructor) values(?,?,?);
            """;
    // sql commands(rows or columns) needs to be same as Entity class variables
    private String DELETE_QUERY = """ 
            delete from course where id=?;
            """;
    private String FIND_QUERY ="""
				select * from course where id=?	
			""";

    public void insertCourse(course course) {

        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getDefinition(), course.getInstructor());
    }

    public void deleteCourse(int id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public course findCourseById(int id) {
        return springJdbcTemplate.queryForObject(FIND_QUERY,
                new BeanPropertyRowMapper<>(course.class), id);
    }
}
