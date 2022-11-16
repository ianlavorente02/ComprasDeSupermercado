package com.ianlavorente.comprasdesupermercado;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button buttonTotal;
    private Button buttonPagar;
    private CheckBox checkBoxCarne;
    private CheckBox checkBoxArroz;
    private CheckBox checkBoxFeijao;
    private EditText editTextPagar;
    private RadioGroup radioGroupDesconto;
    private TextView textViewTotal;

    private DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonTotal = findViewById(R.id.buttonTotal);
        buttonPagar = findViewById(R.id.buttonPagar);
        checkBoxCarne = findViewById(R.id.checkBoxCarne);
        checkBoxArroz = findViewById(R.id.checkBoxArroz);
        checkBoxFeijao = findViewById(R.id.checkBoxFeijao);
        editTextPagar = findViewById(R.id.editTextPagar);
        radioGroupDesconto = findViewById(R.id.radioGroupDesconto);
        textViewTotal = findViewById(R.id.textViewTotal);

        buttonTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valorTotal = 0.0;

                if (checkBoxCarne.isChecked()) {
                    valorTotal += 40.0;
                }
                if (checkBoxArroz.isChecked()) {
                    valorTotal += 3.5;
                }
                if (checkBoxFeijao.isChecked()) {
                    valorTotal += 7.5;
                }
                textViewTotal.setText("Preço total: R$" + decimalFormat.format(valorTotal));
            }
        });

        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valorTotal = 0.0;

                if (checkBoxCarne.isChecked()) {
                    valorTotal += 40.0;
                }
                if (checkBoxArroz.isChecked()) {
                    valorTotal += 3.5;
                }
                if (checkBoxFeijao.isChecked()) {
                    valorTotal += 7.5;
                }
                if (editTextPagar.getText().toString().isEmpty() ||
                    radioGroupDesconto.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(MainActivity.this,
                                        "Por favor, preencha todos os campos",
                                        Toast.LENGTH_SHORT).show();
                } else {
                    int radioButtonSelecionado = radioGroupDesconto.getCheckedRadioButtonId();
                    String desconto = "";
                    double valorAPagar = 0.0;
                    double valorPago = Double.parseDouble(editTextPagar.getText().toString());

                    if (radioButtonSelecionado == R.id.radioButtonNenhum) {
                        desconto = "Nenhum desconto";
                        valorAPagar = valorTotal;
                    }
                    if (radioButtonSelecionado == R.id.radioButtonCinco) {
                        desconto = "5% de desconto";
                        valorAPagar = (valorTotal - (valorTotal * 0.05));
                    }
                    if  (radioButtonSelecionado == R.id.radioButtonDez) {
                        desconto = "10% de desconto";
                        valorAPagar = (valorTotal - (valorTotal * 0.1));
                    }

                    if (valorPago < valorAPagar) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Pagamento");
                        double valorRestante = valorAPagar - valorPago;
                        builder.setMessage("Saldo insuficiente. Faltam: R$" +
                                            decimalFormat.format(valorRestante));
                        builder.setNeutralButton("OK", null);
                        builder.show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Pagamento");
                        double troco = valorPago - valorAPagar;
                        builder.setMessage("Valor total: R$" + decimalFormat.format(valorTotal) +
                                            "\nValor pago: R$" + decimalFormat.format(valorPago) +
                                            "\nDesconto: " + desconto +
                                            "\nTroco: R$" + decimalFormat.format(troco));
                        builder.setNeutralButton("OK", null);
                        builder.show();
                    }
                }
            }
        });
    }
}