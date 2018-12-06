package com.example.rahulkalamkar.myelearnapplication.Presenter;

import com.example.rahulkalamkar.myelearnapplication.Model.Notice;

import java.util.ArrayList;

public class MainPresenterImpl implements MainContractor.presenter, MainContractor.GetNoticeIntractor.OnFinishedListener {

    MainContractor.MainView mainView;
    MainContractor.GetNoticeIntractor getNoticeIntractor;

    public MainPresenterImpl(MainContractor.MainView mainView, MainContractor.GetNoticeIntractor getNoticeIntractor) {
        this.mainView = mainView;
        this.getNoticeIntractor = getNoticeIntractor;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onRefreshButtonClick() {
        if (mainView != null) {
            mainView.showProgress();
        }
        getNoticeIntractor.getNoticeArrayList(this);
    }

    @Override
    public void requestDataFromServer() {
        getNoticeIntractor.getNoticeArrayList(this);
    }

    @Override
    public void onFinished(ArrayList<Notice> noticeArrayList) {
        if (mainView != null) {
            mainView.setDataToRecyclerView(noticeArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if (mainView != null) {
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
