package com.example.bloonshelper.adapters;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.example.bloonshelper.R;
import com.example.bloonshelper.data.Monkey;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MonkeyArtViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final String TAG = "MonkeyViewHolder";

    ImageView monkeyArt;
    CardView monkeyCardView;
    String monkeyName;
    RequestManager requestManager;
    OnMonkeyListener onMonkeyListener;

    public MonkeyArtViewHolder(@NonNull View itemView,
                               OnMonkeyListener listener,
                               RequestManager requestManager) {
        super(itemView);

        this.onMonkeyListener = listener;
        this.requestManager = requestManager;
        monkeyArt = itemView.findViewById(R.id.monkeyIcon);
        monkeyCardView = itemView.findViewById(R.id.monekyIconCardView);

        itemView.setOnClickListener(this);
    }

    public void onBind(Monkey monkey) {
        if (monkey != null) {
            monkeyName = monkey.getMonkeyName();
            Log.d(TAG, "onBind: Monkey Art is: " + monkey.getMonkeyArt());
            requestManager.load("file:///android_asset/" + monkey.getMonkeyArt()).into(monkeyArt);
            switch(monkey.getMonkeyClass()) {
                case "PRIMARY": monkeyCardView.setCardBackgroundColor(Color.parseColor("#6ed7f7")); break;
                case "MILITARY": monkeyCardView.setCardBackgroundColor(Color.parseColor("#a2f1b1")); break;
                case "MAGIC": monkeyCardView.setCardBackgroundColor(Color.parseColor("#ebabfc")); break;
                case "SUPPORT": monkeyCardView.setCardBackgroundColor(Color.parseColor("#f3de95")); break;
                case "HERO": monkeyCardView.setCardBackgroundColor(Color.BLACK); break;
                default: monkeyCardView.setCardBackgroundColor(Color.WHITE); break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        onMonkeyListener.onMonkeyClick(getAdapterPosition());
        Log.d(TAG, "onClick: Monkey Name:" + monkeyName);
    }
}
