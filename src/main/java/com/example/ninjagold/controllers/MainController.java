package com.example.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activities")==null) {
			ArrayList<String> activities = new ArrayList<String>();
			session.setAttribute("activities", activities);
		}
		
		
		return "index.jsp";
	}
	
	@RequestMapping(value= "/mine", method=RequestMethod.POST)
	public String mine(HttpSession session, @RequestParam (value="location") String location ) {
		
		Date d= new Date();
		Random r= new Random();
		int newgold = 0;
		
		
		ArrayList<String> activities = (ArrayList) session.getAttribute("activities");
		
		if(location.equals("farm")) {
			newgold= r.nextInt(11)+10;
		}
		
		if(location.equals("cave")) {
			newgold= r.nextInt(6)+5;
		}
		
		if(location.equals("house")) {
			newgold= r.nextInt(4)+2;
				
		}
		if(location.equals("casino")) {
			newgold= r.nextInt(101)-50;
					
		}
		if(location.equals("spa")) {
			newgold= r.nextInt(20)-25;
					
		}
		
		int gold= (Integer) session.getAttribute("gold");
		session.setAttribute("gold", gold+ newgold);
		
		if (newgold>0) {
			activities.add("You entered the "+ location+ " and earned " + newgold + "gold. " + d);
		}
		else {
			activities.add("You entered the "+ location+ " and lost " + newgold + "gold. " + d);
		}
	
		if ((Integer) session.getAttribute("gold")<-10) {
			return "redirect:/debtorsprison";
		}
		
		return "redirect:/";
	}
	

	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:";
		
	}
	
	@RequestMapping("/debtorsprison")
	public String prison() {

		return "prison.jsp";
		
	}

}
