package com.libarary.mapper;


import java.util.List;

import com.libarary.model.Borrow;
import com.libarary.po.BookInfo;
import com.libarary.po.LendVo;
import com.libarary.po.ReaderInfo;
import com.libarary.po.ReturnVo;

public interface BorrowMapper {
	public  ReaderInfo queryReaderVo(int rdID) throws Exception;
	public int queryLendedNum(int rdID) throws Exception;
	public List<BookInfo> queryBookVo(int bkID) throws Exception;
	public void returnBook(ReturnVo returnVo) throws Exception;
	public void lendBook(LendVo lendVo) throws Exception;
	public Borrow queryBorrow(LendVo lendvo) throws Exception;
	public void contitueLend(LendVo lendVo) throws Exception;
	public void updateBorrow(ReturnVo returnVo ) throws Exception;

}
