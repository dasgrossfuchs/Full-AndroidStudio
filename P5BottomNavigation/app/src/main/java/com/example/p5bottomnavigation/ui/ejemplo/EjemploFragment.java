package com.example.p5bottomnavigation.ui.ejemplo;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.p5bottomnavigation.R;
import com.example.p5bottomnavigation.databinding.FragmentEjemploBinding;
import com.example.p5bottomnavigation.ui.ejemplo.EjemploViewModel;

public class EjemploFragment extends Fragment {

//    private EjemploViewModel mViewModel;
//
//    public static EjemploFragment newInstance() {
//        return new EjemploFragment();
//    }
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate( R.layout.fragment_ejemplo, container, false );
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated( savedInstanceState );
//        mViewModel = new ViewModelProvider( this ).get( EjemploViewModel.class );
//        // TODO: Use the ViewModel
//    }
    private EjemploViewModel ejemploViewModel;
    private FragmentEjemploBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ejemploViewModel =
                new ViewModelProvider( this ).get( EjemploViewModel.class );

        binding = FragmentEjemploBinding.inflate( inflater, container, false );
        View root = binding.getRoot();

        final TextView textView = binding.textEjemplo;
        ejemploViewModel.getText().observe( getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText( s );
            }
        } );
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}