package com.backendtest.backendtest.service.impl;

import com.backendtest.backendtest.dao.CommentDao;
import com.backendtest.backendtest.entity.PostBean;
import com.backendtest.backendtest.model.CommentModel;
import com.backendtest.backendtest.model.PostModel;
import com.backendtest.backendtest.model.TopPostModel;
import com.backendtest.backendtest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    RestTemplate restTemplate;
    CommentDao commentDao;

    @Autowired
    PostServiceImpl(RestTemplate restTemplate, CommentDao commentDao){
        this.restTemplate = restTemplate;
        this.commentDao = commentDao;
    }
    @Override
    public PostModel[] findTopPostAll() {
        System.out.println("ss");
        PostModel[] posts=restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", PostModel[].class);


        return posts;
    }
}
