package UI;

import java.util.Scanner;

public class OperationUI {


    public void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("Enter 1 to Deposit a Package, Enter 2 to Extract a Package, Enter 0 to Logout");

            int option = in.nextInt();
            if (option == 1) {
                System.out.println("Please enter the Package ID:");
                in.nextLine();
                String id = in.nextLine();
                System.out.println("Please scan for item info");
                /* ...Read? Next line is a default input, not as described
                 */
                String itemInfo = in.nextLine();
                /* Operations
                i.e create new item item
                 */
                System.out.println("Does this package require special locker?");
                System.out.println("Enter L for regular locker, F for freezer, R for refrigerator");
                String locker = in.nextLine();
                if (locker.equals("L")){
                    /* Put the item in the locker
                     */
                    System.out.println("Please depose the package in slot: " + additem(item));
                }
                else if (locker.equals("F")){
                    /* Put the item in the freeezer
                     */
                    System.out.println("Please depose the package in slot: " + additem(item));
                }
                else if (locker.equals("R")){
                    /* Put the item in the refrigerator
                     */
                    System.out.println("Please depose the package in slot: " + additem(item));
                }

            }
            else if (option == 2){
                System.out.println("Please enter the Package ID:");
                in.nextLine();
                String id = in.nextLine();


            }
            else if (option == 0) {
                /* Exit the programm

                 */
                break;
            }

        }
    }
}