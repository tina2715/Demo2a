package com.udgs123.demo2a.ui.thanhtoan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.udgs123.demo2a.R;

public class Fragment_atm_nguoinhan extends Fragment {
    View v;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_atm_nguoinhan, container, false);
        return v;
    }
}
