package com.jsp.school_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.school_management_system.dao.AddressDao;
import com.jsp.school_management_system.dto.Address;
import com.jsp.school_management_system.exception.AddressIdNotFound;
import com.jsp.school_management_system.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address)
	{
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully Address inserted");
		responseStructure.setData(addressDao.saveAddress(address));
		
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int id)
	{
		Address address=addressDao.fetchAddressById(id);
		if(address!=null)
		{
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully Address fetched");
		responseStructure.setData(addressDao.fetchAddressById(id));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		}
		else
		{
			throw new AddressIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int id)
	{
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully Address deleted");
		responseStructure.setData(addressDao.deleteAddressById(id));
		
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id,Address address)
	{
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully Address updated");
		responseStructure.setData(addressDao.updateAddress(id, address));
		
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
	}
}
