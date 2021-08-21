package com.example.questions;

import java.util.ArrayList;

public class Question {

    private String ask="";
    private ArrayList<Answer> response=new ArrayList<>();
    public Question(String ask,ArrayList<Answer> response) {
        this.ask = ask;
        this.response=response;
    }
    public Question(){

    }
    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public ArrayList<Answer> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<Answer> response) {
        this.response = response;
    }

    public String getAnswer(){
        for (int i = 0; i < response.size(); i++) {
            if(response.get(i).isRight()){
                return response.get(i).getReponse();
            }
        }
        return null;
    }
}
