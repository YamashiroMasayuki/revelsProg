package com.example.demo.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.*;

@Controller
public class LoginController {

	String redirectUrl;
	
	@RequestMapping("/Login") // アクセス先URIに関連する
	public String page(Model model) {
		redirectUrl = "/Login";
		model.addAttribute("errorMsgFlg", "false" );
		return redirectUrl;
	}

	// 表示される画面はログイン画面・管理者画面・ユーザー画面へ
	@PostMapping("/Login/LoginCheck")
	public String confirm(RedirectAttributes attributes, Model model, @RequestParam String inputUserID, @RequestParam String inputUserPass) {

		if((inputUserID.trim() == "") || (inputUserPass.trim() == "") ){
			redirectUrl = "/Login";
	        model.addAttribute("errorMsg", "ユーザーIDとPassを記述してください。" );
	        model.addAttribute("errorMsgFlg", "true" );
		}
		else {
			var _commonWorker = new CommonWorkerService();
			//ログイン時使用したIDとパスが正しいかどうかを判断する。正しい場合値が入ってくる。
			String methodKekka = "";
			methodKekka = _commonWorker.getLoginCustomerData(inputUserID, inputUserPass);
			if( methodKekka == "" ) {
				redirectUrl = "/Login";
		        model.addAttribute("errorMsgFlg", "true" );
			}
			else {
				//値がある場合、次のログイン後画面に進む。
				redirectUrl = "/CommonLayout";
				attributes.addFlashAttribute("adminFlg", methodKekka);
			}
		}

		return redirectUrl;

	}

	// 表示される画面はログイン画面・管理者画面・ユーザー画面へ
	@PostMapping("/LogoutRedirectLogin")
	public String LooutRedirectLogin(Model model) {

		var _worker = new CommonWorkerService();

		redirectUrl = "/Login";
		model.addAttribute("errorMsgFlg", "false" );

		return redirectUrl;

	}
}