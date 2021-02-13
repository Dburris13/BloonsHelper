package com.example.bloonshelper.activity;

import android.os.Bundle;

import com.example.bloonshelper.R;
import com.example.bloonshelper.adapters.MonkeyRecyclerAdapter;
import com.example.bloonshelper.data.Monkey;
import com.example.bloonshelper.room.MonkeyRepository;
import com.example.bloonshelper.viewmodel.MonkeyListViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MonkeyListActivity extends AppCompatActivity {

    private static final String TAG = "MonkeyListActivity";

    public static final String DATABASE_NAME = "monkeys_db";
    private RecyclerView mMonkeyRecyclverView;
    private ArrayList<Monkey> mMonkeyList = new ArrayList<>();
    private MonkeyRecyclerAdapter mMonkeyRecyclerAdapter;
    private MonkeyRepository mMonkeyRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monkey_list);
        mMonkeyRecyclverView = findViewById(R.id.mainRecyclerView);
        initRecyclerView();
        mMonkeyRepository = new MonkeyRepository(this);
//        mMonkeyRepository.insertMonkeyTask(MonkeysData.populateMonkeysData());
//        mMonkeyRepository.deleteAll();
        updateMonkeyList();
    }

    private void updateMonkeyList() {
        mMonkeyRepository.getMonkeyList().observe(this, (monkeys -> {
            if(mMonkeyList.size() > 0) {
                mMonkeyList.clear();
            }

            if (monkeys != null) {
                mMonkeyList.addAll(monkeys);
            }
            mMonkeyRecyclerAdapter.notifyDataSetChanged();
        }));
    }

    private void initRecyclerView(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL,false);
        mMonkeyRecyclverView.setLayoutManager(gridLayoutManager);
        mMonkeyRecyclverView.setHasFixedSize(true);
        mMonkeyRecyclerAdapter = new MonkeyRecyclerAdapter(mMonkeyList);
        mMonkeyRecyclverView.setAdapter(mMonkeyRecyclerAdapter);
        MonkeyListViewModel mModel = ViewModelProviders.of(this).get(MonkeyListViewModel.class);

        mModel.getAllMonkeys().observe(this, new Observer<List<Monkey>>() {
            @Override
            public void onChanged(List<Monkey> monkeys) {
                mMonkeyRecyclerAdapter.addMonkeyList(monkeys);
            }
        });
        mMonkeyRecyclerAdapter.notifyDataSetChanged();
    }
}