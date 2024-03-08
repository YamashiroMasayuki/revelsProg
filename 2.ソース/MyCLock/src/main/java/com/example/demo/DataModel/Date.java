package com.example.demo.DataModel;

public class Date {
    private int INT_YEAR;
    private int INT_MONTH;
    private int INT_DATE;
    private String STRING_YOUBI;
    

    //コンストラクタ
    public Date(){
    }
    //ゲッター
    public int getYear(){
        return INT_YEAR;
    }
    public int getMonth(){
        return INT_MONTH;
    }
    public int getDate(){
        return INT_DATE;
    }
    public String getYoubi(){
        return STRING_YOUBI;
    }
    //セッター
    public void setYear(int year){
        this.INT_YEAR = year;
    }
    public void setMonth(int month){
        this.INT_MONTH = month;
    }
    public void setDate(int date){
        this.INT_DATE = date;
    }
    public void setYoubi(String youbi){
        this.STRING_YOUBI = youbi;
    }
    
    
}