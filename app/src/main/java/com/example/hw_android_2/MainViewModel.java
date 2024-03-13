package com.example.hw_android_2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public String nameEntered = "Anonymous";
    public long count = 0;

    public MainViewModel() {
    }

    MutableLiveData<String> nameEnteredLiveData = new MutableLiveData<>();

    public void setNameEntered(String name) {
        nameEnteredLiveData.setValue(name);
    }

    public MutableLiveData<String> getNameEntered() {
        return nameEnteredLiveData;
    }

    MutableLiveData<Long> countLiveData = new MutableLiveData<>();

    public void setCount(long count) {
        countLiveData.setValue(count);
    }

    public MutableLiveData<Long> getCount() {
        return countLiveData;
    }
}
