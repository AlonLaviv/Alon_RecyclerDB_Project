package com.example.alon_recyclerdb_project;



import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.alon_recyclerdb_project.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    private List<DataItem> dataList;
    private Context context;

    public MyAdapter(List<DataItem> dataList,Context context)
    {
        this.context = context;
        this.dataList = dataList;
    }
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.data_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick (View v){
                int pos = holder.getAdapterPosition();
                removeDataFromList(pos);
                notifyItemRangeRemoved(pos,getItemCount());
                return true;
            }
        });
    }
    private void removeDataFromList(int pos){
        dataList.remove(pos);
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.textView5);
        }
    }
}
