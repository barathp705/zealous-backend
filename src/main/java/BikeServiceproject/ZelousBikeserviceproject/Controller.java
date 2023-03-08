package BikeServiceproject.ZelousBikeserviceproject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	BikedetailService service;
	@Autowired
	Servicedetailservice sservice;
	
	@PostMapping("/newbikedetails")
	public String newbikedetails( @RequestBody BikeDetails bike)
	{
		return service.create(bike).getCusName()+"has been added successfully";
		
	}
	@PutMapping("/updatenewbikedetails")
	public String updatebike(@RequestBody BikeDetails bike)
	{
		BikeDetails temp=service.create(bike);
		return temp.getCusName()+"has been updated successfully";
	}
	@GetMapping("/listallbikedetails")
	public List<BikeDetails> listaBikeDetails()
	{
		return service.MakeFetchAll();
	}
	// for /
	@GetMapping("/")
			public String sample()
			{
		
		return "welcome home";
			}
	@GetMapping("/listonebikedetails/{id}")
	public Optional<BikeDetails> readonebikedetail(@PathVariable("id")int id)
	{
		return service.MakeFetchone(id);
		
	}
	@DeleteMapping("/deletebikedetails/{id}")
	public String deletebikedetail(@PathVariable("id")int id)
	{
		return service.deletebyid(id);
	}
	@GetMapping("/exactbikeno/{bikenumber}")
	public Optional<BikeDetails>getbikeno(@PathVariable("bikenumber")String bikenumber)
	{
		return service.fetchingbikenumber(bikenumber);
	}
	//list the email id in optional way;
	@GetMapping("/exactbideemailid/{emailidentification}")
	public Optional<BikeDetails>getemailid(@PathVariable ("emailidentification")String emailidentification)
	{
		return service.fetchingbikeemailid(emailidentification);
	}
	@PostMapping("/createnewservice")
	public String newservicedetail(@RequestBody Servicetable serv)
	{
		BikeDetails temp=service.gettingexactone(serv.getBikedetails().getCusId());
		
		if(serv.getBikeTypeofservice()== "free")
		{
			int total =serv.getBikeProductcost()+(serv.getBikeProductcost()*18/100);
			serv.setBikeFinalamount(total);
			
		}
		else {
			int total =serv.getBikeProductcost()+serv.getBikeLabourcharge();
			total+=(total)*18/100;
			serv.setBikeFinalamount(total);
		}
		temp.getMyservicedetails().add(serv);
		serv.setBikedetails(temp);
		sservice.createnewservice(serv);
		return serv.getBikeJobcardno()+"has been service details is added";
		
		
	}
	@PostMapping("/serviceupdatetables")
	public String updateservicetable(@RequestBody Servicetable serv)
	{
		Servicetable temp=sservice.createnewservice(serv);
		return temp.getBikeJobcardno()+"has been updated successfully";
	}
	@GetMapping("/listservietable")
	public List<Servicetable>gettingservicetable(@PathVariable("cusId")int cusId)
	{
		BikeDetails temp=service.gettingexactone(cusId);
		return sservice.Exactcustidwithcustomerdetail(temp);
	}
	@GetMapping("/exacttypeofservice/{typeofservice}")
	
		public List<Servicetable>numberofservice(@PathVariable ("typofservice")String typeofservice)
		{
			return sservice.Exacttypeofservice(typeofservice);
		}
	
	
	
	

}
