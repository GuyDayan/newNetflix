import java.rmi.ServerError;
import java.util.Scanner;

public class Account {
    private String user_name;
    private String password;
    private Date creation_date;
    private Date expiretion_date;
    private WatchedSeries[] mySeries;
    private int watched_index;

    public Account(String user_name, String password, Date creation, Date expire) {
        this.user_name = user_name;
        this.creation_date = creation;
        this.expiretion_date = expire;
        Scanner scanner = new Scanner(System.in);
        this.password = password;
        this.mySeries = new WatchedSeries[Netflix.MAX];
        watched_index = -1;
        while(!isStrongPassword(this.password)) {
            System.out.println("Enter Strong Password (at least 6 digits  one char , one alphabetic digit");
            this.password = scanner.nextLine();
        }
    }

    private boolean isStrongPassword(String password) {
        if(password.length() < 6)
            return false;
        char[] pass  = password.toCharArray();
        int dig_count = 0 , char_count = 0;
        for(int i = 0; i < password.length(); i++) {
            if (Character.isDigit(pass[i]))
                dig_count++;
            if (Character.isAlphabetic(pass[i]))
                char_count++;
        }
        return (dig_count > 0 && char_count > 0);
    }
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getExpiretion_date() {
        return expiretion_date;
    }

    public WatchedSeries[] getMySeries() {
        return mySeries;
    }

    public void setExpiretion_date(Date expiretion_date) {
        this.expiretion_date = expiretion_date;
    }

    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }
    public void printDates() {
        System.out.print("Account creation date: ");
        this.creation_date.print();
        System.out.print("Account expiration date: ");
        this.expiretion_date.print();
    }
    public int countWatchedSeries() {
        return this.watched_index + 1;
    }
    public int countEpisodesWatched() {
        int episode_watched = 0;
        for (int i = 0; i <= watched_index; i++) {
            WatchedSeries ws = this.mySeries[i];
            episode_watched += ws.getLast() + 1;
        }
        return  episode_watched;
    }
    public int finishedSeries() {
        int counter = 0;
        for (int i = 0; i<= watched_index; i++) {
            WatchedSeries ws = this.mySeries[i];
            int len =  ws.getSeries().getEpisodes().length; // how many episode are in series
            int current_episode = ws.getLast() + 1;
            if (len == current_episode)
                counter++;
        }
        return counter;
    }
    public WatchedSeries checkIfWatched(Series s) {
        for (int i = 0; i <= watched_index; i++) {
            WatchedSeries ws = this.mySeries[i];
            if (ws.getSeries().getName().equals(s.getName()))
                return ws;
        }
        return null;
    }
    public void addToWatched(Series series, int episode) {
        WatchedSeries s  = checkIfWatched(series);
        if (s != null) {
            updateWatched(series, episode);
            return;
        }
        watched_index++;
        mySeries[watched_index] = new WatchedSeries(series, episode);
    }
    private void updateWatched(Series s , int episode) {
        for (int i = 0; i <= this.watched_index; i++) {
            if (mySeries[i].getSeries().getName().equals(s.getName())) {
                mySeries[i].setLastEpisode(episode);
                return;
            }
        }
    }


}
