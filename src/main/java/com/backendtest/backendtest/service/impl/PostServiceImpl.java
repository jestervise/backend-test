package com.backendtest.backendtest.service.impl;

import com.backendtest.backendtest.dao.CommentDao;
import com.backendtest.backendtest.dao.PostDao;
import com.backendtest.backendtest.entity.PostBean;

import com.backendtest.backendtest.model.TopPostModel;
import com.backendtest.backendtest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    RestTemplate restTemplate;
    CommentDao commentDao;
    PostDao postDao;

    @Autowired
    PostServiceImpl(RestTemplate restTemplate, CommentDao commentDao, PostDao postDao){
        this.restTemplate = restTemplate;
        this.commentDao = commentDao;
        this.postDao = postDao;
    }
    @Override
    public List<TopPostModel> findTopPostAll() {
        List<PostBean> postBeans=postDao.findAll();

        List<TopPostModel>t =postBeans.stream().map(p->{
                    TopPostModel tpm = new TopPostModel();
                    tpm.setPostId(p.getId());
                    tpm.setPostBody(p.getBody());
                    tpm.setPostTitle(p.getTitle());
                    tpm.setTotalNumberOfComments(commentDao.getCommentCountByPostId(p.getId()));
                    return tpm;
                }
        ).sorted(Comparator.comparing(TopPostModel::getTotalNumberOfComments).reversed()).collect(Collectors.toList());



        return t;
    }
}
