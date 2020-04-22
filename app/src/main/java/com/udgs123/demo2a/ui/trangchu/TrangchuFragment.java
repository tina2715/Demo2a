package com.udgs123.demo2a.ui.trangchu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.udgs123.demo2a.ConnectHelper;
import com.udgs123.demo2a.LoadingDialog;
import com.udgs123.demo2a.R;
import com.udgs123.demo2a.Tttk_Update;
import com.udgs123.demo2a.dangnhap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TrangchuFragment extends Fragment {
    View v;
    private TextView mDisplayDate;
    private TextView tv_tentaikhoan, tv_matkhau, tv_hotenhv, tv_emailhv, tv_sdthv, tv_diachihv, tv_dangxuat, tv_capnhatthongtin;
    Connection connect;
    int REQUEST_CODE_UPDATE = 1997;
    public TrangchuFragment () {
    }

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_trangchu,container,false);

        tv_tentaikhoan = (TextView) v.findViewById(R.id.tv_tentaikhoan);
        tv_matkhau = (TextView) v.findViewById(R.id.tv_matkhau);
        tv_hotenhv = (TextView) v.findViewById(R.id.tv_hotenhv);
        tv_emailhv = (TextView) v.findViewById(R.id.tv_emailhv);
        tv_sdthv = (TextView) v.findViewById(R.id.tv_sdthv);
        tv_diachihv = (TextView) v.findViewById(R.id.tv_diachihv);
        tv_dangxuat = (TextView) v.findViewById( R.id.tv_dangxuat );
        tv_capnhatthongtin = (TextView) v.findViewById( R.id.tv_capnhattaikhoan );
        try {
            ConnectHelper connectHelper = new ConnectHelper();
            connect = connectHelper.connections();
            if (connect==null) {
                Toast.makeText(getActivity(),"Kiểm tra kết nối", Toast.LENGTH_SHORT).show();
            }
            else {
                SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = mPreferences.edit();

                String tentaikhoan = mPreferences.getString( "Tentaikhoanhv","" );

                String query = "select * from thongtinhocvien where Tentaikhoanhv = '"+tentaikhoan+"'";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                if(rs.next()){
                    tv_tentaikhoan.setText(rs.getString("Tentaikhoanhv"));
                    tv_matkhau.setText(rs.getString("Matkhauhv"));
                    tv_hotenhv.setText(rs.getString("Hotenhv"));
                    tv_emailhv.setText(rs.getString("Emailhv"));
                    tv_sdthv.setText(rs.getString("Sdthv"));
                    tv_diachihv.setText(rs.getString("Diachihv"));
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getActivity(),ex.getMessage(), Toast.LENGTH_LONG).show();
        }

        tv_dangxuat.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        } );
        tv_capnhatthongtin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadingDialog loadingDialog= new LoadingDialog();
                loadingDialog.loading(getActivity());
                Intent intent = new Intent(getActivity(),Tttk_Update.class);
                intent.putExtra("Hotenhv",tv_hotenhv.getText().toString());
                intent.putExtra("Emailhv",tv_emailhv.getText().toString());
                startActivityForResult(intent,REQUEST_CODE_UPDATE);
            }
        } );
        return v;
    }

    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Xác nhận");
        builder.setMessage("Bạn có muốn đăng xuất tài khoản?");
        builder.setCancelable(false);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent intent = new Intent(getActivity(), dangnhap.class);
               // CheckLogined.SharedPrefesSAVE(getApplicationContext(),"");
               // FirebaseAuth.getInstance().signOut();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        builder.setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}