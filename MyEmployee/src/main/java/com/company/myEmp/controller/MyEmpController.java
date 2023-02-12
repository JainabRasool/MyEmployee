package com.company.myEmp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.myEmp.Entity.MyEmpEntity;
import com.company.myEmp.dto.MyEmpRequest;
import com.company.myEmp.dto.MyEmpResponse;
import com.company.myEmp.repo.MyEmpolyeeRepo;
import com.company.myEmp.service.MyEmpService;

@RestController
public class MyEmpController {

	@Autowired
	MyEmpService empService;
	@Autowired
	MyEmpEntity empEntity;
	@Autowired
	MyEmpolyeeRepo empRepo;
	@Autowired
	MyEmpResponse empRes;

	
	
	@RequestMapping(value = "/getEmp", method = RequestMethod.GET)
	@ResponseBody
	public List<MyEmpEntity> getAllEmpDetails() {
		return empRepo.findAll();
	}

	
	
	@RequestMapping(value = "/getEmp/{eId}", method = RequestMethod.GET)
	@ResponseBody
	public Optional<MyEmpEntity> getEmpById(@PathVariable @Valid int eId) {
		return empRepo.findById(eId);
	}

	
	
	@RequestMapping(value = "/setEmp", method = RequestMethod.POST)
	public String setEmployee(@RequestBody MyEmpRequest empReq) {
		empRepo.save(empService.ReqDtoToEntity(empReq));
		return empReq.toString();
	}

	
	@RequestMapping(value = "/updateEmp/{eId}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateEmployee(@PathVariable int eId, @RequestParam String eNewName) {
		empService.updateEmployee(eId, eNewName);
		return "Details updated for empId-"+eId;
	}

	
	
	@RequestMapping(value = "/deleteEmp/{eId}",method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteEmpData(@PathVariable int eId) {
		empService.deleteEmployee(eId);
		return "Delete entry for empId- "+eId;

	}

}
