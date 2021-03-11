package com.example.bloonshelper.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.bloonshelper.R;
import com.example.bloonshelper.adapters.MonkeyRecyclerAdapter;
import com.example.bloonshelper.adapters.OnMonkeyListener;
import com.example.bloonshelper.fragments.MonkeyListFragment;
import com.example.bloonshelper.room.MonkeyRepository;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MonkeyListActivity extends AppCompatActivity implements OnMonkeyListener {

    private static final String TAG = "MonkeyListActivity";

    private RecyclerView mMonkeyRecyclerView;
    private MonkeyRecyclerAdapter mMonkeyRecyclerAdapter;
    private MonkeyRepository mMonkeyRepository;
    private int fragmentId = 0;
    private FragmentManager fragmentManager;
    private Fragment fragmentMonkeyList, fragmentMonkeyDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monkey_list);
//        mMonkeyRecyclerView = findViewById(R.id.mainRecyclerView);
//        mMonkeyRepository = MonkeyRepository.getInstance(this);

        loadMonkeyListFragment();
//        initRecyclerView();
//        displaySearchCategories();
//        subscribeObservers();
    }

    private void loadMonkeyListFragment() {
        //fragmentManager = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().add(R.id.FragmentContainer, MonkeyListFragment.class, null).commit();
    }

    private void initRecyclerView(){
        mMonkeyRecyclerAdapter = new MonkeyRecyclerAdapter(this, initGlide());
        mMonkeyRecyclerView.setLayoutManager(new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL,false));
        mMonkeyRecyclerView.setAdapter(mMonkeyRecyclerAdapter);
    }

    private void displaySearchCategories(){
        mMonkeyRecyclerAdapter.displayInitialMonkeys();
    }

    private void subscribeObservers() {

    }

    private RequestManager initGlide(){

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        RequestManager requestManager = Glide.with(this);

        return requestManager;
    }

    @Override
    public void onMonkeyClick(int position, ImageView sharedImageView) {
        Log.d(TAG, "MonkeylistActivity onMonkeyClick: ");
//        Bundle bundle = new Bundle();
//        bundle.putString("monkey_name", mMonkeyRecyclerAdapter.getSelectedMonkey(position).getMonkeyName());
//        //bundle.putString("monkey_name", "YEETISH");
//
//        fragmentId = getSupportFragmentManager().beginTransaction()
//                .setReorderingAllowed(true)
//                .add(R.id.FragmentContainer, MonkeyDetailFragment.class, bundle)
//                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "onBackPressed: ");
    }
}