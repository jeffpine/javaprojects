package br.com.jeffpine.forumhub.repository;

import br.com.jeffpine.forumhub.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByName(String name);
}