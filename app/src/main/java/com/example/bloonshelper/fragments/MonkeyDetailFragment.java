package com.example.bloonshelper.fragments;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.bloonshelper.R;
import com.example.bloonshelper.data.Monkey;
import com.example.bloonshelper.data.MonkeysData;
import com.example.bloonshelper.data.TierTracker;
import com.example.bloonshelper.data.Upgrade;
import com.example.bloonshelper.singleton.GlideSingleton;
import com.example.bloonshelper.viewmodel.MonkeyDetailViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MonkeyDetailFragment extends Fragment {

    private static final String TAG = "MonkeyDetailFragment";
    private MonkeyDetailViewModel mViewModel;
    private LinearLayout scrollView;
    private ImageView imageView;
    private String monkeyName;
    private TextView monkeyNameTextView, txtMonkeyCost1, txtMonkeyCost2, txtMonkeyCost3, upgradeDescription1,upgradeDescription2,upgradeDescription3;
    private TableLayout tableLayout;
    private GlideSingleton glideSingleton;
    private LinearLayout upgradeRow1, upgradeRow2, upgradeRow3;
    private ImageButton imageButton, path1, path2, path3, downgrade1, downgrade2, downgrade3;
    private Monkey mMonkey;
    private TierTracker tierTracker1, tierTracker2, tierTracker3;
    private Upgrade upgrade1, upgrade2, upgrade3;
    private MonkeysData.Difficulty selectedDifficulty;

    /*
    The onCreate() method in a Fragment is called after the Activity's onAttachFragment() but before that Fragment's onCreateView().
    In this method, you can assign variables, get Intent extras, and anything else that doesn't involve the View hierarchy (i.e. non-graphical initialisations).
    This is because this method can be called when the Activity's onCreate() is not finished, and so trying to access the View hierarchy here may result in a crash.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postponeEnterTransition();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
        monkeyName = requireArguments().getString("monkey_name");
        glideSingleton = GlideSingleton.getInstance(this.getContext());
    }

    /*
    After the onCreate() is called (in the Fragment), the Fragment's onCreateView() is called. You can assign your View variables and do any graphical initialisations.
     You are expected to return a View from this method, and this is the main UI view, but if your Fragment does not use any layouts or graphics, you can return null (happens by default if you don't override).
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.monkey_detail_fragment, container, false);
        monkeyNameTextView = view.findViewById(R.id.fMonkeyName);
        imageView = view.findViewById(R.id.fragmentMonkeyIcon);
        tableLayout = view.findViewById(R.id.tableLayout);
        imageButton = view.findViewById(R.id.difficultySelect);
        upgradeRow1 = view.findViewById(R.id.upgradeRow1);
        upgradeRow2 = view.findViewById(R.id.upgradeRow2);
        upgradeRow3 = view.findViewById(R.id.upgradeRow3);
        Typeface typeface = ResourcesCompat.getFont(this.getContext(), R.font.bungee_regular);

        path1 = upgradeRow1.findViewById(R.id.upgradeButton);
        downgrade1 = upgradeRow1.findViewById(R.id.downgradeButton);
        upgradeDescription1 = upgradeRow1.findViewById(R.id.UpgradeContents);
        upgradeDescription1.setMovementMethod(new ScrollingMovementMethod());
        path2 = upgradeRow2.findViewById(R.id.upgradeButton);
        downgrade2 = upgradeRow2.findViewById(R.id.downgradeButton);
        upgradeDescription2 = upgradeRow2.findViewById(R.id.UpgradeContents);
        upgradeDescription2.setMovementMethod(new ScrollingMovementMethod());
        path3 = upgradeRow3.findViewById(R.id.upgradeButton);
        downgrade3 = upgradeRow3.findViewById(R.id.downgradeButton);
        upgradeDescription3 = upgradeRow3.findViewById(R.id.UpgradeContents);
        upgradeDescription3.setMovementMethod(new ScrollingMovementMethod());
        scrollView = view.findViewById(R.id.fragmentScrollView);
        txtMonkeyCost1 = upgradeRow1.findViewById(R.id.txtPrice);
        txtMonkeyCost2 = upgradeRow2.findViewById(R.id.txtPrice);
        txtMonkeyCost3 = upgradeRow3.findViewById(R.id.txtPrice);
        txtMonkeyCost1.setTypeface(typeface);
        txtMonkeyCost2.setTypeface(typeface);
        txtMonkeyCost3.setTypeface(typeface);
        tierTracker1 = new TierTracker(upgradeRow1.findViewById(R.id.toggleButton1), upgradeRow1.findViewById(R.id.toggleButton2), upgradeRow1.findViewById(R.id.toggleButton3), upgradeRow1.findViewById(R.id.toggleButton4), upgradeRow1.findViewById(R.id.toggleButton5));
        tierTracker2 = new TierTracker(upgradeRow2.findViewById(R.id.toggleButton1), upgradeRow2.findViewById(R.id.toggleButton2), upgradeRow2.findViewById(R.id.toggleButton3), upgradeRow2.findViewById(R.id.toggleButton4), upgradeRow2.findViewById(R.id.toggleButton5));
        tierTracker3 = new TierTracker(upgradeRow3.findViewById(R.id.toggleButton1), upgradeRow3.findViewById(R.id.toggleButton2), upgradeRow3.findViewById(R.id.toggleButton3), upgradeRow3.findViewById(R.id.toggleButton4), upgradeRow3.findViewById(R.id.toggleButton5));

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                difficultySelect(mMonkey);
            }
        });

        path1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.upgrade("upgrade1");
            }
        });

        path2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.upgrade("upgrade2");
            }
        });

        path3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.upgrade("upgrade3");
            }
        });

        downgrade1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.upgrade("downgrade1");
            }
        });

        downgrade2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.upgrade("downgrade2");
            }
        });
        downgrade3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.upgrade("downgrade3");
            }
        });

        return view;
    }

    /*
   As the name states, this is called after the Activity's onCreate() has completed.
   It is called after onCreateView(), and is mainly used for final initialisations (for example, modifying UI elements).
   This is deprecated from API level 28.
    */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MonkeyDetailViewModel.class);
        init();
        subscribeObservers();
    }

    private void init() {
        RequestListener<Drawable> yeet = new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                startPostponedEnterTransition();
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                startPostponedEnterTransition();
                return false;
            }
        };

        glideSingleton.getRequestManager().load(R.drawable.modeselecteasybtn).listener(yeet).into(imageButton);
        selectedDifficulty = MonkeysData.Difficulty.EASY;
    }

    private void subscribeObservers() {
        mViewModel.init(monkeyName).observe((LifecycleOwner) this, new Observer<Monkey>() {
            @Override
            public void onChanged(Monkey monkey) {
                if (monkey != null) {
                    mMonkey = monkey;
                    loadMonkeyDetails(monkey);
                    glideSingleton.getRequestManager().load("file:///android_asset/" + mViewModel.listOfUpgrades.get(0).getUpgradeIcon()).into(path1);
                    glideSingleton.getRequestManager().load("file:///android_asset/" + mViewModel.listOfUpgrades.get(5).getUpgradeIcon()).into(path2);
                    glideSingleton.getRequestManager().load("file:///android_asset/" + mViewModel.listOfUpgrades.get(10).getUpgradeIcon()).into(path3);
                    txtMonkeyCost1.setText(String.valueOf(mViewModel.listOfUpgrades.get(0).getUpgradeCost().returnCostViaDifficulty(selectedDifficulty)));
                    txtMonkeyCost2.setText(String.valueOf(mViewModel.listOfUpgrades.get(5).getUpgradeCost().returnCostViaDifficulty(selectedDifficulty)));
                    txtMonkeyCost3.setText(String.valueOf(mViewModel.listOfUpgrades.get(10).getUpgradeCost().returnCostViaDifficulty(selectedDifficulty)));
                    upgradeDescription1.setText(mViewModel.listOfUpgrades.get(0).getUpgradeDescription());
                    upgradeDescription2.setText(mViewModel.listOfUpgrades.get(5).getUpgradeDescription());
                    upgradeDescription3.setText(mViewModel.listOfUpgrades.get(10).getUpgradeDescription());
                    switch(monkey.getMonkeyClass()) {
                        case "PRIMARY": scrollView.setBackground(getResources().getDrawable(R.drawable.gradient_blue)); break;
                        case "MILITARY": scrollView.setBackground(getResources().getDrawable(R.drawable.gradient_green));  break;
                        case "MAGIC": scrollView.setBackground(getResources().getDrawable(R.drawable.gradient_purple));  break;
                        case "SUPPORT": scrollView.setBackground(getResources().getDrawable(R.drawable.gradient_orange)); break;
                        case "HERO": scrollView.setBackground(getResources().getDrawable(R.drawable.gradient_yellow)); break;
                        default: break;
                    }
                }
            }
        });


        mViewModel.activeUpgrade.observe((LifecycleOwner) this, new Observer<List<Upgrade>>() {
            @Override
            public void onChanged(List<Upgrade> upgrades) {
                if (upgrades != null) {
                    tierTracker1.update(mViewModel.getUpgradeTracker1());
                    tierTracker2.update(mViewModel.getUpgradeTracker2());
                    tierTracker3.update(mViewModel.getUpgradeTracker3());
                    if (mViewModel.getUpgradeTracker1() < 5)
                        upgradeDescription1.setText(mViewModel.listOfUpgrades.get(mViewModel.getUpgradeTracker1()).getUpgradeDescription());
                    else
                        upgradeDescription1.setText("");

                    if (mViewModel.getUpgradeTracker2() < 5)
                        upgradeDescription2.setText(mViewModel.listOfUpgrades.get(mViewModel.getUpgradeTracker2() + 5).getUpgradeDescription());
                    else
                        upgradeDescription2.setText("");

                    if (mViewModel.getUpgradeTracker3() < 5)
                        upgradeDescription3.setText(mViewModel.listOfUpgrades.get(mViewModel.getUpgradeTracker3()+10).getUpgradeDescription());
                    else
                        upgradeDescription3.setText("");

                    if (mViewModel.getUpgradeTracker1() != 0) {
                        glideSingleton.getRequestManager().load("file:///android_asset/" + mViewModel.listOfUpgrades.get(mViewModel.getUpgradeTracker1()-1).getUpgradeIcon()).into(downgrade1);
                        if (mViewModel.getUpgradeTracker1() < 5) {
                            glideSingleton.getRequestManager().load("file:///android_asset/" + mViewModel.listOfUpgrades.get(mViewModel.getUpgradeTracker1()).getUpgradeIcon()).into(path1);
                            txtMonkeyCost1.setVisibility(View.VISIBLE);
                            txtMonkeyCost1.setText(String.valueOf(mViewModel.listOfUpgrades.get(mViewModel.getUpgradeTracker1()).getUpgradeCost().returnCostViaDifficulty(selectedDifficulty)));
                        }
                        else {
                            glideSingleton.getRequestManager().load("file:///android_asset/max_upgrade.png").into(path1);
                            txtMonkeyCost1.setVisibility(View.INVISIBLE);
                        }
                    } else {
                        downgrade1.setImageBitmap(null);
                    }

                    if (mViewModel.getUpgradeTracker2() != 0) {
                        glideSingleton.getRequestManager().load("file:///android_asset/" + mViewModel.listOfUpgrades.get(mViewModel.getUpgradeTracker2() -1 + 5).getUpgradeIcon()).into(downgrade2);
                        if (mViewModel.getUpgradeTracker2() < 5) {
                            glideSingleton.getRequestManager().load("file:///android_asset/" + mViewModel.listOfUpgrades.get(mViewModel.getUpgradeTracker2() + 5).getUpgradeIcon()).into(path2);
                            txtMonkeyCost2.setVisibility(View.VISIBLE);
                            txtMonkeyCost2.setText(String.valueOf(mViewModel.listOfUpgrades.get(mViewModel.getUpgradeTracker2()+5).getUpgradeCost().returnCostViaDifficulty(selectedDifficulty)));
                        }
                        else {
                            glideSingleton.getRequestManager().load("file:///android_asset/max_upgrade.png").into(path2);
                            txtMonkeyCost2.setVisibility(View.INVISIBLE);
                        }
                    } else
                        downgrade2.setImageBitmap(null);

                    if (mViewModel.getUpgradeTracker3() != 0) {
                        glideSingleton.getRequestManager().load("file:///android_asset/" + mViewModel.listOfUpgrades.get(mViewModel.getUpgradeTracker3() -1 + 10).getUpgradeIcon()).into(downgrade3);
                        if (mViewModel.getUpgradeTracker3() < 5) {
                            glideSingleton.getRequestManager().load("file:///android_asset/" + mViewModel.listOfUpgrades.get(mViewModel.getUpgradeTracker3() + 10).getUpgradeIcon()).into(path3);
                            txtMonkeyCost3.setVisibility(View.VISIBLE);
                            txtMonkeyCost3.setText(String.valueOf(mViewModel.listOfUpgrades.get(mViewModel.getUpgradeTracker3()+10).getUpgradeCost().returnCostViaDifficulty(selectedDifficulty)));
                        }
                        else {
                            glideSingleton.getRequestManager().load("file:///android_asset/max_upgrade.png").into(path3);
                            txtMonkeyCost3.setVisibility(View.INVISIBLE);
                        }
                    } else
                        downgrade3.setImageBitmap(null);

                    for (int i=0; i< upgrades.size(); i++) {
                        Log.d(TAG, "onChanged: Upgrades are here! " + upgrades.get(i).getUpgradeName());
                    }
                }
            }
        });
    }

    private void loadMonkeyDetails(Monkey monkey) {

        monkeyNameTextView.setText(monkey.getMonkeyName());
//        tableLayout.removeAllViews();
        glideSingleton.getRequestManager().load("file:///android_asset/" + monkey.getMonkeyArt()).into(imageView);
//        for (int i = 1; i < monkey.getColumnCount(); i++) {
//            TableRow tableRow = new TableRow(this.getContext());
//            TextView description = new TextView(this.getContext());
//            description.setText(monkey.getColumnHeader(i));
//            tableRow.addView(description);
//            TextView content = new TextView(this.getContext());
//            content.setText(monkey.getContent(i, selectedDifficulty));
//            content.setGravity(Gravity.LEFT);
//            tableRow.addView(content);
//            tableLayout.addView(tableRow);
//        }
    }

    private void difficultySelect(Monkey monkey) {
        switch (selectedDifficulty) {
            case EASY: glideSingleton.getRequestManager().load(R.drawable.modeselectnormalbtn).into(imageButton); selectedDifficulty = MonkeysData.Difficulty.NORMAL; break;
            case NORMAL: glideSingleton.getRequestManager().load(R.drawable.modeselecthardbtn).into(imageButton); selectedDifficulty = MonkeysData.Difficulty.HARD; break;
            case HARD: glideSingleton.getRequestManager().load(R.drawable.modeselectimpoppablebtn).into(imageButton); selectedDifficulty = MonkeysData.Difficulty.IMPOPPABLE; break;
            case IMPOPPABLE: glideSingleton.getRequestManager().load(R.drawable.modeselecteasybtn).into(imageButton); selectedDifficulty = MonkeysData.Difficulty.EASY; break;
            default: glideSingleton.getRequestManager().load(R.drawable.modeselectnormalbtn).into(imageButton); selectedDifficulty = MonkeysData.Difficulty.EASY; break;
        }
        loadMonkeyDetails(monkey);
    }
}