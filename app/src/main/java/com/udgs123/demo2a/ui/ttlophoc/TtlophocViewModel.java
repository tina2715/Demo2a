package com.udgs123.demo2a.ui.ttlophoc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TtlophocViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TtlophocViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Thông tin lớp học fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}