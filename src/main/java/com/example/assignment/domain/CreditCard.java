package com.example.assignment.domain;

import com.example.assignment.SingleCreditCardMessageValidation;
import com.example.assignment.SingleMessageValidation;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {

    @SingleCreditCardMessageValidation(message = "Invalid Credit Card Number")
    private String cardNumber;

    private String expiryDateCardText;

    @NotNull(message = "CVV can't be empty")
    @Size(min = 3, max = 4, message = "CVV must be 3 or 4 digits long")
    private String cvv;

    @SingleMessageValidation(message = "First name is mandatory")
    private String firstNameCard;

    @SingleMessageValidation(message = "Last name is mandatory")
    private String lastNameCard;

}
