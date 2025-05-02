package edu.nure.ua.main;

import edu.nure.ua.bank.impl.BankImpl;
import edu.nure.ua.service.impl.ServiceImpl;
import edu.nure.ua.dto.BankCard;
import edu.nure.ua.dto.BankCardType;
import edu.nure.ua.dto.User;
import edu.nure.ua.service.api.Service;
import java.time.LocalDate;

public class MainApp {
    public static void main(String[] args) {
        var user = new User("John", "Doe", LocalDate.of(1990, 1, 1));
        var bank = new BankImpl();
        var creditCard = bank.createBankCard(user, BankCardType.CREDIT);
        var service = new ServiceImpl();
        service.subscribe(creditCard);

        var subscription = service.getSubscriptionByBankCardNumber(creditCard.getNumber());
        subscription.ifPresent(sub -> System.out.println("Subscription: " + sub));

        var allUsers = service.getAllUsers();
        System.out.println("All users: " + allUsers);

        System.out.println("Average age: " + service.getAverageUsersAge());

        System.out.println("Is payable: " + Service.isPayableUser(user));
    }
}