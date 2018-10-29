package com.utildev.arch.basemvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.utildev.arch.basemvvm.R;
import com.utildev.arch.basemvvm.databinding.ActivityMainBinding;
import com.utildev.arch.basemvvm.viewmodel.activity.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel();
        activityMainBinding.setMainViewModel(mainViewModel);
    }
}
