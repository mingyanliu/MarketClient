package com.botou.hx.marketclient.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.botou.hx.marketclient.R;


/**
 * Created by Amethyst on 16/4/15/11/01.
 */
public class WorkFragment extends BaseFragment implements View.OnClickListener {
    private Button toolbar_left_btn, toolbar_right_btn;
    private Toolbar toolbar;
    private ImageView userWork;
    private UserWorkFragment userWorkFragment;
    private CasualFragment casualFragment;
    public static final int USERWORK_FRAGMENT_TYPE = 1;
    public static final int CASUAL_FRAGMENT_TYPE = 2;
    public int currentFragmentType = -1;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        if (savedInstanceState != null) {
            int type = savedInstanceState.getInt("currentFragmentType");
            userWorkFragment = (UserWorkFragment)fragmentManager.findFragmentByTag("message");
            casualFragment = (CasualFragment) fragmentManager.findFragmentByTag("call");
            if(type > 0)
                loadFragment(type);
        } else {
            FragmentTransaction transaction = fragmentManager
                    .beginTransaction();
            Fragment mainFragment = fragmentManager.findFragmentByTag("message");
            if (mainFragment != null) {
                transaction.replace(R.id.fl_content, mainFragment);
                transaction.commit();
            } else {
                loadFragment(USERWORK_FRAGMENT_TYPE);
            }
        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_work, null);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        initToolBar(view);
        toolbar_left_btn = findView(R.id.toolbar_left_btn, view);
        toolbar_right_btn = findView(R.id.toolbar_right_btn, view);
        toolbar_right_btn.setOnClickListener(this);
        toolbar_left_btn.setOnClickListener(this);
        userWork = findView(R.id.userWork, view);
        userWork.setOnClickListener(this);

    }

    private void initToolBar(View view) {
        toolbar = findView(R.id.workToolbar, view);
        toolbar.setTitle("");
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_work;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toolbar_left_btn:
                toolbar_left_btn.setTextColor(Color.parseColor("#df3031"));
                toolbar_right_btn.setTextColor(Color.WHITE);
                toolbar_left_btn
                        .setBackgroundResource(R.mipmap.baike_btn_pink_left_f_96);
                toolbar_right_btn
                        .setBackgroundResource(R.mipmap.baike_btn_trans_right_f_96);
                userWork.setVisibility(View.VISIBLE);
                switchFragment(USERWORK_FRAGMENT_TYPE);
                break;
            case R.id.toolbar_right_btn:
                toolbar_left_btn.setTextColor(Color.WHITE);
                toolbar_right_btn.setTextColor(Color.parseColor("#df3031"));
                toolbar_left_btn
                        .setBackgroundResource(R.mipmap.baike_btn_trans_left_f_96);
                toolbar_right_btn
                        .setBackgroundResource(R.mipmap.baike_btn_pink_right_f_96);
                userWork.setVisibility(View.GONE);
                switchFragment(CASUAL_FRAGMENT_TYPE);
                break;
            case R.id.userWork:

                break;
        }
    }

    private void switchFragment(int type) {
        switch (type) {
            case USERWORK_FRAGMENT_TYPE:
                loadFragment(USERWORK_FRAGMENT_TYPE);
                break;
            case CASUAL_FRAGMENT_TYPE:
                loadFragment(CASUAL_FRAGMENT_TYPE);
                break;
        }

    }

    private void loadFragment(int type) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (type == CASUAL_FRAGMENT_TYPE) {
            if (casualFragment == null) {
                casualFragment = new CasualFragment();

                transaction.add(R.id.fl_content, casualFragment, "zhishi");
            } else {
                transaction.show(casualFragment);
            }
            if (userWorkFragment != null) {
                transaction.hide(userWorkFragment);
            }
            currentFragmentType = USERWORK_FRAGMENT_TYPE;
        } else {
            if (casualFragment != null) {
                transaction.hide(casualFragment);
            }
            if (userWorkFragment == null) {
                userWorkFragment = new UserWorkFragment();
                transaction.add(R.id.fl_content, userWorkFragment, "wenda");
            } else {
                transaction.show(userWorkFragment);
            }

            currentFragmentType = CASUAL_FRAGMENT_TYPE;
        }
        transaction.commitAllowingStateLoss();
    }
}
