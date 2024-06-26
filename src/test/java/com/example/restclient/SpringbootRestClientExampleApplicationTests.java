package com.example.restclient;

import com.example.restclient.post.client.PostClient;
import com.example.restclient.post.dto.PostResponse;
import com.example.restclient.user.client.UserClient;
import com.example.restclient.user.dto.UserResponse;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRestClientExampleApplicationTests {

    @Autowired
    private UserClient userClient;

    @Autowired
    private PostClient postClient;

    @Test
    void contextLoads() {
        // 테스트할 User ID
        final long userId = 7;

        // User ID가 7인 사용자 정보 조회
        UserResponse user = userClient.getUser(userId);
        System.out.println(user);

        // User ID가 7인 사용자가 작성한 Post 정보 조회
        List<PostResponse> posts = postClient.getPostByUserId(userId);
        posts.forEach(System.out::println);
    }

}
