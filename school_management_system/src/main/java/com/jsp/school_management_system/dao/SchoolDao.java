package com.jsp.school_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.school_management_system.dto.Branch;
import com.jsp.school_management_system.dto.School;
import com.jsp.school_management_system.repo.SchoolRepo;

@Repository
public class SchoolDao {

	@Autowired
	SchoolRepo schoolRepo;
	
	@Autowired
	BranchDao branchDao;
	
	public School saveSchool(School school)
	{
		return schoolRepo.save(school);
	}
	
	public School fetchSchoolById(int id)
	{
//		School school=schoolRepo.findById(id).get();
//		return school;
		
		Optional<School> school=schoolRepo.findById(id);
		if(school.isPresent())
		{
			return school.get();
		}
		else
		{
			return null;
		}
	}
	
	public School deleteSchoolById(int id)
	{
		School school=fetchSchoolById(id);
		schoolRepo.delete(school);
		return school;
	}
	
	public School updateSchool(int oldId,School school)
	{
		school.setSchoolId(oldId);
		return schoolRepo.save(school);
	}
	
	public School addExistingBranchToExistingSchool(int schoolId,int branchId)
	{
		School school=fetchSchoolById(schoolId);
		Branch branch=branchDao.fetchBranchById(branchId);
		school.getBranch().add(branch);
		return saveSchool(school); //OneToMany
	}
	
	public School addNewBranchToExistingSchool(int schoolId,Branch branch)
	{
		School school=fetchSchoolById(schoolId);
		school.getBranch().add(branch);
		return saveSchool(school);
	}
	
}
