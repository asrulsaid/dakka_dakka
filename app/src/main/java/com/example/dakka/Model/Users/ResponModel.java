package com.example.dakka.Model.Users;

import java.util.ArrayList;

public class ResponModel {
    private String success;
    private ArrayList<User>result;

    public ArrayList<User> getResult() {
        return result;
    }

    public void setResults(ArrayList<User> result) {
        this.result = result;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
