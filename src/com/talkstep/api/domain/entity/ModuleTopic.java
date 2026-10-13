package com.talkstep.api.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "module_topic")
public class ModuleTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "itinerary_id", nullable = false)
    private Itinerary itinerary;
    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;
    @Column(nullable = false, length = 150)
    private String title;
    @Column(name = "grammar_focus")
    private String grammarFocus;
    @Column(name = "vocabulary_focus")
    private String vocabularyFocus;
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesson> lessons = new ArrayList<>();

    public ModuleTopic() {
    }

    public ModuleTopic(Itinerary itinerary, Integer orderIndex, String title, String grammarFocus, String vocabularyFocus, List<Lesson> lessons) {
        this.itinerary = itinerary;
        this.orderIndex = orderIndex;
        this.title = title;
        this.grammarFocus = grammarFocus;
        this.vocabularyFocus = vocabularyFocus;
        this.lessons = lessons;
    }

    public Long getId() {
        return id;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrammarFocus() {
        return grammarFocus;
    }

    public void setGrammarFocus(String grammarFocus) {
        this.grammarFocus = grammarFocus;
    }

    public String getVocabularyFocus() {
        return vocabularyFocus;
    }

    public void setVocabularyFocus(String vocabularyFocus) {
        this.vocabularyFocus = vocabularyFocus;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
