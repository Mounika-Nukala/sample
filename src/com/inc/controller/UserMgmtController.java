package com.inc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inc.service.UserDetails;
import com.inc.service.UserMgmtService;

@Controller
public class UserMgmtController
{
	@Autowired
	private UserMgmtService userService;
	
	public UserMgmtService getUserService() {
		return userService;
	}

	public void setUserService(UserMgmtService userService) {
		this.userService = userService;
	}

	@RequestMapping("addView")
	public String returnView()
	{
		return "addUser";
	}
	
	@RequestMapping("addUser")
	public String addUser(UserDetails usdet)
	{
		System.out.println("User Controller called...!");
		if(!usdet.getLname().isEmpty() && usdet.getLname()!=null
				&&!usdet.getFname().isEmpty()&&usdet.getFname()!=null&&
				!usdet.getEmail().isEmpty()&&usdet.getEmail()!=null)
		{
		userService.addUser(usdet);
		}
		return "redirect:getAllUsers";
	}
	
	/*@RequestMapping("getAllUsers")
	public ModelAndView getAllUser(Model m)
	{
		m.addAttribute("userList", userService.getAllUsers());
		return new ModelAndView("dispAllUsers","model",m);
	}*/
	
	
	@RequestMapping(value="getAllUsers",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody List<UserDetails> getAllUser()
	{
		List<UserDetails> udlist=userService.getAllUsers();
		System.out.println(udlist.size());
		return udlist;
	}
	
	
	@RequestMapping("get")
	public ModelAndView getUserById(@RequestParam("id") int id,@ModelAttribute UserDetails usr)
	{
		System.out.println("id= "+id);
		usr=userService.getUser(id);
		return new ModelAndView("editUser","userModel",usr);
	}
	
	@RequestMapping("update")
	public String UpdateUser(UserDetails usr)
	{
		userService.UpdateUser(usr);
		return "redirect:getAllUsers";
	}
	@RequestMapping("delete")
	public String deleteUser(@RequestParam("id") int id)
	{
		userService.deleteUser(id);
		return "redirect:getAllUsers";
	}
}
