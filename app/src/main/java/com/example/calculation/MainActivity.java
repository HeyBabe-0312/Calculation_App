package com.example.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.calculation.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<String> list;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        list = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        binding.listView.setAdapter(arrayAdapter);
        binding.btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = binding.editA.getText().toString();
                String b = binding.editB.getText().toString();
                list.add(" "+a+" + "+b+" = "+cong(a,b));
                arrayAdapter.notifyDataSetChanged();
            }
        });
        binding.btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = binding.editA.getText().toString();
                String b = binding.editB.getText().toString();
                list.add(" "+a+" - "+b+" = "+tru(a,b));
                arrayAdapter.notifyDataSetChanged();
            }
        });
        binding.btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = binding.editA.getText().toString();
                String b = binding.editB.getText().toString();
                list.add(" "+a+" * "+b+" = "+nhan(a,b));
                arrayAdapter.notifyDataSetChanged();
            }
        });
        binding.btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = binding.editA.getText().toString();
                String b = binding.editB.getText().toString();
                list.add(" "+a+" / "+b+" = "+chia(a,b));
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
    public float cong(String a, String b){
        return Float.parseFloat(a) + Float.parseFloat(b);
    }
    public float tru(String a, String b){
        return Float.parseFloat(a) - Float.parseFloat(b);
    }
    public float nhan(String a, String b){
        return Float.parseFloat(a) * Float.parseFloat(b);
    }
    public float chia(String a, String b){
        return Float.parseFloat(a) / Float.parseFloat(b);
    }
}