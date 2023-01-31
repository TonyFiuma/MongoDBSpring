package co.develhope.mongoDbDemo.controllers;

import co.develhope.mongoDbDemo.entities.User;
import co.develhope.mongoDbDemo.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }
    @PutMapping("/{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        User existingUser = userService.findById(id);
        if (existingUser == null) {
            return null;
        }
        existingUser.setName(user.getName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userService.save(existingUser);
    }


    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteById(id);
    }
}
