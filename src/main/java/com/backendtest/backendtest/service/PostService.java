package com.backendtest.backendtest.service;

import com.backendtest.backendtest.model.PostModel;

import java.util.List;

public interface PostService {
    PostModel[] findTopPostAll();
}
