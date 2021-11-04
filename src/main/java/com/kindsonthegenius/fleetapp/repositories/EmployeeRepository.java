package com.kindsonthegenius.fleetapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kindsonthegenius.fleetapp.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	@Query(value="select * from Employee e where e.firstname like %:keyword%  or e.lastname like %:keyword%", nativeQuery=true)
	List<Employee> findByKeyword(@Param("keyword") String keyword);

}
