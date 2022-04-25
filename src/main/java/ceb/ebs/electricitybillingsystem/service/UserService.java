package ceb.ebs.electricitybillingsystem.service;

import ceb.ebs.electricitybillingsystem.model.User;
import ceb.ebs.electricitybillingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User findUser(Long id) throws EmptyResultDataAccessException {
        Optional<User> user = userRepository.findUserById(id);
        return user.orElse(null);
    }

    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) throws EmptyResultDataAccessException {
        Optional<User> optionalUser = userRepository.findUserById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setActive(false);
            userRepository.save(user);
        } else {
            throw new EmptyResultDataAccessException(1);
        }
    }

}
