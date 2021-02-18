package com.example.bloonshelper.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.bloonshelper.R;
import com.example.bloonshelper.adapters.MonkeyRecyclerAdapter;
import com.example.bloonshelper.adapters.OnMonkeyListener;
import com.example.bloonshelper.viewmodel.MonkeyFragmentListViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MonkeyListFragment extends Fragment implements OnMonkeyListener {

    private MonkeyFragmentListViewModel mViewModel;
    private RecyclerView mMonkeyRecyclerView;
    private MonkeyRecyclerAdapter mMonkeyRecyclerAdapter;

    public static MonkeyListFragment newInstance() {
        return new MonkeyListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.monkey_list_fragment, container, false);
        mMonkeyRecyclerView = view.findViewById(R.id.fmainRecyclerView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MonkeyFragmentListViewModel.class);
        // TODO: Use the ViewModel
        initRecyclerView();
        displaySearchCategories();
    }

    private void initRecyclerView(){
        mMonkeyRecyclerAdapter = new MonkeyRecyclerAdapter(this, initGlide());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2, GridLayoutManager.VERTICAL, false);
        mMonkeyRecyclerView.setLayoutManager(gridLayoutManager);
        mMonkeyRecyclerView.setAdapter(mMonkeyRecyclerAdapter);
    }

    private RequestManager initGlide(){

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        RequestManager requestManager = Glide.with(this);

        return requestManager;
    }

    private void displaySearchCategories(){
        mMonkeyRecyclerAdapter.displayInitialMonkeys();
    }

    @Override
    public void onMonkeyClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("monkey_name", mMonkeyRecyclerAdapter.getSelectedMonkey(position).getMonkeyName());
        //bundle.putString("monkey_name", "YEETISH");

        getParentFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.FragmentContainer, MonkeyDetailFragment.class, bundle)
                .addToBackStack("SecondFragment")
                .commit();
    }
}