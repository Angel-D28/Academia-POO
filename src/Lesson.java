import java.time.Duration;
import java.util.Scanner;

public class Lesson {
    private String title;
    private Video  recordedVideo;
    private String  date;

    Scanner sc = new Scanner(System.in);

    public Lesson(String title, Video recordedVideo, String date) {
        this.title = title;
        this.recordedVideo = recordedVideo;
        this.date = date;
    }
    public Lesson(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public void createVideo() {
        System.out.print("Insert the file name of the video: ");
        String fileName = sc.nextLine();
        System.out.print("Insert the duration of the video in minutes: ");
        Duration durationInMinutes = Duration.ofMinutes(sc.nextInt());
        sc.nextLine();
        System.out.print("Insert the quality of the video: ");
        Quality quality = Quality.valueOf(sc.nextLine().toUpperCase());
        Video recordedVideo = new Video(fileName, durationInMinutes, quality);
        this.setRecordedVideo(recordedVideo);
    }

    public String getTitle() {
        return title;
    }

    public Video getRecordedVideo() {
        return recordedVideo;
    }

    public String getDate() {
        return date;
    }

    public void setRecordedVideo(Video recordedVideo) {
        this.recordedVideo = recordedVideo;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
