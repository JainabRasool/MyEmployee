package com.company.myEmp.controller;



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
import com.company.myEmp.service.MyEmpService;

@RestController
public class MyEmpController {

	@Autowired
	MyEmpService empService;
	@Autowired
	MyEmpEntity empEntity;
		
	
	@RequestMapping(value = "/getEmp", method = RequestMethod.GET)
	@ResponseBody
	public String getAllEmpDetails() {
		return empService.gettAllEmpDetails().toString();
	}

	
	
	@RequestMapping(value = "/getEmp/{eId}", method = RequestMethod.GET)
	@ResponseBody
	public String getEmpById(@PathVariable @Valid int eId) {
		return empService.getEmpById(eId).toString();
	}

	
	
	@RequestMapping(value = "/setEmp", method = RequestMethod.POST)
	public String setEmployee(@RequestBody MyEmpRequest empReq) {
		return empService.setEmployee(empReq);
	}

	
	
	@RequestMapping(value = "/updateEmp/{eId}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateEmployee(@PathVariable int eId, @RequestParam String eNewName) {
		return empService.updateEmployee(eId, eNewName);	
	}

	
	
	@RequestMapping(value = "/deleteEmp/{eId}",method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteEmpData(@PathVariable int eId) {
		return empService.deleteEmployee(eId);
	}

}
