package com.udgs123.demo2a.ui.lichnghi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.demo2a.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<Xemlichnghi> mData;
    public RecyclerViewAdapter (Context mContext, List<Xemlichnghi> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_lichnghi, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }
        public  void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv_malop.setText(mData.get(position).getMalop());
            holder.tv_ngaynghi.setText(mData.get(position).getNgaynghi());
            holder.tv_ngaybu.setText(mData.get(position).getNgaybu());
            holder.tv_lido.setText(mData.get(position).getLido());
            holder.tv_ghichu.setText(mData.get(position).getGhichu());
            holder.tv_nguoidang.setText(mData.get(position).getNguoidang());
            holder.tv_ngaydang.setText(mData.get(position).getNgaydang());

        }


    public int getItemCount() {
        return mData.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout item_lichnghi;
        private TextView tv_malop;
        private TextView tv_ngaynghi;
        private TextView tv_ngaybu;
        private TextView tv_lido;
        private TextView tv_ghichu;
        private TextView tv_nguoidang;
        private TextView tv_ngaydang;
        public MyViewHolder (View itemView) {
            super(itemView);
            item_lichnghi = (LinearLayout) itemView.findViewById(R.id.lichnghi_item_id);
            tv_malop = (TextView) itemView.findViewById(R.id.malop_lichnghi);
            tv_ngaynghi = (TextView) itemView.findViewById(R.id.ngaynghi_lichnghi);
            tv_ngaybu = (TextView) itemView.findViewById(R.id.ngaybu_lichnghi);
            tv_lido = (TextView) itemView.findViewById(R.id.lido_lichnghi);
            tv_ghichu = (TextView) itemView.findViewById(R.id.ghichu_lichnghi);
            tv_nguoidang = (TextView) itemView.findViewById(R.id.nguoidang_lichnghi);
            tv_ngaydang = (TextView) itemView.findViewById(R.id.ngaydang_lichnghi);

        }

    }
}
