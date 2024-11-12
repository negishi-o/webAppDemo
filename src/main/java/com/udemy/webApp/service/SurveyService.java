package com.udemy.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.webApp.model.Survey;
import com.udemy.webApp.rep.SurveyRepository;

@Service
public class SurveyService {
	@Autowired
	private SurveyRepository surveyRepository;
	
	public void addSurvey(Survey survey) {
		surveyRepository.save(survey);
	}
}
