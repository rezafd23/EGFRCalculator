package com.example.egfr_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCalculate,btnClear;
    private EditText txtUsia,txtBB,txtKreatinin,txtAlbumin,txtUreum,txtCk,txtHadi;
    private Spinner SpinJK;
    private Double HitungHadi,HitungCK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsia=findViewById(R.id.txtUsia);
        txtBB=findViewById(R.id.txtBB);
        txtKreatinin=findViewById(R.id.txtKreatinin);
        txtAlbumin=findViewById(R.id.txtAlbumin);
        txtUreum=findViewById(R.id.txtUreum);
        txtCk=findViewById(R.id.txtCk);
        txtHadi=findViewById(R.id.txtHadi);
        btnCalculate=findViewById(R.id.btnCalculate);
        SpinJK=findViewById(R.id.SpinJK);
        btnClear=findViewById(R.id.btnClear);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUsia.setText("");
                txtBB.setText("");
                txtKreatinin.setText("");
                txtAlbumin.setText("");
                txtUreum.setText("");
                txtCk.setText("");
                txtHadi.setText("");
                txtHadi.setText("");
                txtCk.setText("");
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtUsia.getText().toString().equals("")&&txtAlbumin.getText().toString().equals("")&&
                        SpinJK.getSelectedItem().toString().equals("Pilih Jenis Kelamin")&&
                        txtUreum.getText().toString().equals("")||txtKreatinin.getText().toString().equals("")&&
                        txtBB.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Lengkapi Data",Toast.LENGTH_SHORT).show();
                    }
                else if (txtUsia.getText().toString().equals("")||txtAlbumin.getText().toString().isEmpty()||
                        SpinJK.getSelectedItem().toString().equals("Pilih Jenis Kelamin")){
                    Double U =Double.parseDouble(txtUreum.getText().toString());
                    Double K =Double.parseDouble(txtKreatinin.getText().toString());
                    Double B =Double.parseDouble(txtBB.getText().toString());
                    Toast.makeText(MainActivity.this,"Lengkapi Form Untuk Mendapatkan Nilai Hadi",Toast.LENGTH_SHORT).show();
                    if (SpinJK.getSelectedItem().toString().equals("P")){
                        HitungCK=((140-U)*B*0.85)/(K*72);
                    } else {
                        HitungCK=((140-U)*B)/(K*72);
                    }
                    txtCk.setText(String.valueOf(HitungCK));
                    } else {
                    Double U =Double.parseDouble(txtUreum.getText().toString());
                    Double K =Double.parseDouble(txtKreatinin.getText().toString());
                    Double B =Double.parseDouble(txtBB.getText().toString());
                    Double A =Double.parseDouble(txtAlbumin.getText().toString());
                    Double Us =Double.parseDouble(txtUsia.getText().toString());
                    HitungHadi=15+(30/U)+(60/K)-(0.1*A)-(0.2*Us);
                    if (SpinJK.getSelectedItem().toString().equals("P")){
                        HitungCK=((140-U)*B*0.85)/(K*72);
                    } else {
                        HitungCK=((140-U)*B)/(K*72);
                    }
                    txtCk.setText(String.valueOf(HitungCK));
                    txtHadi.setText(String.valueOf(HitungHadi));
                }
            }
        });
    }
}
