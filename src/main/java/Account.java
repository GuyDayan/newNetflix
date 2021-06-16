import java.util.Scanner;

public class Account {

    private String userName;
    private String password;
    private Date dateCreation;
    private Date dateExpired;
    private WatchedSeries[] watchedSeries;

    public Account(String userName, String password) {
        this.userName = userName;
        Scanner scanner = new Scanner(System.in);
        while (!isStrongPassword(password)) {
            System.out.println("weak password ,Enter new password");
            password = scanner.next();
        }
        this.password = password;
        this.dateCreation = new Date();
        this.dateExpired = new Date();
        this.dateExpired.setMonth(this.dateCreation.getMonth() + 1);
        this.watchedSeries = new WatchedSeries[0];
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public WatchedSeries[] getWatchedSeries() {
        return watchedSeries;
    }

    public void setWatchedSeries(WatchedSeries[] watchedSeries) {
        this.watchedSeries = watchedSeries;
    }

    private boolean isStrongPassword(String password) {
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
    public int countEpisodesWatched() {
        int episode_watched = 0;
        for (int i = 0; i < this.watchedSeries.length; i++) {
            WatchedSeries ws = this.watchedSeries[i];
            episode_watched += ws.getLast() + 1;
        }
        return  episode_watched;
    }
    public int finishedSeries() {
        int counter = 0;
        for (int i = 0; i< this.watchedSeries.length; i++) {
            WatchedSeries ws = this.watchedSeries[i];
            int len =  ws.getSeries().getEpisodes().length; // how many episode are in series
            int current_episode = ws.getLast() + 1;
            if (len == current_episode)
                counter++;
        }
        return counter;
    }
    public void printAccountSeriesList() {
        System.out.println("This is your watched series list:");
        if (this.watchedSeries.length == 0)
            System.out.println("----You didn't started to watch in any series yet---"+"\n");
        for (int i = 0; i < this.getWatchedSeries().length; i++) {
            this.getWatchedSeries()[i].print();
        }
    }
    public void printAccountDetails() {
        System.out.println("Your subscription start date --> " + this.dateCreation);
        System.out.println("Your subscription end date --> " + this.dateExpired);
        System.out.println("Your number of series you watched-->" + this.getWatchedSeries().length);
        int countSeries = finishedSeries();
        System.out.println("The number of series you have finished watching is: " + countSeries);
        int sumOfEpisodes = countEpisodesWatched();
        System.out.println("You are watched in - " + sumOfEpisodes + " - episodes in your account");
        System.out.print("-------------------------"+"\n");

    }
    public void addSeriesToAccount(Series series  , int episode) {
        WatchedSeries []new_watched_list = new WatchedSeries[this.watchedSeries.length+1];
        for (int i=0 ;i <this.watchedSeries.length;i++){
            new_watched_list[i]= this.watchedSeries[i];
        }
        WatchedSeries ws = new WatchedSeries(series , episode);
        new_watched_list[this.watchedSeries.length] = ws;
        this.watchedSeries = new_watched_list;
        this.watchedSeries[this.watchedSeries.length-1].setLastEpisode(episode);
    }
    public void addToWatched(Series series, int episode) {
        WatchedSeries s  = checkIfWatched(series);
        if (s == null) {
            addSeriesToAccount(series, episode);
            return;
        }
        updateWatched(series ,episode);

    }
    public WatchedSeries checkIfWatched(Series s) {
        for (int i = 0; i < this.watchedSeries.length; i++) {
            WatchedSeries ws = this.watchedSeries[i];
            if (ws.getSeries().getName().equals(s.getName()))
                return ws;
        }
        return null;
    }
    private void updateWatched(Series s , int episode) {
        for (int i = 0; i < this.watchedSeries.length; i++) {
            if (this.watchedSeries[i].getSeries().getName().equals(s.getName())) {
                this.watchedSeries[i].setLastEpisode(episode);
                return;
            }
        }
    }



    }




