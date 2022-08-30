package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, @RequestParam String verify) {
        if (verify.equals(user.getPassword())) {
            model.addAttribute("error", false);
            return "serviceSelection";
        } else {
            model.addAttribute("error", true);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }
    }
}
