package com.christuniversity.careercounsellingbackend.dao;

import java.util.List;

import com.christuniversity.careercounsellingbackend.model.User_Strengths;

public interface User_StrengthsDao {
	boolean saveorupdate(User_Strengths x);
	User_Strengths getUser_Strengths(String id);
	boolean delete(User_Strengths x);
	List<User_Strengths> User_Strengths();
	User_Strengths getUserStrengthsByStrnUser(String id,String uid); 
	List<User_Strengths> getStrByUser(String id);
}
