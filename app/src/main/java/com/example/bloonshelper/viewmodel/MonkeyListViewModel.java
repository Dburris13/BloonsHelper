package com.example.bloonshelper.viewmodel;

import android.app.Application;

import com.example.bloonshelper.data.Monkey;
import com.example.bloonshelper.room.MonkeyRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MonkeyListViewModel extends AndroidViewModel {

    private static final String TAG = "MonkeyListViewModel";
    
    private MonkeyRepository monkeyRepository;
    private LiveData<List<Monkey>> mMonkeyList;

    public MonkeyListViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Monkey>> getAllMonkeys() {
        return mMonkeyList;
    }

}
