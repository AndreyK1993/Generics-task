package app.service;

import app.entity.Client;

import java.util.Scanner;

public class InfoService01 {

    public String getData() {
        return formData(getInputs());
    }

    private Client<String, String> getInputs() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter client's name: ");
            String name = scanner.nextLine();

            System.out.print("Enter client's email: ");
            String email = scanner.nextLine();

            return new Client<>(name, email);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid values.");
            return new Client<>("Unknown", "Unknown");
        }
    }

    private String formData(Client<String, String> client) {
        return "Client's name is " + client.getKey() +
                ", email is " + client.getValue();
    }
}
