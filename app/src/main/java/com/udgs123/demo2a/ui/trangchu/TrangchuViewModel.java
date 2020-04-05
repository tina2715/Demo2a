package com.udgs123.demo2a.ui.trangchu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TrangchuViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TrangchuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}