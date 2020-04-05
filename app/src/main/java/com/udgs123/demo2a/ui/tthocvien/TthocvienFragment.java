package com.udgs123.demo2a.ui.tthocvien;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.udgs123.demo2a.ConnectHelper;
import com.udgs123.demo2a.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

public class TthocvienFragment extends Fragment {
    View v;
    private TextView mDisplayDate;
    Connection connect;
    String tentaikhoan_hv1;
    Map<String, String> data = null;
    String ConnectionResult="";
    Boolean isSuccessful =false;



    //private DatePickerDialog.OnDateSetListener mDateSetListener;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_tthocvien,container,false);
        final TextView tv_hoten = (TextView) v.findViewById(R.id.tv_hotenhv);
        final TextView tv_tentaikhoan = (TextView) v.findViewById(R.id.tv_tentaikhoan);
        final TextView tv_matkhau = (TextView) v.findViewById(R.id.tv_matkhau);
        final TextView tv_diachi = (TextView) v.findViewById(R.id.tv_diachihv);
        final TextView tv_email = (TextView) v.findViewById(R.id.tv_emailhv);
        final TextView tv_sdt = (TextView) v.findViewById(R.id.tv_sdthv);
        SharedPreferences SP = getActivity().getSharedPreferences("tentaikhoan_hv", 0);
        tentaikhoan_hv1 = SP.getString("tentaikhoan_hv1",null);

            try {

                ConnectHelper connectHelper = new ConnectHelper();
                connect = connectHelper.connections();
                if (connect == null)
                {
                    ConnectionResult="Kiểm tra kết nối";
                } else
                {

                     String query = "select * from taikhoan_hv where tentaikhoan_hv ='" + tentaikhoan_hv1 + "'";
                    Statement st = connect.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {

                        tv_tentaikhoan.setText(rs.getString("tentaikhoan_hv"));
                        tv_matkhau.setText(rs.getString("matkhau_hv"));
                        tv_hoten.setText(rs.getString("hoten_hv"));
                        tv_email.setText(rs.getString("email_hv"));
                        tv_sdt.setText(rs.getString("sdt_hv"));
                        tv_diachi.setText(rs.getString("diachi_hv"));
                    }
                }
            } catch (Exception ex) {
                Toast.makeText(getActivity(),ex.getMessage(), Toast.LENGTH_LONG).show();
            }
//
//
//        try {
//            ConnectHelper connectHelper = new ConnectHelper();
//            connect = connectHelper.connections();
//            if (connect == null)
//            {
//                Toast.makeText(getActivity(), "Kiểm tra kết nối", Toast.LENGTH_SHORT).show();
//            } else {
//                String query ="Select * from taikhoan_hv where tentaikhoan_hv='" + tentaikhoan_hv + "'";
//                Statement stmt = connect.createStatement();
//                ResultSet rs = stmt.executeQuery(query);
//                while (rs.next()){
//                    Map<String, String> datanum = new HashMap<String, String>();
//                        datanum.put("tv_tentaikhoan", rs.getString("tentaikhoan_hv"));
//                        datanum.put("tv_matkhau",rs.getString("matkhau_hv"));
//                        datanum.put("tv_hotenhv",rs.getString("hoten_hv"));
//                        datanum.put("tv_emailhv",rs.getString("email_hv"));
//                        datanum.put("tv_sdthv", rs.getString("sdt_hv"));
//                        datanum.put("tv_diachihv",rs.getString("diachi_hv"));
//                        data.add(datanum);
//                }
//            }
//        } catch (SQLException e) {
//            Toast.makeText(getActivity(), e.getMessage(),Toast.LENGTH_SHORT).show();
//        }


        //hiển thị ngày tháng
//        final TextView mDisplayDate = (TextView) v.findViewById(R.id.tvDate);
//        mDisplayDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(getActivity(),
//                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
//                        mDateSetListener,
//                        year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });
//        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month +1;
//                Log.d("Tag","onDateSet: mm/dd/yyy:" + month + " / " + day + " / " + year);
//                String date = month + "/" + day + "/" + year;
//                mDisplayDate.setText(date);
//            }
//        };

        return v;
    }
//    public Map<String, String> getData() {
//        Connection connect;
//        String ConnectionResult="";
//        Boolean isSuccessful =false;
//            Map<String, String> data = null;
//            data= (Map<String, String>) new ArrayList<Map<String, String>>();
//            try {
//                ConnectHelper connectHelper = new ConnectHelper();
//                connect = connectHelper.connections();
//                if (connect==null)
//                {
//                    ConnectionResult="Kiểm tra kết nối";
//                } else
//                {
//                    String query = "select * from taikhoan_hv where tentaikhoan_hv='" + tentaikhoan_hv + "'";
//                    Statement st = connect.createStatement();
//                    ResultSet rs = st.executeQuery(query);
//                    while (rs.next()) {
//                        Map<String, String> datanum = new HashMap<String, String>();
//                        datanum.put("tv_tentaikhoan", rs.getString("tentaikhoan_hv"));
//                        datanum.put("tv_matkhau",rs.getString("matkhau_hv"));
//                        datanum.put("tv_hotenhv",rs.getString("hoten_hv"));
//                        datanum.put("tv_emailhv",rs.getString("email_hv"));
//                        datanum.put("tv_sdthv", rs.getString("sdt_hv"));
//                        datanum.put("tv_diachihv",rs.getString("diachi_hv"));
//                        data.get(datanum);
//                    }
//                    ConnectionResult = "Successful";
//                    isSuccessful=true;
//                    connect.close();
//                }
//            } catch (Exception ex) {
//                isSuccessful=false;
//                ConnectionResult=ex.getMessage();
//            }
//    return data;
//    }
}