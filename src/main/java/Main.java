import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private NetflixData dataBase;


    public Main() {
        this.dataBase = new NetflixData();
        this.dataBase.initSeries();

    }

    public static void main(String[] args) {
        Main main=new Main();
        main.firstMenu();
    }


    public void firstMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean chooseFlag = true;
        int accountChoose = 0;
        while (chooseFlag) {
            System.out.println("Choose your option  (1 or 2) ");
            System.out.println("1. Create new account");
            System.out.println("2. Connect to existing account");
            try {
                accountChoose = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You can choose only numbers between 1-2 !!! ---> Pick again" + "\n");
                scanner.next();
            }
            if (accountChoose == 1 || accountChoose == 2)
                chooseFlag = false;
        }

        switch (accountChoose) {
            case 1:
                System.out.println("Enter your username");
                scanner.nextLine();
                String username = scanner.nextLine();
                while (this.dataBase.isAccountExist(username)){
                    System.out.println("username exist, Enter new your username");
                    username= scanner.next();
                }
                System.out.println("Choose your password");
                String password = scanner.next();
                while (!isStrongPassword(password)){
                    System.out.println("weak password ,Enter new password");
                    password= scanner.next();
                }
                System.out.println("Congratulations ,You have successfully registered");
                this.dataBase.addAccount(new Account(username,password));
            case 2:
                System.out.println("--- Hi, pls login to your account ---"+"\n");
                System.out.println("Enter username");
                String existUsername = scanner.next();
                System.out.println("Enter password");
                String existPassword = scanner.next();
                Account account = (this.dataBase.userLogin(existUsername,existPassword));
                        if (account == null) {
                            System.out.println("Wrong username or password , pls try again");
                            firstMenu();
                        }else
                    loginMenu(account);

        }
    }

    public void loginMenu(Account account) {
        System.out.println("--You've logged in successfully--");
        Scanner scanner = new Scanner(System.in);
        boolean loginFlag = true;
        boolean menuFlag =true;
        int option = 0;
        while (menuFlag) {
            while (loginFlag) {
                System.out.println("Pls choose your option ---> (1-5)");
                System.out.println("1.View all netflix series");
                System.out.println("2.View your watched series list");
                System.out.println("3.View on your account details");
                System.out.println("4.I want to watch series");
                System.out.println("5.LogOut");
                try {
                    option = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Enter numbers  only between 1 - 5 !!" + "\n");
                    scanner.next();
                }
                if (option < 6 && option > 0)
                    loginFlag = false;
            }
            loginFlag = true;
            switch (option) {
                case 1:
                    this.dataBase.printNetflixSeries();
                    break;
                case 2:
                    account.printAccountSeriesList();
                    break;
                case 3:
                    account.printAccountDetails();
                    break;
                case 4:
                    System.out.println("Enter Series name");
                    String seriesName = scanner.next();
                    Series series = this.dataBase.isSeriesExistOnNetflix(seriesName);
                    if (series == null)
                        System.out.println("Series doesn't exist in our resources");
                    else {
                        this.dataBase.printEpisodesOnSeries(series);
                        WatchedSeries ws = account.checkIfWatched(series);
                        if (ws != null) {
                            System.out.println("------------");
                            System.out.println("Last Episode you watched");
                            ws.getLastEpisode().printEpisode();
                            System.out.println("------------");
                        }
                        System.out.println("Which episode you will like to watch ?");
                        int episodeToWatch = scanner.nextInt();
                        episodeToWatch--;
                        if (episodeToWatch >= 0 && episodeToWatch < series.getEpisodes().length) {
                            account.addToWatched(series, episodeToWatch);
                            System.out.println("---Enjoy Watching---" + account.getUserName());
                        }
                    }
                    break;
                case 5:
                    System.out.println("---Good Bye---" + account.getUserName());
                    menuFlag = false;
                    break;

            }
        }
        firstMenu();
    }


        private boolean isStrongPassword (String password){
            if (password.length() < 6)
                return false;
            int countDigits = 0, countLetters = 0;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isLetter(password.charAt(i)))
                    countLetters++;
                if (Character.isDigit(password.charAt(i)))
                    countDigits++;

            }
            return (countLetters > 0 && countDigits > 0);

        }
    }








