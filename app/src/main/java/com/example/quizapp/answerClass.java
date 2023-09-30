package com.example.quizapp;

public class answerClass {

    private int optionA,optionB,optionC,optionD,questionid,answerid;
    public answerClass(int queid,int opta,int optb,int optc,int optd,int ansid){
        questionid=queid;
        optionA=opta;
        optionB=optb;
        optionC=optc;
        optionD=optd;
        answerid=ansid;


    }

    public int getOptionA() {
        return optionA;
    }

    public void setOptionA(int optionA) {
        this.optionA = optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public void setOptionB(int optionB) {
        this.optionB = optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public void setOptionC(int optionC) {
        this.optionC = optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public void setOptionD(int optionD) {
        this.optionD = optionD;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public int getAnswerid() {
        return answerid;
    }

    public void setAnswerid(int answerid) {
        this.answerid = answerid;
    }
}
