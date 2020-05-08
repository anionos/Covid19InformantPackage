package com.usehover.covid19informantpackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hover.sdk.api.Hover;
import com.hover.sdk.api.HoverParameters;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hover.initialize(MainActivity.this);

        Button button= (Button) findViewById(R.id.action_button);
        button.setEnabled(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new HoverParameters.Builder(MainActivity.this)
                        .request("3fb60464")
                        .extra("step_variable_name”, variable_value_as_string) // Only if your action has variables
                                .buildIntent();
                startActivityForResult(i, 0);
            }
        });
    }
}
