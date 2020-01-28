package com.dev.recyclica.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.recyclica.R;
import com.dev.recyclica.adapters.InformationAboutUtilsAdapter;
import com.dev.recyclica.api.AppConfig;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;

public class InformationAboutUtilFragment extends MvpAppCompatFragment {

    private final InformationAboutUtilsAdapter adapter = new InformationAboutUtilsAdapter();
    private Unbinder unbinder;

    @BindView(R.id.rv_information_about_utils)
    RecyclerView mRecyclerViewInformation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_util_information, container, false);
        unbinder = ButterKnife.bind(this, v);

        mRecyclerViewInformation.setAdapter(adapter);
        mRecyclerViewInformation.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter.setInformationsList(AppConfig.getFishInformation());

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
