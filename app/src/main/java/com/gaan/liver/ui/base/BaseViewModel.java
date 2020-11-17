package com.gaan.liver.ui.base;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

import com.gaan.liver.data.manager.IUserDataManager;
import com.gaan.liver.util.rx.SchedulerProvider;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<N> extends ViewModel {

    private final IUserDataManager mUserDataManager;

    private final SchedulerProvider mSchedulerProvider;

    private CompositeDisposable mCompositeDisposable;

    private final ObservableBoolean mIsLoading = new ObservableBoolean();

    private WeakReference<N> mNavigator;

    public BaseViewModel(IUserDataManager iUserDataManager,SchedulerProvider schedulerProvider) {
        this.mCompositeDisposable = new CompositeDisposable();
        this.mSchedulerProvider = schedulerProvider;
        this.mUserDataManager = iUserDataManager;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public IUserDataManager getUserDataManager() {
        return mUserDataManager;
    }


    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }
}