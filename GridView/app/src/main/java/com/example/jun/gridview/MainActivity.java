package com.example.jun.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private GridView gview;
    private TextView x;
    private TextView y;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    private int[] icon = {R.drawable.ttt, R.drawable.ttt,
            R.drawable.ttt, R.drawable.ttt};
    private String[] iconName = {"加法", "减法", "乘法", "除法"};
    private String[] from = {"image", "text"};
    private int[] to = {R.id.image, R.id.text};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gview = (GridView) findViewById(R.id.myGridView);
        x = (TextView) findViewById(R.id.editText);
        y = (TextView) findViewById(R.id.editText2);
        data_list = new ArrayList<Map<String, Object>>();
        getdata();
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.custom_gird, from, to);
        gview.setAdapter(sim_adapter);
        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                float result = 0;
                try {
                    if (x.getText() != null || y.getText() != null) result = 0;
                    if (iconName[position] == "加法" && x.getText() != null && y.getText() != null) {
                        result = Float.parseFloat(x.getText().toString()) + Float.parseFloat(y.getText().toString());
                    } else if (iconName[position] == "减法" && x.getText() != null && y.getText() != null) {
                        result = Float.parseFloat(x.getText().toString()) - Float.parseFloat(y.getText().toString());
                    } else if (iconName[position] == "乘法" && x.getText() != null && y.getText() != null) {
                        result = Float.parseFloat(x.getText().toString()) * Float.parseFloat(y.getText().toString());
                    } else if (iconName[position] == "除法" && x.getText() != null && y.getText() != null) {
                        result = Float.parseFloat(x.getText().toString()) / Float.parseFloat(y.getText().toString());
                    } else result = 0;
                }
                catch(Exception e){
                    result = 0;
                }
                Toast.makeText(MainActivity.this,String.valueOf(result),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getdata(){
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
    }
}
