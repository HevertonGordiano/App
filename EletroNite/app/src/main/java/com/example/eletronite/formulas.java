package com.example.eletronite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class formulas extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    private Button btnClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulas);


        final EditText  Fp1F1 = findViewById(R.id.edtFp1F1);
        final EditText  Fp1F2 = findViewById(R.id.edtFp1F2);
        final EditText  Fp1F3 = findViewById(R.id.edtFp1F3);
        final EditText  Fp1F4 = findViewById(R.id.edtFp1F4);

        final EditText  RhF1 = findViewById(R.id.edtRhF1);
        final EditText  RhF2 = findViewById(R.id.edtRhF2);
        final EditText  RhF3 = findViewById(R.id.edtRhF3);
        final EditText  RhF4 = findViewById(R.id.edtRhF4);

        final EditText  CbF1 = findViewById(R.id.edtCbF1);
        final EditText  CbF2 = findViewById(R.id.edtCbF2);
        final EditText  CbF3 = findViewById(R.id.edtCbF3);
        final EditText  CbF4 = findViewById(R.id.edtCbF4);

        final EditText  EtF1 = findViewById(R.id.edtEtF1);
        final EditText  EtF2 = findViewById(R.id.edtEtF2);
        final EditText  EtF3 = findViewById(R.id.edtEtF3);
        final EditText  EtF4 = findViewById(R.id.edtEtF4);

        Button btnClick = findViewById(R.id.btnClick);



        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();

                String valueFp1F1 = Fp1F1.getText().toString();
                String valueFp1F2 = Fp1F2.getText().toString();
                String valueFp1F3 = Fp1F3.getText().toString();
                String valueFp1F4 = Fp1F4.getText().toString();

                String valueRhF1 = RhF1.getText().toString();
                String valueRhF2 = RhF2.getText().toString();
                String valueRhF3 = RhF3.getText().toString();
                String valueRhF4 = RhF4.getText().toString();

                String valueCbF1 = CbF1.getText().toString();
                String valueCbF2 = CbF2.getText().toString();
                String valueCbF3 = CbF3.getText().toString();
                String valueCbF4 = CbF4.getText().toString();

                String valueEtF1 = EtF1.getText().toString();
                String valueEtF2 = EtF2.getText().toString();
                String valueEtF3 = EtF3.getText().toString();
                String valueEtF4 = EtF4.getText().toString();


                if ("".equals(valueFp1F1) || valueFp1F1==null || ".".equals(valueFp1F1) || "-.".equals(valueFp1F1) || "-".equals(valueFp1F1)) {
                    Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                    Fp1F1.setText("");
                    Fp1F1.requestFocus();
                }else
                if ("".equals(valueFp1F2) || valueFp1F2==null || ".".equals(valueFp1F2) || "-.".equals(valueFp1F2) || "-".equals(valueFp1F1)) {
                    Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                    Fp1F2.setText("");
                    Fp1F2.requestFocus();

                    }else
                    if ("".equals(valueFp1F3) || valueFp1F3==null || ".".equals(valueFp1F3) || "-.".equals(valueFp1F3) || "-".equals(valueFp1F1)) {
                        Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                        Fp1F3.setText("");
                        Fp1F3.requestFocus();
                    }else
                    if ("".equals(valueFp1F4) || valueFp1F4==null || ".".equals(valueFp1F4) || "-.".equals(valueFp1F4) || "-".equals(valueFp1F1)) {
                        Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                        Fp1F4.setText("");
                        Fp1F4.requestFocus();
                    }
                    else
                    if ("".equals(valueRhF1 ) || valueRhF1 ==null || ".".equals(valueRhF1 ) || "-.".equals(valueRhF1 ) || "-".equals(valueRhF1 )) {
                        Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                        RhF1.setText("");
                        RhF1.requestFocus();
                    }else
                    if ("".equals(valueRhF2 ) || valueRhF2 ==null || ".".equals(valueRhF2 ) || "-.".equals(valueRhF2 ) || "-".equals(valueRhF2 )) {
                        Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                        RhF2.setText("");
                        RhF2.requestFocus();

                    }else
                    if ("".equals(valueRhF3 ) || valueRhF3 ==null || ".".equals(valueRhF3 ) || "-.".equals(valueRhF3 ) || "-".equals(valueRhF3 )) {
                        Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                        RhF3.setText("");
                        RhF3.requestFocus();
                    }else
                    if ("".equals(valueRhF4 ) || valueRhF4 ==null || ".".equals(valueRhF4 ) || "-.".equals(valueRhF4 ) || "-".equals(valueRhF4 )) {
                        Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                        RhF4.setText("");
                        RhF4.requestFocus();
                    }else
                        if ("".equals(valueCbF1) || valueCbF1==null || ".".equals(valueCbF1) || "-.".equals(valueCbF1) || "-".equals(valueCbF1)) {
                            Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                            CbF1.setText("");
                            CbF1.requestFocus();
                        }else
                        if ("".equals(valueCbF2) || valueCbF2==null || ".".equals(valueCbF2) || "-.".equals(valueCbF2) || "-".equals(valueCbF2)) {
                            Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                            CbF2.setText("");
                            CbF2.requestFocus();

                        }else
                        if ("".equals(valueCbF3) || valueCbF3==null || ".".equals(valueCbF3) || "-.".equals(valueCbF3) || "-".equals(valueCbF3)) {
                            Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                            CbF3.setText("");
                            CbF3.requestFocus();
                        }else
                        if ("".equals(valueCbF4) || valueCbF4==null || ".".equals(valueCbF4) || "-.".equals(valueCbF4) || "-".equals(valueCbF4)) {
                            Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                            CbF4.setText("");
                            CbF4.requestFocus();
                        }
                        else
                        if ("".equals(valueEtF1 ) || valueEtF1 ==null || ".".equals(valueEtF1 ) || "-.".equals(valueEtF1 ) || "-".equals(valueEtF1 )) {
                            Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                            EtF1.setText("");
                            EtF1.requestFocus();
                        }else
                        if ("".equals(valueEtF2 ) || valueEtF2 ==null || ".".equals(valueEtF2) || "-.".equals(valueEtF2 ) || "-".equals(valueEtF2 )) {
                            Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                            EtF2.setText("");
                            EtF2.requestFocus();

                        }else
                        if ("".equals(valueEtF3) || valueEtF3 ==null || ".".equals(valueEtF3) || "-.".equals(valueEtF3 ) || "-".equals(valueEtF3 )) {
                            Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                            EtF3.setText("");
                            EtF3.requestFocus();
                        }else
                        if ("".equals(valueEtF4) || valueEtF4 ==null || ".".equals(valueEtF4) || "-.".equals(valueEtF4 ) || "-".equals(valueEtF4 )) {
                            Toast.makeText(formulas.this, "Campo R.min está vazio", Toast.LENGTH_SHORT).show();
                            EtF4.setText("");
                            EtF4.requestFocus();
                        }else{

                            String  FFp1F1=Fp1F1.getText().toString();
                            editor.putString("FFp1F1",FFp1F1);
                            String  FFp1F2=Fp1F2.getText().toString();
                            editor.putString("FFp1F2",FFp1F2);
                            String  FFp1F3=Fp1F3.getText().toString();
                            editor.putString("FFp1F3",FFp1F3);
                            String  FFp1F4=Fp1F4.getText().toString();
                            editor.putString("FFp1F4",FFp1F4);

                            String  RRhF1=RhF1.getText().toString();
                            editor.putString("RRhF1",RRhF1);
                            String  RRhF2=RhF2.getText().toString();
                            editor.putString("RRhF2",RRhF2);
                            String  RRhF3=RhF3.getText().toString();
                            editor.putString("RRhF3",RRhF3);
                            String  RRhF4=RhF4.getText().toString();
                            editor.putString("RRhF4",RRhF4);

                            String  CCbF1=CbF1.getText().toString();
                            editor.putString("CCbF1",CCbF1);
                            String  CCbF2=CbF2.getText().toString();
                            editor.putString("CCbF2",CCbF2);
                            String  CCbF3=CbF3.getText().toString();
                            editor.putString("CCbF3",CCbF3);
                            String  CCbF4=CbF4.getText().toString();
                            editor.putString("CCbF4",CCbF4);

                            String  EEtF1=EtF1.getText().toString();
                            editor.putString("EEtF1",EEtF1);
                            String  EEtF2=EtF2.getText().toString();
                            editor.putString("EEtF2",EEtF2);
                            String  EEtF3=EtF3.getText().toString();
                            editor.putString("EEtF3",EEtF3);
                            String  EEtF4=EtF4.getText().toString();
                            editor.putString(" EEtF4",EEtF4);
                            editor.apply();
                            //editor.commit();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("FFp1F1", Double.parseDouble(Fp1F1.getText().toString()));
                    intent.putExtra("FFp1F2", Double.parseDouble(Fp1F2.getText().toString()));
                    intent.putExtra("FFp1F3", Double.parseDouble(Fp1F3.getText().toString()));
                    intent.putExtra("FFp1F4", Double.parseDouble(Fp1F4.getText().toString()));

                    intent.putExtra("RRhF1", Double.parseDouble(RhF1.getText().toString()));
                    intent.putExtra("RRhF2", Double.parseDouble(RhF2.getText().toString()));
                    intent.putExtra("RRhF3", Double.parseDouble(RhF3.getText().toString()));
                    intent.putExtra("RRhF4", Double.parseDouble(RhF4.getText().toString()));

                    intent.putExtra("CCbF1", Double.parseDouble(CbF1.getText().toString()));
                    intent.putExtra("CCbF2", Double.parseDouble(CbF2.getText().toString()));
                    intent.putExtra("CCbF3", Double.parseDouble(CbF3.getText().toString()));
                    intent.putExtra("CCbF4", Double.parseDouble(CbF4.getText().toString()));

                    intent.putExtra("EEtF1", Double.parseDouble(EtF1.getText().toString()));
                    intent.putExtra("EEtF2", Double.parseDouble(EtF2.getText().toString()));
                    intent.putExtra("EEtF3", Double.parseDouble(EtF3.getText().toString()));
                    intent.putExtra("EEtF4", Double.parseDouble(EtF4.getText().toString()));



                    startActivity(intent);
                }
            }
        });

        SharedPreferences preferences = getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        if(preferences.contains("FFp1F1")) { //439.7351
            String FFp1F1 = preferences.getString("FFp1F1", "www");
            Fp1F1.setText(FFp1F1);
        }
        if(preferences.contains("FFp1F2")) {
            String FFp1F2 = preferences.getString("FFp1F2", "www");
            Fp1F2.setText(FFp1F2);//490.719
        }
        if(preferences.contains("FFp1F3")) {
            String FFp1F3 = preferences.getString("FFp1F3", "www");
            Fp1F3.setText(FFp1F3);//432.785
        }
            if(preferences.contains("FFp1F4")) {
                String FFp1F4 = preferences.getString("FFp1F4", "www");
                Fp1F4.setText(FFp1F4);//15944.7
            }

        if(preferences.contains("RRhF1")) { //439.7351

            String RRhF1 = preferences.getString("RRhF1", "www");
            RhF1.setText(RRhF1);
        }
        if(preferences.contains("RRhF2")) {
            String RRhF2 = preferences.getString("RRhF2", "www");
            RhF2.setText(RRhF2);//490.719
        }
        if(preferences.contains("RRhF3")) {
            String RRhF3 = preferences.getString("RRhF3", "www");
            RhF3.setText(RRhF3);//432.785
        }
        if(preferences.contains("RRhF4")) {
            String RRhF4 = preferences.getString("RRhF4", "www");
            RhF4.setText(RRhF4);//15944.7
        }


        if(preferences.contains("CCbF1")) { //439.7351

            String CCbF1 = preferences.getString("CCbF1", "www");
            CbF1.setText(CCbF1);
        }
        if(preferences.contains("CCbF2")) {
            String CCbF2 = preferences.getString("CCbF2", "www");
            CbF2.setText(CCbF2);//490.719
        }
        if(preferences.contains("CCbF3")) {
            String CCbF3 = preferences.getString("CCbF3", "www");
            CbF3.setText(CCbF3);//432.785
        }
        if(preferences.contains("CCbF4")) {
            String CCbF4 = preferences.getString("CCbF4", "www");
            CbF4.setText(CCbF4);//15944.7
        }


        if(preferences.contains("EEtF1")) { //439.7351
            String EEtF1 = preferences.getString("EEtF1", "www");
            EtF1.setText(EEtF1);
        }
        if(preferences.contains("EEtF2")) {
            String EEtF2 = preferences.getString("EEtF2", "www");
            EtF2.setText(EEtF2);//490.719
        }
        if(preferences.contains("EEtF3")) {
            String EEtF3 = preferences.getString("EEtF3", "www");
            EtF3.setText(EEtF3);//432.785
        }
        if(preferences.contains("EEtF4")) {
            String EEtF4 = preferences.getString("EEtF4", "www");
            EtF4.setText(EEtF4);//15944.7
        }

    }

   }