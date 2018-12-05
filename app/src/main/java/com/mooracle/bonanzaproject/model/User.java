package com.mooracle.bonanzaproject.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String username;
    private String fullName;
    private int age;
    private String location;
    private String gender;


    public User(String username, String fullName, int age, String location, String gender)
            throws IllegalArgumentException{
        inputValidation(username, fullName, age, location, gender);
        this.username = username;
        this.fullName = fullName;
        this.age = age;
        this.location = location;
        this.gender = gender;
    }

    /*Construction validation inputs:*/
    private void inputValidation (String username, String fullName, int age, String location, String gender) {
        if (username.isEmpty()){throw new IllegalArgumentException("username cannot be empty");}
        if (fullName.isEmpty()){throw new IllegalArgumentException("full name cannot be empty");}
        if (age < 3 || age > 90){throw new IllegalArgumentException("the age is out of limit");}
        if (location.isEmpty()){throw new IllegalArgumentException("the location must be defined");}
        if (gender.isEmpty()){throw new IllegalArgumentException("gender must be specified");}
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(fullName);
        dest.writeInt(age);
        dest.writeString(location);
        dest.writeString(gender);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private User(Parcel in) {
        this.username = in.readString();
        this.fullName = in.readString();
        this.age = in.readInt();
        this.location = in.readString();
        this.gender = in.readString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
