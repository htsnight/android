package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


//继承点击事件的接口
public class MainActivity extends Activity implements OnClickListener{
    //按钮
    Button btn_1,btn_2,btn_3,
            btn_4,btn_5,btn_6,
            btn_7,btn_8,btn_9,
            btn_10,btn_11,btn_12,
            btn_13,btn_14,btn_15,
            btn_16,btn_17,btn_18,
            btn_pow,btn_sqrt,btn_21,btn_22;
    //用于判断是否需要重新输入
    boolean restart;

    //屏幕上数字的正负状态
    int front;


    //操作数与操作符，用于后边的计算
    float operator1,operator2;

    int symbol;
    //"+、—、*、/、x^y、/x、sinx、cosx"-->1、2、3、4、5、6、7、8
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //初始化操作数（默认为0）操作符（默认为+）
        operator1=0;
        operator2=0;
        restart=true;//刚开始默认需要输入
        front=0;//刚开始默认为正数

        //将text框的默认显示为 00

        TextView txt=(TextView) findViewById(R.id.textView1);
        txt.setText("00");


        //获取button对象
        btn_1= (Button)findViewById(R.id.button1);
        btn_2= (Button)findViewById(R.id.button2);
        btn_3= (Button)findViewById(R.id.button3);
        btn_4= (Button)findViewById(R.id.button4);
        btn_5= (Button)findViewById(R.id.button5);
        btn_6= (Button)findViewById(R.id.button6);
        btn_7= (Button)findViewById(R.id.button7);
        btn_8= (Button)findViewById(R.id.button8);
        btn_9= (Button)findViewById(R.id.button9);
        btn_10= (Button)findViewById(R.id.button10);
        btn_11= (Button)findViewById(R.id.button11);
        btn_12= (Button)findViewById(R.id.button12);
        btn_13= (Button)findViewById(R.id.button13);
        btn_14= (Button)findViewById(R.id.button14);
        btn_15= (Button)findViewById(R.id.button15);
        btn_16= (Button)findViewById(R.id.button16);
        btn_17= (Button)findViewById(R.id.button17);
        btn_18= (Button)findViewById(R.id.button18);
        btn_pow= (Button)findViewById(R.id.button_pow);
        btn_sqrt= (Button)findViewById(R.id.button_sqrt);
        btn_21= (Button)findViewById(R.id.button21);
        btn_22= (Button)findViewById(R.id.button22);



        //给所有button注册点击事件
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_10.setOnClickListener(this);
        btn_11.setOnClickListener(this);
        btn_12.setOnClickListener(this);
        btn_13.setOnClickListener(this);
        btn_14.setOnClickListener(this);
        btn_15.setOnClickListener(this);
        btn_16.setOnClickListener(this);
        btn_17.setOnClickListener(this);
        btn_18.setOnClickListener(this);
        btn_pow.setOnClickListener(this);
        btn_sqrt.setOnClickListener(this);
        btn_21.setOnClickListener(this);
        btn_22.setOnClickListener(this);
    }


    @Override
    //点击事件处理
    public void onClick(View btn) {
        //获取文本框
        TextView txt=(TextView) findViewById(R.id.textView1);


        //文本框内容，将TextView形式强制转化为String类型
        String text=(String) txt.getText();


        //再将String类型转化为浮点型，获取（每次点击都会获取）
        float value=Float.parseFloat(text);

        //控制台测试语句，测试显示结果是否正确
        System.out.println(value);
        //判断btn类型，作出相应操作
        switch(btn.getId()){
            //数字
            case R.id.button1:

                //如果不先判断，回导致第二次的计算数字跟在后边，而没有清除屏幕
                if(restart){
                    txt.setText("1");
                    restart=false;}
                else
                    txt.setText(text+"1");
                break;
            case R.id.button2:
                if(restart){
                    txt.setText("2");
                    restart=false;}
                else
                    txt.setText(text+"2");
                break;
            case R.id.button3:
                if(restart){
                    txt.setText("3");
                    restart=false;}
                else
                    txt.setText(text+"3");
                break;
            case R.id.button4:
                if(restart){
                    txt.setText("4");
                    restart=false;}
                else
                    txt.setText(text+"4");
                break;
            case R.id.button5:
                if(restart){
                    txt.setText("5");
                    restart=false;}
                else
                    txt.setText(text+"5");
                break;
            case R.id.button6:
                if(restart){
                    txt.setText("6");
                    restart=false;}
                else
                    txt.setText(text+"6");
                break;
            case R.id.button7:
                if(restart){
                    txt.setText("7");
                    restart=false;}
                else
                    txt.setText(text+"7");
                break;
            case R.id.button8:
                if(restart){
                    txt.setText("8");
                    restart=false;}
                else
                    txt.setText(text+"8");
                break;
            case R.id.button9:
                if(restart){
                    txt.setText("9");
                    restart=false;}
                else
                    txt.setText(text+"9");
                break;
             //0
            case R.id.button10:
                if(restart)
                    txt.setText("00");
                else
                    txt.setText(text+"0");
                break;

             //符号不准备显示在屏幕上
            //+
            case R.id.button11:
                symbol=1;//将操作符号：加法为1
                operator1=value;//获取操作数
                restart=true;//清除操作//防止连加情况
                break;
            //-
            case R.id.button12:
                symbol=2;//减法为2
                operator1=value;
                restart=true;
                break;
            //-/+
            case R.id.button13:

                //如果屏幕没有任何东西时：
                if(restart){
                    txt.setText("-");
                    front=1;
                    restart=false;
                }
                //如果是将一个现有展示在屏幕上的数字变成负数时：
                else if(front==0){
                    txt.setText("-"+text);
                    front=1;
                    restart=false;
                }
                //如果已经是负数了，将去掉负号变为正数，调用String类的subString方法，返回去掉负号的字串。
                else if(front==1){
                    txt.setText(text.substring(1));
                    front=0;
                    restart=false;
                }
                front=0;
                break;
            //*
            case R.id.button14:
                symbol=3;
                operator1=value;
                restart=true;
                break;
            // /
            case R.id.button15:
                symbol=4;
                operator1=value;
                restart=true;
                break;
            //C
            //归零操作
            case R.id.button16:
                txt.setText("00");
                restart=true;
                break;
            // .
            case R.id.button17:
                if(restart)
                    txt.setText(".");
                else
                    txt.setText(text+".");
                restart=false;
                break;
            //=
            //点了等于号，则开始计算
            case R.id.button18:
                restart=true;
                switch(symbol){
                    case 1:
                        txt.setText(String.valueOf(operator1+value));
                        break;
                    case 2:
                        txt.setText(String.valueOf(operator1-value));
                        break;
                    case 3:
                        txt.setText(String.valueOf(operator1*value));
                        break;
                    case 4:
                        if(value==0){
                            Toast toast = Toast.makeText(getApplicationContext(), "除数不能为0", Toast.LENGTH_SHORT);
                            toast.show();
                            break;//别忘了break
                        }else {
                            txt.setText(String.valueOf(operator1 / value));
                            break;
                        }
                    case 5:
                        txt.setText(String.valueOf(Math.pow(operator1, value)));
                        break;
                }
                break;

                //以下操作不需要用等号，所以放在外边
            //x^y
            case R.id.button_pow:
                symbol=5;
                operator1=value;
                restart=true;
                break;
            // /x 开方
            case R.id.button_sqrt:
                symbol=6;
                if(value<0){
                    Toast toast = Toast.makeText(getApplicationContext(), "被开方数不能小于0", Toast.LENGTH_SHORT);
                    toast.show();
                    break;//别忘了break
                }else {
                    txt.setText(String.valueOf(Math.sqrt(value)));
                    restart = true;
                    break;
                }
            // sinx
            case R.id.button21:
                symbol=7;
                txt.setText(String.valueOf(Math.sin(value)));
                restart=true;
                break;
            // cosx
            case R.id.button22:
                symbol=8;
                txt.setText(String.valueOf(Math.cos(value)));
                restart=true;
                break;

            default:
                break;
        }
    }

}