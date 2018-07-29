package com.christuniversity.careercounsellingbackend.dao;

import java.util.List;

import com.christuniversity.careercounsellingbackend.model.Question;

public interface QuestionDao 
{
	boolean saveorupdate(Question c);
	Question getQuestions(String id);
    boolean delete(Question c);
    List<Question> Questions();
    List<Question> getquesbyDim(String id);
}
