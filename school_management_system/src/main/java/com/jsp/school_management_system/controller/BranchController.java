package com.jsp.school_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.school_management_system.dto.Address;
import com.jsp.school_management_system.dto.Branch;
import com.jsp.school_management_system.dto.BranchHead;
import com.jsp.school_management_system.dto.Student;
import com.jsp.school_management_system.dto.Teacher;
import com.jsp.school_management_system.service.BranchService;
import com.jsp.school_management_system.util.ResponseStructure;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;
	
	
	
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch)
	{
		return branchService.saveBranch(branch);
	}
	
	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int id)
	{
		return branchService.fetchBranchById(id);
	}
	
	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int id)
	{
		return branchService.deleteBranchById(id);
	}
	
	@PutMapping("/updateBranch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id,@RequestBody Branch branch)
	{
		return branchService.updateBranch(id, branch);
	}
	
	
	
	@PutMapping("/addExistingBranchHeadToExistingBrach")
	public ResponseEntity<ResponseStructure<Branch>> addExistingBranchHeadToExistingBrach(int branchId,int branchHeadId)
	{
		return branchService.addExistingBranchHeadToExistingBrach(branchId, branchHeadId);
	}
	
	@PutMapping("/addNewBranchHeadToExistingBrach")
	public ResponseEntity<ResponseStructure<Branch>> addNewBranchHeadToExistingBrach(int branchId,@RequestBody BranchHead branchHead)
	{
		return branchService.addNewBranchHeadToExistingBrach(branchId, branchHead);
	}
	
	
	
	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int branchId,int addressId)
	{
		return branchService.addExistingAddressToExistingBranch(branchId, addressId);
	}
	
	@PutMapping("/addNewAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(int branchId,@RequestBody Address address)
	{
		return branchService.addNewAddressToExistingBranch(branchId, address);
	}
	
	
	
	@PutMapping("/addExistingStudentToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingStudentToExistingBranch(int studentId,int branchId)
	{
		return branchService.addExistingStudentToExistingBranch(studentId, branchId);
	}
	
	@PutMapping("/addNewStudentToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewStudentToExistingBranch(int branchId,Student student)
	{
		return branchService.addNewStudentToExistingBranch(branchId, student);
	 }
	
	
	
	@PutMapping("/addExistingTeacherToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingTeacherToExistingBranch(int teacherId,int branchId)
	{
		return branchService.addExistingTeacherToExistingBranch(teacherId, branchId);
	}
	
	@PutMapping("/addNewTeacherToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewTeacherToExistingBranch(int branchId,@RequestBody Teacher teacher)
	{
		return branchService.addNewTeacherToExistingBranch(branchId, teacher);
	}
	
}
