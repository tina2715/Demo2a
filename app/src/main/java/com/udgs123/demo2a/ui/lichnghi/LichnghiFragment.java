package com.udgs123.demo2a.ui.lichnghi;

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
public class LichnghiFragment extends Fragment {
    View v;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPaperAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_lichnghi,container,false);


        tabLayout = (TabLayout) v.findViewById(R.id.tablayout_lichnghi);
        viewPager = (ViewPager) v.findViewById(R.id.viewpaper_lichnghi);
        FragmentManager cfManager = getFragmentManager();
        adapter = new ViewPaperAdapter(cfManager);

        adapter.AddFragment(new Fragment_tao_lichnghi(),"Tạo lịch nghỉ");
        adapter.AddFragment(new Fragment_xem_lichnghi(),"Xem lịch nghỉ");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return v;
    }

}