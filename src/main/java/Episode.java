public class Episode implements Printable {
    private String name;
    private  String overview;
    private Date air_time;

    public Episode(String name, String overview, Date air_time) {
        this.name = name;
        this.overview = overview;
        this.air_time = air_time;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getAir_time() {
        return air_time;
    }

    public void setAir_time(Date air_time) {
        this.air_time = air_time;
    }


    public void print() {
        System.out.println(this.name);
    }
    public void printInfo() {
        System.out.print("Episode name: ");
        print();
        System.out.println("Overview: " + this.overview);
        System.out.print("Air date: ");
        this.air_time.print();
    }
}
