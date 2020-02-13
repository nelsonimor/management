package fr.bball.test;



import static org.junit.Assert.assertNotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.bball.management.ManagementApplication;
import fr.bball.management.bo.CityBO;
import fr.bball.management.dao.CityDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManagementApplication.class)
public class CityDAOTest {
	
	@Autowired
	private CityDAO cityDAO;
	
	private final static Logger logger = LoggerFactory.getLogger(CityDAOTest.class);

	@Test
	public void testGetCities() {
		List<CityBO> cities = cityDAO.findAll();
		logger.debug("Number of cities : {}",cities.size());
		assertNotNull(cities);
	}

}
