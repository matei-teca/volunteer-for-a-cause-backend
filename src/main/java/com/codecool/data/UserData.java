package com.codecool.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserData {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String personalObjective;
    private String phoneNbr;
    private String email;
    private String role;

    //TODO: foreign key
//    private int cause_id;
}
