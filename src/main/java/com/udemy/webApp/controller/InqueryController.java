package com.udemy.webApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/inquery")
public class InqueryController {
	
	@GetMapping("/form")
	public String showForm(InqueryForm inqueryForm, 
			Model model,
			@ModelAttribute("complete") String complete) {
		model.addAttribute("title", "Inquery Form");
		
		
		return "inquery/form";
	}
	
	@PostMapping("/form")
	public String getForm(InqueryForm inqueryForm, Model model) {
		model.addAttribute("title", "Inquery Form");
		
		return "inquery/form";
	}	
	
	@PostMapping("/confim")
	public String confim(@Validated InqueryForm inqueryForm,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "Inquery Form");
			
			return "inquery/form";
		}
		model.addAttribute("title", "Cofim Pageだよ");
		
		return "inquery/confim";
	}
	
	@PostMapping("/complete")
	public String complete(@Validated InqueryForm inqueryForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttribute) {
		
		if(result.hasErrors()) {
			model.addAttribute("title", "Inquery Form");
			
			return "inquery/form";
		}
		
		redirectAttribute.addFlashAttribute("complete", "登録終わり！");
		
		return "redirect:/inquery/form";
	}

}
