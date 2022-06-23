package com.makeev.mvchibernate.controllers;


import com.makeev.mvchibernate.model.User;
import com.makeev.mvchibernate.service.UserService;
import com.makeev.mvchibernate.service.UserServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@NoArgsConstructor
@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/users/index";
    }

    @GetMapping("/new")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new User());
        return "/users/newUser";
    }

    @GetMapping("/details/{id}")
    public String showUserDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/users/userDetails";
    }

    @GetMapping("/showEdit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/users/edit";
    }

    @PostMapping("/create")
    public String crateUserFromForm(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) { // get ready person from view
            // in case bad validation:
        if (bindingResult.hasErrors()) { return "/users/newUser"; }
        userService.add(user);
        return "redirect:/users"; // go to /users
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/edit";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}
