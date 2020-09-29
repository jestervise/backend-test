package com.backendtest.backendtest.service.impl;

import com.backendtest.backendtest.dao.CommentDao;
import com.backendtest.backendtest.entity.CommentBean;
import com.backendtest.backendtest.model.CommentModel;
import com.backendtest.backendtest.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    CommentDao commentDao;

    @Autowired
    CommentServiceImpl(CommentDao commentDao){
        this.commentDao = commentDao;
    }
    @Override
    public CommentBean[] findCommentByParams(CommentModel commentModel) {
        return commentDao.findCommentByPostIdAndEmailAndNameAndBodyAndId(commentModel.getPostId(),commentModel.getEmail(),commentModel.getName(),commentModel.getBody(),commentModel.getId());
    }
}
