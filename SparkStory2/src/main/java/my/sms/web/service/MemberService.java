
package my.sms.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.sms.web.dao.MemberDAO;
import my.sms.web.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	MemberDAO memberDAO;
	
	public void memberInsert(MemberVO m) throws Exception{
		memberDAO.memberInsert(m);
	}

	public String login(MemberVO m) {
		return memberDAO.login(m);
	}
}

