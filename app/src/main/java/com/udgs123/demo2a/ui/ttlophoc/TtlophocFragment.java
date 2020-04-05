package com.udgs123.demo2a.ui.ttlophoc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.demo2a.R;

import java.util.ArrayList;
import java.util.List;

public class TtlophocFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Ttlophoc> lstTtlophoc;

    public TtlophocFragment () {
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_ttlophoc,container,false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.ttlophoc_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstTtlophoc);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstTtlophoc=new ArrayList<>();
        lstTtlophoc.add(new Ttlophoc("A123","Trần Văn A", "Tiếng Việt", "Bình Thạnh", "1.600.000", "Giảng viên", "Thứ 2, 4, 6; Từ 19h-21h"));
        lstTtlophoc.add(new Ttlophoc("B325","Nguyễn Thị B", "Tiếng Việt", "Bình Thạnh", "1.700.000","Sinh viên", "Thứ 3, 5, 7; Từ 17h-19h"));
        lstTtlophoc.add(new Ttlophoc("F524","Lê Phạm C", "Thanh nhạc", "Bình Thạnh", "2.000.000","Đã tốt nghiệp", "Thứ 2, 4, 6; Từ 19h-21h"));
    }
}