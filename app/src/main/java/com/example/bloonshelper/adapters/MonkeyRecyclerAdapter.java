package com.example.bloonshelper.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.ViewPreloadSizeProvider;
import com.example.bloonshelper.R;
import com.example.bloonshelper.data.Monkey;
import com.example.bloonshelper.data.MonkeysData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MonkeyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private static final String TAG = "MonkeyRecyclerAdapter";
    private static final int MONKEY_ART = 1;
    private static final int MONKEY_DETAILS = 2;


    private List<Monkey> monkeyList;
    private RequestManager requestManager;
    OnMonkeyListener onMonkeyListener;
    private ViewPreloadSizeProvider<String> preloadSizeProvider;

    public MonkeyRecyclerAdapter(OnMonkeyListener onMonkeyListener, RequestManager requestManager) {
        this.onMonkeyListener = onMonkeyListener;
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public MonkeyArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_monkey_picture, parent, false);
        return new MonkeyArtViewHolder(view, onMonkeyListener, requestManager);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MonkeyArtViewHolder)holder).onBind(monkeyList.get(position));
    }

    @Override
    public int getItemCount() {
        if(monkeyList != null){
            return monkeyList.size();
        }
        return 0;
    }

    public Monkey getSelectedMonkey(int position) {
        if (monkeyList != null) {
            if (monkeyList.size() > 0) {
                return  monkeyList.get(position);
            }
        }
        return null;
    }

    public void displayInitialMonkeys() {
        monkeyList = MonkeysData.populateMonkeysData();
        notifyDataSetChanged();
    }
}
