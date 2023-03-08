package BikeServiceproject.ZelousBikeserviceproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicedetailservice {
	@Autowired
	Servicedetailrepository srepo;
	
	public Servicetable createnewservice(Servicetable service)
	{
		return srepo.save(service);
	}
	public List<Servicetable>Exactcustidwithcustomerdetail(BikeDetails bike)
	{
		return srepo.findAllByBikedetails(bike);
	}
	public List<Servicetable>Exacttypeofservice(String typeofservice)
	{
		return srepo.findAllBybikeTypeofservice(typeofservice);
	}

}

