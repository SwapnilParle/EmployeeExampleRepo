package com.dbConnection.DbConnection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@EnableJpaRepositories
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

Optional<Employee> findEmployeeByEmail(String email);

//List<Employee> findEmp(Pageable pageable);

//@Query("SELECT e FROM Employee e WHERE e.name = :n")
//List<Employee> findByEmployeeName(@Param("n") String name);

}