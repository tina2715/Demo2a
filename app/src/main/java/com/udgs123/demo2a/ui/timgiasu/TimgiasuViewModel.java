package com.udgs123.demo2a.ui.timgiasu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TimgiasuViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TimgiasuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}