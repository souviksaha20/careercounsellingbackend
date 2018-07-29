package com.christuniversity.careercounsellingbackend.dao;

import java.util.List;

import com.christuniversity.careercounsellingbackend.model.Strength;

public interface StrengthDao
{
	boolean saveorupdate(Strength s);
	Strength getStrengths(String id);
	boolean delete(Strength s);
	List<Strength> Strengths();
}
