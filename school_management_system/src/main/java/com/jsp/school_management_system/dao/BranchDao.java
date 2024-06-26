package com.jsp.school_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.school_management_system.dto.Address;
import com.jsp.school_management_system.dto.Branch;
import com.jsp.school_management_system.dto.BranchHead;
import com.jsp.school_management_system.dto.Student;
import com.jsp.school_management_system.dto.Teacher;
import com.jsp.school_management_system.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	BranchHeadDao branchHeadDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	TeacherDao teacherDao;
	
	public Branch saveBranch(Branch branch)
	{
		return branchRepo.save(branch);
	}
	
	public Branch fetchBranchById(int id)
	{
//		Branch branch=branchRepo.findById(id).get();
//		return branch;
		
		Optional<Branch> branch=branchRepo.findById(id);
		if(branch.isPresent())
		{
			return branch.get();
		}
		else
		{
			return null;
		}
	}
	
	public Branch deleteBranchById(int id)
	{
		Branch branch=fetchBranchById(id);
		branchRepo.delete(branch);
		return branch;
	}
	
	public Branch updateBranch(int id,Branch branch)
	{
		branch.setBranchId(id);
		return branchRepo.save(branch);
	}
	
	
	
	// 	BRANCH HEAD
	public Branch addExistingBranchHeadToExistingBrach(int branchId,int branchHeadId)
	{
		Branch branch=fetchBranchById(branchId);
		BranchHead branchHead=branchHeadDao.fetchBranchHeadById(branchHeadId);
		branch.setBranchHead(branchHead);
		return saveBranch(branch);
	}
	
	public Branch addNewBranchHeadToExistingBrach(int branchId, BranchHead branchHead)
	{
		Branch branch=fetchBranchById(branchId);
		branch.setBranchHead(branchHead);
		return saveBranch(branch);
	}
	
	//	ADDRESS
	
	public Branch addExistingAddressToExistingBranch(int branchId,int addressId)
	{
		Branch branch=fetchBranchById(branchId);
		Address address=addressDao.fetchAddressById(addressId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	
	public Branch addNewAddressToExistingBranch(int branchId,Address address)
	{
		Branch branch=fetchBranchById(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	
	
	//	STUDENT
	public Branch addExistingStudentToExistingBranch(int studentId,int branchId)
	{
		Branch branch=fetchBranchById(branchId);
		Student student=studentDao.fetchStudentById(studentId);
		branch.getStudent().add(student);	//TO ADD LIST OF DATA
		return saveBranch(branch);
	}
	
	public Branch addNewStudentToExistingBranch(int branchId,Student student)
	{
		Branch branch=fetchBranchById(branchId);
		branch.getStudent().add(student);
		return saveBranch(branch);
	}
	
	
	//TEACHER
	public Branch addExistingTeacherToExistingBranch(int teacherId,int branchId)
	{
		Branch branch=fetchBranchById(branchId);
		Teacher teacher=teacherDao.fetchTeacherById(teacherId);
		branch.getTeacher().add(teacher);
		return saveBranch(branch);
	}
	
	public Branch addNewTeacherToExistingBranch(int branchId,Teacher teacher)
	{
		Branch branch=fetchBranchById(branchId);
		branch.getTeacher().add(teacher);
		return saveBranch(branch);
	}
}
