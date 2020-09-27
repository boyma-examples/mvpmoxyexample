package com.boyma.mvpmoxyexample.app.di;

import com.boyma.mvpmoxyexample.app.di.scopes.AppScope;

import dagger.Component;
import retrofit2.Retrofit;

@AppScope
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    Retrofit getRetrofit();
}
