package com.juaracoding.huda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.juaracoding.huda.adapter.AdapterListBasic;
import com.juaracoding.huda.model.Biodata;
import com.juaracoding.huda.utility.SharedPrefUtil;

import java.lang.reflect.Type;
import java.util.List;

public class ListBiodata extends AppCompatActivity implements AdapterListBasic.OnItemClickListener{

    RecyclerView lstBiodata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_biodata);

        lstBiodata = findViewById(R.id.lstBiodata);

        if(loadData()!=null){
            AdapterListBasic adapter = new AdapterListBasic(ListBiodata.this,loadData());
            adapter.setOnItemClickListener(ListBiodata.this);
            lstBiodata.setLayoutManager(new LinearLayoutManager(ListBiodata.this));
            lstBiodata.setItemAnimator(new DefaultItemAnimator());
            lstBiodata.setAdapter(adapter);
        }


    }

    public List<Biodata> loadData(){
        List<Biodata> biodataList =null;
        if(!SharedPrefUtil.getInstance(ListBiodata.this).getString("data_input").isEmpty()) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Biodata>>(){}.getType();
            biodataList = gson.fromJson(SharedPrefUtil.getInstance(ListBiodata.this).getString("data_input"), type);
            for (Biodata data : biodataList){
                Log.i("Contact Details", data.getNama() + "-" + data.getAlamat() + "-" + data.getEmail());
            }

        }

        return biodataList;
    }

    @Override
    public void onItemClick(View view, Biodata obj, int position) {

    }
}