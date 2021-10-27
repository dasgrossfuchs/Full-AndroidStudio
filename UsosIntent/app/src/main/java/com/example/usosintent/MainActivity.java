package com.example.usosintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mCallingButton;
    private Button mCameraButton;
    private Button mNavButton;

    private static final int REQUEST_CALL_PHONE = 2;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        mCallingButton = findViewById( R.id.button_llamada );
        mCameraButton=findViewById( R.id.button_camara );
        mNavButton=findViewById( R.id.button_navegador );

        mCallingButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int_marcar = new Intent(Intent.ACTION_CALL);
                int_marcar.setData( Uri.parse("tel:4777531053") );
                if(int_marcar.resolveActivity( getPackageManager())!= null){
                    if(hasPermission( MainActivity.this, Manifest.permission.CALL_PHONE )){
                        startActivity(int_marcar);
                    } else{
                        ActivityCompat.requestPermissions(
                                MainActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                REQUEST_CALL_PHONE);
                        startActivity(int_marcar);
                    }
                    
                }
            }
        } );

        mCameraButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int_camara = new Intent( MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                if(int_camara.resolveActivity( getPackageManager())!=null){
                    startActivityForResult( int_camara,REQUEST_IMAGE_CAPTURE );
                }
            }
        } );

        mNavButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri web = Uri.parse("https://www.reddit.com/r/cats/");
                Intent int_nav= new Intent(Intent.ACTION_VIEW,web);
                if(int_nav.resolveActivity( getPackageManager())!=null){
                    startActivity( int_nav );
                }
            }
        } );

    }
    private boolean hasPermission(Context context, String permission){
        return ContextCompat.checkSelfPermission( context,permission )== PackageManager.PERMISSION_GRANTED;
    }
}