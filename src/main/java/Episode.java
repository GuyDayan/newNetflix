public class Episode {

    private String name;
    private String overView;
    private Date broadcastTime;
    private int episodeNumber;

    public Episode(int episodeNumber,String name, String overView, Date broadcastTime) {
        this.episodeNumber = episodeNumber;
        this.name = name;
        this.overView = overView;
        this.broadcastTime = broadcastTime;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public Date getBroadcastTime() {
        return broadcastTime;
    }

    public void setBroadcastTime(Date broadcastTime) {
        this.broadcastTime = broadcastTime;
    }

    public void printEpisode() {
        System.out.println("Episode number:" +this.episodeNumber+ "\t" + "Episode-name: " +this.name+ "\t"+ "\t"+
                "overView:" +this.overView +"\t" + "\t"+"broadcastTime:"+this.broadcastTime);
    }
}
