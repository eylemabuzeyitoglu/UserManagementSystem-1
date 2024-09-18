package org.eylemabz;

import java.util.List;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findById(id).orElse(null);
    }

    public void addUser(long id,String name,String email){
        User user = new User(id,name,email);
        userRepository.save(user);
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
}
