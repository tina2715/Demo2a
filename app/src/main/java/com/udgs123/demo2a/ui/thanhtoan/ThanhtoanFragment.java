package com.udgs123.demo2a.ui.thanhtoan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;
import com.udgs123.demo2a.R;

public class ThanhtoanFragment extends Fragment {
    View v;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPaperAdapter adapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_thanhtoan,container,false);

        tabLayout = (TabLayout) v.findViewById(R.id.tablayout);
        viewPager = (ViewPager) v.findViewById(R.id.viewpaper);
        FragmentManager cfManager = getFragmentManager();
        adapter = new ViewPaperAdapter(cfManager);

        adapter.AddFragment(new Fragment_thanhtoan_trai(),"Sử dụng ATM");
        adapter.AddFragment(new Fragment_thanhtoan_phai(),"Phương thức khác");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return v;

    }

}