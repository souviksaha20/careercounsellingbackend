package com.christuniversity.careercounsellingbackend.dao;

import java.util.List;

import com.christuniversity.careercounsellingbackend.model.School;

public interface SchoolDao {
	boolean saveorupdate(School s);
	School getSchools(String id);
	boolean delete(School s);
	List<School> Schools();
}
