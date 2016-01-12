package com.example.hpes;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class TabDemo extends Activity implements TabListener {

    List<TabFragment> tabFragmentList = new ArrayList<TabFragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (int i=1; i <= 3; i++) {
            Tab tab = actionBar.newTab();
            tab.setText("Tab " + i);
            tab.setTabListener(this);
            actionBar.addTab(tab);
        }
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        Fragment fragment = null;
        TabFragment tabFragment = null;

        if (tabFragmentList.size() > tab.getPosition()) {
            fragment = (Fragment) tabFragmentList.get(tab.getPosition());
        }

        if (fragment == null) {
            tabFragment = new TabFragment();
            Bundle bundle = new Bundle();
            int imgResId = 0;
            
            if(tab.getPosition()==0){
                imgResId = getResources().getIdentifier("duck", "drawable",
                        "com.example.hpes.layout.activity_calculator");
                
            } else if (tab.getPosition()==1){
                imgResId = getResources().getIdentifier("parrot", "drawable",
                        "com.example.hpes.layout.activity_game");
               
            } else if(tab.getPosition()==2){
                imgResId = getResources().getIdentifier("cock", "drawable",
                        "com.example.hpes.layout.activity_dictionary");
                
            }
            bundle.putInt("image", imgResId);
           
            tabFragment.setArguments(bundle);
            tabFragmentList.add(tabFragment);
        }
        else {
            tabFragment = (TabFragment) fragment;
        }
        ft.replace(android.R.id.content, tabFragment);
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        if (tabFragmentList.size() > tab.getPosition()) {
            ft.remove((Fragment) tabFragmentList.get(tab.getPosition()));
        }
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {  }
}

 

