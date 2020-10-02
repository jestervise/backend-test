package com.backendtest.backendtest.service.impl;

import com.backendtest.backendtest.dao.CommentDao;
import com.backendtest.backendtest.entity.CommentBean;
import com.backendtest.backendtest.model.CommentModel;
import com.backendtest.backendtest.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    CommentDao commentDao;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CommentServiceImpl(CommentDao commentDao){
        this.commentDao = commentDao;
    }
    @Override
    public CommentBean[] findCommentByParams(CommentModel commentModel) {
        CommentBean[] commentBeans=restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", CommentBean[].class);
        if(commentBeans!=null) {
            return Arrays.stream(commentBeans).filter(commentBean -> {
                boolean post = true;
                if (commentModel.getPostId() != null)
                    post = commentBean.getPostId().intValue() == commentModel.getPostId().intValue();

                boolean body = true;
                if (commentModel.getBody() != null)
                    body = commentBean.getBody().contains(commentModel.getBody());

                boolean email = true;
                if (commentModel.getEmail() != null)
                    email = commentBean.getEmail().contains(commentModel.getEmail());

                boolean name = true;
                if (commentModel.getName() != null)
                    name = commentBean.getName().contains(commentModel.getName());

                boolean id = true;
                if (commentModel.getId() != null)
                    id = commentBean.getId().intValue() == commentModel.getId().intValue();

                return post && body && email && name && id;
            }).toArray(CommentBean[]::new);


        }else{
            return new CommentBean[0];
        }
//        return commentDao.findCommentByPostIdAndEmailAndNameAndBodyAndId(commentModel.getPostId(),commentModel.getEmail(),commentModel.getName(),commentModel.getBody(),commentModel.getId());
    }
}
