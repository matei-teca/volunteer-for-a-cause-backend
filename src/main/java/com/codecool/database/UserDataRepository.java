package com.codecool.database;

import com.codecool.model.VolunteerData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<VolunteerData, Long> {
    // Sa nu uit sa am pgAdmin deschis
}