package com.example.wbvideo2.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<String> mUrl = new MutableLiveData<>();

    public void setUrl(String url) {
        mUrl.setValue(url);
    }

    public LiveData<String> getUrl() {
        return mUrl;
    }
}