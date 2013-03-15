package com.sandbox.spring.models;

import java.util.List;

public interface IModel<T> {
	
	T getById(int id);
	T save(T Domaindata);
	void delete();
	List<T> getAll();
}
