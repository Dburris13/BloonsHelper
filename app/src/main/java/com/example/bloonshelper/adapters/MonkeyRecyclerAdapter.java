package com.example.bloonshelper.adapters;

import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.bloonshelper.R;
import com.example.bloonshelper.data.Monkey;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MonkeyRecyclerAdapter extends RecyclerView.Adapter<MonkeyRecyclerAdapter.MonkeyViewHolder> {
    private static final String TAG = "MonkeyRecyclerAdapter";

    private List<Monkey> monkeyList;
    private RequestManager requestManager;

    public MonkeyRecyclerAdapter(List<Monkey> monkeyList) {
        this.monkeyList = monkeyList;
    }

    @NonNull
    @Override
    public MonkeyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_monkey_item, parent, false);
        return new MonkeyViewHolder(view);
    }

    public void addMonkeyList(List<Monkey> monkeys) {
        monkeyList = monkeys;
        notifyDataSetChanged();
    }

    public class MonkeyViewHolder extends RecyclerView.ViewHolder {
        ImageView monkeyArt;
        CardView monkeyCardView;

        public MonkeyViewHolder(@NonNull View itemView) {
            super(itemView);
            monkeyArt = itemView.findViewById(R.id.monkeyIcon);
            monkeyCardView = itemView.findViewById(R.id.monekyIconCardView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MonkeyViewHolder holder, int position) {
        Monkey monkey = monkeyList.get(position);
        if (monkey != null) {
            Glide.with(holder.itemView).load(Uri.parse("file:///android_asset/" + monkey.getMonkeyArt())).into(holder.monkeyArt);
            switch(monkey.getMonkeyClass()) {
                case "PRIMARY": holder.monkeyCardView.setCardBackgroundColor(Color.parseColor("#6ed7f7")); break;
                case "MILITARY": holder.monkeyCardView.setCardBackgroundColor(Color.parseColor("#a2f1b1")); break;
                case "MAGIC": holder.monkeyCardView.setCardBackgroundColor(Color.parseColor("#ebabfc")); break;
                case "SUPPORT": holder.monkeyCardView.setCardBackgroundColor(Color.parseColor("#f3de95")); break;
                case "HERO": holder.monkeyCardView.setCardBackgroundColor(Color.BLACK); break;
                default: holder.monkeyCardView.setCardBackgroundColor(Color.WHITE); break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return monkeyList.size();
    }
}
