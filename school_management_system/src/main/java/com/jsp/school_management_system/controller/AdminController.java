package com.jsp.school_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.school_management_system.dto.Admin;
import com.jsp.school_management_system.dto.School;
import com.jsp.school_management_system.service.AdminService;
import com.jsp.school_management_system.util.ResponseStructure;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/saveAdmin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin)
	{
		return adminService.saveAdmin(admin);
	}
	
	@GetMapping("/fetchAdminById")
	public ResponseEntity<ResponseStructure<Admin>> fetchAdminById(int id)
	{
		return adminService.fetchAdminById(id);
	}
	
	@DeleteMapping("/deleteAdminById")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(int id)
	{
		return adminService.deleteAdminById(id);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int id,@RequestBody Admin admin)
	{
		return adminService.updateAdmin(id, admin);
	}
	
	@PutMapping("/addExistingSchoolToExistingAdmin")
	public ResponseEntity<ResponseStructure<Admin>> addExistingSchoolToExistingAdmin(int adminId,int schoolId)
	{
		return adminService.addExistingSchoolToExistingAdmin(adminId, schoolId);
	}
	
	@PutMapping("/addNewSchoolToExistingAdmin")
	public ResponseEntity<ResponseStructure<Admin>> addNewSchoolToExistingAdmin(int adminId,@RequestBody School school)
	{
		return adminService.addNewSchoolToExistingAdmin(adminId, school);
	}
}
