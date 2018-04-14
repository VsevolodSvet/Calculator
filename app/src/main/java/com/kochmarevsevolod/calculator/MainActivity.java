package com.kochmarevsevolod.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNum;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    Button btnEq;
    Button btnBacksp;
    Button btnClear;
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
    Button btndot;
    Button btnsign;

    TextView tvResult;

    float result = 0;
    int oper = 0;
    boolean firstclick = true;
    boolean clear = false;

    // имя файла настройки
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_RESULT = "saved_result";
    private SharedPreferences mSettings;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        // находим элементы
        etNum = (EditText) findViewById(R.id.etNum);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnEq = (Button) findViewById(R.id.btnEq);
        btnBacksp = (Button) findViewById(R.id.btnBacksp);
        btnClear = (Button) findViewById(R.id.btnClear);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btndot = (Button) findViewById(R.id.btndot);
        btnsign = (Button) findViewById(R.id.btnsign);

        tvResult = (TextView) findViewById(R.id.tvResult);

        // делаем обработчики
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEq.setOnClickListener(this);
        btnBacksp.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btndot.setOnClickListener(this);
        btnsign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
         float num;

        // читаем etNum и задаем переменной число
        if (TextUtils.isEmpty(etNum.getText().toString())) num = 0;
        else num = Float.parseFloat(etNum.getText().toString());

        // длинный свич для обработки действий всех кнопок
        switch (v.getId()) {
            case R.id.btnAdd: // firstclick определяет, считать ли значение поля EtNum первым операндом (далее в каждом действии)
                oper = 1;     // если firstclick == false, первым операндом считается предыдущий результат
                if (firstclick){
                    result = Float.parseFloat(etNum.getText().toString());
                    firstclick = false;
                }
                etNum.setText("0");
                break;
            case R.id.btnSub:
                oper = 2;
                if (firstclick){
                    result = Float.parseFloat(etNum.getText().toString());
                    firstclick = false;
                }
                etNum.setText("0");
                break;
            case R.id.btnMult:
                oper = 3;
                if (firstclick){
                    result = Float.parseFloat(etNum.getText().toString());
                    firstclick = false;
                }
                etNum.setText("0");
                break;
            case R.id.btnDiv:
                oper = 4;
                if (firstclick){
                    result = Float.parseFloat(etNum.getText().toString());
                    firstclick = false;
                }
                etNum.setText("0");
                break;
            case R.id.btnEq:
                switch (oper){
                    case 1:
                        result += num;
                        oper = 0;
                        break;
                    case 2:
                        result -= num;
                        oper = 0;
                        break;
                    case 3:
                        result *= num;
                        oper = 0;
                        break;
                    case 4:
                        result /= num;
                        oper = 0;
                        break;
                    default:
                        break;
                }
                break;
            case R.id.btnBacksp:
                etNum.setText(etNum.getText().replace(etNum.length()-1, etNum.length(), ""));
                if (TextUtils.isEmpty(etNum.getText().toString())) etNum.setText("0"); // чтобы нельзя было получить пустую строку
                break;
            case R.id.btnClear:
                etNum.setText("0");
                tvResult.setText("0");
                result = 0;
                clear = true;
                firstclick = true;
                break;
            case R.id.btn0:
                if (!etNum.getText().toString().equals("0")) etNum.setText(etNum.getText().append("0"));
                else etNum.setText("0"); // везде проверка, является ли строка 0, чтобы не получать на входе строку вида "002345" и.т.д.
                break;                   // но строка может быть 0.0000
            case R.id.btn1:
                if (!etNum.getText().toString().equals("0")) etNum.setText(etNum.getText().append("1"));
                else etNum.setText("1");
                break;
            case R.id.btn2:
                if (!etNum.getText().toString().equals("0")) etNum.setText(etNum.getText().append("2"));
                else etNum.setText("2");
                break;
            case R.id.btn3:
                if (!etNum.getText().toString().equals("0")) etNum.setText(etNum.getText().append("3"));
                else etNum.setText("3");
                break;
            case R.id.btn4:
                if (!etNum.getText().toString().equals("0")) etNum.setText(etNum.getText().append("4"));
                else etNum.setText("4");
                break;
            case R.id.btn5:
                if (!etNum.getText().toString().equals("0")) etNum.setText(etNum.getText().append("5"));
                else etNum.setText("5");
                break;
            case R.id.btn6:
                if (!etNum.getText().toString().equals("0")) etNum.setText(etNum.getText().append("6"));
                else etNum.setText("6");
                break;
            case R.id.btn7:
                if (!etNum.getText().toString().equals("0")) etNum.setText(etNum.getText().append("7"));
                else etNum.setText("7");
                break;
            case R.id.btn8:
                if (!etNum.getText().toString().equals("0")) etNum.setText(etNum.getText().append("8"));
                else etNum.setText("8");
                break;
            case R.id.btn9:
                if (!etNum.getText().toString().equals("0")) etNum.setText(etNum.getText().append("9"));
                else etNum.setText("9");
                break;
            case R.id.btndot:  // проверкой исключается возможность появления двух "." в строке
                if (!etNum.getText().toString().contains(".") && !TextUtils.isEmpty(etNum.getText().toString())){
                    etNum.setText(etNum.getText().append("."));
                }
                if (TextUtils.isEmpty(etNum.getText().toString())) etNum.setText("0.");
                break;
            case R.id.btnsign:
                if (etNum.getText().toString().contains("-")){
                    etNum.setText(etNum.getText().replace(0, 1, ""));
                    break;
                }
                else if (!TextUtils.isEmpty(etNum.getText().toString()) && Float.parseFloat(etNum.getText().toString()) != 0){
                    etNum.setText("-"+etNum.getText());
                }
                break;
            default:
                break;
        }

        // формируем строку вывода "" используем для неявного преобразования float
        if (result != 0 && !clear) tvResult.setText(""+result);
        else tvResult.setText("0");
        clear = false;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mSettings.contains(APP_PREFERENCES_RESULT)) {
            result = mSettings.getFloat(APP_PREFERENCES_RESULT, 0); // Получаем число из настроек
            result = Math.round(result*10000)/10000; // округлем до 4 знаков после запятой
            tvResult.setText(""+result); // Выводим на экран данные из настроек
            if (Float.isInfinite(result))result = 0; // при Nan и Infinite считаем result за 0
            firstclick = false; // для того, чтобы сохраненный результат сразу использовать как первый операнд
                                // чтобы производить действия не используя результат, нужно сначала сделать сброс (C)
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Запоминаем данные
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putFloat(APP_PREFERENCES_RESULT, result);
        editor.apply();
    }
}