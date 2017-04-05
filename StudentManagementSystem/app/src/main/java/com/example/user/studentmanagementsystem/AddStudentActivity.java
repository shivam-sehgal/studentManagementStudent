package com.example.user.studentmanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.widget.Button;

/**
 * activity to show added students in list
 */
public class AddStudentActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static int layoutDetector = 0;
    private Button addBtn;
    private StudentData studentData;
    private int reqCode = 1;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private Button btnToogle;
    private Spinner spinner;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        init();
        setListeners();
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(recyclerAdapter);
    }

    /**
     * method to initialize objects
     */
    public void init() {
        addBtn = (Button) findViewById(R.id.add_student);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler);
        btnToogle = (Button) findViewById(R.id.toogle_btn);
        spinner = (Spinner) findViewById(R.id.my_spinner);
        recyclerAdapter = new RecyclerAdapter(this);
        setSpinner();

    }

    /**
     * spineer set
     */
    public void setSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sorting_creterias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    /**
     * method to set listeners on button and spinner
     */
    public void setListeners() {
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(getBaseContext(), FormActivity.class);
                startActivityForResult(intent, reqCode);
            }
        });
        btnToogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (layoutDetector == 0) {
                    recyclerView.setLayoutManager(new GridLayoutManager(AddStudentActivity.this, 2));
                    layoutDetector = 1;
                } else {
                    recyclerView.setLayoutManager(new LinearLayoutManager(AddStudentActivity.this));
                    layoutDetector = 0;

                }

            }
        });
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == reqCode && resultCode == Activity.RESULT_OK) {
            this.studentData = data.getExtras().getParcelable("obj");
            //Toast.makeText(getBaseContext(),"NAME IS "+this.data.getLastName(),Toast.LENGTH_LONG).show();
            recyclerAdapter.addElementInList(this.studentData);
            recyclerAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        if (position == 1) {
            ArrayList<StudentData> list = recyclerAdapter.getList();
            Collections.sort(list, new Comparator<StudentData>() {
                @Override
                public int compare(final StudentData o1, final StudentData o2) {
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
            });

            recyclerAdapter.notifyDataSetChanged();
        } else if (position == 2) {
            ArrayList<StudentData> list = recyclerAdapter.getList();
            Collections.sort(list, new Comparator<StudentData>() {
                @Override
                public int compare(final StudentData o1, final StudentData o2) {
                    return o1.getRollNumber() - o2.getRollNumber();
                }
            });
            recyclerAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onNothingSelected(final AdapterView<?> parent) {

    }
}
