package com.backendtest.backendtest.mvc;


import com.backendtest.backendtest.model.TopPostModel;
import com.backendtest.backendtest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "/rest/post/")
public class PostController {
    PostService postService;

    @Autowired
    PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/find-top-post-all")
    public List<TopPostModel> findTopPostAll(){
        return postService.findTopPostAll();
    }
}
