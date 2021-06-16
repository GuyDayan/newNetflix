public class NetflixData {
    Account [] accounts;
    Series [] series;

    public NetflixData() {
        this.accounts = new Account[0];
        this.series = new Series[3];
    }
    public void initSeries(){
        Date date1 = new Date(2000,5,5);
        Date date2 = new Date(2001 , 6 ,20);
        Date date3 = new Date(2001 , 7 , 6);
        Episode e1  = new Episode(1, "Episode 1 of Suits", "episode 1" , date1);
        Episode e2 = new Episode(2, "Episode 2 of Suits", "episode 2" , date2);
        Episode e3 = new Episode(3, "Episode 3 of Suits","episode 3" ,date3);
        Episode [] episodes = {e1 , e2 ,e3};
        Series suits = new Series("Suits" , episodes);
        //gambit
        Episode e21  = new Episode(1, "Episode 1 of Queen Gambit", "episode 1" , date1);
        Episode e22 = new Episode(2, "Episode 2 of Queen Gambit", "episode 2" , date2);
        Episode e23 = new Episode(3, "Episode 3 of Queen Gambit", "episode 3" , date3);
        Episode [] episodes2 = {e21 , e22 ,e23};
        Series gambit = new Series("Queen Gambit" , episodes2);
        // friends
        Episode e31  = new Episode(1, "Episode 1 of Friends", "episode 1" , date1);
        Episode e32 = new Episode(2, "Episode 2 of Friends", "episode 2" , date2);
        Episode e33 = new Episode(3, "Episode 3 of Friends", "episode 3" , date3);
        Episode [] episodes3 = {e31 , e32 ,e33};
        Series friends = new Series("Friends" , episodes3);
        this.series[0] = suits;
        this.series[1] = gambit;
        this.series[2] = friends;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Series[] getSeries() {
        return series;
    }

    public void setSeries(Series[] series) {
        this.series = series;
    }

    public boolean isAccountExist(String username){
        for (int i=0 ; i< this.accounts.length ; i++){
            if (this.accounts[i].getUserName().equals(username))
                return true;
        }
        return false;
    }
    public Account userLogin(String user, String password) {
        for (int i = 0; i < this.accounts.length;i++) {
            Account account = this.accounts[i];
            if(account.getUserName().equals(user) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }
    public void printNetflixSeries(){
        System.out.println("------Netflix Series---------");
        for (int i=0 ; i<this.series.length; i ++){
            this.series[i].print();
        }
        System.out.println("-----------------------------");
    }
    public void addAccount(Account account){
        Account[] new_accounts_list = new Account[this.accounts.length+1];
        for (int i=0;i<this.accounts.length;i++){
            new_accounts_list[i] = this.accounts[i];
        }
        new_accounts_list[this.accounts.length] = account;
        this.accounts = new_accounts_list;
    }
    public Series isSeriesExistOnNetflix(String seriesName){
        for (int i=0 ; i<this.series.length;i++){
            Series series = this.series[i];
            if (series.getName().equals(seriesName))
                return series;
        }
        return null;
    }
    public void printEpisodesOnSeries(Series series){
        for (int i =0 ; i< this.series.length ; i++){
            Series s = this.series[i];
            if (s.getName().equals(series.getName()))
                s.printEpisodesInfo();
        }
    }
}
