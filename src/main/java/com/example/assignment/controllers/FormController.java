package com.example.assignment.controllers;

import com.example.assignment.domain.CreditCard;
import com.example.assignment.services.CreditCardValidationServiceImpl;
import com.example.assignment.services.DateValidatorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class FormController {
    @Autowired
    CreditCardValidationServiceImpl validationService;

    @Autowired
    DateValidatorServiceImpl dateValidatorService;

    @GetMapping("/")
    public String getForm(CreditCard creditCard){
        return "form";
    }

    @PostMapping("/")
    public String form(@Valid CreditCard creditCard, BindingResult errors, Model model) throws ParseException {
        String err = validationService.validateCreditCard(creditCard);
        if(!err.isEmpty()){
            ObjectError error = new ObjectError("globalError", err);
            errors.addError(error);
        }
        if(!dateValidatorService.isValid(creditCard.getExpiryDateCardText())){
            FieldError error = new FieldError("expiryDateCardText", "expiryDateCardText", "Invalid Expiration Date");
            errors.addError(error);
        } else if(dateValidatorService.expiredCard(creditCard.getExpiryDateCardText())) {
            FieldError error = new FieldError("expiryDateCardText", "expiryDateCardText", "Card Expiration Date can't be in the past");
            errors.addError(error);
        }

        if (errors.hasErrors()) {
            return "form";
        } else {
            model.addAttribute("message", "Credit Card Verification was successful...");
            return "form";
        }
    }

}
