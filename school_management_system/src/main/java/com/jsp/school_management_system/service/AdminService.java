package com.jsp.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.school_management_system.dao.AdminDao;
import com.jsp.school_management_system.dto.Admin;
import com.jsp.school_management_system.dto.School;
import com.jsp.school_management_system.exception.AdminIdNotFound;
import com.jsp.school_management_system.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin)
	{
		ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully Admin inserted");
		responseStructure.setData(adminDao.saveAdmin(admin));
		
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> fetchAdminById(int id)
	{
		Admin admin=adminDao.fetchAdminById(id);
		if(admin!=null) {
		
		ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully Admin fetched");
		responseStructure.setData(adminDao.fetchAdminById(id));
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.FOUND);
		}
		else
		{
			throw new AdminIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(int id)
	{
		ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully Admin deleted");
		responseStructure.setData(adminDao.deleteAdminById(id));
		
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int id,Admin admin)
	{
		ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully Admin updated");
		responseStructure.setData(adminDao.updateAdmin(id, admin));
		
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> addExistingSchoolToExistingAdmin(int adminId,int schoolId)
	{
		ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully existing school added to existing admin");
		responseStructure.setData(adminDao.addExistingSchoolToExistingAdmin(adminId, schoolId));
		
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> addNewSchoolToExistingAdmin(int adminId,School school)
	{
		ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully new school added to existing admin");
		responseStructure.setData(adminDao.addNewSchoolToExistingAdmin(adminId, school));
		
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
	}
}
