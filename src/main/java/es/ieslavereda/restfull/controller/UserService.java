package es.ieslavereda.restfull.controller;

import es.ieslavereda.restfull.model.User;
import es.ieslavereda.restfull.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*public User create(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User change(User user) {
        return userRepository.save(user);
    }

    public boolean remove(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }*/
    public User find(long id) {
        return userRepository.findById(id);
    }

    public boolean remove(long id){
        return userRepository.remove(id);
    }
}
