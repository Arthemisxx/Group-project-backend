package org.example.photobackend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(length = 1000)
    private String bio;

    private String profilePictureUrl;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Relations
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LocationEntity> locations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PhotoEntity> photos;
}
