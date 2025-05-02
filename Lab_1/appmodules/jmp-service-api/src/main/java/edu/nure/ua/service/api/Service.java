package edu.nure.ua.service.api;

import edu.nure.ua.dto.BankCard;
import edu.nure.ua.dto.Subscription;
import edu.nure.ua.dto.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.time.temporal.ChronoUnit;

public interface Service {
    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);
    List<User> getAllUsers();

    default double getAverageUsersAge() {
        return getAllUsers().stream()
                .mapToLong(user -> ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()))
                .average()
                .orElse(0.0);
    }

    static boolean isPayableUser(User user) {
        return ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()) >= 18;
    }
}