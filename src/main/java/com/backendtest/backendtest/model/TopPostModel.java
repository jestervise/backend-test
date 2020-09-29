package com.backendtest.backendtest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)
public class TopPostModel{
    @JsonProperty("post_id")
    private Long postId;
    @JsonProperty("post_title")
    private String postTitle;
    @JsonProperty("post_body")
    private String postBody;
    @JsonProperty("total_number_of_comments")
    private Integer totalNumberOfComments;


}
