package com.udgs123.demo2a.ui.lichnghi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LichnghiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LichnghiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}