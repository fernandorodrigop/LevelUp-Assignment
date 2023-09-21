package com.example.assignment.services;

import java.text.ParseException;
import java.util.Date;

public interface DateValidatorService {
    boolean isValid(String dateStr);
    Boolean expiredCard(String dateStr) throws ParseException;
}
