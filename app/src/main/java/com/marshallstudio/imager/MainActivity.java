package com.marshallstudio.imager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.marshallstudio.imager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding=ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(mBinding.getRoot());
    }
}