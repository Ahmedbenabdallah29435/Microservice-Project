package com.esprit.microservices.candidate.service;

import com.esprit.microservices.candidate.domain.Comment;
import com.esprit.microservices.candidate.domain.Post;

import java.io.IOException;
import java.util.List;

public interface ICommentService  {
    public void addComment(Comment c ) throws IOException;


    public void updateComment(Comment c);
    public String deleteComment(int idc);
    public List<Comment> comments();

    Comment retrieveCommentById(Integer commentId);
    public List<Comment> comments(Post p);



}