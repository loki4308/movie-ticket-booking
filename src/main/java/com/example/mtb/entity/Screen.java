package com.example.mtb.entity;

import com.example.mtb.enums.ScreenType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String screenId;
    @Enumerated(EnumType.STRING)
    private ScreenType screenType;
    private Integer capacity;
    private Integer noOfRows;
    private long createdAt;
    private long updatedAt;
    private String createdBy;

    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("seatName ASC")
    private List<Seat> seats;

    @OneToMany(mappedBy = "screen", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Show> shows;
}
