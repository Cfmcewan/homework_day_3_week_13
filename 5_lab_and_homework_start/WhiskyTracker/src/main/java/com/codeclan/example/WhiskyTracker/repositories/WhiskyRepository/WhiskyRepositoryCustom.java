package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.models.Distillery;

import java.util.List;

public interface WhiskyRepositoryCustom {

    List<Whisky> findWhiskyFromCertainDistilleryByCertainAge(String name, int age);

    List<Whisky> findWhiskeysByRegion(String region);
}
