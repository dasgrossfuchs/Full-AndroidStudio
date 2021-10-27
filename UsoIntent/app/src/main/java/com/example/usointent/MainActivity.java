package com.example.usointent;

import androidx.activity.result.contract.ActivityResultContracts;
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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mHelloTv;
    private Button mCallingButton;
    private Button mCameraButton;
    private Button mNavButton;

    private static final int REQUEST_IMAGE_CAPTURE=1;
    private static final int REQUEST_CALL_PHONE=2;
    private static final String TAG="etiqueta";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        mHelloTv=findViewById( R.id.textview_hello );
        mCallingButton=findViewById( R.id.button_llamar );

        mCallingButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imarcar = new Intent(Intent.ACTION_CALL);
                imarcar.setData( Uri.parse("tel:4777531053") );

//                if(ActivityCompat.checkSelfPermission( MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
//                    return;
//                }
                if (imarcar.resolveActivity(getPackageManager()) != null) {
                    if(hasPermission( MainActivity.this,Manifest.permission.CALL_PHONE )){
                        startActivity(imarcar);
                    } else{
                        ActivityCompat.requestPermissions(
                                MainActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                REQUEST_CALL_PHONE);
                    }
                    startActivity(imarcar);
                    Log.i(TAG, "Se inicio la llamada");
                }
            }
        } );

        mCameraButton=findViewById( R.id.button_camara );

        mCameraButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCamara = new Intent( MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                if (iCamara.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(iCamara, REQUEST_IMAGE_CAPTURE);
                    Log.i(TAG, "Se inicio la camara");
                }
            }
        } );

        mNavButton=findViewById( R.id.button_navegador );

        mNavButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://www.reddit.com/r/cats/");
                Intent inavegador = new Intent(Intent.ACTION_VIEW, webpage);
                if (inavegador.resolveActivity(getPackageManager()) != null) {
                    startActivity(inavegador);
                    Log.i(TAG, "Se inicio el navegador");
                }
            }
        } );


    }
    private boolean hasPermission(Context context, String permission){
        return ContextCompat.checkSelfPermission(context,permission) == PackageManager.PERMISSION_GRANTED;
    }
}