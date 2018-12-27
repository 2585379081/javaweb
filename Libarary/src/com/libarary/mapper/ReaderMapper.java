package com.libarary.mapper;

import java.util.*;
import com.libarary.model.*;
import com.libarary.po.*;

public interface ReaderMapper{
	
	public String loginCheck(String rdID) throws Exception;
	public List<Reader> queryReader(QueryCondition qc) throws Exception;
	public Reader noOfReader(String rdID) throws Exception;
	public void insertReader(Reader reader) throws Exception;
	public void updateReader(Reader reader) throws Exception;
	public void updateByID(Reader reader) throws Exception;
	public void changeLevel(Reader reader) throws Exception;
	public void deleteById(int rdID) throws Exception;
}
