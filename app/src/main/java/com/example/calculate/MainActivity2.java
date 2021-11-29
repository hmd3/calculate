package com.example.calculate;

import android.app.Activity;
import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class MainActivity2 extends Activity{
    private EditText input = null;
    private EditText output = null;
    private Button zero = null;
    private Button one = null;
    private Button two = null;
    private Button three = null;
    private Button four = null;
    private Button five = null;
    private Button six = null;
    private Button sevent = null;
    private Button eight = null;
    private Button nine = null;
    private Button dot = null;
    private Button jia = null;
    private Button jian = null;
    private Button cheng = null;
    private Button chu = null;
    private Button zhengchu = null;
    private Button dengyu = null;
    private Button mod = null;
    private Button bin = null;
    private Button sinx = null;
    private Button cosx = null;
    private Button logx = null;
    private Button lnx = null;
    private Button genhaox = null;
    private Button ngenhaox = null;
    private Button xn = null;
    private Button xfang = null;
    private Button njiecheng = null;
    private Button cls = null;
    private Button back = null;
    private Button zuokuohao = null;
    private Button youkuohao = null;
    private Button lifangm = null;
    private Button lifangdm = null;
    private Button lifangcm = null;

    private StringBuilder showText = new StringBuilder();//记录运算式,用于显示
    private StringBuilder showText2 = new StringBuilder();//记录运算式，用于计算
    //private Double result = null;//结果
    private Boolean errBoolean =false;//有误true，无误false
    private Boolean flag = false;//true响应消息，false不响应
    private Boolean flagDot = false;//小数点标记
    private int dotCount = 0;
    private Boolean flagYoukuohao = false;//先有左括号再有又括号
    private int zuokuohaoCount = 0;//记录左括号次数
    private int youkuohaoCount = 0;//记录右括号次数

    //定义监听器
    private OnClickListener listener = (v) -> {
        switch (v.getId()){
            case R.id.zero:
                num(0);
                break;
            case R.id.one:
                num(1);
                break;
            case R.id.two:
                num(2);
                break;
            case R.id.three:
                num(3);
                break;
            case R.id.four:
                num(4);
                break;
            case R.id.five:
                num(5);
                break;
            case R.id.six:
                num(6);
                break;
            case R.id.sevent:
                num(7);
                break;
            case R.id.eight:
                num(8);
                break;
            case R.id.nine:
                num(9);
                break;
            case R.id.dot:
                dot();
                break;
            case R.id.jia:
                jia();
                break;
            case R.id.jian:
                jian();
                break;
            case R.id.cheng:
                cheng();
                break;
            case R.id.chu:
                chu();
                break;
            case R.id.zhengchu:
                zhengchu();
                break;
            case R.id.mod:
                mod();
                break;
            case R.id.bin:
                try {
                    bin();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.sinx:
                sinx();
                break;
            case R.id.cosx:
                cosx();
                break;
            case R.id.logx:
                logx();
                break;
            case R.id.lnx:
                lnx();
                break;
            case R.id.genhaox:
                genhaox();
                break;
            case R.id.ngenhaox:
                ngenhaox();
                break;
            case R.id.xn:
                xn();
                break;
            case R.id.xfang:
                xfang();
                break;
            case R.id.njiecheng:
                njiecheng();
                break;
            case R.id.cls:
                cls();
                break;
            case R.id.back:
                back();
                break;
            case R.id.zuokuohao:
                zuokuohao();
                break;
            case R.id.youkuohao:
                youkuohao();
                break;
            case R.id.lifangm:
                lifangm();
                break;
            case R.id.lifangdm:
                lifangdm();
                break;
            case R.id.lifangcm:
                lifangcm();
                break;
            case R.id.dengyu:
                dengyu();

                break;
            default:
                break;
        }




    };


    //初始化
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        sevent = findViewById(R.id.sevent);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        dot = findViewById(R.id.dot);
        jia = (Button) findViewById(R.id.jia);
        jian = (Button) findViewById(R.id.jian);
        cheng = (Button) findViewById(R.id.cheng);
        chu = (Button) findViewById(R.id.chu);
        zhengchu = (Button) findViewById(R.id.zhengchu);
        dengyu = (Button) findViewById(R.id.dengyu);
        mod = (Button) findViewById(R.id.mod);
        bin = (Button) findViewById(R.id.bin);
        sinx = (Button) findViewById(R.id.sinx);
        cosx = (Button) findViewById(R.id.cosx);
        logx = (Button) findViewById(R.id.logx);
        lnx = (Button) findViewById(R.id.lnx);
        genhaox = (Button) findViewById(R.id.genhaox);
        ngenhaox = (Button) findViewById(R.id.ngenhaox);
        xn = (Button) findViewById(R.id.xn);
        xfang = (Button) findViewById(R.id.xfang);
        njiecheng = (Button) findViewById(R.id.njiecheng);
        cls = (Button) findViewById(R.id.cls);
        back = (Button) findViewById(R.id.back);
        zuokuohao = (Button) findViewById(R.id.zuokuohao);
        youkuohao = (Button) findViewById(R.id.youkuohao);
        lifangm = (Button) findViewById(R.id.lifangm);
        lifangdm = (Button) findViewById(R.id.lifangdm);
        lifangcm = (Button) findViewById(R.id.lifangcm);

        //添加监听器
        zero.setOnClickListener(listener);
        one.setOnClickListener(listener);
        two.setOnClickListener(listener);
        three.setOnClickListener(listener);
        four.setOnClickListener(listener);
        five.setOnClickListener(listener);
        six.setOnClickListener(listener);
        sevent.setOnClickListener(listener);
        eight.setOnClickListener(listener);
        nine.setOnClickListener(listener);
        dot.setOnClickListener(listener);
        jia.setOnClickListener(listener);
        jian.setOnClickListener(listener);
        cheng.setOnClickListener(listener);
        chu.setOnClickListener(listener);
        zhengchu.setOnClickListener(listener);
        dengyu.setOnClickListener(listener);
        mod.setOnClickListener(listener);
        bin.setOnClickListener(listener);
        sinx.setOnClickListener(listener);
        cosx.setOnClickListener(listener);
        logx.setOnClickListener(listener);
        lnx.setOnClickListener(listener);
        genhaox.setOnClickListener(listener);
        ngenhaox.setOnClickListener(listener);
        xn.setOnClickListener(listener);
        xfang.setOnClickListener(listener);
        njiecheng.setOnClickListener(listener);
        cls.setOnClickListener(listener);
        back.setOnClickListener(listener);
        zuokuohao.setOnClickListener(listener);
        youkuohao.setOnClickListener(listener);
        lifangm.setOnClickListener(listener);
        lifangdm.setOnClickListener(listener);
        lifangcm.setOnClickListener(listener);

    }



    //按钮具体操作
    private void jia() {
        if (flag){
            showText.append("+");
            showText2.append("+");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void jian() {
        if (flag){
            showText.append("-");
            showText2.append("-");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void cheng() {
        if (flag){
            showText.append("*");
            showText2.append("*");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void chu() {
        if (flag){
            showText.append("/");
            showText2.append("/");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void dot() {
        if (flag) {
            if (flagDot) {
                if (dotCount == 0) {
                    showText.append(".");
                    showText2.append(".");
                    input.setText(showText);
                    input.setSelection(input.getText().length());
                    flag = false;
                    flagDot = false;
                    dotCount = 1;
                }
            }
        }
    }
    private void zhengchu() {//a
        if (flag){
            showText.append("//");
            showText2.append("a");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void mod() {//b
        if (flag){
            showText.append("mod");
            showText2.append("b");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void bin() throws Exception {//c
        if (flag){
            String s = showText.toString();
            System.out.println(s);
            Double d = Double.parseDouble(s);
            
            String s1 = decimal2Binary(d);
            output.setText("二进制:"+s1);
        }
    }
    private void sinx() {//d
        if (flag){
            showText.append("sin");
            showText2.append("d");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void cosx() {//e
        if (flag){
            showText.append("cos");
            showText2.append("e");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void logx() {//f
        if (flag){
            showText.append("logx(x,n)");
            showText2.append("f");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void lnx() {//g
        if (flag){
            showText.append("lnx(x)");
            showText2.append("g");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void genhaox() {//h
        if (flag){
            showText.append("√x");
            showText2.append("h");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void ngenhaox() {//i
        if (flag){
            showText.append("n√x(x,n)");
            showText2.append("i");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void xn() {
        if (flag){
            showText.append("^");
            showText2.append("^");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void xfang() {//j
        if (flag){
            showText.append("^2");
            showText2.append("j");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = false;
        }
    }
    private void njiecheng() {
        if (flag){
            showText.append("!");
            showText2.append("!");
            input.setText(showText);
            input.setSelection(input.getText().length());
            dotCount = 0;
            flag = true;
        }
    }
    private void cls() {
        //System.out.println(Math.sin(90));
        String l = showText.substring(0);
        System.out.println("删除前:"+l);
        for (int x = 0 ; x<l.length() ; x++){
            showText.deleteCharAt(showText.length()-1);
        }
        System.out.println("删除后:"+showText);
        String l2 = showText2.substring(0);
        for (int x = 0 ; x<l2.length() ; x++) {
            showText2.deleteCharAt(showText2.length() - 1);
        }
        //result = null;//结果
        errBoolean =false;//有误true，无误false
        flag = false;//true响应消息，false不响应
        flagDot = false;//小数点标记
        dotCount = 0;
        flagYoukuohao = false;//先有左括号再有又括号
        zuokuohaoCount = 0;//记录左括号次数
        youkuohaoCount = 0;//记录右括号次数
        input.setText(showText);
        output.setText("结果");
    }
    private void back() {
        if (showText.length() == 0) {
            output.setText("输入为空");
        } else {
            String x = showText2.substring(showText2.length() - 1);
            System.out.println(x);
            if (x.equals("(") || x.equals(")")) {
                System.out.println("这是括号");
                showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            }else if (x.equals("0") || x.equals("1") || x.equals("2") || x.equals("3") || x.equals("4") || x.equals("5") || x.equals("6") || x.equals("7") || x.equals("8") || x.equals("9")) {
                System.out.println("这是0到9");
                showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            } else if (x.equals(".")) {
                System.out.println("这是.");
                showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
                flag = true;
                flagDot = true;
                dotCount = 0;
            } else if (x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")) {
                System.out.println("这是加减乘除");
                showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
                flag = true;
            } else if (x.equals("a")) {
                System.out.println("这是a");
                String name = "//";
                for (int y = 0; y < name.length(); y++)
                    showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            } else if (x.equals("b")) {
                System.out.println("这是b");
                String name = "mod";
                for (int y = 0; y < name.length(); y++)
                    showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            } else if (x.equals("c")) {
                System.out.println("这是c");
                String name = "bin";
                for (int y = 0; y < name.length(); y++)
                    showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            } else if (x.equals("d")) {
                System.out.println("这是d");
                String name = "sin";
                for (int y = 0; y < name.length(); y++)
                    showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            } else if (x.equals("e")) {
                System.out.println("这是e");
                String name = "cos";
                for (int y = 0; y < name.length(); y++)
                    showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            } else if (x.equals("f")) {
                System.out.println("这是f");
                String name = "logx(x,n)";
                for (int y = 0; y < name.length(); y++)
                    showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            } else if (x.equals("g")) {
                System.out.println("这是g");
                String name = "lnx(x)";
                for (int y = 0; y < name.length(); y++)
                    showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            } else if (x.equals("h")) {
                System.out.println("这是h");
                String name = "√x";
                for (int y = 0; y < name.length(); y++)
                    showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            } else if (x.equals("i")) {
                System.out.println("这是i");
                String name = "n√x(x,n)";
                for (int y = 0; y < name.length(); y++)
                    showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            } else if (x.equals("j")) {
                System.out.println("这是j");
                String name = "^2";
                for (int y = 0; y < name.length(); y++)
                    showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            } else if (x.equals("^")) {
                System.out.println("这是^");
                showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            } else if (x.equals("!")) {
                System.out.println("这是!");
                showText.deleteCharAt(showText.length() - 1);
                showText2.deleteCharAt(showText2.length() - 1);
                input.setText(showText);
            } else {
                System.out.println("???");
                input.setText("123456");
            }
        }
    }
    private void zuokuohao() {
        if (!flag) {
            if (zuokuohaoCount >= youkuohaoCount) {
                showText.append("(");
                showText2.append("(");
                input.setText(showText);
                input.setSelection(input.getText().length());
                zuokuohaoCount++;
                flagYoukuohao = true;
            }
        }
    }
    private void youkuohao() {
        if (flag){
            if (flagYoukuohao) {
                if (youkuohaoCount < zuokuohaoCount) {
                    showText.append(")");
                    showText2.append(")");
                    input.setText(showText);
                    input.setSelection(input.getText().length());
                    youkuohaoCount++;
                }
            }
        }
    }
    private void lifangm() {
    }
    private void lifangdm() {
    }
    private void lifangcm() {
    }
    private void dengyu() {
        if (flag){
            output.setText(calculate());
        }

    }
    public static String decimal2Binary(double value) throws Exception {
        // 整数部分的值
        int in = (int) value;
        //System.out.println("The integer is: " + in);
        // 小数部分的值
        double r = value - in;
        System.out.println("The decimal number is: " + r);

        StringBuilder stringBuilder = new StringBuilder();
        // 将整数部分转化为二进制
        int remainder = 0;
        int quotient = 0;
        while (in != 0) {
            // 得商
            quotient = in / 2;
            // 得余数
            remainder = in % 2;
            stringBuilder.append(remainder);
            in = quotient;
        }
        stringBuilder.reverse();
        if(r != 0)
            stringBuilder.append(".");

        // 将小数部分转化为二进制
        int count = 32; // 限制小数部分位数最多为32位，如果超过32为则抛出异常
        double num = 0;
        while (r > 0.0000000001) {
            count--;
            if (count == 0) {
                throw new Exception("Cannot change the decimal number to binary!");
            }else {
                num = r * 2;
                if (num >= 1) {
                    System.out.println("加入1");
                    stringBuilder.append(1);
                    r = num - 1;
                } else {
                    System.out.println("加入0");
                    stringBuilder.append(0);
                    r = num;
                }
            }
        }
        System.out.println("这个数字："+stringBuilder.toString());

        return stringBuilder.toString();
    }
    private String calculate(){
        //创建两个栈，数栈，一个符号栈
        ArrayStack numStack = new ArrayStack(20);
        ArrayStack operStack = new ArrayStack(20);
        //定义需要的相关变量
        int index = 0;
        double num1 = 0;
        double num2 = 0;
        int oper = 0;
        double res = 0;
        char ch = ' '; //将每次扫描得到char保存到ch
        String keepNum = ""; //用于拼接 多位数
        //开始while循环的扫描showText
        while(true) {
            //依次得到showText 的每一个字符
            ch = showText2.substring(index, index+1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if(operStack.isOper(ch)) {//如果是运算符
                //判断当前的符号栈是否为空
                if(!operStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从数栈中pop出两个数,
                    //这里需要判断是否此时的栈顶是否为左括号，如果是左括号不进入此循环
                    //我们设定的左括号是优先级大于加减乘除，所以当发现下一个进栈的符号的优先级比此时的栈顶的左括号优先级小的时候，
                    //应该让符号直接进栈，不进行弹出左符号的运算（左括号弹出来运算是不行的）
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek()) & operStack.peek()!=40) {
                        num1 = numStack.numPop();
                        num2 = numStack.numPop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算的结果如数栈
                        numStack.numPush(res);
                        //然后将当前的操作符入符号栈
                        operStack.push(ch);
                        /**
                         * 进行右括号的判断。匹配左括号
                         * 当发现进入的是右括号时就优先进行括号内的计算
                         */
                    } else if(ch==41){
                        //先让右括号进栈
                        operStack.push(ch);
                        if (ch==41) {
                            //再把右括号弹出
                            int oper1 = operStack.pop();
                            //弹出右括号后开始进行括号内运算
                            while(true) {
                                //右括号
                                num1 = numStack.numPop();
                                num2 = numStack.numPop();
                                oper = operStack.pop();
                                res = numStack.cal(num1, num2, oper);
                                //把运算的结果如数栈
                                numStack.numPush(res);
                                //当运算到栈顶符号为左括号时候，就弹出栈顶元素左括号，结束循环
                                if(operStack.peek()==40) {
                                    int oper2 = operStack.pop();
                                    break;
                                }
                            }

                        }

                        //如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
                    }
                    else {
                        operStack.push(ch);
                    }
                }else {
                    //如果为空直接入符号栈
                    operStack.push(ch);
                }
            } else { //如果是数，则直接入数栈

                //分析思路
                //1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2. 在处理数，需要向showText的表达式的index 后再看一位,如果是数就进行扫描，如果是符号才入栈
                //3. 因此我们需要定义一个变量 字符串，用于拼接

                //处理多位数
                keepNum += ch;

                //如果ch已经是showText的最后一位，并且不是右括号，就直接入栈
                if (index == showText2.length() - 1 && ch != 41) {
                    numStack.numPush(Double.parseDouble(keepNum));
                }else{

                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    //注意是看后一位，不是index++
                    if (operStack.isOper(showText2.substring(index+1,index+2).charAt(0))) {
                        //如果后一位是运算符，则入栈 keepNum = "1" 或者 "123"
                        numStack.numPush(Double.parseDouble(keepNum));
                        //重要的!!!!!!, keepNum清空
                        keepNum = "";

                    }
                }
            }
            //让index + 1, 并判断是否扫描到expression最后.
            index++;
            if (index >= showText2.length()) {
                break;
            }
        }

        //当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
        while(true) {
            //System.out.println(operStack.peek());
            //如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
            if(operStack.isEmpty()) {
                break;
            }
            num1 = numStack.numPop();
            num2 = numStack.numPop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.numPush(res);//入栈

        }
        //将数栈的最后数，pop出，就是结果
        double res2 = numStack.numPop();
        String result = String.valueOf(res2);
        return result;

    }


    private void num(int i){
        showText.append(i);
        showText2.append(i);
        input.setText(showText);
        input.setSelection(input.getText().length());
        flag = true;
        flagDot = true;
        System.out.println(i);
    }




}


class Logarithm {
    static public double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }
}

//定义一个 ArrayStack 表示栈, 需要扩展功能
class ArrayStack {
    private int maxSize; // 栈的大小
    private int[] operStack; // 符号数组，数组模拟栈，数据就放在该数组
    private double[] numStack;//数字数组
    private int top = -1;// top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        operStack = new int[this.maxSize];
        numStack = new double[this.maxSize];
    }

    //增加一个方法，可以返回当前栈顶的值, 但是不是真正的pop
    public int peek() {
        return operStack[top];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }
    //栈空
    public boolean isEmpty() {
        return top == -1;
    }
    //符号入栈-push
    public void push(int value) {
        //先判断栈是否满
        if(isFull()) {
            //System.out.println("栈满");
            return;
        }
        top++;
        operStack[top] = value;
    }
    //符号出栈-pop, 将栈顶的数据返回
    public int pop() {
        //先判断栈是否空
        if(isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = operStack[top];
        top--;
        return value;
    }

    //数字入栈-push
    public void numPush(double value) {
        //先判断栈是否满
        if(isFull()) {
            //System.out.println("栈满");
            return;
        }
        top++;
        numStack[top] = value;
    }
    //数字出栈-pop, 将栈顶的数据返回
    public double numPop() {
        //先判断栈是否空
        if(isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        double value = numStack[top];
        top--;
        return value;
    }


    //返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
    //数字越大，则优先级就越高.
    public int priority(int oper) {
        if (oper=='.'){
            return 3;
        }
        else if(oper=='a' || oper=='b'|| oper=='c'|| oper=='d'|| oper=='e'|| oper=='f'|| oper=='g'|| oper=='h'|| oper=='i'|| oper=='j'|| oper=='^'|| oper=='!'){
            return 2;
        }
        else if(oper=='(' || oper==')') {
            return 4;
        }else if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/'|| val=='('||val==')'||val=='.'||val=='^'||val=='!'||val=='a'||val=='b'||val=='c'||val=='d'||val=='e'||val=='f'||val=='g'||val=='h'||val=='i'||val=='j';
    }
    //计算方法
    public Double cal(double num1, double num2, int oper) {
        double res = 0; // res 用于存放计算的结果
        switch (oper) {
            case '.':
                res = num2 + num1*0.1;
                break;
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;// 注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            case 'a':////
                int x = (int)num2 / (int)num1;
                res = x;
                break;
            case 'b'://mod
                res = num2 % num1;
                break;
            case 'c'://bin
                res = num2 / num1;
                break;
            case 'd'://sin
                double sinNum = Math.toDegrees(num1);
                res = Math.sin(sinNum)*num2;
                break;
            case 'e'://cos
                double cosNum = Math.toDegrees(num1);
                res = Math.cos(num1)*num2;
                break;
            case 'f'://logx(x,n)
                res = Logarithm.log(100, 10);
                break;
            case 'g'://lnx
                res = Math.log(num1)*num2;
                break;
            case 'h'://√x
                res = Math.sqrt(num1)*num2;
                break;
            case 'i'://n√x(x,n)
                res = Math.sqrt(1.0);
                break;
            case 'j'://^2
                res = num2 * num2;
                break;
            case '^':
                double zhishuNum = 1;
                for (int zhishu = 0 ; zhishu < num1 ; zhishu++)
                    zhishuNum = zhishuNum*num2 ;
                res = zhishuNum;
                break;
            case '!':
                double jieshuNum = 1;
                for (int jieshu = 1 ; jieshu <= num2 ; jieshu++){
                    jieshuNum = jieshuNum*jieshu;
                }
                res = jieshuNum;
                break;
            default:
                break;
        }
        return res;
    }

}




