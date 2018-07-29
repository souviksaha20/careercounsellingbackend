package com.christuniversity.careercounsellingbackend.dao;

import java.util.List;

import com.christuniversity.careercounsellingbackend.model.User_Subjects;

public interface User_SubjectsDao {
	boolean saveorupdate(User_Subjects x);
	User_Subjects getUser_Subjects(String id);
	boolean delete(User_Subjects x);
	List<User_Subjects> User_Subjects();
	User_Subjects getUserSubjectsBySubnUser(String id,String uid);
	List<User_Subjects> getSubByUser(String id);
}
