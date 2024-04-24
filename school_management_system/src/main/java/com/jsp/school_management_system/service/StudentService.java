package com.jsp.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.school_management_system.dao.StudentDao;
import com.jsp.school_management_system.dto.Student;
import com.jsp.school_management_system.exception.StudentIdNotFound;
import com.jsp.school_management_system.util.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	StudentDao studentDao;
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student)
	{
		ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully Student inserted");
		responseStructure.setData(studentDao.saveStudent(student));
		
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Student>> fetchStudentById(int id)
	{
		Student student=studentDao.fetchStudentById(id);
		if(student!=null)
		{
		ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully Student fetched");
		responseStructure.setData(studentDao.fetchStudentById(id));
		
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.FOUND);
		}
		else
		{
			throw new StudentIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Student>> deleteStudentById(int id)
	{
		ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully Student deleted");
		responseStructure.setData(studentDao.deleteStudentById(id));
		
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Student>> updateStudent(int id,Student student)
	{
		ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully Student updated");
		responseStructure.setData(studentDao.updateStudent(id, student));
		
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.OK);
	}
}
