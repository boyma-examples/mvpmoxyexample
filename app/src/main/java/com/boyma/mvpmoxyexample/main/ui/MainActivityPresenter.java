package com.boyma.mvpmoxyexample.main.ui;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.boyma.mvpmoxyexample.app.App;
import com.boyma.mvpmoxyexample.feature_posts.data.models.PostDto;
import com.boyma.mvpmoxyexample.feature_posts.di.DaggerNetPostComponent;
import com.boyma.mvpmoxyexample.feature_posts.di.NetPostComponent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<IMainActivityView> {

    private boolean firstlaunch = true;
    private NetPostComponent netPostComponent;

    public MainActivityPresenter() {
        System.out.println("MainActivityPresenter constructor");
        netPostComponent = DaggerNetPostComponent.builder()
                .netComponent((App.getNetComponent()))
                .build();
    }


    @SuppressLint("CheckResult")
    public void onCreate() {
        netPostComponent.getIPostDataRepository().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onSuccess,
                        throwable -> System.out.println(throwable.toString())
                );
    }

    private void onSuccess(List<PostDto> posts) {
        System.out.println("sdf:" + posts.size());
        if (firstlaunch) getViewState().showToast("asd:" + posts.size());
        getViewState().setText("asd:" + posts.size());
        firstlaunch = false;
    }
}
