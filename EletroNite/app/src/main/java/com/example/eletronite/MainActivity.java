package com.example.eletronite;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double al;
    double ox;
    int fr = 3;
    Button botao;
    EditText edttemp, edtmv;
    TextView txtResultadooxigenio, txtResultadoalum, tvResp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edttemp = findViewById(R.id.entratemp);
        edtmv = findViewById(R.id.entramv);
        txtResultadooxigenio = findViewById(R.id.ResultadoOxigenio);
        txtResultadoalum = findViewById(R.id.ResultadoAlum);
        botao = findViewById(R.id.btnCalc);
        //tvResp = findViewById(R.id.tvResp);
    }


    public void calcular(View view) {

        //converte a string para checar campos vazio
        String vtemp = edttemp.getText().toString();
        String vmiliv = edtmv.getText().toString();

        //checa campo vazio
        if ("".equals(vtemp)) {
            Toast.makeText(this, "Entre com a temperatura", Toast.LENGTH_LONG).show();
        } else if ("".equals(vmiliv)) {
            Toast.makeText(this, "Entre com a miliviltagem", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = getIntent();
            Double FFp1F1 = intent.getDoubleExtra("FFp1F1", 0);
            Double FFp1F2 = intent.getDoubleExtra("FFp1F2", 0);
            Double FFp1F3 = intent.getDoubleExtra("FFp1F3", 0);
            Double FFp1F4 = intent.getDoubleExtra("FFp1F4", 0);

            Double RRhF1 = intent.getDoubleExtra("RRhF1", 0);
            Double RRhF2 = intent.getDoubleExtra("RRhF2", 0);
            Double RRhF3 = intent.getDoubleExtra("RRhF3", 0);
            Double RRhF4 = intent.getDoubleExtra("RRhF4", 0);

            Double CCbF1 = intent.getDoubleExtra("CCbF1", 0);
            Double CCbF2 = intent.getDoubleExtra("CCbF2", 0);
            Double CCbF3 = intent.getDoubleExtra("CCbF3", 0);
            Double CCbF4 = intent.getDoubleExtra("CCbF4", 0);

            Double EEtF1 = intent.getDoubleExtra("EEtF1", 0);
            Double EEtF2 = intent.getDoubleExtra("EEtF2", 0);
            Double EEtF3 = intent.getDoubleExtra("EEtF3", 0);
            Double EEtF4 = intent.getDoubleExtra("EEtF4", 0);

            double temperatura = Double.parseDouble(edttemp.getText().toString());
            double milivoltagem = Double.parseDouble(edtmv.getText().toString());
            Double realVtemp = Double.valueOf(vtemp);
            Double realVMiliv = Double.valueOf(vmiliv);

            if (realVtemp > 1760 || realVtemp < 1450) {
                Toast.makeText(this, R.string.CampoMaximo, Toast.LENGTH_LONG).show();
            } else if (realVMiliv < -300 || realVMiliv > 0) {
                Toast.makeText(this, R.string.CamposMaximos, Toast.LENGTH_LONG).show();
            } else {
                //ao clicar no btn
                if (view.getId() == R.id.btnCalc) {

                    if (fr == 1) {
                        //rh2 f1-104 f2 104 f3 111.26 f4 - 12079
                        al = Math.pow(10, (RRhF1 + RRhF2 * (milivoltagem + 24) / (temperatura - 1550 + 1550 + 273) + RRhF3 * Math.exp((-milivoltagem - 24) / (temperatura - 1550 + 1550 + 273)) + RRhF4 / (temperatura - 1550 + 1550 + 273)));

                    } else if (fr == 2) {
                        //rh3
                        al = Math.pow(10, (RRhF1 + RRhF2 * (milivoltagem + 24) / (temperatura - 1550 + 1550 + 273) + RRhF3 * Math.exp((-milivoltagem - 24) / (temperatura - 1550 + 1550 + 273)) + RRhF4 / (temperatura - 1550 + 1550 + 273)));


                    } else if (fr == 3) {
                        //fp 81 2.1
                        al = Math.pow(10, (FFp1F1 + FFp1F2 * (milivoltagem + 24) / (temperatura - 1550 + 1550 + 273) + FFp1F3 * Math.exp((-milivoltagem - 24) / (temperatura - 1550 + 1550 + 273)) + FFp1F4 / (temperatura + 1550 - 1550 + 273)));
                        //tvResp.setText("Nome: "+FFp1F1+"\nIdade: "+FFp1F2);
                    } else if (fr == 4) {
                        //cas ob
                        al = Math.pow(10, (CCbF1 + CCbF2 * (milivoltagem + 24) / (temperatura - 1550 + 1550 + 273) + CCbF3 * Math.exp((-milivoltagem - 24) / (temperatura - 1550 + 1550 + 273)) + CCbF4 / (temperatura + 1550 - 1550 + 273)));

                    } else if (fr == 5) {
                        //Estaçao argonio
                        al = Math.pow(10, (EEtF1 + EEtF2 * (milivoltagem + 24) / (temperatura - 1550 + 1550 + 273) + EEtF3 * Math.exp((-milivoltagem - 24) / (temperatura - 1550 + 1550 + 273)) + EEtF4 / (temperatura + 1550 - 1550 + 273)));

                    }
                    // 1.36+0.0059*(E+0.54*(T-1550)+0.0002*E*(T-1550))
                    ox = Math.pow(10, (1.36 + 0.0059 * (milivoltagem + 0.54 * (temperatura - 1550) + 0.0002 * milivoltagem * (temperatura - 1550))));

                    double aluminio = al;
                    double oxigenio = ox;
                    //double somas = soma;


                    //formatar apenas duas casas após virgula
                    DecimalFormat decimalOxigenio = new DecimalFormat("0.00");
                    String valorFormatadoOx = decimalOxigenio.format(oxigenio);
                    DecimalFormat decimalAlumio = new DecimalFormat("0.00");
                    String valorFormatadoAl = decimalAlumio.format(aluminio);

                    // DecimalFormat decimalSomas = new DecimalFormat("0.00");
                    //String valorSomas = decimalSomas.format(somas);

                    // txtResultadooxigenio.setText(String.valueOf(soma));
                    txtResultadooxigenio.setText(valorFormatadoOx);//
                    txtResultadoalum.setText(valorFormatadoAl);

                }
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // MenuInflater inflater =
        getMenuInflater().inflate(R.menu.menuecil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();

        switch(id)

    {
        case R.id.fformulas:

            Intent intent = new Intent(this, formulas.class);
            startActivity(intent);
            return true;

        case R.id.rh2:
            fr = 1;
            botao.setText("RH2");
            return true;


        case R.id.rh3:
            fr = 2;
            botao.setText("RH3");
            return true;

        case R.id.fornop:
            fr = 3;
            botao.setText("FORNO PANELA");
            return true;

        case R.id.casob:
            fr = 4;
            botao.setText("CAS OB");
            return true;

        case R.id.eestacaoArg:
            fr = 5;
            botao.setText("ESTAÇAO ARGONIO");
            return true;

        default:
            return super.onOptionsItemSelected(item);
    }



        }

}