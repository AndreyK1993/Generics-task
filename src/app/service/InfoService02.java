package app.service;

import app.entity.Client;

import app.utils.Rounder;

import java.util.Scanner;

import java.util.InputMismatchException;

public class InfoService02 {

    Scanner scanner;
    String name;
    double amount;

    public String getData() {

        return formData(getInputs());
    }

    private Client<String, Double> getInputs() {
        scanner = new Scanner(System.in);
        // Обработка ошибок при вводе нечислового значения для суммы покупки
        try {
        System.out.print("Enter client's phone: ");
        name = scanner.nextLine();

        System.out.print("Enter client's purchase amount: ");
        amount = scanner.nextDouble();

        } catch (InputMismatchException e) {
            // В случае ошибки выводим сообщение
            System.out.println("Invalid input. Purchase amount must be a number.");
            amount = 0.0;
        }
        return new Client<>(name, amount);
    }

    private String formData(Client<String, Double> client) {
        String amountRounded = Rounder.roundValue(client.getValue());
        return "Client's phone is " + client.getKey() +
                ", purchase amount is USD " + amountRounded;
    }
}
