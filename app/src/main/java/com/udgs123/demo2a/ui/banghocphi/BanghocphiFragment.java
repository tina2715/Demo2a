package com.udgs123.demo2a.ui.banghocphi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.udgs123.demo2a.R;

public class BanghocphiFragment extends Fragment {
    View v;
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_banghocphi, container,false);
        return v;
    }
}
