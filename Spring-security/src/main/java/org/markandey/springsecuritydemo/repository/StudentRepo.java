package org.markandey.springsecuritydemo.repository;

import org.markandey.springsecuritydemo.Model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentClass, Integer> {
}
