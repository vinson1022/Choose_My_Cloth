package com.example.vinson_chen.choose_my_cloth;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_result,bt_record,bt_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setView();
        setListener();

    }

    public void setView(){

        bt_record = (Button)findViewById(R.id.button_record);
        bt_result = (Button)findViewById(R.id.button_result);
        bt_setting = (Button)findViewById(R.id.button_setting);

    }

    public void setListener(){

        bt_result.setOnClickListener(this);
        bt_setting.setOnClickListener(this);
        bt_record.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == bt_result.getId()){
            FragmentResult fragment = new FragmentResult();
            getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment).commit();
        }
        else if(v.getId() == bt_record.getId()){
            FragmentRecord fragment = new FragmentRecord();
            getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment).commit();
        }
        else{
            return;
        }

    }
}
