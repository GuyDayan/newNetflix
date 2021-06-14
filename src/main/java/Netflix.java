public class Netflix {
    private Series[] series;
    private Account[] accounts;
    private int lastIndex;
    public static final int MAX = 30;

    public Netflix(Series[] series) {
        this.accounts = new Account[MAX];
        this.series = series;
        this.lastIndex = 0;
    }
    public void addAccount(Account account) {
        this.accounts[lastIndex] = account;
        this.lastIndex++;

    }
    public Series[] getSeries() {
        return series;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public boolean isUserExist(String user_name) {
        for (int i = 0 ; i < this.lastIndex; i++) {
            if(this.accounts[i].getUser_name().equals(user_name))
                return true;
        }
        return false;
    }
    public Account UserLogin(String user, String password) {
        for (int i = 0; i < this.lastIndex;i++) {
            Account acc = this.accounts[i];
            if(acc.getUser_name().equals(user) && acc.checkPassword(password)) {
                return acc;
            }
        }
        return null;
    }
    public void printSeries() {
        for(int i = 0; i < series.length;i++) {
            System.out.print(i + 1 + ". ");
            series[i].print();
        }
    }
    public Series isSeriesExist(String name) {
        for (int i =0 ; i < this.series.length; i++) {
            Series s  = this.series[i];
            if (s.getName().equals(name))
                return s;
        }
        return null;
    }

}
