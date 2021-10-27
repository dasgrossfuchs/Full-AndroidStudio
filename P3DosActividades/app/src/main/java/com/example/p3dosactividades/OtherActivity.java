package com.example.p3dosactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {
    // variables ivars
    private TextView mMessageTextView;
    private TextView mNameTextView;
    private Button mShowButton;
    private static final String SEND_MESSAGE="mensaje";
    private static final String NAME = "Carlos";
    private static final String EXTRA_NAME_SHOWN="name";
    /* Asignacion de valor de variable mensaje a constante
    * SEND_MESSAGE static crea metodos o variables de clase
    * y esto hace que no se tenga que crear un objeto y es instancia */
    public static Intent newIntent(Context context, String message){
        Intent i = new Intent(context,OtherActivity.class);
        i.putExtra( SEND_MESSAGE,message );
        return i;
    }
    // Metodo llamado desde MainActivity para obtener valor de name en constante.
    public static String wasNameShown(Intent data){
        return data.getStringExtra( EXTRA_NAME_SHOWN );
    }
    //Recibe de parametro nombre de estudiante
    private void sendBackName(String name){
        Intent data = new Intent();
        //asigna valor de variable a constante
        data.putExtra( EXTRA_NAME_SHOWN,name );
        setResult( RESULT_OK,data );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_other );
        //inf widg
        mMessageTextView=findViewById( R.id.message_textview );
        mNameTextView=findViewById( R.id.name_textview );
        mShowButton=findViewById( R.id.show_button );
        mShowButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=getIntent().getStringExtra( SEND_MESSAGE );
                mMessageTextView.setText( message );
                mNameTextView.setText( NAME );
                sendBackName( NAME );
            }
        } );
    }
}