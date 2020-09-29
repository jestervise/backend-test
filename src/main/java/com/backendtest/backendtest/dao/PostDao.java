package com.backendtest.backendtest.dao;

import com.backendtest.backendtest.entity.CommentBean;
import com.backendtest.backendtest.entity.PostBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends JpaRepository<PostBean,Long> {
}
