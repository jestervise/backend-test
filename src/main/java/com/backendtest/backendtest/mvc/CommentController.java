package com.backendtest.backendtest.mvc;

import com.backendtest.backendtest.entity.CommentBean;
import com.backendtest.backendtest.model.CommentModel;
import com.backendtest.backendtest.service.CommentService;
import com.backendtest.backendtest.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value= "/rest/comment/")
public class CommentController {
    CommentService commentService;


    @Autowired
    CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/find-comment-by-params")
    public CommentBean[] findCommentByParams(@RequestBody(required = true) CommentModel commentModel){

        return commentService.findCommentByParams(commentModel);
    }

}
