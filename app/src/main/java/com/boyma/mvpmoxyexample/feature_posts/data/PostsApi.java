package com.boyma.mvpmoxyexample.feature_posts.data;

import com.boyma.mvpmoxyexample.feature_posts.data.models.PostDto;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface PostsApi {

    @GET("/posts")
    Single<List<PostDto>> getPosts();
}
