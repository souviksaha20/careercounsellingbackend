package com.christuniversity.careercounsellingbackend.dao;

import java.util.List;

import com.christuniversity.careercounsellingbackend.model.User;


public interface UserDao
{
	boolean saveorupdate(User c);
	User getUsers(String id);
    boolean delete(User c);
    List<User> Users(); 
    User isvalid(String email,String pass);
    User getUserByUniqCode(String id);
}
