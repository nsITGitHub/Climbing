package jp.co.bol.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import jp.co.bol.entity.Calender;
import jp.co.bol.service.ClimbingService;
import jp.co.bol.service.jim.Jim_news_Nobolock;


@Controller
public class ClimbingController {

	private final ClimbingService climbService;
	
	public ClimbingController(ClimbingService climbService) {
		this.climbService = climbService;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("climbs",climbService.findAll());
		model.addAttribute("names",climbService.category());
		model.addAttribute("news",climbService.newsFindAll());
		return "index";
	}
	
	 @PostMapping("/update")
		public String update(@ModelAttribute("climbs") Calender climb ,Model model) throws UnsupportedEncodingException  {
		 climbService.update();
		 climbService.updateNews();
		 return "redirect:/";
	 }
	 
	 @PostMapping("/delete")
	  	public String delete() {
		climbService.delete();
		return "redirect:/";
	}
	 
	 
	 @PostMapping("/display")
	  	public String display(@RequestParam("jimcategory")  List<String> name_jim ,Model model) {
		 if (name_jim.size()==1) {
			 return "redirect:/";
		    }else {
		    	model.addAttribute("climbs",climbService.display(name_jim));
				model.addAttribute("names",climbService.category());
				model.addAttribute("news",climbService.newsFindAll());
				return "index";
		    }
	}
}


/*
@GetMapping("/Climbing/json")
@ResponseBody
	public List<Climbing> getClimbingJson() {
		List<Climbing> ClimbingrList = climbService.findAll();
		return ClimbingrList;
}
*/
