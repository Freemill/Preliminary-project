package my.sms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import my.sms.web.service.MemberService;
import my.sms.web.vo.MemberVO;

@Controller
public class HomeController {
	
	
	@Autowired MemberService memberService;
	
	
	@RequestMapping(value = "login.sms", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")			
	@ResponseBody
	public String login(HttpServletRequest request,
			HttpServletResponse response){
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");		
		
		JSONObject json=new JSONObject();
		try {
			MemberVO m=new MemberVO(id,pw); 
			String name=memberService.login(m);
			if(name!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("member", m);
			
				json.put("name", name);
				
			}else {
				json.put("msg", "로그인 실패");
			}
		}catch(Exception e) {
			json.put("msg", e.getMessage());		
		}
		return json.toJSONString();
	}
	
	
	@RequestMapping(value = "logout.sms", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")			
	@ResponseBody
	public String logout(HttpServletRequest request,
			HttpServletResponse response){
		
			HttpSession session=request.getSession(false);
			session.invalidate();
			return "";
		
	}

	 
	@RequestMapping(value = "memberInsert.sms", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")
			
	@ResponseBody
	public String memberInsert(HttpServletRequest request,
			HttpServletResponse response){
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		System.out.println("memberInsert:"+id+"\t"+pw+"\t"+name);
		
		try {
			MemberVO m=new MemberVO(id,pw,name); 
			memberService.memberInsert(m);
			return name+"님 회원가입 되셨습니다";
		}catch(Exception e) {
			return e.getMessage();
		}		
	}
}
