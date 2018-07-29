package com.christuniversity.careercounsellingbackend.dao;

import java.util.List;

import com.christuniversity.careercounsellingbackend.model.Subject;

public interface SubjectDao
{
	boolean saveorupdate(Subject su);
	Subject getSubjects(String id);
	boolean delete(Subject su);
	List<Subject> Subjects();

}
