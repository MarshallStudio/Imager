package com.marshallstudio.imager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.marshallstudio.imager.databinding.FragmentPreviewImageBinding;

import java.util.Objects;

public class PreviewImageFragment extends Fragment {
    private FragmentPreviewImageBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding=FragmentPreviewImageBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            PreviewImageFragmentArgs args=PreviewImageFragmentArgs.fromBundle(getArguments());
            Hits hit=args.getImageDetails();

            Glide
                    .with(requireContext())
                    .load(hit.getLargeImageURL())
                    .thumbnail(Glide
                            .with(requireContext())
                            .load(hit.getWebformatURL()))
                    .transition(DrawableTransitionOptions.withCrossFade(200))
                    .into(mBinding.ivImage);

        }
    }
}