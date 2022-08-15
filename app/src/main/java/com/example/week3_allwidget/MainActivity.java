package com.example.week3_allwidget;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    float num1,num2,total;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton add,minus,multiply,divide;
        EditText val_1,val_2;
        Button btn_cal,btn_clr,btn_ent;
        SeekBar seekbar;
        Spinner spinner;
        TextView tv_seek,tv_spin,tv_sw;
        CheckBox cb_red,cb_blue,cb_green;
        RatingBar ratingBar;
        Switch sw1;
        ToggleButton tg_button;

        add = findViewById(R.id.rad_add);
        minus = findViewById(R.id.rad_minus);
        multiply = findViewById(R.id.rad_multiply);
        divide = findViewById(R.id.rad_divide);
        val_1 = findViewById(R.id.val_1);
        val_2 = findViewById(R.id.val_2);
        btn_cal = findViewById(R.id.btn_cal);
        btn_clr = findViewById(R.id.btn_clr);
        btn_ent = findViewById(R.id.btn_ent);
        seekbar = findViewById(R.id.seekBar);
        spinner = findViewById(R.id.spinner);
        tv_seek = findViewById(R.id.tv_progb);
        tv_spin = findViewById(R.id.tv_spin);
        tv_sw = findViewById(R.id.tv_sw);
        cb_red = findViewById(R.id.cb_red);
        cb_blue = findViewById(R.id.cb_blue);
        cb_green = findViewById(R.id.cb_green);
        ratingBar = findViewById(R.id.ratingBar);
        sw1 = findViewById(R.id.switch1);
        tg_button = findViewById(R.id.toggleButton);
        AlertDialog.Builder alert_dialog = new AlertDialog.Builder(MainActivity.this);
        AlertDialog ald = alert_dialog.create();

        btn_ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_spin.setText(spinner.getSelectedItem().toString());

                int seek_value = seekbar.getProgress();
                tv_seek.setText(Integer.toString(seek_value));

                if (cb_red.isChecked() && !cb_blue.isChecked() && !cb_green.isChecked()) {
                    Toast.makeText(MainActivity.this, "red", Toast.LENGTH_SHORT).show();
                }
                else if (!cb_red.isChecked() && cb_blue.isChecked() && !cb_green.isChecked()) {
                    Toast.makeText(MainActivity.this, "blue", Toast.LENGTH_SHORT).show();
                }
                else if (!cb_red.isChecked() && !cb_blue.isChecked() && cb_green.isChecked()) {
                    Toast.makeText(MainActivity.this, "green", Toast.LENGTH_SHORT).show();
                }
                else if (!cb_red.isChecked() && !cb_blue.isChecked() && !cb_green.isChecked()) {
                    Toast.makeText(MainActivity.this, "None Select", Toast.LENGTH_SHORT).show();
                }
                else if (cb_red.isChecked() && cb_blue.isChecked() && cb_green.isChecked()) {
                    Toast.makeText(MainActivity.this, "U R select All", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tg_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tg_button.isChecked() == true){
                    ald.setMessage("ON");
                }
                else {
                    ald.setMessage("OFF");
                }
                ald.show();
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int seek_value = (seekBar.getThumbOffset()*i)/22;
                tv_seek.setText(Integer.toString(seek_value));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                Float val = ratingBar.getRating();
                Toast.makeText(MainActivity.this, Float.toString(val),Toast.LENGTH_SHORT).show();

            }
        });

        sw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw1.isChecked()){
                    tv_sw.setText("ON");
                }
                else {
                    tv_sw.setText("OFF");
                }
            }
        });

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1 = Float.parseFloat(val_1.getText().toString());
                num2 = Float.parseFloat(val_2.getText().toString());

                if (add.isChecked()){
                    total = num1 + num2;
                    Toast.makeText(MainActivity.this,Float.toString(total),Toast.LENGTH_SHORT).show();
                }
                else if (minus.isChecked()){
                    total = num1 - num2;
                    Toast.makeText(MainActivity.this,Float.toString(total),Toast.LENGTH_SHORT).show();
                }
                else if (multiply.isChecked()){
                    total = num1 * num2;
                    Toast.makeText(MainActivity.this,Float.toString(total),Toast.LENGTH_SHORT).show();
                }
                else if (divide.isChecked()){
                    total = num1 / num2;
                    Toast.makeText(MainActivity.this,Float.toString(total),Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val_1.setText("");
                val_2.setText("");
            }
        });
    }
}