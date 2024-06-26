package com.example.restclient.user.client;

import com.example.restclient.user.dto.UserRequest;
import com.example.restclient.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class UserClient {

    private final static String BASE_URI = "/users";
    private final RestClient restClient;

    public UserResponse postUser(UserRequest userRequest) {
        return restClient
            .post()
            .uri(BASE_URI)
            .body(userRequest)
            .retrieve()
            .body(UserResponse.class);
    }


    public UserResponse putUser(long userId, UserRequest userRequest) {
        return restClient
            .put()
            .uri(String.format("%s/%d", BASE_URI, userId))
            .body(userRequest)
            .retrieve()
            .body(UserResponse.class);
    }


    public UserResponse getUser(long userId) {
        return restClient
            .get()
            .uri(String.format("%s/%d", BASE_URI, userId))
            .retrieve()
            .body(UserResponse.class);
    }

    public Void deleteUser(long userId) {
        return restClient
            .delete()
            .uri(String.format("%s/%d", BASE_URI, userId))
            .retrieve()
            .body(Void.class);
    }

}
