package com.jsp.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.school_management_system.dao.SchoolDao;
import com.jsp.school_management_system.dto.Branch;
import com.jsp.school_management_system.dto.School;
import com.jsp.school_management_system.exception.SchoolIdNotFound;
import com.jsp.school_management_system.util.ResponseStructure;

@Service
public class SchoolService {

	@Autowired
	SchoolDao schoolDao;
	
	public ResponseEntity<ResponseStructure<School>> saveSchool(School school)
	{
		ResponseStructure<School> responseStructure=new ResponseStructure<School>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully school inserted");
		responseStructure.setData(schoolDao.saveSchool(school));
		
		return new ResponseEntity<ResponseStructure<School>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<School>> fetchSchoolById(int id)
	{
		School school=schoolDao.fetchSchoolById(id);
		if(school!=null)
		{
		ResponseStructure<School> responseStructure=new ResponseStructure<School>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully school fetched");
		responseStructure.setData(schoolDao.fetchSchoolById(id));
		
		return new ResponseEntity<ResponseStructure<School>>(responseStructure, HttpStatus.FOUND);
		}
		else
		{
			throw new SchoolIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<School>> deleteSchoolById(int id)
	{
		ResponseStructure<School> responseStructure=new ResponseStructure<School>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully school deleted");
		responseStructure.setData(schoolDao.deleteSchoolById(id));
		
		return new ResponseEntity<ResponseStructure<School>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<School>> updateSchool(int oldId,School school)
	{
		ResponseStructure<School> responseStructure=new ResponseStructure<School>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully school updated");
		responseStructure.setData(schoolDao.updateSchool(oldId, school));
		
		return new ResponseEntity<ResponseStructure<School>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<School>> addExistingBranchToExistingSchool(int schoolId,int branchId)
	{
		ResponseStructure<School> responseStructure=new ResponseStructure<School>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully existing branch added to existing school");
		responseStructure.setData(schoolDao.addExistingBranchToExistingSchool(schoolId, branchId));
		
		return new ResponseEntity<ResponseStructure<School>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<School>> addNewBranchToExistingSchool(int schoolId,Branch branch)
	{
		ResponseStructure<School> responseStructure=new ResponseStructure<School>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully new branch added to existing school");
		responseStructure.setData(schoolDao.addNewBranchToExistingSchool(schoolId, branch));
		
		return new ResponseEntity<ResponseStructure<School>>(responseStructure, HttpStatus.OK);
	}
}
