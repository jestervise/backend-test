package com.backendtest.backendtest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentModel {
    public Long postId;
    public Long id;
    public String name;
    public String email;
    public String body;
}
