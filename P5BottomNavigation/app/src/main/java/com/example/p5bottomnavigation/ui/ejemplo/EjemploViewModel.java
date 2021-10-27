package com.example.p5bottomnavigation.ui.ejemplo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EjemploViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EjemploViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue( "This is Ejemplo fragment" );
    }

    public LiveData<String> getText() {
        return mText;
    }
}