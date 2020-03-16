package co.kr.gogoeuro.serviceImpl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.gogoeuro.HomeController;
import co.kr.gogoeuro.dao.JOIN;
import co.kr.gogoeuro.dao.LOGIN;
import co.kr.gogoeuro.dao.RESULT;
import co.kr.gogoeuro.mapper.UserMapper;
import co.kr.gogoeuro.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	public UserMapper userMapper;
	
	@Override
	public RESULT Login(String id, String passwd, String ip) {
		RESULT result = new RESULT();
		// TODO Auto-generated method stub
		try{
			LOGIN loginDao = new LOGIN();
			HashMap<String,Object> param = new HashMap<String,Object>();

			loginDao = userMapper.Login(id);
			//db_passwd를 가져오지 못하면 exception 발생하여 catch로 이동
			String db_passwd = loginDao.getUserPasswd();

			if(passwd.equals(db_passwd)) {
				param.put("id",id);
				param.put("ip",ip);
				userMapper.LoginInfoUpdate(param);
				result.setResult(true);
				result.setMessage("로그인 및 최종 로그인 ip 교체");
			}else {
				result.setMessage("일치하는 아이디와 비밀번호가 없습니다.");
			}
			result.setBody(loginDao);
			
			return result;
		
		}catch(Exception e) {
			result.setMessage("일치하는 아이디와 비밀번호가 없습니다.");
			logger.error(result.getMessage());
			return result;
		}finally {
			logger.info("Login_request: id ="+id+", passwd ="+passwd);
			logger.info("Login_response: result ="+result.toString());
		}
	}

	//보류
	@Override
	public RESULT ipCheck(String ip) {
		// TODO Auto-generated method stub
		RESULT result = new RESULT();
		LOGIN loginDao = new LOGIN();
		try {
			loginDao = userMapper.ipCheck(ip);
			//해당 ip로 로그인 된 ID를 가져옴 
			String lat_id = loginDao.getUserId();
			result.setResult(true);
			//ip에 대한 로그인id가 존재할 경우
			if(!lat_id.isEmpty()) {
				result.setBody(loginDao);
			}else {
				result.setMessage("새로운 환경에서 ");
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			logger.debug("ipCheck_request: ip ="+ip);
			logger.debug("ipCheck_response: result="+result);
		}

		return result;
	}

	@Override
	public RESULT join(JOIN reqJoin) {
		// TODO Auto-generated method stub
		RESULT result = new RESULT();
		try {
			int insertResult = userMapper.Join(reqJoin);
			if(insertResult != 0) {
				result.setResult(true);
				result.setMessage("회원가입 완료");
			}else {
				result.setMessage("회원가입 오류E0");
			}
			return result;
		}catch(Exception e){
			logger.error(e.getMessage());
			result.setMessage("회원가입 오류E1");
			return result;
		}finally {
			logger.debug("join_request:"+reqJoin);
			logger.debug("join_response:"+result);
		}
	}
	
	
}
