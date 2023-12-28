package com.springpractice.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1L, "Learn AWS", "in28Minutes"),
                new Course(2L, "Spring In Action", "Unknown")
        );
    }
}