package co.dev.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.dev.beans.Login;
import co.dev.beans.User;
import co.dev.service.LoginService;
import co.dev.service.UserService;



@Controller
public class UserController {

  
   @Autowired
   	private LoginService loginService;
   @Autowired
   private UserService userService;

   
   @RequestMapping("/login")
   public ModelAndView getLogin(@ModelAttribute("login") Login login, BindingResult res)
   {
	   System.out.println("Login Page");
       return new ModelAndView("login");
	   
   }
   
   @RequestMapping("/loginAuth")
   public ModelAndView loginAuthentication(@ModelAttribute("login") Login login,
           BindingResult result) {
	   		System.out.println("User Name from  Form page: "+login.getuName()+" and password is: "+login.getPass());
	   		System.out.println("-------------------------loginService-----------------"+loginService);
	   		boolean res=loginService.userAuth(login.getuName(), login.getPass());
	   		//System.out.println("User Name from  Form page: "+login.getUName());
	   		if(res){
	   			return new ModelAndView("redirect:/userList");
	   		}
	   		else{
	   			return new ModelAndView("redirect:/failed");
	   		}

   }
 
   @RequestMapping("/failed")
   public ModelAndView userLoginFailed() {
    
	   return new ModelAndView("redirect:/login","msg","Login Failed!!!!");

   }
  
  
    @RequestMapping("/register")
    public ModelAndView getRegisterForm(@ModelAttribute("user") User user,
            BindingResult result) {

        ArrayList<String> gender = new ArrayList<String>();
        gender.add("Male");
        gender.add("Female");

        ArrayList<String> city = new ArrayList<String>();
        city.add("Delhi");
        city.add("Kolkata");
        city.add("Chennai");
        city.add("Bangalore");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("gender", gender);
        model.put("city", city);

        System.out.println("Register Form");
        return new ModelAndView("register", "model", model);

    }


    @RequestMapping("/saveUser")
    public ModelAndView saveUserData(@ModelAttribute("user") User user,
            BindingResult result) {

        userService.addUser(user);
        System.out.println("Save User Data");
        return new ModelAndView("redirect:/login");

    }


    @RequestMapping("/userList")
    public ModelAndView getUserList() {

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("user", userService.getUsers());
        return new ModelAndView("UserDetails", model);

    }

    @RequestMapping("/logout")
    public ModelAndView logout() {

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("msg", "Logged Out Successfully");
        return new ModelAndView("redirect:/login", model);

    }

    

}