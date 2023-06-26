package com.example.demo.ShinseiCheck;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.*;

@Controller
public class ShinseiCheckController {

	//打刻画面URL
	String redirectShinseiCheckUrl = "/ShinseiCheck";
	
	@RequestMapping("/ShinseiCheck") // アクセス先URIに関連する
	public String page(Model model) {
		
		
		return redirectShinseiCheckUrl;
	}
}