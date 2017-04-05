package com.example.user.studentmanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * activity to display form
 */
public class FormActivity extends AppCompatActivity {
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etRollNo;
    private RadioGroup radioGroup;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private String email;
    private String schoolname;
    private EditText etEmail;
    private EditText etSchoolName;
    private Button submit;
    private String gender;
    private String firstName;
    private String lastName;
    private int rollNo;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setListeners();

    }

    /**
     * to initialize objects
     */
    public void init() {
        setContentView(R.layout.activity_form);
        etFirstName = (EditText) findViewById(R.id.first_name_form);
        etLastName = (EditText) findViewById(R.id.last_name_form);
        etEmail = (EditText) findViewById(R.id.email_form);
        etSchoolName = (EditText) findViewById(R.id.school_name_form);
        radioGroup = (RadioGroup) findViewById(R.id.my_radioGroup);
        maleRadioButton = (RadioButton) findViewById(R.id.radio_male);
        etRollNo = (EditText) findViewById(R.id.roll_no_form);
        femaleRadioButton = (RadioButton) findViewById(R.id.radio_female);
        submit = (Button) findViewById(R.id.submit_btn);

    }

    /**
     * to add listeners
     */
    public void setListeners() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup group, @IdRes final int checkedId) {
                switch (checkedId) {
                    case R.id.radio_male:
                        gender = "Male";
                        break;
                    case R.id.radio_female:
                        gender = "Female";
                        break;
                    default:
                        break;
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                firstName = String.valueOf(etFirstName.getText());
                lastName = String.valueOf(etFirstName.getText());
                rollNo = Integer.parseInt(String.valueOf(etRollNo.getText()));
                email = String.valueOf(etEmail.getText());
                schoolname = String.valueOf(etSchoolName.getText());
                StudentData data = new StudentData(firstName, lastName, schoolname, email, gender, rollNo);
                Intent intent = new Intent();
                intent.putExtra("obj", data);
                setResult(Activity.RESULT_OK, intent);
                finish();

            }
        });

    }
}
