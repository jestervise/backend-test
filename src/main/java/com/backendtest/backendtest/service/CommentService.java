package com.backendtest.backendtest.service;

import com.backendtest.backendtest.entity.CommentBean;
import com.backendtest.backendtest.model.CommentModel;

public interface CommentService {
    CommentBean[] findCommentByParams(CommentModel commentModel);
}
