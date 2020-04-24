package integration.sf.mag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import integration.sf.mag.model.User;
import integration.sf.mag.repository.UserRepository;


@RestController
@CrossOrigin
@RequestMapping("/users")
public class ApiUserController {
 
    @Autowired
    private UserRepository userRepository;
 
    @PostMapping
    public User save(@RequestBody User user){
        userRepository.save(user);
        return user;
    }
 
    @GetMapping
    public List list(){
        return userRepository.findAll();
    }
 
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return userRepository.findById(id);
    }
 
    @PutMapping
    public User update(@RequestBody User user){
        userRepository.update(user);
        return user;
    }
 
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userRepository.delete(id);
        return id;
    }
 
}
