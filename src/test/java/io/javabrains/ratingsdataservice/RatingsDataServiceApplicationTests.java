package io.javabrains.ratingsdataservice;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingsDataServiceApplicationTests {

	@Test
	public void contextLoads() {
		RatingsDataServiceApplication.main(new String[] {});
	}

}

