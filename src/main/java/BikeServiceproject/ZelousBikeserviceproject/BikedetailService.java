package BikeServiceproject.ZelousBikeserviceproject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikedetailService 
{
	@Autowired // object creation
	BikedetailsRepository repo;
	
	public BikeDetails create(BikeDetails bike)// entity class =bikeDetails
	{
		return repo.save(bike);
	}
	// list 
	public List<BikeDetails> MakeFetchAll()//utile package list and make fetch all method
	{
		return repo.findAll();
	}
	//option
	public Optional<BikeDetails>MakeFetchone( int id)// makefectchone is method
	{
		return repo.findById(id);
	}
	public String deletebyid(int id)
	{
		BikeDetails temp=repo.findById(id).orElse(new BikeDetails());
		repo.delete(temp);
		return temp.getCusName()+"has deleted successfully";
	}
	public BikeDetails gettingexactone(int cusid)//it is how to take id with the table e cannot take by the optional method
	{
		return repo.findById(cusid).orElse(new BikeDetails());
	}
	public Optional<BikeDetails>fetchingbikenumber(String bikenumber)
	{
		return repo.findAllByCusBikeno(bikenumber);
	}
	public Optional<BikeDetails>fetchingbikeemailid(String emailidentification)
	{
		return repo.findAllBycusEmailid(emailidentification);
	}

}
