package BikeServiceproject.ZelousBikeserviceproject;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikedetailsRepository extends JpaRepository<BikeDetails, Integer>
{
	public Optional<BikeDetails>findAllByCusBikeno(String cusBikeno);
	public Optional<BikeDetails>findAllBycusEmailid(String cusEmailid);
	

}