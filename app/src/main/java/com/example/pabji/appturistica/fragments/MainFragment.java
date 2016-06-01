package com.example.pabji.appturistica.fragments;


import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pabji.appturistica.APIHelpers.TurismAPI;
import com.example.pabji.appturistica.APIHelpers.TurismAPIClient;
import com.example.pabji.appturistica.R;
import com.example.pabji.appturistica.activities.MainActivity;
import com.example.pabji.appturistica.adapters.ItemListAdapter;
import com.example.pabji.appturistica.models.RequestModel;
import com.example.pabji.appturistica.models.ResponseModel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pabji on 01/06/2016.
 */
public class MainFragment extends Fragment{

    private static final String TAG = MainFragment.class.getName();
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    private TurismAPI service;
    private Location location;
    private ItemListAdapter adapter;
    private ProgressDialog progressBar;


    public static MainFragment newInstance(Location location) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putParcelable("location",location);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        loadProgressBar();

        location = getArguments().getParcelable("location");
        getDataFromServer();
    }

    private void loadProgressBar() {
        progressBar = new ProgressDialog(getContext());
        progressBar.setIndeterminate(true);
        progressBar.setMessage("Obteniendo datos");
        progressBar.show();
    }

    private void getDataFromServer() {
        service = TurismAPIClient.createService();
        RequestModel request = new RequestModel("cc80e7fa7d839187f65d0f0c1d23d78e",String.valueOf(location.getLatitude()),String.valueOf(location.getLongitude()));
        Call<ResponseModel> response = service.receiveSomePlaces("application/x-www-form-urlencoded",request.getKey(),request.getLatitude(),request.getLongitude());
        response.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel responseServer = response.body();
                if (responseServer.getData().getTrips() !=null  && responseServer.getData().getDestinations()!=null){
                    progressBar.dismiss();
                    adapter = new ItemListAdapter(getActivity(), responseServer.getData());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());

                }else{
                    Toast.makeText(getActivity(), R.string.acceso_servidor,Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }


}
