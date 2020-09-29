package com.backendtest.backendtest.mvc;

import com.backendtest.backendtest.model.PostModel;
import com.backendtest.backendtest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value= "/rest/post/")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/find-top-post-all")
    public PostModel[] findTopPostAll(){
        return postService.findTopPostAll();
    }
}
