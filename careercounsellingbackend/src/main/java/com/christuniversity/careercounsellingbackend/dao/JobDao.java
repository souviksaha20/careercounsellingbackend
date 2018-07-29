package com.christuniversity.careercounsellingbackend.dao;

import java.util.List;

import com.christuniversity.careercounsellingbackend.model.Job;

public interface JobDao
{
	boolean saveorupdate(Job j);
	Job getJobs(String id);
	boolean delete(Job j);
	List<Job> Jobs();
	boolean deleteUser_job(String x, String y);
	boolean deleteUser_job1(String x);
}
