package com.christuniversity.careercounsellingbackend.dao;

import java.util.List;

import com.christuniversity.careercounsellingbackend.model.Report;

public interface ReportDao {
	boolean saveorupdate(Report r);
	Report getReports(String id);
	boolean delete(Report r);
	List<Report> reports();

}
