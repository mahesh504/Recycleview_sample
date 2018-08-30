package com.mahesh504.recycleview_sample.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mahesh504.recycleview_sample.R;
import com.mahesh504.recycleview_sample.adapters.PropertyListAdapter;
import com.mahesh504.recycleview_sample.data.PropertyData;
import com.mahesh504.recycleview_sample.model.PropertyModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private RecyclerView rcv_pro;
    private LinearLayoutManager layoutManager;
    private List<PropertyModel> propertyDataList;
    private PropertyListAdapter propertyListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bind();

    }

    private void bind() {
        propertyDataList = PropertyData.getPropertyData();
        propertyListAdapter = new PropertyListAdapter(propertyDataList,mContext);
        rcv_pro.setAdapter(propertyListAdapter);
    }

    private void init() {
        mContext =MainActivity.this;
        layoutManager = new LinearLayoutManager(mContext);
        rcv_pro = findViewById(R.id.rcv_pro);
        rcv_pro.setLayoutManager(layoutManager);

    }
}
