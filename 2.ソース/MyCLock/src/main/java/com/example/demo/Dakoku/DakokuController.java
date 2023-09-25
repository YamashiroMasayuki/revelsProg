package com.example.demo.Dakoku;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.CommonWorkerService;
import com.example.demo.Dakoku.*;

@Controller
public class DakokuController {

	//打刻画面URL
	String redirectDakokuUrl = "/Dakoku";
	
	@RequestMapping("/Dakoku") // アクセス先URIに関連する
	public String main(Model model) {

        model.addAttribute("generalFlg", "true" );
		var _worker = new DakokuWorkerService();
		var _commonWorker = new CommonWorkerService();
		
		//ログインユーザーで本日文のDBが登録されているかの確認
		//データが存在しない場合のみ新しくinsertをする。
		if(_commonWorker.getKintaiDate("admin") == 2) {
			_commonWorker.insertKintaiDate("admin");
		}
		
        model.addAttribute("kinmuStatus", "退勤中" );
		return redirectDakokuUrl;
	}
	
	@RequestMapping("/Dakoku/UpDate") // アクセス先URIに関連する
	public String dakokuUpdate(Model model, @RequestParam boolean dakokuFlg, @RequestParam String systemViewDate, @RequestParam String systemViewTime) {

		String kinmuStatusText = "";
		
		//出勤(true)ボタン押下時
		if(dakokuFlg == true) {
			//出勤時間を更新する。
			var _commonWorker = new CommonWorkerService();
			//if(0 != _commonWorker.setKintaiDate(userID, systemViewDate, dakokuFlg)) {
				
			//}
			
			
			
			//DB更新に以上がない場合は文言を出勤中に変更する。
			kinmuStatusText = "出勤中";
		}
		else {
			//退勤時間を更新する。
			
			
			
			//DB更新に異常がない場合は文言を退勤中に変更する。
			kinmuStatusText = "退勤中";
		}

        model.addAttribute("kinmuStatus", kinmuStatusText );
        
		return redirectDakokuUrl;
	}
	
	
}