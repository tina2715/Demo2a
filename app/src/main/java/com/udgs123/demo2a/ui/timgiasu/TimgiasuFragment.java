package com.udgs123.demo2a.ui.timgiasu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.udgs123.demo2a.R;

public class TimgiasuFragment extends Fragment {


    View v;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_timgiasu, container, false);
        Spinner lophocSpin = (Spinner) v.findViewById(R.id.spin_lophoc);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spin_lophoc));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lophocSpin.setAdapter(myAdapter);

        Spinner monhocSpin = (Spinner) v.findViewById(R.id.spin_monhoc);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spin_monhoc));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monhocSpin.setAdapter(myAdapter1);

        Spinner trinhdogsSpin = (Spinner) v.findViewById(R.id.spin_trinhdo);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spin_trinhdogs));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        trinhdogsSpin.setAdapter(myAdapter2);
        return v;
    }
}