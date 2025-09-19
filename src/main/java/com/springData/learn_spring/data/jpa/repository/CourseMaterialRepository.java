package com.springData.learn_spring.data.jpa.repository;

import com.springData.learn_spring.data.jpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
