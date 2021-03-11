package com.example.bloonshelper.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.example.bloonshelper.R;
import com.example.bloonshelper.adapters.MonkeyRecyclerAdapter;
import com.example.bloonshelper.adapters.OnMonkeyListener;
import com.example.bloonshelper.singleton.GlideSingleton;
import com.example.bloonshelper.viewmodel.MonkeyFragmentListViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MonkeyListFragment extends Fragment implements OnMonkeyListener {

    private MonkeyFragmentListViewModel mViewModel;
    private RecyclerView mMonkeyRecyclerView;
    private MonkeyRecyclerAdapter mMonkeyRecyclerAdapter;
    private GlideSingleton glideSingleton;

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
        return GlideSingleton.getInstance(this.getContext()).getRequestManager();
    }

    private void displaySearchCategories(){
        mMonkeyRecyclerAdapter.displayInitialMonkeys();
    }

    @Override
    public void onMonkeyClick(int position, ImageView sharedImageView) {
        Bundle bundle = new Bundle();
        bundle.putString("monkey_name", mMonkeyRecyclerAdapter.getSelectedMonkey(position).getMonkeyName());

        getParentFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .addSharedElement(sharedImageView, ViewCompat.getTransitionName(sharedImageView))
//                .setCustomAnimations(
//                        R.anim.slide_in,
//                        R.anim.fade_out,
//                        R.anim.fade_in,
//                        R.anim.slide_out
//                )
                .replace(R.id.FragmentContainer, MonkeyDetailFragment.class, bundle)
                .addToBackStack("SecondFragment")
                .commit();
    }
}