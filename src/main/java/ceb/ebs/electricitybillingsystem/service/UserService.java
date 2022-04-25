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

    public User updateUser(Long id, User user) throws EmptyResultDataAccessException {
        Optional<User> optionalUser = userRepository.findUserById(id);
        if (optionalUser.isPresent()) {
            user.setId(optionalUser.get().getId());
            return userRepository.save(user);
        } else {
            throw new EmptyResultDataAccessException(1);
        }
    }

    public User findUser(Long id) throws EmptyResultDataAccessException {
        Optional<User> optionalUser = userRepository.findUserById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new EmptyResultDataAccessException(1);
        }
    }

    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    public User deleteUser(Long id) throws EmptyResultDataAccessException {
        Optional<User> optionalUser = userRepository.findUserById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setActive(false);
            return userRepository.save(user);
        } else {
            throw new EmptyResultDataAccessException(1);
        }
    }

}
