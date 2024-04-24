package com.jsp.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.school_management_system.dao.BranchDao;
import com.jsp.school_management_system.dto.Address;
import com.jsp.school_management_system.dto.Branch;
import com.jsp.school_management_system.dto.BranchHead;
import com.jsp.school_management_system.dto.Student;
import com.jsp.school_management_system.dto.Teacher;
import com.jsp.school_management_system.exception.BranchIdNotFound;
import com.jsp.school_management_system.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch)
	{
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully Branch inserted");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int id)
	{
		Branch branch=branchDao.fetchBranchById(id);
		if(branch!=null) {
		
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully Branch fetched");
		responseStructure.setData(branchDao.fetchBranchById(id));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int id)
	{
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully Branch deleted");
		responseStructure.setData(branchDao.deleteBranchById(id));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id,Branch branch)
	{
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully Branch updated");
		responseStructure.setData(branchDao.updateBranch(id, branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	
	
	
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingBranchHeadToExistingBrach(int branchId,int branchHeadId)
	{
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully existing branch head added to existing branch");
		responseStructure.setData(branchDao.addExistingBranchHeadToExistingBrach(branchId, branchHeadId));
		
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewBranchHeadToExistingBrach(int branchId, BranchHead branchHead)
	{
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully new branch head added to existing branch");
		responseStructure.setData(branchDao.addNewBranchHeadToExistingBrach(branchId, branchHead));
		
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int branchId,int addressId)
	{
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully existing address added to existing branch");
		responseStructure.setData(branchDao.addExistingAddressToExistingBranch(branchId, addressId));
		
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(int branchId,Address address)
	{
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully new address added to existing branch");
		responseStructure.setData(branchDao.addNewAddressToExistingBranch(branchId, address));
		
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingStudentToExistingBranch(int studentId,int branchId)
	{
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully existing student added to existing branch");
		responseStructure.setData(branchDao.addExistingStudentToExistingBranch(studentId, branchId));
		
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewStudentToExistingBranch(int branchId,Student student)
	{
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully new student added to existing branch");
		responseStructure.setData(branchDao.addNewStudentToExistingBranch(branchId, student));
		
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingTeacherToExistingBranch(int teacherId,int branchId)
	{
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully existing teacher added to existing branch");
		responseStructure.setData(branchDao.addExistingTeacherToExistingBranch(teacherId, branchId));
		
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewTeacherToExistingBranch(int branchId,Teacher teacher)
	{
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully new teacher added to existing branch");
		responseStructure.setData(branchDao.addNewTeacherToExistingBranch(branchId, teacher));
		
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
}
