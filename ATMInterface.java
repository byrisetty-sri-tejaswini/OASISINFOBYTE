import java.util.Scanner;

public class ATMInterface {
    private static int balance = 1000; // Initial balance

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Check Balance"+"\t"+"2. Deposit"+"\t"+"3. Withdraw"+"\t"+"4. Exit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(sc);
                    break;
                case 3:
                    withdraw(sc);
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        sc.close();
    }

    private static void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    private static void deposit(Scanner sc) {
        System.out.print("Enter the amount to deposit: $");
        double amount = sc.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " successfully.");
        } else {
            System.out.println("Invalid amount. Please enter a positive amount.");
        }
    }

    private static void withdraw(Scanner sc) {
        System.out.print("Enter the amount to withdraw: $");
        double amount = sc.nextDouble();
	if((balance-amount)>=1000)
      {
        if (amount > 0 && amount <= balance) 
	{
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " successfully.");
        } 
      }
      else
      {
	    System.out.println("Sorry Insufficient Funds");
      }
    }
}
