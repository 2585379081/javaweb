package com.libarary.mapper;

import com.libarary.model.ReaderType;

public interface ReaderTypeMapper {
	public int noOfName(String name) throws Exception;
	public int noOfCanContitueTimes(int rdID) throws Exception;
	public ReaderType rdIDofReaderType(int rdID) throws Exception;

}
