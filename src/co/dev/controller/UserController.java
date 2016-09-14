package co.dev.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import co.dev.beans.Login;
import co.dev.beans.RegisterUser;
import co.dev.beans.User;
import co.dev.service.LoginService;
import co.dev.service.UserService;
import co.dev.validator.FormValidation;

@Controller
public class UserController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private UserService userService;

	@Autowired
	private FormValidation formValidators;

	@RequestMapping("/login")
	public ModelAndView getLogin(@ModelAttribute("login") Login login,
			BindingResult res) {
		System.out.println("Login Page");
		return new ModelAndView("login");

	}

	@RequestMapping("/loginAuth")
	public ModelAndView loginAuthentication(
			@ModelAttribute("login") Login login, BindingResult result) {
		System.out.println("User Name from  Form page: " + login.getuName()
				+ " and password is: " + login.getPass());
		System.out
				.println("-------------------------loginService-----------------"
						+ loginService);
		boolean res = loginService.userAuth(login.getuName(), login.getPass());
		// System.out.println("User Name from  Form page: "+login.getUName());

		if (res) {

			return new ModelAndView("redirect:/userList");

		} else {
			return new ModelAndView("redirect:/failed");
		}

	}

	@RequestMapping("/failed")
	public ModelAndView userLoginFailed(@ModelAttribute("login") Login login) {

		return new ModelAndView("login", "msg", "Login Failed!!!!");

	}

	@RequestMapping("/userRegistration")
	public ModelAndView getRegisterForm(
			@ModelAttribute("regUser") RegisterUser regUser,
			BindingResult result) {

		ArrayList<String> gender = new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("gender", gender);
		// model.put("city", city);

		System.out.println("Register Form");
		return new ModelAndView("register", "model", model);

	}

	@RequestMapping("/registerUser")
	public ModelAndView registerUser(
			@ModelAttribute("regUser") RegisterUser regUser,
			BindingResult result) {

		 ArrayList<String> gender = new ArrayList<String>();
		 gender.add("Male");
		 gender.add("Female");
		
		 Map<String, Object> model = new HashMap<String, Object>();
		 model.put("gender", gender);
		
		 formValidators.validate(regUser, result);
		
		 if (result.hasErrors()) {
		
		   return new ModelAndView("register","model",model);
		 }
		String pass=regUser.getPassword();
		
        regUser.setPassword("************");
		loginService.registerUser(regUser);

		int a = loginService.activateUser(regUser.getEmail(),pass);
		System.out.println("User Created Successfully!!!!");

		return new ModelAndView("redirect:/login");

	}

	@RequestMapping("/addUser")
	public ModelAndView addUserPage(@ModelAttribute("user") User user,
			BindingResult result) {

		ArrayList<String> gender = new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		ArrayList<String> city = new ArrayList<String>();
		city.add("Select");
		city.add("Delhi");
		city.add("Kolkata");
		city.add("Chennai");
		city.add("Bangalore");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("gender", gender);
		model.put("city", city);

		System.out.println("Register Form");
		return new ModelAndView("addUser", "model", model);



	}
	@RequestMapping("/saveUser")
	public ModelAndView saveUserData(
			@ModelAttribute("user") User user,
			BindingResult result) {

		ArrayList<String> gender = new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		ArrayList<String> city = new ArrayList<String>();
		city.add("Select");
		city.add("Delhi");
		city.add("Kolkata");
		city.add("Chennai");
		city.add("Bangalore");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("gender", gender);
		model.put("city", city);
		
		 formValidators.validateUser(user, result);
		
		 if (result.hasErrors()) {
		
		 return new ModelAndView("addUser","model",model);
		 }

		userService.addUser(user);

	
		System.out.println("User Added Successfully!!!!");

		return new ModelAndView("redirect:/userList");

	}

	@RequestMapping("/edit/updateUser")
	public ModelAndView updateUserData(@ModelAttribute("user") User user,
			BindingResult result) {

		userService.editUser(user);
		System.out.println("Updated User Data Successfully");
		return new ModelAndView("redirect:/userList");

	}

	@RequestMapping("/userList")
	public ModelAndView getUserList() {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", userService.getUsers());
		return new ModelAndView("UserDetails", model);

	}

	@RequestMapping("/delete/{id}")
	public ModelAndView deleteUser(@PathVariable int id) {

		userService.deleteUser(id);

		return new ModelAndView("redirect:/userList");

	}

	@RequestMapping("/logout")
	public ModelAndView invalidaUser(HttpSession session) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("msg", "Logged Out Successfully");
		session.invalidate();
		return new ModelAndView("redirect:/login", model);

	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editUser(@PathVariable int id,
			@ModelAttribute("users") User users) {
		Map<String, Object> user = new HashMap<String, Object>();
		// user=userService.getUserById(id);
		user.put("user", userService.getUserById(id));
		return new ModelAndView("success", user);

	}

}