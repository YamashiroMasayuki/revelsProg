package com.example.demo.DataModel;

import java.util.ArrayList;
import java.util.List;

public class Year {
    private List<com.example.demo.DataModel.Date> calenderMonth = new ArrayList<com.example.demo.DataModel.Date>();
	

    //コンストラクタ
    public Year(){
    }
    //ゲッター
    public List<com.example.demo.DataModel.Date> get1Month(){
        return calenderMonth;
    }
    //セッター
    public void set1Month(List<com.example.demo.DataModel.Date> monthList){
        this.calenderMonth = monthList;
    }
    
    

}
