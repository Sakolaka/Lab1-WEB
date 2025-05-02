package edu.nure.api;

import edu.nure.ua.dto.BankCard;
import edu.nure.ua.dto.BankCardType;
import edu.nure.ua.dto.User;

public interface Bank {
    BankCard createBankCard(User user, BankCardType type);
}