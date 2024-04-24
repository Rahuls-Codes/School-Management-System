package com.jsp.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.school_management_system.dao.TeacherDao;
import com.jsp.school_management_system.dto.Teacher;
import com.jsp.school_management_system.exception.TeacherIdNotFound;
import com.jsp.school_management_system.util.ResponseStructure;

@Service
public class TeacherService {

	@Autowired
	TeacherDao teacherDao;
	
	public ResponseEntity<ResponseStructure<Teacher>> saveTeacher(Teacher teacher)
	{
		ResponseStructure<Teacher> responseStructure=new ResponseStructure<Teacher>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully Student inserted");
		responseStructure.setData(teacherDao.saveTeacher(teacher));
		
		return new ResponseEntity<ResponseStructure<Teacher>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Teacher>> fetchTeacherById(int id)
	{
		Teacher teacher=teacherDao.fetchTeacherById(id);
		if(teacher!=null)
		{
		ResponseStructure<Teacher> responseStructure=new ResponseStructure<Teacher>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully Student fetched");
		responseStructure.setData(teacherDao.fetchTeacherById(id));
		
		return new ResponseEntity<ResponseStructure<Teacher>>(responseStructure, HttpStatus.FOUND);
		}
		else
		{
			throw new TeacherIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Teacher>> deleteTeacherById(int id)
	{
		ResponseStructure<Teacher> responseStructure=new ResponseStructure<Teacher>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully Student deleted");
		responseStructure.setData(teacherDao.deleteTeacherById(id));
		
		return new ResponseEntity<ResponseStructure<Teacher>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Teacher>> updateTeacher(int id,Teacher teacher)
	{
		ResponseStructure<Teacher> responseStructure=new ResponseStructure<Teacher>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully Student updated");
		responseStructure.setData(teacherDao.updateTeacher(id, teacher));
		
		return new ResponseEntity<ResponseStructure<Teacher>>(responseStructure, HttpStatus.OK);
	}
}
