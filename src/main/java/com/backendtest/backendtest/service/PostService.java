package com.backendtest.backendtest.service;

import com.backendtest.backendtest.model.TopPostModel;

import java.util.List;

public interface PostService {
    List<TopPostModel> findTopPostAll();
}
