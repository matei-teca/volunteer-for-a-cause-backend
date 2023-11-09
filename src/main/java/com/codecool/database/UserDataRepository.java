package com.codecool.database;

import com.codecool.data.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Long> {
    // Sa nu uit sa am pgAdmin deschis
}