package ceb.ebs.electricitybillingsystem.repository;

import ceb.ebs.electricitybillingsystem.model.PaymentMethod;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long> {

    @Query(value = "SELECT P FROM PaymentMethod P, User U where P.id = :id and U.active = true and P.active = true")
    Optional<PaymentMethod> findPaymentMethodById(Long id);

    @Query(value = "SELECT P FROM PaymentMethod P, User U where P.user.id = U.id and U.active = true and P.active = true")
    Iterable<PaymentMethod> findAll();

}
