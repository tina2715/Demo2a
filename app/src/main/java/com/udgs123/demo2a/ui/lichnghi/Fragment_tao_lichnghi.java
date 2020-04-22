package com.udgs123.demo2a.ui.lichnghi;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.udgs123.demo2a.R;

import java.util.Calendar;

public class Fragment_tao_lichnghi extends Fragment {
    View v;
    private TextView mHienthiNgaynghi;
    private TextView mHienthiNgaybu;

    private DatePickerDialog.OnDateSetListener mNgaynghiSetListener;
    private DatePickerDialog.OnDateSetListener mNgaybuSetListener;





    public Fragment_tao_lichnghi() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_tao_lichnghi, container,false);
        final TextView mHienthiNgaynghi = (TextView) v.findViewById(R.id.tv_ngaynghi) ;
        mHienthiNgaynghi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog (getActivity(),android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mNgaynghiSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mNgaynghiSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                Log.d("tag", "onDateSet: mm/dd/yyy" + month + "/" + day + "/" + year);
                String date = month + "/" + day + "/" + year;
                mHienthiNgaynghi.setText(date);
            }
        };

        final TextView mHienthiNgaybu = (TextView) v.findViewById(R.id.tv_ngaybu);
        mHienthiNgaybu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog (getActivity(),android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mNgaybuSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mNgaybuSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                Log.d("tag", "onDateSet: mm/dd/yyy" + month + "/" + day + "/" + year);
                String date = month + "/" + day + "/" + year;
                mHienthiNgaybu.setText(date);

            }
        };


        return v;
    }

}
