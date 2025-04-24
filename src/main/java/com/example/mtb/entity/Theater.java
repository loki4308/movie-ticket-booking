package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Builder
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String theaterId;
    private String name;
    private String address;
    private String city;
    private String landmark;
    private long createdAt;
    private long updateAt;
    private String createdBy;

    @ManyToOne
    private TheaterOwner theaterOwner;
}
