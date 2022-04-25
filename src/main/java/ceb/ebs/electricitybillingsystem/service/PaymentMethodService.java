package ceb.ebs.electricitybillingsystem.service;

import ceb.ebs.electricitybillingsystem.model.PaymentMethod;
import ceb.ebs.electricitybillingsystem.model.User;
import ceb.ebs.electricitybillingsystem.repository.PaymentMethodRepository;
import ceb.ebs.electricitybillingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Objects;
import java.util.Optional;

@Service
public class PaymentMethodService {

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Autowired
    UserRepository userRepository;

    public PaymentMethod addPaymentMethod(PaymentMethod paymentMethod) throws SQLIntegrityConstraintViolationException {
        Optional<User> optionalUser = userRepository.findUserById(paymentMethod.getUser().getId());
        if (optionalUser.isPresent()) {
            return paymentMethodRepository.save(paymentMethod);
        } else {
            throw new SQLIntegrityConstraintViolationException();
        }
    }

    public PaymentMethod editPaymentMethod(Long id, PaymentMethod paymentMethod) throws EmptyResultDataAccessException, EntityNotFoundException {
        Optional<User> optionalUser = userRepository.findUserById(paymentMethod.getUser().getId());
        if (optionalUser.isPresent()) {
            Optional<PaymentMethod> optionalPaymentMethod = optionalUser
                    .get()
                    .getPaymentMethods()
                    .stream()
                    .filter(record -> Objects.equals(record.getId(), id))
                    .findFirst();
            if (optionalPaymentMethod.isPresent()) {
                paymentMethod.setId(optionalPaymentMethod.get().getId());
                return paymentMethodRepository.save(paymentMethod);
            } else {
                throw new EmptyResultDataAccessException(1);
            }
        } else {
            throw new EntityNotFoundException();
        }
    }

    public PaymentMethod findPaymentMethod(Long id) throws EmptyResultDataAccessException {
        Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findPaymentMethodById(id);
        if (optionalPaymentMethod.isPresent()) {
            return optionalPaymentMethod.get();
        } else {
            throw new EmptyResultDataAccessException(1);
        }
    }

    public Iterable<PaymentMethod> listPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    public PaymentMethod deletePaymentMethod(Long id) {
        Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findPaymentMethodById(id);
        if (optionalPaymentMethod.isPresent()) {
            PaymentMethod paymentMethod = optionalPaymentMethod.get();
            paymentMethod.setActive(false);
            return paymentMethodRepository.save(paymentMethod);
        } else {
            throw new EmptyResultDataAccessException(1);
        }
    }

}
