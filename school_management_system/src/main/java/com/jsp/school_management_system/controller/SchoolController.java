package com.jsp.school_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.school_management_system.dto.Branch;
import com.jsp.school_management_system.dto.School;
import com.jsp.school_management_system.service.SchoolService;
import com.jsp.school_management_system.util.ResponseStructure;

@RestController
public class SchoolController {

	@Autowired
	SchoolService schoolService;
	
	@PostMapping("/saveSchool")
	public ResponseEntity<ResponseStructure<School>> saveSchool(@RequestBody School school)
	{
		return schoolService.saveSchool(school);
	}
	
	@GetMapping("/fetchSchoolById")
	public ResponseEntity<ResponseStructure<School>> fetchSchoolById(int id)
	{
		return schoolService.fetchSchoolById(id);
	}
	
	@DeleteMapping("/deleteSchoolById")
	public ResponseEntity<ResponseStructure<School>> deleteSchoolById(int id)
	{
		return schoolService.deleteSchoolById(id);
	}
	
	@PutMapping("/updateSchool")
	public ResponseEntity<ResponseStructure<School>> updateSchool(int oldId,@RequestBody School school)
	{
		return schoolService.updateSchool(oldId, school);
	}
	
	@PutMapping("/addExistingBranchToExistingSchool")
	public ResponseEntity<ResponseStructure<School>> addExistingBranchToExistingSchool(int schoolId,int branchId)
	{
		return schoolService.addExistingBranchToExistingSchool(schoolId, branchId);
	}
	
	@PutMapping("/addNewBranchToExistingSchool")
	public ResponseEntity<ResponseStructure<School>> addNewBranchToExistingSchool(int schoolId,@RequestBody Branch branch)
	{
		return schoolService.addNewBranchToExistingSchool(schoolId, branch);
	}
}
