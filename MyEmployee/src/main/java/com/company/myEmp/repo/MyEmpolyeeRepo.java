package com.company.myEmp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.myEmp.Entity.MyEmpEntity;

@Repository
public interface MyEmpolyeeRepo extends JpaRepository<MyEmpEntity, Integer> {

}
