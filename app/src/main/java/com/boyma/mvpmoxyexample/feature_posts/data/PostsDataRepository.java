package com.boyma.mvpmoxyexample.feature_posts.data;

import com.boyma.mvpmoxyexample.feature_posts.data.models.PostDto;

import java.util.List;

import io.reactivex.Single;

public interface PostsDataRepository {
    Single<List<PostDto>> getPosts();
}
