//package UI;
//
//import Controller.PickupSystem;
//
//import java.util.Scanner;
//
//public class LoginUI {
//
//
//    public void main(String[] args){
//        Scanner in = new Scanner (System.in);
//
//        while (true){
//            System.out.println("Enter 1 to log in, enter 2 to register, 0 to exit");
//            int option = in.nextInt();
//            if (option == 1) {
//                System.out.println("Please enter username");
//                in.nextLine();
//                String username = in.nextLine();
//                System.out.println("Please enter password");
//                String pw = in.nextLine();
//                if (PickupSystem.userLogin(username, pw)){
//                    System.out.println("Login Successful");
//                } else {
//                    System.out.println("Incorrect username or password");
//                }
//            }
//
//
//            else if (option == 2){
//                System.out.println("Please enter username");
//                in.nextLine();
//                String username = in.nextLine();
//                System.out.println("Please enter password");
//                String pw = in.nextLine();
//                if (){
//                    System.out.println("Username already exists. Please select a different username");
//                } else{
//                    /* set up a new user with username and pw
//                     ...
//                    */
//                }
//
//            }
//            else if (option == 0){
//                /* exit
//                ...
//                 */
//                break;
//            }
//        }
//    }
//}
