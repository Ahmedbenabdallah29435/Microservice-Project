package com.esprit.microservices.candidate.service;

import com.esprit.microservices.candidate.domain.Post;

import lombok.NonNull;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IPostService {

    Post savePost(Post post) throws Exception;
    public Post addPost(Post p, int userId)throws MessagingException;

    public void updatePost(Post p);

    public String deletePost(int idp);

    public List<Post> allPost();

    Post retrievePostById(Integer postId);



    public void follow(int idp, int idu);

    public void unfollow(int idp, int idu);
    public  Map<Integer, Post> topPosts(int days);


    public List<Post> retrieveByDateAsc();
    public List<Post> retrieveByDateDesc();

    Post getById(Integer offreid);
}