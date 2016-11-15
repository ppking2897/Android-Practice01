package com.example.biancaen.ppking_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private TextView textView;
    private String strAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText)findViewById(R.id.input);
        textView = (TextView)findViewById(R.id.textView);
        strAnswer = creatAnswer(4);
    }
    public void guess(View v){

        String guessNumber = input.getText().toString();
        if(strAnswer.length()==guessNumber.length()) {

            String guessResult = checkAB(strAnswer, guessNumber);
            textView.append(guessResult + "\n");
            input.setText("");
        }
        else{
            textView.append("數字不夠" + "\n");
        }
    }

    static String creatAnswer(int numberCount){
        int [] number = new int [numberCount];
        for(int i=0; i<number.length;i++){
            number[i]=(int)(Math.random()*9+1);
        }
        for(int j = number.length-1 ; j>0 ; j--){
            int b = (int)(Math.random()*(j+1));
            int a = number[j] ;
            number[j]  = number[b];
            number[b]  = a;
        }
        String ret = "" ;
        for(int v  : number) {
            ret += v;
        }
        return ret;
    }
    static String checkAB(String a, String g){
        int A , B; A = B = 0;
        for (int i = 0; i < a.length(); i++) {
            if (g.charAt(i) == a.charAt(i)) {
                A++;
            } else if (a.indexOf(g.charAt(i)) != -1) {
                B++;
            }
        }
        return A + "A" + B + "B";
    }
}
