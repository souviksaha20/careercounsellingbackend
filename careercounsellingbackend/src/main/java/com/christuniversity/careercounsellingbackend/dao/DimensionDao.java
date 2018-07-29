package com.christuniversity.careercounsellingbackend.dao;

import java.util.List;

import com.christuniversity.careercounsellingbackend.model.Dimension;


public interface DimensionDao
{
	boolean saveorupdate(Dimension c);
	Dimension getDimensions(String id);
    boolean delete(Dimension c);
    List<Dimension> Dimensions(); 
}
