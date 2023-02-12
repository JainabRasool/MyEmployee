package com.company.myEmp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.company.myEmp.Entity.MyEmpEntity;
import com.company.myEmp.dto.MyEmpRequest;
import com.company.myEmp.dto.MyEmpResponse;
import com.company.myEmp.repo.MyEmpolyeeRepo;

@Service
public class MyEmpService {

	@Autowired
	MyEmpRequest empReq;

	@Autowired
	MyEmpEntity empE;

	@Autowired
	MyEmpResponse empRes;

	@Autowired
	MyEmpolyeeRepo empRepo;

	

	public MyEmpEntity ReqDtoToEntity(@RequestBody MyEmpRequest empReq) {

		empE.seteId(empReq.geteId());
		empE.seteName(empReq.geteName());
		empE.setePass(empReq.getePass());
		empE.setAge(empReq.getAge());

		return empE;

	}

	/*
	 public MyEmpRequest EntiyToReqDto(@RequestBody MyEmpEntity empE) {

		empReq.seteId(empE.geteId());
		empReq.seteName(empE.geteName());
		empReq.setePass(empE.getePass());
		empReq.setAge(empE.getAge());

		return empReq;

	}public MyEmpResponse EntiyToResDto(@RequestBody MyEmpEntity empE) {

		empRes.seteId(empE.geteId());
		empRes.seteName(empE.geteName());
		empRes.setePass(empE.getePass());
		empRes.setAge(empE.getAge());

		return empRes;

	}

	public MyEmpEntity ResDtoToEntity(@RequestBody MyEmpResponse empRes) {

		empE.seteId(empRes.geteId());
		empE.seteName(empRes.geteName());
		empE.setePass(empRes.getePass());
		empE.setAge(empRes.getAge());

		return empE;

	}
*/
	public MyEmpEntity updateEmployee(int eId, String eNewName) {
		if (empRepo.existsById(eId)) {
			empE.seteId(eId);
			empE.seteName(eNewName);
			System.out.println("updateEmployee-" + empE);
			return empRepo.save(empE);
		}

		else {
			return null;
			}

	}
	
	
	public String deleteEmployee(int eId) {
		if (empRepo.existsById(eId)) {
			empRepo.deleteById(eId);
			return "Deleted Student with id: " + eId;
		} else
			return "Enter a valid student Id!";

	}
	

}
