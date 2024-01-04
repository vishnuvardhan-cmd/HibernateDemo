package com.dailycodelearner.service;

import com.dailycodelearner.entity.Post;
import com.dailycodelearner.exception.PostNotFoundException;
import com.dailycodelearner.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {

        return postRepository.findAll();
    }

    @Override
    public Post findByTitle(String title) {
        Optional<Post> byTitle = postRepository.findByTitle(title);
        if(!byTitle.isPresent()){
            throw new PostNotFoundException("Post Not Found with the given title : "+title);
        }
        return byTitle.get();
    }

    @Override
    public Post findById(Long id) {
        Optional<Post> byId = postRepository.findById(id);
        if(!(byId.isPresent())){
            throw new PostNotFoundException("Post Not Found with this id : "+id);
        }
        return byId.get();
    }

    @Override
    public Post updateTitle(Post post,String title) {
        post.setTitle(title);
        return savePost(post);
    }

    @Override
    public Post deleteById(Long id) {
        Post post = findById(id);
        postRepository.deleteById(id);
        return post;
    }
}
