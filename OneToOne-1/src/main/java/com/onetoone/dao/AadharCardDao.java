package com.onetoone.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onetoone.entity.AadharCard;
import com.onetoone.repo.AadharRepo;



@Repository
public class AadharCardDao {
	
	@Autowired 
	private AadharRepo aadharrepo;

	public AadharCard saveAadhar(AadharCard aadharCard) {
		
		return aadharrepo.save(aadharCard);
	}

	public AadharCard getByCardId(int id) {
		Optional<AadharCard>optional=aadharrepo.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	public AadharCard updateCardById(int id, AadharCard aadharCard) {
		Optional<AadharCard> optional=aadharrepo.findById(id);
		if(optional.isPresent())
		{
			aadharCard.setId(id);
		  return aadharrepo.save(aadharCard);
		}
		return null;
	}

	public AadharCard deleteCardById(int id) {
		Optional<AadharCard> optional=aadharrepo.findById(id);
		if(optional.isPresent())
		{
			AadharCard aadharCard=optional.get();
			aadharrepo.deleteById(id);
			return aadharCard;
		}
		return null;
	}
	

}
