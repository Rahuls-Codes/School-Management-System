package com.jsp.school_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.school_management_system.dto.BranchHead;
import com.jsp.school_management_system.service.BranchHeadService;
import com.jsp.school_management_system.util.ResponseStructure;

@RestController
public class BranchHeadController {

	@Autowired
	BranchHeadService branchHeadService;
	
	@PostMapping("/saveBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(@RequestBody BranchHead branchHead)
	{
		return branchHeadService.saveBranchHead(branchHead);
	}
	
	@GetMapping("/fetchBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHeadById(int id)
	{
		return branchHeadService.fetchBranchHeadById(id);
	}
	
	@DeleteMapping("/deleteBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHeadById(int id)
	{
		return branchHeadService.deleteBranchHeadById(id);
	}
	
	@PutMapping("/updateBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHead(int id,@RequestBody BranchHead branchHead)
	{
		return branchHeadService.updateBranchHead(id, branchHead);
	}
}
