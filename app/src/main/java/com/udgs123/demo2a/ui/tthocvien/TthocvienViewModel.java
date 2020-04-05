package com.udgs123.demo2a.ui.tthocvien;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TthocvienViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TthocvienViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}