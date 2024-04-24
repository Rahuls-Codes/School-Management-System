package com.jsp.school_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.school_management_system.dto.Address;
import com.jsp.school_management_system.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address)
	{
		return addressRepo.save(address);
	}
	
	public Address fetchAddressById(int id)
	{
//		Address address=addressRepo.findById(id).get();
//		return address;
		
		 Optional<Address> address=addressRepo.findById(id);
		 if(address.isPresent())
			{
				return address.get();
			}
			else
			{
				return null;
			}
	}
	
	public Address deleteAddressById(int id)
	{
		Address address=fetchAddressById(id);
		addressRepo.delete(address);
		return address;
	}
	
	public Address updateAddress(int id,Address address)
	{
		address.setAddressId(id);
		return addressRepo.save(address);
	}
}
