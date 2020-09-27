package com.boyma.mvpmoxyexample.feature_posts.di;

import com.boyma.mvpmoxyexample.app.di.scopes.PerActivityScope;
import com.boyma.mvpmoxyexample.feature_posts.data.PostsApi;
import com.boyma.mvpmoxyexample.feature_posts.data.PostsDataRepository;
import com.boyma.mvpmoxyexample.feature_posts.data.PostsDataRepositoryImpl;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class NetPostModule {

    @Provides
    @PerActivityScope
    public PostsDataRepository provideRepository(PostsApi api) {
        return new PostsDataRepositoryImpl(api);
    }

    @Provides
    @PerActivityScope
    public PostsApi provideApi(Retrofit retrofit) {
        System.out.println("Api Constructor");
        return retrofit.create(PostsApi.class);
    }

}
