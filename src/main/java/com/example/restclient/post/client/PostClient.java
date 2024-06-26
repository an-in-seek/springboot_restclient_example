package com.example.restclient.post.client;

import com.example.restclient.post.dto.PostRequest;
import com.example.restclient.post.dto.PostResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class PostClient {

    private final static String BASE_URI = "/posts";
    private final RestClient restClient;

    public PostResponse postPost(PostRequest postRequest) {
        return restClient
            .post()
            .uri(BASE_URI)
            .body(postRequest)
            .retrieve()
            .body(PostResponse.class);
    }


    public PostResponse putPost(long postId, PostRequest postRequest) {
        return restClient
            .put()
            .uri(String.format("%s/%d", BASE_URI, postId))
            .body(postRequest)
            .retrieve()
            .body(PostResponse.class);
    }


    public PostResponse getPost(long postId) {
        return restClient
            .get()
            .uri(String.format("%s/%d", BASE_URI, postId))
            .retrieve()
            .body(PostResponse.class);
    }

    public List<PostResponse> getPostByUserId(long userId) {
        return restClient
            .get()
            .uri(uriBuilder -> uriBuilder
                .path(BASE_URI)
                .queryParam("userId", userId)
                .build())
            .retrieve()
            .body(new ParameterizedTypeReference<>() {
            });
    }

    public Void deletePost(long postId) {
        return restClient
            .delete()
            .uri(String.format("%s/%d", BASE_URI, postId))
            .retrieve()
            .body(Void.class);
    }

}
