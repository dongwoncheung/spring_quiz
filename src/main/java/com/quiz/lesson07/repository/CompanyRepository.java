package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{
	//spring data jpa라는 기능을 별도로 사용하고있는것이다 => method을 제공 받고있다
	
	//save(엔티티객체)
	
	// findById()-> select
	//save - insert, update(id가 있으면)
	// delete
	
}
