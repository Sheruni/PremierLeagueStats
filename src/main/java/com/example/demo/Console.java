package com.example.demo;


import com.example.demo.model.FootballClub;
import com.example.demo.model.LeagueManager;
import com.example.demo.model.PremierLeagueManager;


import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;


public class Console{

    private final Scanner sc = new Scanner(System.in);
    private static final LeagueManager manager = new PremierLeagueManager();


    public static void main(String[] args) throws Exception {
        manager.retrieveData();  //retrieves the saved data in text file
        Console console=new Console();
        console.display();

    }

    public void display(){
        System.out.println("\nWelcome to the Premier League Manager !");
        //The welcome message will only be displayed once
        while (true) {
            displayMenu();

            while (!sc.hasNext("[12345678]")) {   // Checks for input validation
                System.out.println("That's not a valid input!");
                sc.next();
            }
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addClub();
                    break;
                case 2:
                    removeClub();
                    break;
                case 3:
                    displayStats();
                    break;
                case 4:
                    manager.displayTable();
                    break;
                case 5:
                    manager.addMatch();
                    break;
                case 6:
                    try {
                        manager.saveData("PremierLeague");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    openBackend();
                    System.out.println("GUI successfully opened on localhost:4200");
                    break;
                case 8:
                    System.out.println("Thank you for using the system!");
                    System.exit(1);
                default:
                    System.out.println("Invalid response!");
            }
        }

    }

    private void openBackend() {
        // this method opens the angular frontend webpage in browser
        String url = "http://localhost:4200";

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void displayStats() {
        System.out.println("Enter club name to display statistics: ");
        String clubName = sc.nextLine().toLowerCase();   //get input as lowercase
        manager.displayStats(clubName);
    }

    public void removeClub() {
        System.out.println("Enter club to remove :");
        String clubName = sc.nextLine().toLowerCase();
        //input is converted to lowercase
        manager.deleteClub(clubName);



    }

    public void addClub() {
        System.out.print("Enter club name : ");
        String clubName = sc.nextLine().toLowerCase();

        System.out.print("Enter club location : ");
        String location = sc.nextLine().toLowerCase();

        FootballClub fclub = new FootballClub((String) toCamelCase(clubName), (String) toCamelCase(location));
        manager.addClub(fclub);


        //Using toCamelCase method the names and locations of clubs are converted to camel case

    }


    public void displayMenu() {
        System.out.println("\nTo add new club to Premier League, press 1");
        System.out.println("To remove a club from Premier League, press 2");
        System.out.println("To print statistics of a club, press 3");
        System.out.println("To display the Premier League Table, press 4");
        System.out.println("To add a played match, press 5");
        System.out.println("To save the data, press 6");
        System.out.println("To open GUI, press 7");
        System.out.println("To exit press 8");
    }


    public Object toCamelCase(String key){
        //This is a method to convert string(name) into upperCamel case before inserting into Database

        StringBuilder name = new StringBuilder(key.length());
        for (final String word : key.split(" ")) {
            //the name is split by whitespace

            if (!word.isEmpty()) {
                //if the split part is not empty the first letter is set to capital and the rest to simple

                name.append(Character.toUpperCase(word.charAt(0)));
                name.append(word.substring(1).toLowerCase());
            }

            if (!(name.length() == key.length()))
                //if the name length is not equal to the key length a space is added to the name
                name.append(" ");
        }
        return name.toString();

    }

}
