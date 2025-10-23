package org.example.photobackend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "locations")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    private String address;
    private String city;
    private String country;
    private LocalDateTime createdAt = LocalDateTime.now();

    // Relationships
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<PhotoEntity> photos;

//    @ManyToMany
//    @JoinTable(
//            name = "location_tags",
//            joinColumns = @JoinColumn(name = "location_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id")
//    )
//    private List<Tag> tags;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;
}
