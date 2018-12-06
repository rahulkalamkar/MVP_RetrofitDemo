package com.example.rahulkalamkar.myelearnapplication.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahulkalamkar.myelearnapplication.Interface.RecyclerItemClickListener;
import com.example.rahulkalamkar.myelearnapplication.Model.Notice;
import com.example.rahulkalamkar.myelearnapplication.R;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Notice> dataList;
    RecyclerItemClickListener recyclerItemClickListener;

    public NoticeAdapter(ArrayList<Notice> dataList, RecyclerItemClickListener recyclerItemClickListener) {
        this.dataList = dataList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_view_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.txtNoticeTitle.setText(dataList.get(position).getTitle());
        holder.txtNoticeBrief.setText(dataList.get(position).getBrief());
        holder.txtNoticeFilePath.setText(dataList.get(position).getFileSource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(dataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtNoticeTitle, txtNoticeBrief, txtNoticeFilePath;

        MyViewHolder(View itemView) {
            super(itemView);
            txtNoticeTitle = itemView.findViewById(R.id.txt_notice_title);
            txtNoticeBrief = itemView.findViewById(R.id.txt_notice_brief);
            txtNoticeFilePath = itemView.findViewById(R.id.txt_notice_file_path);

        }

    }
}
