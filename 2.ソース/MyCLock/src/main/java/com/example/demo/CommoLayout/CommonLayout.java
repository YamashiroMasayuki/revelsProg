package com.example.demo.CommoLayout;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.CommonWorkerService;

@Controller
@RequestMapping("/Login")
public class CommonLayout {

	//共通画面レイアウトURL
	String redirectCommonLayoutUrl = "/CommonLayout";

	//ユーザー情報修正画面メインメソッド
	@GetMapping("/CommonLayout/{userID}")
	public String page(Model model, @PathVariable("userID") String userID) {
		try {
			var _commonWorker = new CommonWorkerService();
			ResultSet result = _commonWorker.getMUserData("admin");

			//管理者フラグの取得
	        model.addAttribute("adminFlg", result.getObject("IS_ADMINISTRATOR").toString() );
			
		}
		catch(SQLException e) {
			
		}

		
		
		return redirectCommonLayoutUrl;
	}
	
	
	
}
