package com.narcisoRyanRiquelme.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.real = findViewById(R.id.edit_real);
        this.mViewHolder.resultDolar = findViewById(R.id.text_resultDolar);
        this.mViewHolder.resultEuro = findViewById(R.id.text_resultEuro);
        this.mViewHolder.calcular = findViewById(R.id.button_calcular);
        this.mViewHolder.calcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calcular) ;
        {
            String value = this.mViewHolder.real.getText().toString();

            if ("".equals(value)) {
                Toast.makeText(this, "Digite um Valor Para Real", Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(value);
                this.mViewHolder.resultDolar.setText(String.format("%.2f", real / 5.17));
                this.mViewHolder.resultEuro.setText(String.format("%.2f", real / 5.46));
            }
        }
    }

    private static class ViewHolder {

        TextView resultDolar;
        TextView resultEuro;
        Button calcular;
        EditText real;

    }
}