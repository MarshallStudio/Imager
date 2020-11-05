package com.marshallstudio.imager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;

import com.marshallstudio.imager.databinding.FragmentOptionsBinding;

public class OptionsFragment extends Fragment {
    private FragmentOptionsBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentOptionsBinding.inflate(inflater, container, false);
        setOnItemSelectedListeners();
        setOnSwitchStateChangeListeners();
        return mBinding.getRoot();
    }

    private void setOnSwitchStateChangeListeners() {
        mBinding.switchEdictorsChoice.setOnCheckedChangeListener((compoundButton, b) -> {
            SearchPreferences searchPreferences = SearchPreferences.getSearchPreferences();
            searchPreferences.setEditorsChoice(b);
        });

        mBinding.switchSafeSearch.setOnCheckedChangeListener((compoundButton, b) -> {
            SearchPreferences searchPreferences = SearchPreferences.getSearchPreferences();
            searchPreferences.setSafeSearch(b);
        });
    }

    private void setOnItemSelectedListeners() {
        mBinding.spinnerOrders.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SearchPreferences searchPreferences = SearchPreferences.getSearchPreferences();
                searchPreferences.setOrder(mBinding.spinnerOrders.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        mBinding.spinnerCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (mBinding.spinnerCategories.getSelectedItem().toString().equals("all")) {
                    SearchPreferences searchPreferences = SearchPreferences.getSearchPreferences();
                    searchPreferences.setCategory(null);
                } else {
                    SearchPreferences searchPreferences = SearchPreferences.getSearchPreferences();
                    searchPreferences.setCategory(mBinding.spinnerCategories.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mBinding.spinnerImageTypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SearchPreferences searchPreferences = SearchPreferences.getSearchPreferences();
                searchPreferences.setImageType(mBinding.spinnerImageTypes.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mBinding.spinnerOrientations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SearchPreferences searchPreferences = SearchPreferences.getSearchPreferences();
                searchPreferences.setOrientation(mBinding.spinnerOrientations.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}