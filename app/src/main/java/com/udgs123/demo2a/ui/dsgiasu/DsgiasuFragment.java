package com.udgs123.demo2a.ui.dsgiasu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.demo2a.ConnectHelper;
import com.udgs123.demo2a.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DsgiasuFragment extends Fragment {
    View v;
    private RecyclerView myrecyclerview;
    Connection connect;
    private List<Giasu> lstTtgisu;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate( R.layout.fragment_dsgiasu, container, false );

        myrecyclerview = v.findViewById( R.id.ttgiasu_recyclerview);

        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mGiasu());
        myrecyclerview.setAdapter(recyclerViewAdapter);
        return v;
    }

    public List<Giasu> mGiasu() {
        List<Giasu> giasus = new ArrayList<>();
        try {
            ConnectHelper connectHelper = new ConnectHelper();
            connect=connectHelper.connections();
            if (connect==null) {
                Toast.makeText(getActivity(), "Lỗi kết nối",Toast.LENGTH_SHORT).show();
            } else {
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("Select * from taikhoan_gs");
                while (rs.next()) {
                    giasus.add( new Giasu(
                            rs.getString( "id_gs" ),
                            rs.getString("hotengs"),
                            rs.getString("emailgs"),
                            rs.getString("sodienthoaigs"),
                            rs.getString("diachigs"),
                            rs.getString("truongtheohocgs"),
                            rs.getString("chuyennganhgs"),
                            rs.getString("mondaygs"),
                            rs.getString("trinhdogs")
                    ) );
                }
            }
        } catch (SQLException e) {
            Toast.makeText(getActivity(), e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return giasus;
    }

}