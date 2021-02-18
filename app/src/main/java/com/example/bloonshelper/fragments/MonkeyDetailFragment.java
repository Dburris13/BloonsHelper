package com.example.bloonshelper.fragments;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.bloonshelper.R;
import com.example.bloonshelper.data.Monkey;
import com.example.bloonshelper.room.MonkeyRepository;
import com.example.bloonshelper.viewmodel.MonkeyDetailViewModel;

import java.io.IOException;
import java.io.InputStream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class MonkeyDetailFragment extends Fragment {

    private static final String TAG = "MonkeyDetailFragment";
    private MonkeyDetailViewModel mViewModel;
    private ImageView imageView;
    private TextView monkeyName;
    private MonkeyRepository monkeyRepository;
    private TableLayout tableLayout;

    public static MonkeyDetailFragment newInstance() {
        return new MonkeyDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.monkey_detail_fragment, container, false);

        monkeyName = view.findViewById(R.id.fMonkeyName);
        imageView = view.findViewById(R.id.fragmentMonkeyIcon);
        monkeyRepository = new MonkeyRepository(this.getContext());
        tableLayout = view.findViewById(R.id.tableLayout);


        if (requireArguments().getString("monkey_name") != null) {
            Log.d(TAG, "onActivityCreated: monkey_name = " + requireArguments().getString("monkey_name"));
//            textView.setText(requireArguments().getString("monkey_name"));
            Monkey monkey = monkeyRepository.getMonkeyByName(requireArguments().getString("monkey_name"));
            monkeyName.setText(monkey.getMonkeyName());
//            Log.d(TAG, "onCreateView: File:///android_asset/" + monkey.getMonkeyArt());
            imageView.setImageBitmap(getBitmapFromAsset(monkey.getMonkeyArt()));
            loadMonkeyDetails(monkey);

        } else {
            Log.d(TAG, "onActivityCreated: monkey_name is null");
        }
        return view;
    }

    private void loadMonkeyDetails(Monkey monkey) {
        for (int i = 1; i < monkey.getColumnCount(); i++) {
            TableRow tableRow = new TableRow(this.getContext());
            TextView description = new TextView(this.getContext());
            description.setText(monkey.getColumnHeader(i));
            tableRow.addView(description);
            TextView content = new TextView(this.getContext());
            content.setText(monkey.getContent(i));
            content.setGravity(Gravity.RIGHT);
            tableRow.addView(content);
            tableLayout.addView(tableRow);
        }

    }

    private Bitmap getBitmapFromAsset(String strName)
    {
        AssetManager assetManager = this.getContext().getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(strName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        return bitmap;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MonkeyDetailViewModel.class);
        // TODO: Use the ViewModel
        
//        Glide.with(this).load("file:///android_asset/" + requireArguments().getString("monkey_art")).into(imageView);
//        imageView.setImageURI("file:///android_asset/" + requireArguments().getString("monkey_art"));
    }

    public void onBackPressed() {

    }


}