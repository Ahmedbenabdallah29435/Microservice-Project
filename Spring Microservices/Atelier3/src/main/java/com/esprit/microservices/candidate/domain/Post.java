package com.esprit.microservices.candidate.domain;


import com.esprit.microservices.candidate.model.Category;
import com.esprit.microservices.candidate.model.Category;
import com.esprit.microservices.candidate.model.State;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Post {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer postId;

    @Column
    //@NotBlank(message = "the Title of tte post is required!")

    private String title;
    @Column
    private String image;
    @Lob
    @Column(name = "post_content", columnDefinition = "LONGTEXT")

    //@NotBlank(message = "the Content of tte post is required!")
    private String postContent;

    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime postdate;



    @Column
    @Enumerated(EnumType.STRING)
    private State state;




   @OneToMany(cascade = CascadeType.ALL,mappedBy = "postComment")
    @JsonIgnore
    private Set<Comment> comments;




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_post_id")
    @JsonIgnore
    private User userPost;


    private String followers;



}