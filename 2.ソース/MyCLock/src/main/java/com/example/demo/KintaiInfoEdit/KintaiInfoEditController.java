package com.example.demo.KintaiInfoEdit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.*;

@Controller
public class KintaiInfoEditController {

	//打刻画面URL
	String redirectKintaiInfoEditUrl = "/KintaiInfoEdit";
	
	@RequestMapping("/KintaiInfoEdit") // アクセス先URIに関連する
	public String page(Model model) {
		
		
		return redirectKintaiInfoEditUrl;
	}
}