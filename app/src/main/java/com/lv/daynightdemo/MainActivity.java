package com.lv.daynightdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbarMain;
    private RecyclerView recyclerMain;
    private FloatingActionButton floatButtonMain;

    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {

        toolbarMain = (Toolbar) findViewById(R.id.toolbar_main);
        recyclerMain = (RecyclerView) findViewById(R.id.recycler_main);
        floatButtonMain = (FloatingActionButton) findViewById(R.id.float_button_main);

        setSupportActionBar(toolbarMain);
        setRecyclerMain();
        floatButtonMain.setOnClickListener(this);
    }

    private void setRecyclerMain() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerMain.setLayoutManager(linearLayoutManager);
        mainAdapter = new MainAdapter(this);
        recyclerMain.setAdapter(mainAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            if (DemoApplication.IS_DAY_MODE) {//说明是日间模式
                item.setIcon(R.drawable.ic_night);
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                item.setIcon(R.drawable.ic_day);
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            recreate();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.float_button_main:
                recyclerMain.scrollToPosition(0);
                break;
        }
    }
}
