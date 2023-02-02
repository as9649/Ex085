package com.example.ex085;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView tV1, tV2, tV3, tV4, tV5, tV6;
    EditText eT1, eT2;
    RadioButton rB1, rB2;
    Button btn;
    double d;
    double x;
    boolean type=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        btn.setOnClickListener(view -> {
            if (!rB1.isChecked()&&!rB2.isChecked())
                Toast.makeText(MainActivity.this, "Select..", Toast.LENGTH_SHORT).show();
            else {
                String st1=eT1.getText().toString();
                String st2=eT2.getText().toString();
                if (st1.matches("-?\\d+(\\.\\d+)?") && st2.matches("-?\\d+(\\.\\d+)?")){
                    x=Double.parseDouble(st1);
                    d=Double.parseDouble(st2);
                    String[] arr=new String[20];
                    arr[0]=x+"";
                    if(rB2.isChecked()) {
                        for (int i = 1; i < arr.length; i++)
                            arr[i] = (x + d * (i)) + "";
                    }
                    else{
                        type=false;
                        for (int i = 1; i < arr.length; i++)
                            arr[i] = String.format("%s", (x * Math.pow(d,i)));
                    }
                    MyAdapter myAdapter=new MyAdapter(getApplicationContext(), tV5, tV6, arr, rB1, rB2);
                    recyclerView.setAdapter(myAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
                else {
                    eT1.setText("");
                    eT2.setText("");
                    Toast.makeText(MainActivity.this, "Wrong input", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    void initialize(){
        recyclerView=findViewById(R.id.recyclerV);
        tV1=findViewById(R.id.tV1);
        tV2=findViewById(R.id.tV2);
        tV3=findViewById(R.id.tV3);
        tV4=findViewById(R.id.tV4);
        tV5=findViewById(R.id.tV5);
        tV6=findViewById(R.id.tV6);
        eT1=findViewById(R.id.eT1);
        eT2=findViewById(R.id.eT2);
        rB1=findViewById(R.id.rB1);
        rB2=findViewById(R.id.rB2);
        btn=findViewById(R.id.btn);
    }
}