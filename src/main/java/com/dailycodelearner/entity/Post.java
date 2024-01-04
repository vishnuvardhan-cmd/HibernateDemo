package com.dailycodelearner.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    private String content;

    private Date postedAt = new Date();

    private Date lastUpdated = new Date();

    public Post(Long id, String title, String description, String content, Date postedAt, Date lastUpdated) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.postedAt = postedAt;
        this.lastUpdated = lastUpdated;
    }

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "post_tag", joinColumns = {@JoinColumn(name = "post_id")}, inverseJoinColumns = {@JoinColumn(name = "tag_id")}

    )
    private List<Tag> tags;

}
