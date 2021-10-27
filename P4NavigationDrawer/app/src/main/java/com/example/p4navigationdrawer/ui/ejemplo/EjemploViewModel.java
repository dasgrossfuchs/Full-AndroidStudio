package com.example.p4navigationdrawer.ui.ejemplo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EjemploViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public EjemploViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue( "This is ejemplo fragment" );
    }

    public LiveData<String> getText() {
        return mText;
    }
}