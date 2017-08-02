package com.ssm.controller;

import com.ssm.dto.User;
import com.ssm.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/userList")
    public String userList(HttpServletRequest request, Model model) {
        List<User> uList = userService.getAllUser();
        model.addAttribute("uList", uList);
        return "userList";
    }

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "showUser";
    }

    @RequestMapping("/addUserUI")
    public String addUserUI() {
        return "addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(HttpServletRequest request, Model model) {
        User user = new User();
        user.setName(String.valueOf(request.getParameter("name")));
        user.setPassword(String.valueOf(request.getParameter("password")));
        userService.addUser(user);
        return "redirect:/user/userList";
    }

    @RequestMapping("/testContrller")
    @ResponseBody
    public String testContrller(HttpServletRequest request, String username, String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        userService.addUser(user);
        return "成功";
    }

    @RequestMapping("/loginContrller")
    public String loginContrller(String username, String password, Model model) {
        User user = userService.getUserByName(username);
        String message = null;
        if (user != null) {
            if (user.getPassword().equals(password)) {
                model.addAttribute("name", username);
                return "index";
            } else {
                message = "密码错误";
            }
        } else {
            message = "该用户还未注册";
        }
        model.addAttribute("message", message);
        return "error";

    }
}