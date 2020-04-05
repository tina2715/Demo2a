package com.udgs123.demo2a.ui.thanhtoan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ThanhtoanViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ThanhtoanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}