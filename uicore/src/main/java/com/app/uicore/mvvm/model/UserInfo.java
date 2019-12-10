package com.app.uicore.mvvm.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.android.databinding.library.baseAdapters.BR;

public class UserInfo {

//    private String username;
//    private String password;
//
//    @Bindable
//    public String getUsername() {
//        return username == null ? "" : username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//        notifyPropertyChanged(BR.username);
//    }
//
//    @Bindable
//    public String getPassword() {
//        return password == null ? "" : password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//        notifyPropertyChanged(BR.password);
//    }

    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

}
