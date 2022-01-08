package com.example.eletronite;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class ecil extends AppCompatActivity {
    double al ;
    double ox ;
    int fr = 1;
    Button botao;
    EditText edttemp,edtmv;
    TextView txtResultadooxigenio,txtResultadoalum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecil);

        edttemp=findViewById(R.id.entratemp);
        edtmv=findViewById(R.id.entramv);
        txtResultadooxigenio=findViewById(R.id.ResultadoOxigenio);
        txtResultadoalum=findViewById(R.id.ResultadoAlum);
        botao = findViewById(R.id.btnCalc);
    }

    public  void calcular(View view) {

        //converte a string para checar campos vazio
        String vtemp = edttemp.getText().toString();
        String vmiliv = edtmv.getText().toString();


        //checa campo vazio

        if ("".equals(vtemp) || "".equals(vmiliv)) {
            Toast.makeText(this, R.string.Ha_campos_vazios, Toast.LENGTH_LONG).show();
        } else {
            double temperatura = Double.parseDouble(edttemp.getText().toString());
            double milivoltagem = Double.parseDouble(edtmv.getText().toString());
            Double realVtemp = Double.valueOf(vtemp);
            Double realVMiliv = Double.valueOf(vmiliv);

            if (realVtemp > 1760 || realVtemp < 1450) {
                Toast.makeText(this, R.string.CampoMaximo, Toast.LENGTH_LONG).show();
            } else
                if (realVMiliv <-300 || realVMiliv >0) {
                    Toast.makeText(this, R.string.CamposMaximos, Toast.LENGTH_LONG).show();
                }else{
                //ao clicar no btn
                if (view.getId() == R.id.btnCalc) {
                    //RH2/rh3
                    if (fr == 1 && realVMiliv <= -190) {
                        al = Math.pow(10, (125.2509 - 133.8457 * (milivoltagem + 24) / (temperatura - 1550 + 1550 + 273) - 112.2807 * Math.exp((-milivoltagem - 24) / (temperatura - 1550 + 1550 + 273)) - 23600.8493 / (temperatura - 1550 + 1550 + 273)));

                    } else if (fr == 1 && realVMiliv >= -160) {//ok
                        al = Math.pow(10, (-2196.5674 + 2396.6448 * (milivoltagem + 24) / (temperatura - 1550 + 1550 + 273) + 2216.1478 * Math.exp((-milivoltagem - 24) / (temperatura - 1550 + 1550 + 273)) - 20072.5584 / (temperatura - 1550 + 1550 + 273)));


                    } else if (fr == 1 && realVMiliv < -160 && realVMiliv > -190) {
                        al = Math.pow(10, (-104 + 104 * (milivoltagem + 24) / (temperatura - 1550 + 1550 + 273) + 111.26162 * Math.exp((-milivoltagem - 24) / (temperatura - 1550 + 1550 + 273)) - 12079.273 / (temperatura - 1550 + 1550 + 273)));//modifiquei

                    }

                    //fp
                    else if (fr == 3) {

                        al = Math.pow(10, (-58.6816 + 56.2414 * (milivoltagem + 24) / (temperatura - 1550 + 1550 + 273) + 66.7762 * Math.exp((-milivoltagem - 24) / (temperatura - 1550 + 1550 + 273)) - 14143.1400 / (temperatura - 1550 + 1550 + 273)));

                        //cas ob
                    } else if (fr == 4) {

                        al = Math.pow(10, (-58.6816 + 56.2414 * (milivoltagem + 24) / (temperatura - 1550 + 1550 + 273) + 66.7762 * Math.exp((-milivoltagem - 24) / (temperatura - 1550 + 1550 + 273)) - 14143.1400 / (temperatura - 1550 + 1550 + 273)));

                    }

                    ox = Math.pow(10, (1.36 + 0.0059 * (milivoltagem + 0.54 * (temperatura - 1550) + 0.0002 * milivoltagem * (temperatura - 1550))));
                    double aluminio = al;
                    double oxigenio = ox;

                    //formatar apenas duas casas após virgula
                    DecimalFormat decimalOxigenio = new DecimalFormat("0.00");
                    String valorFormatadoOx = decimalOxigenio.format(oxigenio);
                    DecimalFormat decimalAlumio = new DecimalFormat("0.00");
                    String valorFormatadoAl = decimalAlumio.format(aluminio);

                    txtResultadooxigenio.setText(valorFormatadoOx);
                    txtResultadoalum.setText(valorFormatadoAl);

                }
            }
        }
    }

/*
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuecil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fformulas:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                 return true;


            case R.id.rh2:
                fr = 1;
                botao.setText("RH2");
                return true;

            case R.id.rh3:
                fr = 1;
                botao.setText("RH3");
                return true;

            case R.id.fornop:
                fr = 3;
                botao.setText("FORNO P");
                return true;

            case R.id.casob:
                fr = 4;
                botao.setText("CAS OB");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
    }

