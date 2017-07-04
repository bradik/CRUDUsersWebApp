package com.bradik.webapp.web;

import com.bradik.webapp.model.User;
import com.bradik.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Brad on 30.06.2017.
 */

@RestController
@RequestMapping("/rest")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/users",method= RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value="/users/{id}",method=RequestMethod.GET)
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @RequestMapping(value="/users",method=RequestMethod.POST)
    @ResponseStatus(code= HttpStatus.CREATED)
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @RequestMapping(value="/users",method=RequestMethod.PUT)
    @ResponseStatus(code=HttpStatus.OK)
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @RequestMapping(value="/users/{id}",method=RequestMethod.DELETE)
    @ResponseStatus(code=HttpStatus.OK)
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

}
