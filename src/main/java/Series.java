public class Series implements Printable {
    private String name;
    private Episode[] episodes;

    public Series(String name, Episode[] episodes) {
        this.name = name;
        this.episodes = episodes;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Episode[] getEpisodes() {
        return episodes;
    }


    public void setEpisodes(Episode[] episodes) {
        this.episodes = episodes;
    }


    public void print() {
        System.out.println(this.name);
    }
    public void printEpisodesInfo() {
        for (int i =0; i < episodes.length; i++) {
            System.out.println("Episode number " + (i + 1));
            this.episodes[i].printInfo();
        }
    }
}
