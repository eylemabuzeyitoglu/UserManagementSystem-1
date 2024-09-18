package org.eylemabz;

import java.util.Scanner;

public class App {
    private static UserService userService = new UserService();
    private static Scanner sc = new Scanner(System.in);

    public static void main( String[] args ) {
        boolean exit = false;

        while(!exit){
            printMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    addUser();
                    break;
                case 2:
                    viewAllUsers();
                    break;
                case 3:
                    viewUserById();
                    break;
                case 4:
                    deleteUserById();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        }

    }

    private static void printMenu() {
        System.out.println("\n--- Kullanıcı Yönetim Sistemi ---");
        System.out.println("1. Kullanıcı Ekle");
        System.out.println("2. Tüm Kullanıcıları Görüntüle");
        System.out.println("3. ID'ye Göre Kullanıcı Görüntüle");
        System.out.println("4. Kullanıcı Sil");
        System.out.println("5. Çıkış");
        System.out.print("Seçiminizi yapın: ");
    }

    private static void addUser(){
        System.out.println("Kullanıcı ID'sini girin: ");
        long id = sc.nextLong();
        sc.nextLine();

        System.out.println("Kullanıcı adını girin: ");
        String name = sc.nextLine();

        System.out.println("Kullanıcı email'ini girin: ");
        String email = sc.nextLine();

        userService.addUser(id,name,email);
        System.out.println("Kullanıcı eklendi.");
    }


    private static void viewAllUsers() {
        System.out.println("--- Tüm Kullanıcılar ---");
        userService.getAllUsers().forEach(System.out::println);
    }


    private static void viewUserById() {
        System.out.print("Görüntülemek istediğiniz kullanıcının ID'sini girin: ");
        long id = sc.nextLong();

        User user = userService.getUserById(id);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("Kullanıcı bulunamadı.");
        }
    }

    private static void deleteUserById(){
        System.out.println("Silmek istediğiniz kullanıcın ID'sini girin");
        long id = sc.nextLong();

        userService.deleteUser(id);
        System.out.println("Kullanıcı silindi.");
    }


}



































