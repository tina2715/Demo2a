package com.udgs123.demo2a.ui.dsgiasu;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.demo2a.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    public List<Giasu> lstGiasu;
    Dialog myDialog;

    public RecyclerViewAdapter(List<Giasu> lstGiasu) {
        this.lstGiasu = lstGiasu;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ttgiasu, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(view);
        final Dialog dialoggs = new Dialog(parent.getContext());
        dialoggs.setContentView(R.layout.dialog_ttgiasu);
        dialoggs.getWindow();

        vHolder.btn_xemchitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tentaikhoan_gs = (TextView) dialoggs.findViewById(R.id.tv_tentaikhoangs);
                TextView hoten_gs = (TextView) dialoggs.findViewById(R.id.tv_hotengs);
                TextView ngaysinh_gs = (TextView) dialoggs.findViewById(R.id.tv_ngaysinhgs);
                TextView email_gs = (TextView) dialoggs.findViewById(R.id.tv_emailgs);
                TextView sodienthoai_gs = (TextView) dialoggs.findViewById(R.id.tv_sdtgs);
                TextView diachi_gs = (TextView) dialoggs.findViewById(R.id.tv_diachigs);
                TextView truongtheohoc_gs = (TextView) dialoggs.findViewById(R.id.tv_truongtheohocgs);
                TextView chuyennganh_gs = (TextView) dialoggs.findViewById(R.id.tv_chuyennganhgs);
                TextView monday_gs = (TextView) dialoggs.findViewById(R.id.tv_mondaygs);
                TextView trinhdo_gs = (TextView) dialoggs.findViewById(R.id.tv_trinhdogs);

                tentaikhoan_gs.setText(lstGiasu.get(vHolder.getAdapterPosition()).getTentaikhoan_gs());
                hoten_gs.setText(lstGiasu.get(vHolder.getAdapterPosition()).getHoten_gs());
                ngaysinh_gs.setText(lstGiasu.get(vHolder.getAdapterPosition()).getNgaysinh_gs());
                email_gs.setText(lstGiasu.get(vHolder.getAdapterPosition()).getEmail_gs());
                sodienthoai_gs.setText(lstGiasu.get(vHolder.getAdapterPosition()).getSodienthoai_gs());
                diachi_gs.setText(lstGiasu.get(vHolder.getAdapterPosition()).getDiachi_gs());
                truongtheohoc_gs.setText(lstGiasu.get(vHolder.getAdapterPosition()).getTruongtheohoc_gs());
                chuyennganh_gs.setText(lstGiasu.get(vHolder.getAdapterPosition()).getChuyennganh_gs());
                monday_gs.setText(lstGiasu.get(vHolder.getAdapterPosition()).getMonday_gs());
                trinhdo_gs.setText(lstGiasu.get(vHolder.getAdapterPosition()).getTrinhdo_gs());
                dialoggs.show();

            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tentaikhoan_gs.setText(lstGiasu.get(position).getTentaikhoan_gs());
        holder.hoten_gs.setText(lstGiasu.get(position).getHoten_gs());
        holder.ngaysinh_gs.setText(lstGiasu.get(position).getNgaysinh_gs());
        holder.email_gs.setText(lstGiasu.get(position).getEmail_gs());
        holder.sodienthoai_gs.setText(lstGiasu.get(position).getSodienthoai_gs());
        holder.diachi_gs.setText(lstGiasu.get(position).getDiachi_gs());
        holder.truongtheohoc_gs.setText(lstGiasu.get(position).getTruongtheohoc_gs());
        holder.chuyennganhgs.setText(lstGiasu.get(position).getChuyennganh_gs());
        holder.monday_gs.setText(lstGiasu.get(position).getMonday_gs());
        holder.trinhdo_gs.setText(lstGiasu.get( position ).getTrinhdo_gs());

    }

    @Override
    public int getItemCount() {
        return this.lstGiasu.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private Button btn_xemchitiet;
        private TextView tentaikhoan_gs,hoten_gs, ngaysinh_gs,email_gs, sodienthoai_gs, diachi_gs, truongtheohoc_gs, chuyennganhgs, monday_gs, trinhdo_gs;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tentaikhoan_gs = (TextView) itemView.findViewById( R.id.tentaikhoan_gs );
            hoten_gs = (TextView) itemView.findViewById(R.id.tv_hotengs);
            ngaysinh_gs = (TextView) itemView.findViewById(R.id.tv_ngaysinh);
            email_gs = (TextView) itemView.findViewById( R.id.tv_emailgs );
            sodienthoai_gs = (TextView) itemView.findViewById( R.id.tv_sdtgs );
            diachi_gs = (TextView) itemView.findViewById( R.id.tv_diachigs );
            truongtheohoc_gs = (TextView) itemView.findViewById( R.id.tv_truongtheohocgs );
            chuyennganhgs = (TextView) itemView.findViewById( R.id.tv_chuyennganhgs );
            monday_gs = (TextView) itemView.findViewById( R.id.tv_mondaygs );
            trinhdo_gs = (TextView) itemView.findViewById( R.id.tv_trinhdogs );
            btn_xemchitiet = (Button) itemView.findViewById(R.id.btn_xemchitiet);

        }
    }

}
