package com.example.bloonshelper.adapters;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.example.bloonshelper.R;
import com.example.bloonshelper.data.Monkey;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
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
            requestManager.load("file:///android_asset/" + monkey.getMonkeyArt()).into(monkeyArt);
            ViewCompat.setTransitionName(monkeyArt, monkey.getMonkeyName());
            switch(monkey.getMonkeyClass()) {
                case "PRIMARY": monkeyCardView.setCardBackgroundColor(Color.parseColor("#77bedc")); break;
                case "MILITARY": monkeyCardView.setCardBackgroundColor(Color.parseColor("#92fa7a")); break;
                case "MAGIC": monkeyCardView.setCardBackgroundColor(Color.parseColor("#ba8df3")); break;
                case "SUPPORT": monkeyCardView.setCardBackgroundColor(Color.parseColor("#f2d297")); break;
                case "HERO": monkeyCardView.setCardBackgroundColor(Color.BLACK); break;
                default: monkeyCardView.setCardBackgroundColor(Color.WHITE); break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        onMonkeyListener.onMonkeyClick(getAdapterPosition(), monkeyArt);
    }
}
