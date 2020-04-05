package com.udgs123.demo2a.ui.lichnghi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPaperAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> lstFragment = new ArrayList<>();
    private final List<String> lstTitles = new ArrayList<>();

    public ViewPaperAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
    }

    @Override

    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return lstTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitles.get(position);
    }

    public void AddFragment (Fragment fragment, String titile) {
        lstFragment.add(fragment);
        lstTitles.add(titile);
    }

}
