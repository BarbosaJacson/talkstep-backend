package com.talkstep.api.domain.entity;

import jakarta.persistence.*;
import com.talkstep.api.domain.enums.CefrLevel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "itinerary")
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "target_level", nullable = false, length = 20)
    private CefrLevel targetlevel;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModuleTopic> topics = new ArrayList<>();

    public Itinerary() {
    }


    public Itinerary(String title, String description, CefrLevel targetLevel) {
        this.title = title;
        this.description = description;
        this.targetlevel = targetLevel;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CefrLevel getTargetlevel() {
        return targetlevel;
    }

    public void setTargetlevel(CefrLevel targetlevel) {
        this.targetlevel = targetlevel;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<ModuleTopic> getTopics() {
        return topics;
    }

    public void setTopics(List<ModuleTopic> topics) {
        this.topics = topics;
    }

    @PrePersist
    protected void onCreated() {
        this.createdAt = LocalDateTime.now();
    }

    public void addTopic(ModuleTopic topic) {
        topics.add(topic);
        topic.setItinerary(this);

    }

    public void removeTopic(ModuleTopic topic) {
        topics.remove(topic);
        topic.setItinerary(null);

    }

}
