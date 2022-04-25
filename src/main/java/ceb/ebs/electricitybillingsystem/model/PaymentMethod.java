package ceb.ebs.electricitybillingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class PaymentMethod {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "User is required")
    @JsonBackReference
    @ManyToOne
    private User user;

    @NotNull(message = "Card Number is required")
    private String cardNumber;

    @NotNull(message = "Card Holders Name is required")
    private String cardHolderName;

    @NotNull(message = "CVV is required")
    private Integer cvv;

    @NotNull(message = "Expiration date is required")
    private String expirationDate;

    private boolean active = true;

    public Long getId() {
        return id;
    }

    public PaymentMethod setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public PaymentMethod setUser(User user) {
        this.user = user;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public PaymentMethod setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public PaymentMethod setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
        return this;
    }

    public Integer getCvv() {
        return cvv;
    }

    public PaymentMethod setCvv(Integer cvv) {
        this.cvv = cvv;
        return this;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public PaymentMethod setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public boolean isActive() {
        return this.active;
    }

    public PaymentMethod setActive(boolean active) {
        this.active = active;
        return this;
    }

}
