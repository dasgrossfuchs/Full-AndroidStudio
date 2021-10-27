package com.example.p3dosactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //variables miembro
    private Button mOtherActivityButton;
    private TextView mHelloTextView;
    private String mName;
    //constantes
    private static final int REQUEST_CODE_NAME=0;
    private static final String TAG="etiqueta";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        // Infllar widget
        mOtherActivityButton = findViewById( R.id.other_activity_button );
        mHelloTextView=findViewById( R.id.hello_textview );
        //Evento onClick
        mOtherActivityButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = mHelloTextView.getText().toString();
                Intent i=OtherActivity.newIntent(MainActivity.this,message);
                startActivityForResult( i,0 );
            }

        } );
        Log.d(TAG,"onCreate() llamado");
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode != Activity.RESULT_OK){
            return;
        }
        if(requestCode == REQUEST_CODE_NAME){
            if(data==null){
                return;
            }
            //Asignacion de valor de variable name
            //de Clase OtherActivity a variable name de aqui
            mName=OtherActivity.wasNameShown(data);
            mHelloTextView.setText( mName );
            Log.d(TAG,"onActivityResult() llamado");
        }
    }
}