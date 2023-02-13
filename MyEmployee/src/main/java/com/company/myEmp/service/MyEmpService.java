package com.company.myEmp.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.myEmp.Entity.MyEmpEntity;
import com.company.myEmp.dto.MyEmpRequest;
import com.company.myEmp.repo.MyEmpolyeeRepo;


@Service
public class MyEmpService {

	MyEmpEntity empE=new MyEmpEntity();
	
	@Autowired
	MyEmpRequest empReq;

	@Autowired
	MyEmpolyeeRepo empRepo;
	

	public MyEmpEntity ReqDtoToEntity(@RequestBody MyEmpRequest empReq) {
		
		System.out.println("empReq.geteId()::"+empReq.geteId());
		
		empE.seteId(empReq.geteId());
		empE.seteName(empReq.geteName());
		empE.setePass(empReq.getePass());
		empE.setAge(empReq.getAge());

		return empE;

	}

	/*
	 * public MyEmpRequest EntiyToReqDto(@RequestBody MyEmpEntity empE) {
	 * 
	 * empReq.seteId(empE.geteId()); empReq.seteName(empE.geteName());
	 * empReq.setePass(empE.getePass()); empReq.setAge(empE.getAge());
	 * 
	 * return empReq;
	 * 
	 * }public MyEmpResponse EntiyToResDto(@RequestBody MyEmpEntity empE) {
	 * 
	 * empRes.seteId(empE.geteId()); empRes.seteName(empE.geteName());
	 * empRes.setePass(empE.getePass()); empRes.setAge(empE.getAge());
	 * 
	 * return empRes;
	 * 
	 * }
	 * 
	 * public MyEmpEntity ResDtoToEntity(@RequestBody MyEmpResponse empRes) {
	 * 
	 * empE.seteId(empRes.geteId()); empE.seteName(empRes.geteName());
	 * empE.setePass(empRes.getePass()); empE.setAge(empRes.getAge());
	 * 
	 * return empE;
	 * 
	 * }
	 */
	public String updateEmployee(int eId, String eNewName) {
		if (empRepo.existsById(eId)) {
			empE.seteId(eId);
			empE.seteName(eNewName);
			 empRepo.save(empE);
			 return "Deatils are updated for Employee Id-"+eId;
		}

		else {
			return "Enter a valid Employee Id";
		}

	}

	public String deleteEmployee(int eId) {
		if (empRepo.existsById(eId)) {
			empRepo.deleteById(eId);
			return "Deleted Employee with id: " + eId;
		} else
			return "Enter a valid Employee Id!";

	}

	public List<MyEmpEntity> gettAllEmpDetails() {
		return empRepo.findAll();
	}

	public Optional<MyEmpEntity> getEmpById(@PathVariable @Valid int eId) {
		return empRepo.findById(eId);

	}

	public String setEmployee(@RequestBody MyEmpRequest empReq) {
		empRepo.save(ReqDtoToEntity(empReq));
		return empReq.toString();
	}

}
