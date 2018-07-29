package com.christuniversity.careercounsellingbackend.dao;

import java.util.List;

import com.christuniversity.careercounsellingbackend.model.Report;
import com.christuniversity.careercounsellingbackend.model.Result;

public interface ResultDao {
	boolean saveorupdate(Result r);
	Result getResults(String id);
	boolean delete(Result r);
	List<Result> results();
//	Result getResultByReport(String id);
	Result getResultByQuestion(String id);
	Result getResultByQnU(String x,String y);
	List<Result> resByDim(String id);
	List<Result> resByQue(String id);
	List<Result> resByRep(String id);
	List<Result> resByDimnRep(String dimid,String repid);
//	Report setRepo(String x,String y,String z);
}
