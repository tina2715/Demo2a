package com.udgs123.demo2a.ui.banghocphi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BanghocphiViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    public BanghocphiViewModel () {
        mText = new MutableLiveData<>();
        mText.setValue("Bảng học phí");
    }
    public LiveData<String> getText() {return mText;}
}
