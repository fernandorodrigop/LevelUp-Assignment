package com.example.assignment.services;

import com.example.assignment.domain.CreditCard;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;

@Service
public class CreditCardValidationServiceImpl implements CreditCardValidationService {
    @Override
    public String validateCreditCard(CreditCard creditCard) {
        String message = "";
        if(creditCard.getCvv() == null) {
            return message;
        }
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("^3[47][0-9]{0,}$");
        Matcher m = p.matcher(creditCard.getCardNumber());
        boolean b = m.matches();
        if(b){
            int cvvLength = creditCard.getCvv().length();
            if(cvvLength == 4){
               return message;
            } else {
                message = "CVV must be 4 digits on American Express Credit Cards";
            }
        }
        return message;
    }
}
