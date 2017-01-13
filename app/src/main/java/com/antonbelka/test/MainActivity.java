package com.antonbelka.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindViews({ R.id.a_btn, R.id.b_btn, R.id.c_btn, R.id.d_btn,
            R.id.e_btn, R.id.f_btn, R.id.g_btn, R.id.h_btn })
    List<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        for (int i = 0; i < buttons.size(); i++) {
            Button button = buttons.get(i);
            button.setText(String.valueOf(i));
        }
    }

    @OnClick({ R.id.a_btn, R.id.b_btn, R.id.c_btn, R.id.d_btn,
            R.id.e_btn, R.id.f_btn, R.id.g_btn, R.id.h_btn })
    public void onButtonClick(Button button) {
        disableAllButtons(buttons);
        enableButton(button, true);
    }

    @OnClick(R.id.open_custom_btn)
    public void onOpenCustomActivityClick() {
        startActivity(new Intent(this, CustomActivity.class));
    }

    private void enableButton(Button button, boolean enabled) {
        button.setCompoundDrawablesWithIntrinsicBounds(
                ContextCompat.getDrawable(this,
                        enabled ? android.R.drawable.btn_star_big_on
                                : android.R.drawable.btn_star_big_off),
                null, null, null);
    }

    private void disableAllButtons(List<Button> buttons) {
        for (Button button: buttons) {
            enableButton(button, false);
        }
    }

}
