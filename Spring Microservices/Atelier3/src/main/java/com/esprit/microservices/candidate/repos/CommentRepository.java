package com.esprit.microservices.candidate.repos;

import com.esprit.microservices.candidate.domain.Comment;
import com.esprit.microservices.candidate.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("SELECT c FROM Comment c")
    List<Comment> getAllComments();
    @Query("SELECT c FROM Comment c where c.postComment=:post ")
    public List<Comment> getAllComments(@Param("post") Post post);
    @Query("SELECT c FROM Comment c where c.postComment=:post ")
    List<Comment> findAllByCommentPost(Post post);
}
