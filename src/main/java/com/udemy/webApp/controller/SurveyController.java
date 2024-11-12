package com.udemy.webApp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.udemy.webApp.model.Survey;
import com.udemy.webApp.service.SurveyService;

@Controller
@RequestMapping("/survey")
public class SurveyController {

	@Autowired
	private SurveyService surveyService;
	
	
	@GetMapping("/form")
	public String showForm(surveyForm surveyForm,
			Model model,
			@ModelAttribute("complete") String complete) {
		model.addAttribute("title", "アンケートフォーム");
		return "/survey/form";
	}
	
	@PostMapping("/form")
	public String postForm(surveyForm surveyForm,
			Model model) {
		model.addAttribute("title", "アンケートフォーム");
		return "/survey/form";
	}
	
	@PostMapping("/confirm")
	public String showConfirm(@Validated surveyForm surveyForm,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "アンケートフォーム");
			return "/survey/form";
		}
		model.addAttribute("title", "アンケート内容の確認");
		
		return "/survey/confirm";
	}
	
	@PostMapping("/complete")
	public String registerForm(@Validated surveyForm surveyForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			model.addAttribute("title", "アンケートフォーム");
			
			return "/survey/form";
		}
		
		LocalDateTime nowDate = LocalDateTime.now();
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String formatNowDate = dtf1.format(nowDate);
		
		Survey survey = new Survey(surveyForm.getAge(),
				surveyForm.getSatisfaction(),
				surveyForm.getComment());
		surveyService.addSurvey(survey);
		redirectAttributes.addFlashAttribute("complete", "アンケートのご回答ありがとうございます♪");
		
		return "redirect:/survey/form";
	}
}
