package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskeysByYear(){
		List<Whisky> found = whiskyRepository.findWhiskeysByYear(2018);
		assertEquals(2, found.size());
	}

	@Test
	public void findDistilleriesByRegion(){
		List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Speyside");
		assertEquals(2, found.size());
	}

	@Test
	public void findWhiskyByDistilleryByAge(){
		List<Whisky> found = whiskyRepository.findWhiskyFromCertainDistilleryByCertainAge("Macallan", 1995);
		assertEquals(1, found.size());
	}

	@Test
	public void findDistilleriesByWhiskyAge(){
		List<Distillery> found = distilleryRepository.findDistilleriesByWhiskiesOfCertainAge(12);
		assertEquals(2, found.size());

	}

}
