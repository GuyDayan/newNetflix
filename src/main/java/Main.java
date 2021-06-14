
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // rick and morty
        Episode e1  = new Episode("Episode 1", "Episode 1 of rick and morty", new Date(22,6,2000));
        Episode e2 = new Episode("Episode 2", "Episode 2 of rick and morty", new Date(23,6,2000));
        Episode e3 = new Episode("Episode 3", "Episode 3 of rick and morty", new Date(24,6,2000));
        Episode [] episodes = {e1 , e2 ,e3};
        Series rick_and_morty = new Series("Rick and Morty" , episodes);
        //gambit
        Episode e21  = new Episode("Episode 1", "Episode 1 of Queen Gambit", new Date(22,6,2000));
        Episode e22 = new Episode("Episode 2", "Episode 2 of Queen Gambit", new Date(23,6,2000));
        Episode e23 = new Episode("Episode 3", "Episode 3 of Queen Gambit", new Date(24,6,2000));
        Episode [] episodes2 = {e21 , e22 ,e23};
        Series gambit = new Series("Queen Gambit" , episodes2);
        // friends
        Episode e31  = new Episode("Episode 1", "Episode 1 of Friends", new Date(22,6,2000));
        Episode e32 = new Episode("Episode 2", "Episode 2 of Friends", new Date(23,6,2000));
        Episode e33 = new Episode("Episode 3", "Episode 3 of Friends", new Date(24,6,2000));
        Episode [] episodes3 = {e31 , e32 ,e33};
        Series friends = new Series("Friends" , episodes3);
        Netflix netflix = new Netflix(new Series[]{rick_and_morty, gambit, friends});
        showMainMenu(netflix);

    }
    public static void showMainMenu(Netflix netflix) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Create account\n" + "2.Login into existing account");
            int option = scanner.nextInt();
            if (option == 1) {
                System.out.println("------SIGN UP----");
                System.out.print("Enter username :");
                scanner.nextLine();
                String user_name = scanner.nextLine();
                while (netflix.isUserExist(user_name)) {
                    System.out.println("user name already exist , pick again");
                    user_name = scanner.nextLine();
                }
                System.out.println("Enter password( at least 6 character; include at least one digit and one alphabetic character");
                String pass = scanner.nextLine();
                Date createDate = Date.getCurrentDate();
                Date endDate = new Date(createDate.getDay(), createDate.getMonth() + 1, createDate.getYear());
                Account newAcc = new Account(user_name, pass, createDate, endDate);
                netflix.addAccount(newAcc);
            } else if (option == 2) {
                Account account = userLogin(netflix);
                if (account != null) {
                    boolean is_logged_in = true;
                    WatchedSeries[] ws = account.getMySeries();
                    while (is_logged_in) {
                        int user_option = UserMenu();
                        switch (user_option) {
                            case 1:
                                System.out.println("================");
                                netflix.printSeries();
                                System.out.println("================");
                                break;
                            case 2:
                                for (int i = 0; i < ws.length; i++) {
                                    if (ws[i] != null) {
                                        System.out.println("================");
                                        ws[i].print();
                                        System.out.println("================");
                                    }
                                }
                                System.out.println("You didn't start to watch series yet");
                                break;
                            case 3:
                                System.out.println("================");
                                account.printDates();
                                System.out.println("Series started watching : " + account.countWatchedSeries());
                                System.out.println("Total episodes watched : " + account.countEpisodesWatched());
                                System.out.println("Total finished series : " + account.finishedSeries());
                                System.out.println("================");
                                break;
                            case 4:
                                System.out.println("Enter series name you would like to watch");
                                scanner.nextLine();
                                String s_name = scanner.nextLine();
                                Series ser = netflix.isSeriesExist(s_name);
                                if (ser == null) {
                                    System.out.println("Series not found");
                                    break;
                                }
                                ser.printEpisodesInfo();
                                WatchedSeries wss  = account.checkIfWatched(ser);
                                if (wss != null) {
                                    System.out.println("------------");
                                    System.out.println("Last Episode you watched");
                                    wss.getLastEpisode().printInfo();
                                    System.out.println("------------");
                                }
                                System.out.println("Pick episode you would like to watch : ");
                                int episode = scanner.nextInt();
                                episode--;
                                if (episode >=0 && episode < ser.getEpisodes().length) {
                                    account.addToWatched(ser, episode);
                                    System.out.println("Enjoy Watch");
                                }
                                break;
                            case 5:
                                System.out.println("-------LOGOUT-------");
                                is_logged_in = false;
                                break;
                        }

                    }

                }
            }
            else break;
        }
        System.out.println("GOOD BYE");
    }
    public static Account userLogin(Netflix netflix) {
        // login
        Scanner scanner = new Scanner(System.in);
        // login
        System.out.println("LOGIN");
        System.out.println("Enter user name :");

        String user_name = scanner.nextLine();
        if (!netflix.isUserExist(user_name)) {
            System.out.println("User name does not exist");
            System.out.println("return to main menu");
            return null;
        }
        System.out.println("Enter password :");
        String password = scanner.nextLine();
        Account account = netflix.UserLogin(user_name, password);
        if (account == null) {
            System.out.println("Wrong password....");
            System.out.println("return to main menu");
        }
        return account;
    }
    public static int UserMenu() {
        Scanner scanner = new Scanner(System.in);
        int opt;
        System.out.println("1. View the list of all series");
        System.out.println("2. View the list of series you started watching");
        System.out.println("3. View subscription details");
        System.out.println("4. Select a series to watch");
        System.out.println("5. Log out.\"\"\");");
        while(true) {
            opt = scanner.nextInt();
            if (opt >= 0 && opt <=5) {
                break;
            }
            else {
                System.out.println("error");
            }
        }
        return opt;
    }


}
