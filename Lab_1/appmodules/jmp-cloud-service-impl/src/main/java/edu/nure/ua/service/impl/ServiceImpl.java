package edu.nure.ua.service.impl;

import edu.nure.ua.dto.BankCard;
import edu.nure.ua.dto.Subscription;
import edu.nure.ua.dto.User;
import edu.nure.ua.service.api.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceImpl implements Service {
    private final Map<String, Subscription> subscriptions = new HashMap<>();
    private final List<User> users = new ArrayList<>();

    @Override
    public void subscribe(BankCard bankCard) {
        var subscription = new Subscription(bankCard.getNumber(), LocalDate.now());
        subscriptions.put(bankCard.getNumber(), subscription);
        if (!users.contains(bankCard.getUser())) {
            users.add(bankCard.getUser());
        }
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
        return Optional.ofNullable(subscriptions.get(cardNumber));
    }



    @Override
    public List<User> getAllUsers() {
        return users.stream()
                .collect(Collectors.toUnmodifiableList());
    }
}