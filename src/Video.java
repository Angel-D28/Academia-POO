import java.time.Duration;

public class Video {
    private String fileName;
    private Duration duration;
    private Quality quality;

    public Video(String fileName, Duration duration, Quality quality) {
        this.fileName = fileName;
        this.duration = duration;
        this.quality = quality;
    }

    public String getFileName() {
        return fileName;
    }

    public Duration getDuration() {
        return duration;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

}
