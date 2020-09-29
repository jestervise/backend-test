package com.backendtest.backendtest;

import com.backendtest.backendtest.dao.CommentDao;
import com.backendtest.backendtest.dao.PostDao;
import com.backendtest.backendtest.entity.CommentBean;
import com.backendtest.backendtest.entity.PostBean;
import com.backendtest.backendtest.model.CommentModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootApplication
public class BackendTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner demo(CommentDao commentDao, PostDao postDao,RestTemplate restTemplate) {
		return (args) -> {
			CommentBean[] commentBeans=restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", CommentBean[].class);
			if(commentBeans!=null)
				commentDao.saveAll(Arrays.stream(commentBeans).collect(Collectors.toList()));
			PostBean[] postBeans=restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", PostBean[].class);
			if(postBeans!=null)
				postDao.saveAll(Arrays.stream(postBeans).collect(Collectors.toList()));

		};
	}
}
