package com.jsp.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.school_management_system.dao.BranchHeadDao;
import com.jsp.school_management_system.dto.BranchHead;
import com.jsp.school_management_system.exception.BranchHeadIdNotFound;
import com.jsp.school_management_system.util.ResponseStructure;

@Service
public class BranchHeadService {

	@Autowired
	BranchHeadDao branchHeadDao;
	
	public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(BranchHead branchHead)
	{
		ResponseStructure<BranchHead> responseStructure=new ResponseStructure<BranchHead>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully Branch Head inserted");
		responseStructure.setData(branchHeadDao.saveBranchHead(branchHead));
		
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHeadById(int id)
	{
		BranchHead branchHead=branchHeadDao.fetchBranchHeadById(id);
		if(branchHead!=null)
		{
		ResponseStructure<BranchHead> responseStructure=new ResponseStructure<BranchHead>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully Branch Head fetched");
		responseStructure.setData(branchHeadDao.fetchBranchHeadById(id));
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			throw new BranchHeadIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHeadById(int id)
	{
		ResponseStructure<BranchHead> responseStructure=new ResponseStructure<BranchHead>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully branch head deleted");
		responseStructure.setData(branchHeadDao.deleteBranchHeadById(id));
		
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHead(int id,BranchHead branchHead)
	{
		ResponseStructure<BranchHead> responseStructure=new ResponseStructure<BranchHead>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully branch head updated");
		responseStructure.setData(branchHeadDao.updateBranchHead(id, branchHead));
		
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.OK);
	}
}
