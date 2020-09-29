package com.backendtest.backendtest.dao;

import com.backendtest.backendtest.entity.CommentBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<CommentBean,Long> {

    @Query("SELECT COUNT(c) FROM CommentBean c WHERE c.postId = ?1")
    Integer getCommentCountByPostId(Long postId);

    @Query("SELECT c FROM CommentBean c WHERE (:name IS NULL OR c.name LIKE  '%' ||:name || '%') AND (:email IS NULL"
            + " OR c.email LIKE  '%' ||:email || '%') AND (:postId IS NULL OR c.postId =:postId ) AND (:body IS NULL OR c.body LIKE  '%' ||:body || '%')  AND" +
            "(:id IS NULL OR c.id =:id )")
    CommentBean[] findCommentByPostIdAndEmailAndNameAndBodyAndId(@Param("postId")Long postId, @Param("email") String email, @Param("name") String name, @Param("body") String body, @Param("id") Long id);

}
