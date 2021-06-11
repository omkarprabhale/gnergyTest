package com.omkar.gnrgytest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.omkar.gnrgytest.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WaysAdapter extends RecyclerView.Adapter<WaysAdapter.CustomViewHolder> {

    private List<String> listforways;
    private View.OnClickListener listener;

    public WaysAdapter(List listways,View.OnClickListener listener)
    {
        this.listforways =listways;
        this.listener =listener;
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.adpater_ways,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        String ways = listforways.get(position);
        holder.textView.setText(ways);

    }



    @Override
    public int getItemCount() {
        return listforways.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        private TextView textView ;

        public CustomViewHolder(View item)
        {
            super(item);
           item.setOnClickListener(this);
           this.textView =item.findViewById(R.id.tvWays);

        }

        @Override
        public void onClick(View v) {
            v.setTag(listforways.get(getAdapterPosition()));
            listener.onClick(v);


        }
    }
}
