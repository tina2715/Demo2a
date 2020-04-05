package com.udgs123.demo2a.ui.trangchu;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.demo2a.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>  {
    Context mContext;
    List<Trangchu> mData;
    Dialog myDialog;

    public RecyclerViewAdapter(Context mContext, List<Trangchu> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_ttgiasu_trangchu, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_ttgiasu);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



        vHolder.btn_xemchitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_ten_tv = (TextView) myDialog.findViewById(R.id.dialog_ten_id);
                TextView dialog_diachi_tv = (TextView) myDialog.findViewById(R.id.dialog_diachi_id);
                TextView dialog_email_tv = (TextView) myDialog.findViewById(R.id.dialog_email_id);
                TextView dialog_sdt_tv = (TextView) myDialog.findViewById(R.id.dialog_sdt_id);
                TextView dialog_daymon_tv = (TextView) myDialog.findViewById(R.id.dialog_daymon_id);
                ImageView dialog_ttgiasu_img = (ImageView) myDialog.findViewById(R.id.dialog_img);
                dialog_ten_tv.setText(mData.get(vHolder.getAdapterPosition()).getTen());
                dialog_diachi_tv.setText(mData.get(vHolder.getAdapterPosition()).getDiachi());
                dialog_email_tv.setText(mData.get(vHolder.getAdapterPosition()).getEmail());
                dialog_sdt_tv.setText(mData.get(vHolder.getAdapterPosition()).getSdt());
                dialog_daymon_tv.setText(mData.get(vHolder.getAdapterPosition()).getDaymon());
                dialog_ttgiasu_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());
                myDialog.show();
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_ten.setText(mData.get(position).getTen());
        holder.tv_namsinh.setText(mData.get(position).getNamsinh());
        holder.tv_diachi.setText(mData.get(position).getDiachi());
        holder.tv_email.setText(mData.get(position).getEmail());
        holder.tv_sdt.setText(mData.get(position).getSdt());
        holder.tv_daymon.setText(mData.get(position).getDaymon());
        holder.img.setImageResource(mData.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private Button btn_xemchitiet;
        private LinearLayout item_ttgiasu;
        private TextView tv_ten;
        private TextView tv_namsinh;
        private TextView tv_diachi;
        private TextView tv_email;
        private TextView tv_sdt;
        private TextView tv_daymon;
        private ImageView img;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_ttgiasu = (LinearLayout) itemView.findViewById(R.id.ttgiasu_item_id);
            tv_ten = (TextView) itemView.findViewById(R.id.ten_ttgiasu);
            tv_namsinh = (TextView) itemView.findViewById(R.id.namsinh_ttgiasu);
            tv_diachi = (TextView) itemView.findViewById(R.id.diachi_ttgiasu);
            tv_email = (TextView) itemView.findViewById(R.id.email_ttgiasu);
            tv_sdt = (TextView) itemView.findViewById(R.id.sdt_ttgiasu);
            tv_daymon = (TextView) itemView.findViewById(R.id.daymon_ttgiasu);
            img = (ImageView) itemView.findViewById(R.id.img_ttgiasu);
            btn_xemchitiet = (Button) itemView.findViewById(R.id.btn_xemchitiet);

        }
    }
}
