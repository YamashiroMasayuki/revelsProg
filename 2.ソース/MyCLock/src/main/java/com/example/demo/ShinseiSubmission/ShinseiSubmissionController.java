package com.example.demo.ShinseiSubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.*;

@Controller
public class ShinseiSubmissionController {

	//打刻画面URL
	String redirectShinseiSubmissionUrl = "/ShinseiSubmission";
	
	@RequestMapping("/ShinseiSubmission") // アクセス先URIに関連する
	public String page(Model model) {
		
		
		return redirectShinseiSubmissionUrl;
	}
}