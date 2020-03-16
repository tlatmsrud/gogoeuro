package co.kr.gogoeuro.mapper;

import java.util.HashMap;

import co.kr.gogoeuro.dao.JOIN;
import co.kr.gogoeuro.dao.LOGIN;

public interface UserMapper {
	public LOGIN Login(String id);
	public void LoginInfoUpdate(HashMap<String,Object> param);
	public LOGIN ipCheck(String ip);
	public int Join(JOIN reqJoin);
}
