package demoList;
import java.util.*;

class Account{
    int id;
    String ownerName;
    double balance;

    @Override
    public String toString() {
        return "Account Information [" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                ']';
    }

    public static <T> double getBalance(T t) {
        return 0;
    }

    public static <T> int getId(T t) {
        return 0;
    }
}
public class Main {
    public static void pressToContinue() {
        System.out.println("Press enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void main(String[] args) {

        int option;
        List<Account> accountList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1: Add account:");
            System.out.println("2: Remove Account: ");
            System.out.println("3. Edit Account ");
            System.out.println("4. Show account infor");
            System.out.println("5. Exit ");
            System.out.print("Choose option ( 1 - 5 ) : ");
            option  = input.nextInt();

            switch (option){
                case  1 :
                    System.out.println("|| Enter your account information ||");
                    Account acc = new Account();
                    System.out.print(" Input ID:");
                    acc.id = input.nextInt();
                    System.out.print(" Input Name:");
                    input.nextLine();
                    acc.ownerName = input.nextLine();
                    System.out.print(" Input Balance:");
                    acc.balance = input.nextInt();
                    accountList.add(acc);
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Enter  ID of the account you want to remove ->");
                    int idRemove = input.nextInt();
                    int indexRemove=-1;

                    for (int i=0;i < accountList.size();i++){
                        if (accountList.get(i).id == idRemove){
                            indexRemove=i;
                            break;
                        }
                    }

                    if (indexRemove!=-1){
                        accountList.remove(indexRemove);
                        System.out.println("====================================");
                        System.out.println("Remove Success!!");
                        System.out.println("====================================");
                    }
                    else{
                        System.out.println("=======================================================");
                        System.out.println("Account ID ="+idRemove+" not found -!-!-!");
                        System.out.println("=======================================================");

                    }
                    break;
                case 3 :
                    System.out.println();
                    System.out.print("Enter  ID of the account you want to Edit ->");
                    int idEdit = input.nextInt();
                    int indexEdit=-1;

                    for (int i=0;i < accountList.size();i++){
                        if (accountList.get(i).id == idEdit){
                            indexEdit=i;
                            break;
                        }
                    }

                    if (indexEdit!=-1){
                        Account accountEdit= accountList.get(indexEdit);
                        System.out.print("Enter New Name ->");
                        input.nextLine();
                        String newName=input.nextLine();
                        System.out.print("Enter New Balance ->");
                        double newBalance= input.nextDouble();
                        accountEdit.ownerName=newName;
                        accountEdit.balance=newBalance;
                        System.out.println("====================================");
                        System.out.println("Update Success!!");
                        System.out.println("====================================");
                    }
                    else{
                        System.out.println("=======================================================");
                        System.out.println("Account ID ="+idEdit+" not found -!-!-!");
                        System.out.println("=======================================================");

                    }
                    break;
                case 4 :
                    int showOption ;
                    System.out.println("Show account Information");
                    System.out.println("1. Ascending order (by ID )");
                    System.out.println("2. Descending order (by ID) ");
                    System.out.println("3. Descending order by balance ");
                    System.out.println("----------------------------------------");
                    System.out.print("Choose show option : ");
                    showOption =  input.nextInt();
                    System.out.println("----------------------------------------");

                    switch (showOption){
                        case 1:
                            Collections.sort(accountList, Comparator.comparingInt(a -> a.id));
                            for (Account account : accountList) {
                                System.out.println(account);
                            }
                            break;
                        case 2:
                            Collections.sort(accountList, Comparator.comparingInt(Account::getId).reversed());
                            for (Account account : accountList) {
                                System.out.println(account);
                            }
                            break;
                        case 3:
                            Collections.sort(accountList, Comparator.comparingDouble(Account::getBalance).reversed());
                            for (Account account : accountList) {
                                System.out.println(account);
                            }
                            break;
                    }
                    break;
                case 5 :
                    System.out.println("Exit the program....!");break;

            }
            System.out.println();
            pressToContinue();
        }while(option  !=5);

    }
}