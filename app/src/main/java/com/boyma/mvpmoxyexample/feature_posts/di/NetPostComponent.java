package com.boyma.mvpmoxyexample.feature_posts.di;

import com.boyma.mvpmoxyexample.app.di.NetComponent;
import com.boyma.mvpmoxyexample.app.di.scopes.PerActivityScope;
import com.boyma.mvpmoxyexample.feature_posts.data.PostsDataRepository;
import com.boyma.mvpmoxyexample.main.ui.MainActivity;

import dagger.Component;

@PerActivityScope
@Component(modules = {NetPostModule.class}, dependencies = NetComponent.class)
public interface NetPostComponent {

    void injecttim(MainActivity mainActivity);

    PostsDataRepository getIPostDataRepository();
}
