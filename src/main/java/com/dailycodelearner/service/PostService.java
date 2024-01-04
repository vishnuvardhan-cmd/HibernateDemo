package com.dailycodelearner.service;

import com.dailycodelearner.entity.Post;

import java.util.List;

public interface PostService {

    public Post savePost(Post post);

    List<Post> findAll();

    Post findByTitle(String title);

    Post findById(Long id);

    Post updateTitle(Post post,String title);

    Post deleteById(Long id);
}
