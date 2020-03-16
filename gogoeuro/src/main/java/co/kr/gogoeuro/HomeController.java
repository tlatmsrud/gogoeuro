package co.kr.gogoeuro;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.kr.gogoeuro.dao.JOIN;
import co.kr.gogoeuro.dao.RESULT;
import co.kr.gogoeuro.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@Autowired
	public UserService userService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home")
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.debug(request.getRemoteAddr());
		String a = request.getRemoteAddr();
		System.out.println(a);

		return "main/home";
	}
	
	@RequestMapping(value ="/loginPage", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) {
		
		String ip = request.getRemoteAddr();
		// 보류 userService.ipCheck(ip);
		model.addAttribute("client_ip",ip);
		return "main/loginPage";
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request,
			@RequestParam(value="id") String id, @RequestParam(value="passwd") String passwd ) {
		
		RESULT result = new RESULT();
		String ip = request.getRemoteAddr();
		result = userService.Login(id,passwd,ip);
		model.addAttribute("result",result);
		
		return "main/loginResult";
	}
	@RequestMapping(value ="/joinPage")
	public String joinPage(Model model, HttpServletRequest request) {
		
		return "main/joinPage";
	}
	
	@RequestMapping(value ="/join")
	public String join(Model model, HttpServletRequest request, JOIN reqJoin ) {
		
		RESULT result = new RESULT();
		String ip = request.getRemoteAddr();
		reqJoin.setIp(ip);
		
		result = userService.join(reqJoin);
		model.addAttribute("result",result);
		return "main/joinResult";
	}
}
