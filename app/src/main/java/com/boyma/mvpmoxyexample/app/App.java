package com.boyma.mvpmoxyexample.app;

import android.app.Application;

import com.boyma.mvpmoxyexample.app.di.AppModule;
import com.boyma.mvpmoxyexample.app.di.DaggerNetComponent;
import com.boyma.mvpmoxyexample.app.di.NetComponent;
import com.boyma.mvpmoxyexample.app.di.NetModule;

public class App extends Application {

    private static NetComponent netComponent;

    public static NetComponent getNetComponent() {
        return netComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();

    }

}
