package com.example.restclient.post.dto;

public record PostRequest(
    String title,
    String content,
    long userId
) {

}
