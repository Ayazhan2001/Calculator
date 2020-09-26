package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

     TextView tv_result, tv_zapis;

     Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
     Button btnC, btnSkob, btnPro, btnDev, btnMulti, btnMinus, btnPlus, btnDot, btnBack;
     Button btnEqual;

     String previousNumber, secondNumber;
     String allZapis = "";
     String operation = "";

     /*
     previousNumber = 100
     operation = "+"
     currentNumber = 20
     =
     120

      */


     boolean doubleClicked = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initAction();

    }
    public void initView(){
        tv_zapis = findViewById(R.id.tv_zapis);
        tv_result = findViewById(R.id.tv_result);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnC = findViewById(R.id.btnC);
        btnSkob = findViewById(R.id.btnSkob);
        btnPro = findViewById(R.id.btnPro);
        btnDev = findViewById(R.id.btnDev);
        btnMulti = findViewById(R.id.btnMulti);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnDot = findViewById(R.id.btnDot);
        btnBack = findViewById(R.id.btnBack);
        btnEqual = findViewById(R.id.btnEqual);




    }

    private void initAction() {

        onClickButton(btn7, "7");
        onClickButton(btn8, "8");
        onClickButton(btn9, "9");
//        onClickButton(btnPlusMinus, "+-");
        onClickButton(btnBack, "back");
        onClickButton(btnDot, "tochka");

        onClickOperationButton(btnPlus, "+");
        onClickOperationButton(btnMinus, "-");
        onClickOperationButton(btnMulti,"*");
        onClickOperationButton(btnDev,"/");
        onClickOperationButton(btnDev,"%");
        onClickButtonEqual();
    }
    public void onClickOperationButton(Button btn, final String curOperation) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousNumber = tv_result.getText().toString();
                if(!previousNumber.equals("0")) {
                    operation = curOperation;
                    tv_result.setText("0");
                    allZapis += previousNumber + " " + operation;
                    tv_zapis.setText(allZapis);
                }
            }
        });
    }

    public void onClickButtonEqual() {
        btnEqual.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                secondNumber = tv_result.getText().toString();
                allZapis += secondNumber;
                int result = 0;
                double result2 = 0;

                switch (operation){
                    case "+":
                        result = Integer.parseInt(previousNumber) + Integer.parseInt(secondNumber);

                        if(doubleClicked){
                            result2 = Double.parseDouble(previousNumber) + Double.parseDouble(secondNumber);
                            tv_result.setText(""+result2);
                        }else{
                            result = Integer.parseInt(previousNumber) + Integer.parseInt(secondNumber);
                            tv_result.setText(""+result);
                        }

                        break;

                    case "-":
                        result = Integer.parseInt(previousNumber) - Integer.parseInt(secondNumber);
                        break;
                }

                tv_zapis.setText(allZapis);
                tv_result.setText(Integer.toString(result));
            }
        });
    }
    public void onClickButton(Button btn, final String text){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res = tv_result.getText().toString();

                if(res.equals("0")){
                    res = text;
                }else {
                    res += text;    //res = res + text  res = 12
                }
                tv_result.setText(res);
            }
        });

    }


}
