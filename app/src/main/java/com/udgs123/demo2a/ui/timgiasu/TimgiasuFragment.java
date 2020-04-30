package com.udgs123.demo2a.ui.timgiasu;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.udgs123.demo2a.ConnectHelper;
import com.udgs123.demo2a.ManHinhDauTien;
import com.udgs123.demo2a.R;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

public class TimgiasuFragment extends Fragment {
    View v;
    Connection connect;
    EditText diadiemhoc, ngayhoctrongtuan, motayeucau, hocphi;
    TextView tvTentaikhoan;
    Button btnXacnhan;

    EditText ngaydukienhoc;
    Calendar mNgaydukien;
    int day, month, year;

    Spinner caplopSpin;
    ArrayList<String> caplopID = new ArrayList<>();
    String CaplopID;

    Spinner monhocSpin;
    ArrayList<String> monhocID = new ArrayList<>();
    String MonhocID;

    Spinner soluonggioSpin;
    ArrayList<String> soluonggioID = new ArrayList<>();
    String SoluonggioID;

    Spinner giobatdauSpin;
    ArrayList<String> giobatdauID = new ArrayList<>();
    String GiobatdauID;

    Spinner trinhdoSpin;
    ArrayList<String> trinhdoID = new ArrayList<>();
    String TrinhdoID;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_timgiasu, container, false);
        //Anh xa
        tvTentaikhoan = (TextView) v.findViewById( R.id.tv_tentaikhoan );
        caplopSpin = (Spinner) v.findViewById( R.id.spin_caphoc );
        monhocSpin = (Spinner) v.findViewById( R.id.spin_tenmon );
        diadiemhoc = (EditText) v.findViewById( R.id.edt_diadiemhoc );
        ngaydukienhoc = (EditText) v.findViewById( R.id.edt_ngaydukienhoc );
        soluonggioSpin = (Spinner) v.findViewById( R.id.spin_soluonggiohoc );
        ngayhoctrongtuan = (EditText) v.findViewById( R.id.edt_ngayhoctrongtuan );
        giobatdauSpin = (Spinner) v.findViewById( R.id.spin_giobatdauhoc );
        trinhdoSpin = (Spinner) v.findViewById( R.id.spin_trinhdogiasu );
        motayeucau = (EditText) v.findViewById( R.id.edt_motayeucau );
        hocphi = (EditText) v.findViewById( R.id.edt_hocphi );
        btnXacnhan = (Button) v.findViewById(R.id.btn_xacnhan);
        SelectedCaplopItem();
        SelectedMonhocItem();
        SelectedSoluonggioItem();
        SelectedGiobatdauItem();
        SelectedTrinhdoItem();

        mNgaydukien = Calendar.getInstance();
        day = mNgaydukien.get(Calendar.DAY_OF_MONTH);
        month = mNgaydukien.get(Calendar.MONTH);
        year = mNgaydukien.get(Calendar.YEAR);
        month = month+1;
        ngaydukienhoc.setText(day + "/" + month +"/" + year);
        ngaydukienhoc.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog( getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear +1;
                        ngaydukienhoc.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                    }
                }, year,month,day );
            }
        } );
        btnXacnhan.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Upload();
            }
        } );


        return v;
    }
    public void SelectedCaplopItem() {
        ConnectHelper connectHelper = new ConnectHelper();
        connect = connectHelper.connections();
        if (connect==null) {
            Toast.makeText(getActivity(),"Loi", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery( "Select * from Lop" );
                rs.next();
                do {
                    caplopID.add(rs.getString(1));
                } while (rs.next());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, caplopID);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            caplopSpin.setAdapter(adapter1);
            caplopSpin.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CaplopID = caplopID.get(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            } );
        }
    }

    public void SelectedMonhocItem() {
        ConnectHelper connectHelper = new ConnectHelper();
        connect = connectHelper.connections();
        if (connect==null) {
            Toast.makeText(getActivity(),"Loi", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("Select * from Monhoc");
                rs.next();
                do {
                    monhocID.add(rs.getString(1));
                } while (rs.next());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, monhocID);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            monhocSpin.setAdapter(adapter2);
            monhocSpin.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    MonhocID = monhocID.get(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            } );
        }
    }

    public void SelectedSoluonggioItem() {
        ConnectHelper connectHelper = new ConnectHelper();
        connect = connectHelper.connections();
        if (connect==null){
            Toast.makeText(getActivity(),"Loi",Toast.LENGTH_SHORT).show();
        } else {
            try {
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("Select *from SLgio");
                rs.next();
                do {
                    soluonggioID.add(rs.getString(1));
                } while (rs.next());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,soluonggioID);
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            soluonggioSpin.setAdapter(adapter3);
            soluonggioSpin.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SoluonggioID=soluonggioID.get(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            } );
        }
    }
    public void SelectedGiobatdauItem() {
        ConnectHelper connectHelper = new ConnectHelper();
        connect = connectHelper.connections();
        if (connect==null) {
            Toast.makeText(getActivity(),"Loi", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("Select * from Giobd");
                rs.next();
                do {
                    giobatdauID.add(rs.getString(1));
                } while (rs.next());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,giobatdauID);
            adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            giobatdauSpin.setAdapter(adapter4);
            giobatdauSpin.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    GiobatdauID = giobatdauID.get(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            } );

        }
    }
 public void SelectedTrinhdoItem() {
        ConnectHelper connectHelper = new ConnectHelper();
        connect = connectHelper.connections();
        if (connect==null) {
            Toast.makeText(getActivity(),"Loi",Toast.LENGTH_SHORT).show();
        } else {
            try {
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("Select * from Trinhdo");
                rs.next();
                do {
                    trinhdoID.add(rs.getString(1));
                } while (rs.next());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,trinhdoID);
            adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            trinhdoSpin.setAdapter(adapter5);
            trinhdoSpin.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    TrinhdoID = trinhdoID.get(position);
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            } );
        }
    }
    public void Upload() {
        if (diadiemhoc.getText().toString().trim().equals("")||ngayhoctrongtuan.getText().toString().trim().equals("")) {
            Toast.makeText(getActivity(),"Nhap day du thong tin", Toast.LENGTH_SHORT).show();
        } else {
            try {
                ConnectHelper connectHelper = new ConnectHelper();
                connect = connectHelper.connections();
                if (connect==null) {
                    Toast.makeText(getActivity(),"Loi", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        mPreferences.edit();

                        String tvTentaikhoan =mPreferences.getString("Tentaikhoanhv","");
                        String caplopID = CaplopID.toString();
                        String monhocID = MonhocID.toString();
                        String diadiemHoc = diadiemhoc.getText().toString().trim();
                        String ngaydukienHoc = ngaydukienhoc.getText().toString();
                        String soluonggioID = SoluonggioID.toString();
                        String ngayHoctrongtuan = ngayhoctrongtuan.getText().toString().trim();
                        String giobatdauID = GiobatdauID.toString();
                        String trinhdoID = TrinhdoID.toString();
                        String motayeuCau = motayeucau.getText().toString().trim();
                        String hocphiyeucau = hocphi.getText().toString().trim();
                        String query = "insert into Quanlylop(Tentaikhoanhv, Caplop, Tenmonhoc, Diadiem, Ngaydukien, Soluonggio, Ngayhoctrongtuan, Giobatdau,Loaitrinhdo, Mota, Hocphi) values\n" +
                                "('"+tvTentaikhoan+"','"+caplopID+"','"+monhocID+"','"+diadiemHoc+"','"+ngaydukienHoc+"','"+soluonggioID+"','"+ngayHoctrongtuan+"','"+giobatdauID+"','"+trinhdoID+"','"+motayeuCau+"','"+hocphiyeucau+"')";
                        PreparedStatement pst = connect.prepareStatement(query);
                        pst.executeUpdate();
                        Toast.makeText(getActivity(),"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getActivity(),ManHinhDauTien.class));
                        connect.close();
                    } catch (SQLException e) {
                        Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (Exception ex){
                Toast.makeText(getActivity(),ex.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }


    }

}