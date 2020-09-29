package com.backendtest.backendtest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)
public class TopPostModel {
    public Long postId;
    public String postTitle;
    public String postBody;
    public Integer totalNumberOfComments;
}
