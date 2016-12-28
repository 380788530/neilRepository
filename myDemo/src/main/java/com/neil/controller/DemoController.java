package com.neil.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neil.domain.FUsers;
import com.neil.domain.Module;
import com.neil.service.DemoService;
import com.neil.utils.Tools;


@Controller
@RequestMapping("/demoController")
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value = "/login")
	public String  login(HttpServletRequest request,HttpServletResponse response){
		
		return "page/login";
	}
	
	
	/**   
	*******************************************************************
	*<p><b>登录成功进入该页面</b><br/>
	*<p><b>备注：</b><br/>
	*******************************************************************
	* @Title:  
	* @Description: TODO(这里用一句话描述这个方法的作用)    
	* @param @return    设定文件    
	* @return String    返回类型  
	* @author lizhiyong 
	* @date 2016-11-5 下午2:32:37
	* @throws     
	*/
	@RequestMapping(value = "/index")
	public String  index(HttpServletRequest request,HttpServletResponse response){
		
		List<Module>  moduleList = 	demoService.queryModuleAll();
		
		request.setAttribute("moduleList", moduleList);
		return "page/index";
	}
	
	
	
	/**   
	*******************************************************************
	*<p><b>用户管理</b><br/>
	*<p><b>备注：</b><br/>
	*******************************************************************
	* @Title:  
	* @Description: TODO(这里用一句话描述这个方法的作用)    
	* @param @return    设定文件    
	* @return String    返回类型  
	* @author lizhiyong 
	* @date 2016-11-5 下午4:00:25
	* @throws     
	*/
	@RequestMapping(value = "/userIndex")
	public String  userIndex(HttpServletRequest request,HttpServletResponse response){
		
//		List<FUsers>  fUsersList = 	demoService.queryFuserAll();
//		
//		request.setAttribute("fUsersList", fUsersList);
		return "page/userIndex";
	}
	
	@ResponseBody
	@RequestMapping(value = "/userData")
	public String  userData(HttpServletRequest request,HttpServletResponse response){
		
		List<FUsers>  fUsersList = 	demoService.queryFuserAll();
		
		System.out.println("{\"data\":"+fUsersList.toString()+"}");
		return "{\"data\":"+fUsersList.toString()+"}";
	}

}
