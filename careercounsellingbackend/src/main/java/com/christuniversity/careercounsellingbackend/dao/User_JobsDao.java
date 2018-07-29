package com.christuniversity.careercounsellingbackend.dao;

import java.util.List;

import com.christuniversity.careercounsellingbackend.model.User_Jobs;

public interface User_JobsDao {
	boolean saveorupdate(User_Jobs x);
	User_Jobs getUser_Jobs(String id);
	boolean delete(User_Jobs x);
	List<User_Jobs> User_Jobs();
	User_Jobs getUserJobsByJobnUser(String id,String uid);
	List<User_Jobs> getJobsByUser(String id);
}
