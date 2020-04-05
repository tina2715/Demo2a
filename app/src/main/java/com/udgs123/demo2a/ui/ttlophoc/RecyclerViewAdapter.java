package com.udgs123.demo2a.ui.ttlophoc;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.udgs123.demo2a.R;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<Ttlophoc> mData;
    Dialog myDialog;

    public RecyclerViewAdapter(Context mContext, List<Ttlophoc> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_ttlophoc, parent, false);
        final MyViewHolder vHolder = new MyViewHolder (v);
        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_ttlophoc);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        vHolder.btn_xemchitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_tenlop_tv = (TextView) myDialog.findViewById(R.id.dialog_tenlop_id);
                TextView dialog_motayeucau_tv = (TextView) myDialog.findViewById(R.id.dialog_motayeucau_id);
                TextView dialog_monhoc_tv = (TextView) myDialog.findViewById(R.id.dialog_monhoc_id);
                TextView dialog_diachi_tv = (TextView) myDialog.findViewById(R.id.dialog_diachi_id);
                TextView dialog_hocphi_tv = (TextView) myDialog.findViewById(R.id.dialog_hocphi_id);
                TextView dialog_trinhdogiasu_tv = (TextView) myDialog.findViewById(R.id.dialog_trinhdogiasu_id);
                TextView dialog_thoigianhoc_tv = (TextView) myDialog.findViewById(R.id.dialog_thoigianhoc_id);
                dialog_tenlop_tv.setText(mData.get(vHolder.getAdapterPosition()).getTenlop());
                dialog_motayeucau_tv.setText(mData.get(vHolder.getAdapterPosition()).getMotayeucau());
                dialog_monhoc_tv.setText(mData.get(vHolder.getAdapterPosition()).getMonhoc());
                dialog_diachi_tv.setText(mData.get(vHolder.getAdapterPosition()).getDiachi());
                dialog_hocphi_tv.setText(mData.get(vHolder.getAdapterPosition()).getHocphi());
                dialog_trinhdogiasu_tv.setText(mData.get(vHolder.getAdapterPosition()).getTrinhdogiasu());
                dialog_thoigianhoc_tv.setText(mData.get(vHolder.getAdapterPosition()).getThoigianhoc());
                myDialog.show();
            }
        });
        return vHolder;
    }
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_tenlop.setText(mData.get(position).getTenlop());
        holder.tv_motayeucau.setText(mData.get(position).getMotayeucau());
        holder.tv_monhoc.setText(mData.get(position).getMonhoc());
        holder.tv_diachi.setText(mData.get(position).getDiachi());
        holder.tv_hocphi.setText(mData.get(position).getHocphi());
        holder.tv_trinhdogiasu.setText(mData.get(position).getTrinhdogiasu());
        holder.tv_thoigianhoc.setText(mData.get(position).getThoigianhoc());
    }
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout item_ttlophoc;
        private TextView tv_tenlop;
        private TextView tv_motayeucau;
        private TextView tv_monhoc;
        private TextView tv_diachi;
        private TextView tv_hocphi;
        private TextView tv_trinhdogiasu;
        private TextView tv_thoigianhoc;
        private Button btn_xemchitiet;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_ttlophoc = (LinearLayout) itemView.findViewById(R.id.ttlophoc_item_id);
            tv_tenlop = (TextView) itemView.findViewById(R.id.ten_ttlophoc);
            tv_motayeucau = (TextView) itemView.findViewById(R.id.motayeucau_ttlophoc);
            tv_monhoc = (TextView) itemView.findViewById(R.id.monhoc_ttlophoc);
            tv_diachi = (TextView) itemView.findViewById(R.id.diachi_ttlophoc);
            tv_hocphi = (TextView) itemView.findViewById(R.id.hocphi_ttlophoc);
            tv_trinhdogiasu = (TextView) itemView.findViewById(R.id.trinhdogiasu_ttlophoc);
            tv_thoigianhoc = (TextView) itemView.findViewById(R.id.thoigianhoc_ttlophoc);
            btn_xemchitiet = (Button) itemView.findViewById(R.id.btn_xemchitiet);
        }
    }

}
