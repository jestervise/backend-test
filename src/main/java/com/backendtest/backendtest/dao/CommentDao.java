package com.backendtest.backendtest.dao;

import com.backendtest.backendtest.entity.CommentBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<CommentBean,Long> {
    List<CommentBean> getById(Long id);
}
