package com.example.rahulkalamkar.myelearnapplication.Presenter;

import android.util.Log;

import com.example.rahulkalamkar.myelearnapplication.Interface.GetNoticeDataService;
import com.example.rahulkalamkar.myelearnapplication.Model.NoticeList;
import com.example.rahulkalamkar.myelearnapplication.WebService.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetNoticeIntractorImpl implements MainContractor.GetNoticeIntractor {
    @Override
    public void getNoticeArrayList(final OnFinishedListener onFinishedListener) {
        /** Create handle for the RetrofitInstance interface*/
        GetNoticeDataService service = ApiClient.getRetrofitInstance().create(GetNoticeDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<NoticeList> call = service.getNoticeData();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                onFinishedListener.onFinished(response.body().getNoticeArrayList());

            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
