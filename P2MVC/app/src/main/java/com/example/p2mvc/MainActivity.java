package com.example.p2mvc;

import static java.lang.String.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Declaracion de variables
    private Button mNextButton;
    private Button mPreviousButton;
    private TextView mStudentTextView;
    private static final String TAG="etiqueta";
    private static final String KEY_INDEX="indice";
    // Creacion de arreglo de objetos de la clase student
    // Conexion del modelo con controlador
    Student[] mStudents = new Student[]{
            new Student( 111,"carlos",100 ),
            new Student( 222,"Ana",80 ),
            new Student( 333,"luis", 69 )
    };
    // Indice del arreglo
    private int mCurrentIndex=0;

    private void updateStudent(){
        mStudentTextView.setText(
                format( "%d\n%s\n%d",
                        mStudents[mCurrentIndex].getNoControl(),
                        mStudents[mCurrentIndex].getName(),
                        mStudents[mCurrentIndex].getScore() ) );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mNextButton = findViewById( R.id.next_button );
        mPreviousButton = findViewById( R.id.previous_button );
        mStudentTextView = findViewById( R.id.student_textview );
        mNextButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(mCurrentIndex<mStudents.length-1) mCurrentIndex++;
//                else mCurrentIndex = 0;
                mCurrentIndex = (mCurrentIndex+1)%mStudents.length;
                updateStudent();
            }
        });
        mPreviousButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(mCurrentIndex>0) mCurrentIndex--;
//                else mCurrentIndex = mStudents.length-1;
                mCurrentIndex = ((mCurrentIndex + mStudents.length) - 1) % mStudents.length;
                updateStudent();
            }
        });
        if(savedInstanceState!=null){
            mCurrentIndex = savedInstanceState.getInt( KEY_INDEX );
        }
        updateStudent();
        Log.d(TAG,"onCreate() llamado");
    }

    // Metodo para almacenar el indice antes de que se destruya
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState( savedInstanceState );
        Log.d(TAG,"onSavedInstanceState() llamado");
        savedInstanceState.putInt( KEY_INDEX,mCurrentIndex);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d( TAG,"onStart() llamado" );
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d( TAG,"onResume() llamado" );
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d( TAG,"onPause() llamado" );
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d( TAG,"onStop() llamado" );
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d( TAG,"onDestroy() llamado" );
    }

}