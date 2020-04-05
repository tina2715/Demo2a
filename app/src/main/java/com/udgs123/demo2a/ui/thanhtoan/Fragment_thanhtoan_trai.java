package com.udgs123.demo2a.ui.thanhtoan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.udgs123.demo2a.R;

public class Fragment_thanhtoan_trai extends Fragment {
    View v;
    private Button buttonxacnhanthanhtoan;
    private Button buttonhuythanhtoan;
    public Fragment_thanhtoan_trai() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_thanhtoan_trai, container,false);
        buttonxacnhanthanhtoan = (Button) v.findViewById(R.id.btn_xacnhan_thanhtoan);
        buttonxacnhanthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_atm_nguoinhan newAtmFragment = new Fragment_atm_nguoinhan();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.layout_thanhtoan_trai, newAtmFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        buttonhuythanhtoan = (Button) v.findViewById(R.id.btn_huy_thanhtoan);
        buttonhuythanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"update", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
//    private void swapFragment () {
//        Fragment_atm_nguoinhan newAtmFragment = new Fragment_atm_nguoinhan();
//        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.layout_atm_nguoinhan, newAtmFragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//
//    }

}
