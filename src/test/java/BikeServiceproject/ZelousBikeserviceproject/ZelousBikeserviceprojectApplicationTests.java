package BikeServiceproject.ZelousBikeserviceproject;


import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest 
@RunWith(SpringRunner.class)
class ZelousBikeserviceprojectApplicationTests {
	@MockBean
	BikedetailsRepository jpa;
	@Autowired
	BikedetailService serives;
	
	@Test
	public void testcase()
	{
		Date date=new Date(2022,10,10);
		BikeDetails bike1=new BikeDetails(1, "TN34V3456", "vasanth", 9944778654L, "barathyp705@gmail.com", date, null);
		when(jpa.findAll()).thenReturn(Stream.of(bike1).collect(Collectors.toList()));
		assertNotNull(serives.MakeFetchAll());
		
	}
	

//	@Test
//	void contextLoads() {
//	}

}
