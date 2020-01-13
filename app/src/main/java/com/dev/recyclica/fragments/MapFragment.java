package com.dev.recyclica.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dev.recyclica.R;
import com.dev.recyclica.api.AppConfig;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;

public class MapFragment extends MvpAppCompatFragment {

    private Unbinder unbinder;

    @BindView(R.id.map_view)
    MapView mapView;

    public static final String TAG = "Map";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        unbinder = ButterKnife.bind(this, v);

        mapView.getMap().move(
                new CameraPosition(new Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MapKitFactory.setApiKey(AppConfig.MAP_KEY);
        MapKitFactory.initialize(getActivity());
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
        MapKitFactory.getInstance().onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
