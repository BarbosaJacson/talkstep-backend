package domain.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topic_id", nullable = false)
    private ModuleTopic topic;

    @Column(name = "lesson_number", nullable = false)
    private Integer lessonNumber;

    @Column(nullable = false, length = 20)
    private String status = "PLANNED";

    @Column(name = "previous_lesson_summary", columnDefinition = "TEXT")
    private String previousLessonSummary;

    @Column(name = "current_topic_summary", columnDefinition = "TEXT")
    private String currentTopicSummary;

    @Column(name = "weak_points_notes", columnDefinition = "TEXT")
    private String weakPointsNotes;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    public Lesson() {
    }

    public Lesson(ModuleTopic topic, Integer lessonNumber) {
        this.topic = topic;
        this.lessonNumber = lessonNumber;
    }

    public Long getId() {
        return id;
    }

    public ModuleTopic getTopic() {
        return topic;
    }

    public void setTopic(ModuleTopic topic) {
        this.topic = topic;
    }

    public Integer getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(Integer lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}