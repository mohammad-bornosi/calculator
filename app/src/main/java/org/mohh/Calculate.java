package org.mohh;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Calculate extends Activity {
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button decimals;
    Button btn_sin;
    Button btn_cos;
    Button clear;
    Button multipy;
    Button divison;
    Button plus;
    Button mines;
    Button equal;
    Button power;
    Button open_acad;
    Button close_acad;
    Button under_line;
    EditText edittext;
    ArrayList<String>moadele=new ArrayList<>();
    @Override
    public String toString() {
        String string=moadele.get(0);
        for (int i=1;i<moadele.size();i++) {
            string = string +moadele.get(i);
        }
        return string;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        btn0=findViewById(R.id.button0);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        btn5=findViewById(R.id.button5);
        btn6=findViewById(R.id.button6);
        btn7=findViewById(R.id.button7);
        btn8=findViewById(R.id.button8);
        btn9=findViewById(R.id.button9);
        decimals=findViewById(R.id.point_button);
        btn_sin=findViewById(R.id.sin_button);
        btn_cos=findViewById(R.id.cos_button);
        clear=findViewById(R.id.ac_button);
        multipy=findViewById(R.id.mltiply_button);
        divison=findViewById(R.id.division_button);
        plus=findViewById(R.id.plus_button);
        mines=findViewById(R.id.mines_button);
        equal=findViewById(R.id.equals_button);
        power=findViewById(R.id.power_button);
        open_acad=findViewById(R.id.btn1);
        close_acad=findViewById(R.id.btn2);
        under_line=findViewById(R.id.underline_button);
        edittext=findViewById(R.id.editText);
        btn0.setOnClickListener((V) ->{
            moadele.add("0");
            edittext.setText(toString());
        });
        btn1.setOnClickListener((V) ->{
            moadele.add("1");
            edittext.setText(toString());
        });
        btn2.setOnClickListener((V) ->{
            moadele.add("2");
            edittext.setText(toString());
        });
        btn3.setOnClickListener((V) ->{
            moadele.add("3");
            edittext.setText(toString());
        });
        btn4.setOnClickListener((V) ->{
            moadele.add("4");
            edittext.setText(toString());
        });
        btn5.setOnClickListener((V) ->{
            moadele.add("5");
            edittext.setText(toString());
        });
        btn6.setOnClickListener((V) ->{
            moadele.add("6");
            edittext.setText(toString());
        });
        btn7.setOnClickListener((V) ->{
            moadele.add("7");
            edittext.setText(toString());
        });
        btn8.setOnClickListener((V) ->{
            System.out.println(moadele);
            moadele.add("8");
            edittext.setText(toString());
        });
        btn9.setOnClickListener((V) ->{
            moadele.add("9");
            edittext.setText(toString());
        });
        decimals.setOnClickListener((V) ->{
            moadele.add(".");
            edittext.setText(toString());
        });
        btn_cos.setOnClickListener((V) ->{
            moadele.add("cos");
            edittext.setText(toString());
        });
        btn_sin.setOnClickListener((V) ->{
            moadele.add("sin");
            edittext.setText(toString());
        });
         clear.setOnClickListener((V) ->{
             moadele.remove(moadele.size()-1);
             edittext.setText(toString());
        });
        mines.setOnClickListener((V) ->{
            moadele.add("-");
            edittext.setText(toString());
        });
        plus.setOnClickListener((V) ->{
            moadele.add("+");
            edittext.setText(toString());
        });
        power.setOnClickListener((V) ->{
            moadele.add("^");
            edittext.setText(toString());
        });
        under_line.setOnClickListener((V) ->{
            moadele.add("_");
            edittext.setText(toString());
        });
        multipy.setOnClickListener((V) ->{
            moadele.add("*");
            edittext.setText(toString());
        });
        equal.setOnClickListener((V) ->{
            Shungtinyard shungtinyard=new Shungtinyard(moadele);
                edittext.setText(shungtinyard.fiil_stack_output());
        });
        open_acad.setOnClickListener((V) ->{
            moadele.add("(");
            edittext.setText(toString());
        });
        close_acad.setOnClickListener((V) ->{
            moadele.add(")");
            edittext.setText(toString());
        });
        divison.setOnClickListener((V) ->{
            moadele.add("/");
            edittext.setText(toString());
        });
    }
}

