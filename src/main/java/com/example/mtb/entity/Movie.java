package com.example.mtb.entity;

import com.example.mtb.enums.Certificate;
import com.example.mtb.enums.Genre;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String movieId;

    private String title;
    private String description;
    @ElementCollection
    private Set<String> castList;

    private Duration runtime;

    @Enumerated(EnumType.STRING)
    private Certificate certificate;

    @Enumerated(EnumType.STRING)
    private Genre genre;


    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Show> shows;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<Feedback> feedbacks;
}
