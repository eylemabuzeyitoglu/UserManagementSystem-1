package org.eylemabz;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public List<User> findAll(){
        return users;
    }

    //ID ye gore kullanıcı bulma
    public Optional<User> findById(long id){
        return users.stream().filter(user -> Objects.equals(user.getId(), id)).findFirst();
    }

    public void save(User user){
        users.add(user);
    }

    public void deleteById(long id){
        users.removeIf(user -> Objects.equals(user.getId(),id));
    }

}