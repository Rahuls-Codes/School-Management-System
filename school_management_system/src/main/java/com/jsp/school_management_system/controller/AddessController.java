package com.jsp.school_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.school_management_system.dto.Address;
import com.jsp.school_management_system.service.AddressService;
import com.jsp.school_management_system.util.ResponseStructure;

@RestController
public class AddessController {

	@Autowired
	AddressService addressService;
	
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address)
	{
		return addressService.saveAddress(address);
	}
	
	@GetMapping("/fetchAddressById")
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int id)
	{
		return addressService.fetchAddressById(id);
	}
	
	@DeleteMapping("/deleteAddressById")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int id)
	{
		return addressService.deleteAddressById(id);
	}
	
	@PutMapping("/updateAddress")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id,@RequestBody Address address)
	{
		return addressService.updateAddress(id, address);
	}
}
