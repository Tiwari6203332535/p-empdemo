package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	//finder method in spring boot
	Optional<Employee>findByEmail(String email);
	Optional<Employee>findByMobile(String Mobile);
	Optional<Employee>findByEmailAndMobile(String Email,String Mobile);
	List<Employee>findByEmailOrMobile(String Email,String Mobile);
    boolean existsByEmail(String email);
    boolean existsByMobile(String email);
    
    //JPQL
    @Query("select emp from Employee emp where emp.email=:em")	
    Employee findEmployeeByEmail(@Param("em") String emailId);
    
    @Query("select e from Employee e where e.mobile=:m")	
    Employee findEmployeeByMobile(@Param("m") String mobile);
    
    @Query("select e from Employee e where e.email=:em and e.mobile=:mo")	
    Employee findEmployeeByEmailAndMobile(@Param("em") String email,@Param("mo") String mobile);
    
    @Query("select e from Employee e where e.email=:em or e.mobile=:mo")	
    List<Employee> findEmployeeByEmailOrMobile(@Param("em") String email,@Param("mo") String mobile);
        
}
