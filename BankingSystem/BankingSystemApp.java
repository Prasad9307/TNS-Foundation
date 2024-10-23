import java.util.Scanner;

public class BankingSystemApp {
    public static void main(String[] args) {
        BankingServiceImpl bankingService = new BankingServiceImpl();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Banking System");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Account");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Add Transaction");
            System.out.println("5. Find Customer by ID");
            System.out.println("6. List all Accounts of a Customer");
            System.out.println("7. List all Transactions of an Account");
            System.out.println("8. List all Beneficiaries of a Customer");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int customerID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();
                    bankingService.addCustomer(new Customer(customerID, name, address, contact));
                    break;

                case 2:
                    System.out.print("Enter Account ID: ");
                    int accountID = scanner.nextInt();
                    System.out.print("Enter Customer ID: ");
                    int accCustomerID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Account Type (Saving/Current): ");
                    String accountType = scanner.nextLine();
                    System.out.print("Enter Balance: ");
                    double balance = scanner.nextDouble();
                    bankingService.addAccount(new Account(accountID, accCustomerID, accountType, balance));
                    break;

                case 3:
                    System.out.print("Enter Beneficiary ID: ");
                    int beneficiaryID = scanner.nextInt();
                    System.out.print("Enter Customer ID: ");
                    int benCustomerID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Beneficiary Name: ");
                    String beneficiaryName = scanner.nextLine();
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter Bank Details: ");
                    String bankDetails = scanner.nextLine();
                    bankingService.addBeneficiary(new Beneficiary(beneficiaryID, benCustomerID, beneficiaryName, accountNumber, bankDetails));
                    break;

                case 4:
                    System.out.print("Enter Transaction ID: ");
                    int transactionID = scanner.nextInt();
                    System.out.print("Enter Account ID: ");
                    int transAccountID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Type (Deposit/Withdrawal): ");
                    String transactionType = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    bankingService.addTransaction(new Transaction(transactionID, transAccountID, transactionType, amount));
                    break;

                case 5:
                    System.out.print("Enter Customer ID: ");
                    int custId = scanner.nextInt();
                    System.out.println(bankingService.findCustomerById(custId));
                    break;

                case 6:
                    System.out.print("Enter Customer ID: ");
                    int customerForAccounts = scanner.nextInt();
                    System.out.println(bankingService.getAccountsByCustomerId(customerForAccounts));
                    break;

                case 7:
                    System.out.print("Enter Account ID: ");
                    int accId = scanner.nextInt();
                    System.out.println(bankingService.getTransactionsByAccountId(accId));
                    break;

                case 8:
                    System.out.print("Enter Customer ID: ");
                    int customerForBeneficiaries = scanner.nextInt();
                    System.out.println(bankingService.getBeneficiariesByCustomerId(customerForBeneficiaries));
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
