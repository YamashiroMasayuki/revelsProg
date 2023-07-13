package com.example.demo.UserInfoEdit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.*;

@Controller
public class UserInfoEditController {

	//打刻画面URL
	String redirectUserInfoEditUrl = "/UserInfoEdit";

	//ユーザー情報修正画面メインメソッド
	@RequestMapping("/UserInfoEdit")
	public String page(Model model) {
		
		
		return redirectUserInfoEditUrl;
	}
	
	

	//ユーザー情報検索表示
	@RequestMapping("/UserInfoEdit/SerchView")
	public String SerchView(Model model, @RequestParam String inputUserID, @RequestParam String inputFName, @RequestParam String inputLName) {
		
		
		return redirectUserInfoEditUrl;
	}

	//ユーザー情報更新
	@RequestMapping("/UserInfoEdit/UpdateUserInfo")
	public String UserEditUpdate(Model model, @RequestParam String inputUserID, @RequestParam String inputFName, @RequestParam String inputLName) {
		
		
		return redirectUserInfoEditUrl;
	}
	
	
}