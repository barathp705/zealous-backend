package BikeServiceproject.ZelousBikeserviceproject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Servicedetailrepository extends JpaRepository<Servicetable, Integer> 
{

	public List<Servicetable> findAllByBikedetails(BikeDetails bike);
	
	public List<Servicetable> findAllBybikeTypeofservice(String typeofservice);
}

