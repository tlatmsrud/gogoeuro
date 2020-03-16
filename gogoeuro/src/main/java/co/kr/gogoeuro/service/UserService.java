package co.kr.gogoeuro.service;

import co.kr.gogoeuro.dao.JOIN;
import co.kr.gogoeuro.dao.RESULT;

public interface UserService {
	public RESULT Login(String id, String passwd, String ip);
	public RESULT ipCheck(String ip);
	public RESULT join(JOIN reqJoin);
}
