package com.backendtest.backendtest.service.impl;

import com.backendtest.backendtest.dao.CommentDao;
import com.backendtest.backendtest.dao.PostDao;
import com.backendtest.backendtest.entity.CommentBean;
import com.backendtest.backendtest.entity.PostBean;

import com.backendtest.backendtest.model.CommentModel;
import com.backendtest.backendtest.model.TopPostModel;
import com.backendtest.backendtest.service.CommentService;
import com.backendtest.backendtest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import javax.xml.stream.events.Comment;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    RestTemplate restTemplate;
    CommentDao commentDao;
    CommentService commentService;
    PostDao postDao;

    @Autowired
    PostServiceImpl(RestTemplate restTemplate, CommentDao commentDao, PostDao postDao,CommentService commentService){
        this.restTemplate = restTemplate;
        this.commentDao = commentDao;
        this.postDao = postDao;
        this.commentService = commentService;
    }
    @Override
    public List<TopPostModel> findTopPostAll() {
        PostBean[] postBeans=restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", PostBean[].class);

        List<TopPostModel>t = Arrays.stream(postBeans).map(p->{
                    TopPostModel tpm = new TopPostModel();
                    tpm.setPostId(p.getId());
                    tpm.setPostBody(p.getBody());
                    tpm.setPostTitle(p.getTitle());
                    CommentModel cm= new CommentModel();
                    cm.setPostId(p.getId());
                    tpm.setTotalNumberOfComments(commentService.findCommentByParams(cm).length);
                    return tpm;
                }
        ).sorted(Comparator.comparing(TopPostModel::getTotalNumberOfComments).reversed()).collect(Collectors.toList());



        return t;
    }
}
