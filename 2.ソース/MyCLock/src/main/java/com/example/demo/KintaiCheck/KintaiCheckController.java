package com.example.demo.KintaiCheck;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.*;

@Controller
public class KintaiCheckController {

	//打刻画面URL
	String redirectKintaiCheckUrl = "/KintaiCheck";
	
	@RequestMapping("/KintaiCheck") // アクセス先URIに関連する
	public String page(Model model) {
		
		
		return redirectKintaiCheckUrl;
	}
}