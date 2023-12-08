package com.example.student;

import static kotlinx.coroutines.flow.FlowKt.count;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float price = 35_000; // стоимость робота
    float amount = 1_700; // стипендия в месяц
    float account = 700; // счёт пользователя
    float percent = 9; // годовая процентная ставка за ипотеку
    float[] monthlyPayments = new float[60];

    private TextView possibilityOut; // поле вывода количества месяцев выплаты ипотеки
    private TextView manyMonthOut; // поле выписки по ежемесячным платежам

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        possibilityOut = findViewById(R.id.countOut); // вывод информации количества месяцев выплаты ипотеки
        manyMonthOut = findViewById(R.id.possibilityOut); // вывод информации выписки по ежемесячным платежам
        possibilityOut.setText (countMonth() + "месяцев");
        // 2) подготовка выписки
        String monthlyPaymentsList = ""; // строка для записи выписки
        for(float list : monthlyPayments) { // цикл заполнения строки выпиской
            if (list > 0) {
                monthlyPaymentsList += Float.toString(list) + ", ";
            } else {
                break;
            }
        }
        // 3) вывод выписки ежемесячных выплат по ипотеке
        manyMonthOut.setText("Первоначальный взнос" + account + "монет");

    }
    public int countMonth(float percentBankYear, float amount, float apartment, float accumulation, float[] arrayPayments) {

        float percentMonth1 = percent / 12; // подсчёт ежемесячного процента банка за ипотеку
        float payMonth = (amount * percent) / 100; // подсчёт ежемесячных трат на робота
        float onePay = payMonth + amount; // 1го начальный взнос
        float total = price - onePay; // подсчёт стоимости квартиры с учётом первоначального взноса// счётчик месяцев вы
        return 0;
    }
            public int countMonth() {
            float percentMonth = percent / 12;
            float total = account;
            int count = 0;
            while (total < price) {
            total += total * percentMonth / 100;
            total += amount;
            count++;
            }
            return count;
}

}