package ATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Postavite PIN i početni saldo
        String pin = "1234";
        double initialBalance = 1000.0;

        // Inicijalizirajte ATM
        ATM atm = new ATM(pin, initialBalance);

        // Simulirajte unos PIN-a
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (atm.validatePin(enteredPin)) {
            // Ako je PIN ispravan, omogućite transakcije
            System.out.println("Welcome to the ATM!");
            while (true) {
                System.out.println("Options:");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Exit");
                System.out.print("Enter option: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        double balance = atm.checkBalance();
                        System.out.println("Current balance: $" + balance);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM!");
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        } else {
            System.out.println("Invalid PIN. Exiting...");
        }

        scanner.close();
    }
}
