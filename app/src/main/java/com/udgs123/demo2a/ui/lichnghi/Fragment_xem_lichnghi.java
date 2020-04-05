package com.udgs123.demo2a.ui.lichnghi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.demo2a.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_xem_lichnghi extends Fragment {


    View v;

    private RecyclerView myrecycleview;
    private List<Xemlichnghi> lstXemlichnghi;
    public Fragment_xem_lichnghi() {
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_xem_lichnghi,container,false);
        myrecycleview =(RecyclerView) v.findViewById(R.id.lichnghi_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstXemlichnghi);
        myrecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleview.setAdapter(recyclerViewAdapter);
        return v;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstXemlichnghi = new ArrayList<>();
        lstXemlichnghi.add(new Xemlichnghi("B512","1/2/2018","3/2/2018","bận việc gia đình","ôn lại kiến thức","Gia sư","1/1/2018"));
        lstXemlichnghi.add(new Xemlichnghi("A179","5/3/2018","7/3/2018","bận họp","ôn lại kiến thức","Gia sư","1/1/2018"));
        lstXemlichnghi.add(new Xemlichnghi("A179","4/8/2018","6/8/2018","bận việc cá nhân","ôn lại kiến thức","Gia sư","1/1/2018"));
        lstXemlichnghi.add(new Xemlichnghi("B512","9/7/2018","11/7/2018","bận việc gia đình","ôn lại kiến thức","Gia sư","1/1/2018"));
        lstXemlichnghi.add(new Xemlichnghi("B512","2/5/2018","5/5/2018","bận họp","ôn lại kiến thức","Gia sư","1/1/2018"));
        lstXemlichnghi.add(new Xemlichnghi("A179","8/4/2018","10/4/2018","bận việc cá nhân","ôn lại kiến thức","Gia sư","1/1/2018"));
        lstXemlichnghi.add(new Xemlichnghi("B512","18/3/2018","20/3/2018","nghỉ bệnh","ôn lại kiến thức","Gia sư","1/1/2018"));
        lstXemlichnghi.add(new Xemlichnghi("A179","24/2/2018","26/2/2018","bận việc cá nhân","ôn lại kiến thức","Gia sư","1/1/2018"));
        lstXemlichnghi.add(new Xemlichnghi("B512","27/3/2018","29/3/2018","bận họp","ôn lại kiến thức","Gia sư","1/1/2018"));
        lstXemlichnghi.add(new Xemlichnghi("B512","30/4/2018","3/5/2018","nghỉ lễ","ôn lại kiến thức","Gia sư", "1/1/2018"));
    }
}
