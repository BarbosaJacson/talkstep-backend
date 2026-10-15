package com.talkstep.api.domain.entity;

import jakarta.persistence.*;
import com.talkstep.api.domain.enums.AuthProvider;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private  String name;
    @Column(nullable = false, unique = true, length = 150)
    private String email;
    @Column(name = "google_id", unique = true)
    private String googleId;
    @Column(name = "picture_url")
    private String pictureUrl;
    @Enumerated(EnumType.STRING)
    @Column(name = "auth_provider", nullable = false, length = 20)
    private AuthProvider authProvider;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Itinerary> itineraries = new ArrayList<>();

    @PrePersist
    protected void onCreate(){this.createdAt = LocalDateTime.now();}

    public User() {
    }

    public User(String name, String email, String googleId, String pictureUrl, AuthProvider authProvider) {
        this.name = name;
        this.email = email;
        this.googleId = googleId;
        this.pictureUrl = pictureUrl;
        this.authProvider = authProvider;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public AuthProvider getAuthProvider() {
        return authProvider;
    }

    public void setAuthProvider(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    public void addItinerary(Itinerary itinerary) {
        itineraries.add(itinerary);
        itinerary.setUser(this);
    }

    public void removeItinerary(Itinerary itinerary) {
        itineraries.remove(itinerary);
        itinerary.setUser(null);
    }
}





