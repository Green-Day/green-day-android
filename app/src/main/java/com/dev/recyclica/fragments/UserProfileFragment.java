package com.dev.recyclica.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.recyclica.R;
import com.dev.recyclica.adapters.ProfileOptionAdapter;
import com.dev.recyclica.api.AppConfig;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;

public class UserProfileFragment extends MvpAppCompatFragment {

    private Unbinder unbinder;

    private ProfileOptionAdapter adapter = new ProfileOptionAdapter();
    public static final String TAG = "Profile";

    @BindView(R.id.rc_profile_options)
    RecyclerView mRecyclerViewOptions;

    @BindView(R.id.tv_nickName)
    TextView mTextViewNickName;

    @BindView(R.id.tv_fullName)
    TextView mTextViewFullName;

    @BindView(R.id.tv_registration_year)
    TextView mTextViewRegistrationYear;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, v);
        mRecyclerViewOptions.setAdapter(adapter);
        mRecyclerViewOptions.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter.setOptions(AppConfig.getFishOptions());

        Bundle arguments = getArguments();

        if (arguments != null) {
            mTextViewFullName.setText(arguments.getString(FULLNAME_KEY, "Name"));
            mTextViewNickName.setText(arguments.getString(NICKNAME_KEY, "NickName"));
            mTextViewRegistrationYear.setText(getString(R.string.registered_in_the_service_since,
                    arguments.getInt(REGISTRATION_YEAR_KEY, 2020)));
        }


        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private UserProfileFragment() {}

    private static final String FULLNAME_KEY = "FullName";
    private static final String NICKNAME_KEY = "NickName";
    private static final String REGISTRATION_YEAR_KEY = "REGISTRATION_YEAR_KEY";

    public static UserProfileFragment newInstance(String FullName, String NickName, int RegistrationYear) {

        Bundle args = new Bundle();
        args.putString(FULLNAME_KEY, FullName);
        args.putString(NICKNAME_KEY, NickName);
        args.putInt(REGISTRATION_YEAR_KEY, RegistrationYear);

        UserProfileFragment fragment = new UserProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
