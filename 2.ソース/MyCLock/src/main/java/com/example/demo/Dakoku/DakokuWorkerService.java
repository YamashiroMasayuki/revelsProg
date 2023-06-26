package com.example.demo.Dakoku;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.example.demo.CommonWorkerService;

public class DakokuWorkerService {

	//画面表示用システム日付の取得・作成
	public String setNowDate() {

		try {
			var _comWorker = new CommonWorkerService();
			//システム年月(yyyyMMdd)の取得
			String sysDate = _comWorker.getSystemDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			
			return sdf.parse(sysDate).toString();
		}
		catch(ParseException e) {
			return "error";
		}
	}

}