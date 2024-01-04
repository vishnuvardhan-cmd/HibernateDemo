package com.dailycodelearner.controller;

import com.dailycodelearner.entity.Post;
import com.dailycodelearner.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/savepost")
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        Post savePost = postService.savePost(post);
        return new ResponseEntity<>(savePost, HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Post>> findAll(){
        List<Post> posts=postService.findAll();
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("/findByTitle")
    public ResponseEntity<Post> findByTitle(@RequestParam(value="title") String title ){
        Post post = postService.findByTitle(title);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @PutMapping("/updateTitle/{id}")
    public ResponseEntity<Post> updateTitle(@PathVariable("id") Long id,@RequestBody String title){
        Post post=postService.findById(id);
        Post post1=postService.updateTitle(post,title);
        return new ResponseEntity<>(post1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Post> deleteById(@PathVariable("id") Long id){
        Post post = postService.deleteById(id);
        return new ResponseEntity<>(post,HttpStatus.OK);

    }
/**
 * sample request for Post and Tag Object
    {
        "title":"my history",
            "description":"success rate is 0.1%",
            "content":"Not Stronger Than 2 days"
            "tags":[
        {"name":"bel"},
        {"name":"hebbal"},
        {"name":"belandur"},
        {"name":"sarjapur"}
    ]
    }
 **/
}
