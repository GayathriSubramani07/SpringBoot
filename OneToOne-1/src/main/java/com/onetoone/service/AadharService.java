package com.onetoone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetoone.dao.AadharCardDao;
import com.onetoone.dao.PersonDao;
import com.onetoone.entity.AadharCard;
import com.onetoone.entity.Person;

@Service
public class AadharService {
	
	@Autowired
	private AadharCardDao aadhardao;
	
	@Autowired
	private PersonDao persondao;
	
//	When i am saving the aadharcard data that time only i am updating the person table also
	
	
	public AadharCard saveAadhar(AadharCard aadharCard, int person_id) {
		AadharCard aadharCard2=aadhardao.saveAadhar(aadharCard);
		Person person=persondao.getByPersonId(person_id);
		if(person !=null)
		{
			 person.setAadhar_id(aadharCard2);
			 persondao.updatePersonById(person, person_id);
			 return aadharCard2;
		}
		else
		{
			return null;
		}

}

	public AadharCard getByCardId(int id) {
		
		return aadhardao.getByCardId(id);
	}

	public AadharCard updateCardById(int id, AadharCard aadharCard) {
		
		return aadhardao.updateCardById(id,aadharCard);
	}
	
	
	
// delete an AadharCard record that is  being referenced by a Person record through a foreign key constraint.
//	So, if a Person is linked to an AadharCard, you can't delete that AadharCard without breaking the link first.
//	How to Fix It
//	You must unlink (or nullify) the AadharCard reference from Person before deleting it.
//	1. Fetch the Person using AadharCard ID
//	2. Set person.aadhar_id to null
//	3. Update the person
//	4. Then delete the AadharCard
	
	
	
	public AadharCard deleteCardById(int id) {
	  Person person=persondao.getByPersonaadharId(id);
	  if(person !=null) {
		  person.setAadhar_id(null);
		  persondao.updatePersonById(person, id);
		  return aadhardao.deleteCardById(id);
	  }
		
		return null;
	} 
}
