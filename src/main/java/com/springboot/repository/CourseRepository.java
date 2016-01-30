package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.domain.Course;

/** Repository interface COURSE table.
 * @author RAJASHEKHAR
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
