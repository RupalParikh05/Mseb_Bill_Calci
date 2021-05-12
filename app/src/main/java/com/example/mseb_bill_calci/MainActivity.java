package com.example.mseb_bill_calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button bt;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int unit = Integer.parseInt(et.getText().toString());
                int count = 0;
                int bill = 0;
                int limit[] = {100,100,50};
                int rate[] = {3,5,6,8};
                while(count < limit.length && unit >= limit[count]){
                    bill = bill + (limit[count] * rate[count]);
                    unit = unit - limit[count];
                    count++;
                }
                bill = bill + (unit * rate[count]);
                tv.setText(Integer.toString(bill));
            }
        });
    }

    private void init() {

        et = findViewById(R.id.editTextenter);
        bt = findViewById(R.id.btncheck);
        tv = findViewById(R.id.textViewtotalbill);
    }
}