package com.example.hellotoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewMostrar;
    private int resultado ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void mostrarResultado() {
        mTextViewMostrar = (TextView) findViewById(R.id.show_count);// identificamos ventana donde mostrar texto
        mTextViewMostrar.setText(String.valueOf(resultado)); // establecemos valor en la ventana
    }
    public void aumentarCuenta(View view) {
        resultado++;
        mostrarResultado();
    }
    public void mostrarToast(View view) {
        Context context = getApplicationContext();
        TextView text = (TextView) findViewById(R.id.show_count);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text.getText(), duration);
        toast.show();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("resultado", resultado);
    }
    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        resultado = savedInstanceState.getInt("resultado");
        mTextViewMostrar = findViewById(R.id.show_count); // vuelvo a identificar la ventana, si no , no la encuentra
        mTextViewMostrar.setText(String.valueOf(resultado));
    }
}