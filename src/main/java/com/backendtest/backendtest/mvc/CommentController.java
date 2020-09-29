package com.backendtest.backendtest.mvc;

import com.backendtest.backendtest.model.CommentModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value= "/rest/comment/")
public class CommentController {

    @GetMapping("/find-all-comment")
    public CommentModel findAllComment(){
        //TODO find all comment
        System.out.println("See");
        return null;
    }

    @GetMapping("/find-all-comment-by-title-and-body")
    public CommentModel findCommentByTitleAndBody(@RequestParam(value = "title",required = false) String title,@RequestParam(value = "body",required = false) String body){
        return null;
    }

}
