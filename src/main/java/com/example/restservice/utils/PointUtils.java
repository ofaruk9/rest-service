package com.example.restservice.utils;

import com.example.restservice.Customer;
import java.util.List;

public class PointUtils {

    public static Customer calculatePointsAndPrint(Customer c) {
        List<Customer> customers = c.getCustomers();
        for (Customer customer : customers) {
            System.out.println("Customer Name " + customer.getName());
            customer.getPurchases().entrySet().stream().forEach(e -> {
                        System.out.println("Month: " + e.getKey());
                        int points = e.getValue().stream().mapToInt(PointUtils::calculatePoints).sum();
                        e.getValue().clear();
                        e.getValue().add(points);
                        System.out.println("Earned points: " + points);
                    }

            );
        }
        return c;
    }

    public static int calculatePoints(int number) {
        if (number < 50) return 0;
        int points = 0;
        if (number > 100) {
            int twoPoints = number - 100;
            points += twoPoints * 2 + ((number - twoPoints - 50) * 1);
        } else if (number > 50) {
            points += (number - 50) * 1;
        }
        return points;
    }
}
