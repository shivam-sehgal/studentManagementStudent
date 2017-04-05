package com.example.user.studentmanagementsystem;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 4/4/2017.
 */

public class StudentData implements Parcelable {

    public static final Parcelable.Creator<StudentData> CREATOR = new Parcelable.Creator<StudentData>() {

        public StudentData createFromParcel(final Parcel in) {
            return new StudentData(in);
        }

        public StudentData[] newArray(final int size) {
            return new StudentData[size];
        }
    };

    private String firstName;
    private String lastName;
    private String schoolName;
    private String email;
    private String gender;
    private int rollNumber;

    /**
     * @param firstName  fname
     * @param lastName   lname
     * @param schoolName schname
     * @param email      eml
     * @param gender     gndr
     * @param rollNumber rollno
     */
    public StudentData(final String firstName, final String lastName, final String schoolName, final String email,
                       final String gender, final int rollNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolName = schoolName;
        this.email = email;
        this.gender = gender;
        this.rollNumber = rollNumber;

    }

    /**
     * @param in Prcel obj
     */
    public StudentData(final Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.schoolName = in.readString();
        this.email = in.readString();
        this.gender = in.readString();
        this.rollNumber = in.readInt();
    }

    /**
     * @return fhgv
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName fstname
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return hhh
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName vh
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return jbj
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * @param schoolName hvh
     */
    public void setSchoolName(final String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * @return bjb
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email jj
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @return bjbj
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender hbjh
     */
    public void setGender(final String gender) {
        this.gender = gender;
    }

    /**
     * @return jbj
     */
    public int getRollNumber() {
        return rollNumber;
    }

    /**
     * @param rollNumber bjbj
     */
    public void setRollNumber(final int rollNumber) {
        this.rollNumber = rollNumber;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(schoolName);
        dest.writeString(email);
        dest.writeString(gender);
        dest.writeInt(rollNumber);
    }


    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof StudentData) {
            StudentData toCompare = (StudentData) obj;
            return this.firstName.equalsIgnoreCase(toCompare.getFirstName());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return (this.getFirstName()).hashCode();
    }
}
