package com.backendtest.backendtest.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CommentBean {
    @Id
    private Long Id;

    private Long postId;

    private String name;

    private String email;

    @Column(length=2000)
    private String body;
}
