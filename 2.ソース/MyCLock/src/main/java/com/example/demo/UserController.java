package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("")
    public boolean create(@RequestBody String name) {
        return userMapper.create(name);
    }

    @GetMapping("")
    public List<User> read() {
        return userMapper.read();
    }

    @PatchMapping("/{id}")
    public boolean update(@PathVariable int id, @RequestBody String name) {
        return userMapper.update(id, name);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return userMapper.delete(id);
    }

}
