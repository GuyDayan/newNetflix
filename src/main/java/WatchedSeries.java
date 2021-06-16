public class WatchedSeries implements Printable  {
    private Series series;
    private int lastEpisode;

    public WatchedSeries(Series series, int last) {
        this.series = series;
        if (last < 0 || last > series.getEpisodes().length)
            this.lastEpisode = 0; //
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }


    public int getLast() {
        return this.lastEpisode;
    }

    public Episode getLastEpisode() {
        return this.series.getEpisodes()[lastEpisode];
    }

    public void setLastEpisode(int lastEpisode) {
        this.lastEpisode = lastEpisode;
    }


    public void print() {
        System.out.print("Series :");
        series.print();
        System.out.print("Last episode watched :");
        getLastEpisode().printEpisode();
    }
}
