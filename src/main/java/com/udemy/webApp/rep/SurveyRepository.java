package com.udemy.webApp.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udemy.webApp.model.Survey;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long>{

}
