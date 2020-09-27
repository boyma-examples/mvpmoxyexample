package com.boyma.mvpmoxyexample.feature_posts.data;

import com.boyma.mvpmoxyexample.feature_posts.data.models.PostDto;

import java.util.List;

import io.reactivex.Single;

public class PostsDataRepositoryImpl implements PostsDataRepository {

    private PostsApi api;


    public PostsDataRepositoryImpl(PostsApi api) {
        this.api = api;
        System.out.println("PostDataRepositoryImpl constructor");
    }

    @Override
    public Single<List<PostDto>> getPosts() {
        return api.getPosts();
    }
}
