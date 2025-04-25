package com.example.mtb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@ToString
public class TheaterOwner extends UserDetails{

    @OneToMany(mappedBy = "theaterOwner")
    private List<Theater> theaters;
}
