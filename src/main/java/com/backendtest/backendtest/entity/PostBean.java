package com.backendtest.backendtest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PostBean {
    @Id
    private Long id;
    private Long userId;
    private String title;
    private String body;
}
