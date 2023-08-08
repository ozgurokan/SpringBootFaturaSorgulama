package com.ozgurokan.fatura.controller;



import com.ozgurokan.fatura.entity.User;
import com.ozgurokan.fatura.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService theUserService){
        userService = theUserService;
    }

    @GetMapping("/list")
    public String listUsers(Model theModel){
        List<User> theUsers = userService.findAll();

        theModel.addAttribute("users", theUsers);

        return "users/list-users";
    }


    @GetMapping("/showFormForAdd")
    public String showFromForAdd(Model theModel) {
        // create model attribute to bind form data
        User theUser = new User();

        theModel.addAttribute("user", theUser);

        return "users/form-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User theUser) {
        // save the user
        userService.save(theUser);

        return "redirect:/users/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theId,Model theModel){

        // spring will update automatically
        User theUser = userService.findById(theId);

        theModel.addAttribute("user",theUser);

        return "users/form-user";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int theId){
        userService.deleteById(theId);

        return "redirect:/users/list";
    }





}
