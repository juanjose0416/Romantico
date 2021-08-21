package com.example.questions;

import java.util.ArrayList;

public class Answer {

    private String reponse="";
    private boolean isRight=false;

    public Answer(String reponse, boolean isRight) {
        this.reponse = reponse;
        this.isRight = isRight;
    }
    public Answer(){

    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }
}
