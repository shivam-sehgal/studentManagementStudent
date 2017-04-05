package com.example.user.studentmanagementsystem;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 4/4/2017.
 */

public class CustomDialogClass extends Dialog implements android.view.View.OnClickListener {
    private static final int REQ_CODE = 1;
    private Activity activity;
    private Button btnView;
    private Button btnEdit;
    private Button btnDelete;
    private int adapterPosition;
    private StudentData studentData;
    private RecyclerAdapter recyclerAdapter;

    /**
     * @param activity ac
     * @param adapterPosition pos
     * @param recyclerAdapter ad
     */
    public CustomDialogClass(final Activity activity, final int adapterPosition, final RecyclerAdapter recyclerAdapter) {
        super(activity);
        this.activity = activity;
        this.adapterPosition = adapterPosition;
        this.recyclerAdapter = recyclerAdapter;
    }

    /**
     * @param savedInstanceState ab
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_layout);
        init();
        setListeners();
    }

    /**
     *
     */
    public void init() {
        btnView = (Button) findViewById(R.id.view_btn);
        btnEdit = (Button) findViewById(R.id.edit_btn);
        btnDelete = (Button) findViewById(R.id.delete_btn);

    }

    /**
     * to add listeners to object
     */
    public void setListeners() {
        btnView.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
        btnDelete.setOnClickListener(this);


    }

    @Override
    public void onClick(final View v) {

        switch (v.getId()) {
            case R.id.view_btn:
                studentData = recyclerAdapter.getElementInList(adapterPosition);
                ((AddStudentActivity) activity).startViewingListElement(studentData);

                dismiss();
                break;
            case R.id.edit_btn:

                studentData = recyclerAdapter.getElementInList(adapterPosition);
                ((AddStudentActivity) activity).startEditActivity(studentData, adapterPosition);

                dismiss();
                break;
            case R.id.delete_btn:
                recyclerAdapter.deleteElementAtPosition(adapterPosition);
                recyclerAdapter.notifyDataSetChanged();
                dismiss();
                break;
            default:
                dismiss();
                break;

        }


    }
}
