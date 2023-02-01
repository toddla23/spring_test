package sample.coc.project;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SheetController {
	@Autowired
	SheetService sheetService;
	
	@RequestMapping(value="/sheet", method = RequestMethod.GET)
	public ModelAndView create() {
	    return new ModelAndView("coc/sheet");
	}
	
	@RequestMapping(value = "/sheet", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
	    ModelAndView mav = new ModelAndView();	
	    for(String key : map.keySet()) {
	         String value = (String) map.get(key);
	            System.out.println(key + " : " + value);
	        }

	    String userId = this.sheetService.create(map);
	    if (userId == null) {
	        mav.setViewName("redirect:/sheet");
	    }else {
	        mav.setViewName("redirect:/update?userId=" + userId); 
	    }  
	    

	    return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)  
	public ModelAndView update(@RequestParam Map<String, Object> map) {  
		Map<String, Object> detailMap = this.sheetService.detail(map); 
		
		ModelAndView mav = new ModelAndView();  
		mav.addObject("data", detailMap);  
		mav.setViewName("/coc/update");  
		return mav;  
	}  
	
	@RequestMapping(value = "update", method = RequestMethod.POST)  
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {  
	ModelAndView mav = new ModelAndView();  

	boolean isUpdateSuccess = this.sheetService.edit(map);  
	if (isUpdateSuccess) {  
	String userId = map.get("userId").toString();  
	mav.setViewName("redirect:/update?userId=" + userId);  
	}else {  
	mav = this.update(map);  
	}  

	return mav;  
	}  
}
