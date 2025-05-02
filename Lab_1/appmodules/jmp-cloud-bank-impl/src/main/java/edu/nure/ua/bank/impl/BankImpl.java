package edu.nure.ua.bank.impl;

import edu.nure.api.Bank;
import edu.nure.ua.dto.BankCard;
import edu.nure.ua.dto.BankCardType;
import edu.nure.ua.dto.CreditBankCard;
import edu.nure.ua.dto.DebitBankCard;
import edu.nure.ua.dto.User;

import java.util.UUID;

public class BankImpl implements Bank {
    @Override
    public BankCard createBankCard(User user, BankCardType type) {
        String cardNumber = UUID.randomUUID().toString();
        return switch (type) {
            case CREDIT -> new CreditBankCard(cardNumber, user);
            case DEBIT -> new DebitBankCard(cardNumber, user);
            default -> throw new IllegalArgumentException("Unknown card type: " + type);
        };
    }
}