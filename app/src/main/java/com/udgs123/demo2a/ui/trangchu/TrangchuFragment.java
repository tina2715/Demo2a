package com.udgs123.demo2a.ui.trangchu;

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

public class TrangchuFragment extends Fragment {
    private String ten_ttgiasu;

    View v;
    private RecyclerView myrecyclerview;
    private List<Trangchu> lstTtgisu;

    public TrangchuFragment () {
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_trangchu,container,false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.ttgiasu_trangchu_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstTtgisu);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);
        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstTtgisu=new ArrayList<>();
        lstTtgisu.add(new Trangchu("Jayden Long", "6/5/1984", "6251 Eason Rd", " jayden.long@example.com", "(885)-407-3637","Môn 1",R.drawable.avt1));
        lstTtgisu.add(new Trangchu("Gabe Hart", "8/5/1958", "6041 Samaritan Dr","gabe.hart@example.com","(431)-178-0398", "Môn 2",R.drawable.avt2));
        lstTtgisu.add(new Trangchu("Kitty Robertson", "7/2/1980", "2126 Nowlin Rd", "kitty.robertson@example.com","(075)-603-4594","Môn 3",R.drawable.avt3));
        lstTtgisu.add(new Trangchu("Serenity Fleming", "10/4/1951", "7843 Hickory Creek Dr", "serenity.fleming@example.com","(668)-980-8202","Môn 4",R.drawable.avt4));
        lstTtgisu.add(new Trangchu("Oscar Willis", "6/2/1953", "6722 Royal Ln", "oscar.willis@example.com","(602)-675-6951","Môn 5",R.drawable.avt5));
        lstTtgisu.add(new Trangchu("Kevin Knight", "9/7/1994", "1881 Mcclellan Rd","knight-kevin.knight@example.com","(368)-773-3391", "Môn 6",R.drawable.avt6));
        lstTtgisu.add(new Trangchu("Dwight Byrd", "5/6/1982", "7663 Photinia Ave", "dwight.byrd@example.com","(363)-338-6793","Môn 7",R.drawable.avt7));
        lstTtgisu.add(new Trangchu("Bertha Williamson", "7/1/1995", "6136 Samaritan Dr", "bertha.williamson@example.com","(929)-519-2474","Môn 8",R.drawable.avt8));
        lstTtgisu.add(new Trangchu("Tim Griffin", "8/1/1995", "8675 Wheeler Ridge Dr", "tim.griffin@example.com", "(857)-662-6052", "Môn 9",R.drawable.avt9));
        lstTtgisu.add(new Trangchu("Ray Myers", "10/4/1971", "9510 Central St", "ray.myers@example.com", "(384)-529-7659", "Môn 10",R.drawable.avt10));
    }
}