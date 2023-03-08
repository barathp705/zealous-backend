package BikeServiceproject.ZelousBikeserviceproject;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;
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
	@Test
	public void testread()
	{
		Date date=new Date(2022,10,10);
		Optional<BikeDetails> bike1=Optional.of(new BikeDetails(1,"Tn34V5656", "Manojkumar", 9789355930L, "Manojgeetha12@gmail.com", date, null));
		Optional<BikeDetails> bike2=Optional.of(new BikeDetails(2,"Tn34V5656", "Manojkumar", 9789355930L, "Manojgeetha12@gmail.com", date, null));
		
		
		when(jpa.findById(1)).thenReturn(bike1);
		when(jpa.findById(2)).thenReturn(bike2);
		
		assertSame(bike2, serives.MakeFetchone(2));
		assertEquals(bike1, serives.MakeFetchone(1));
		
	}

//	@Test
//	void contextLoads() {
//	}

}
