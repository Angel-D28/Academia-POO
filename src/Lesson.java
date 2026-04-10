
public class Lesson {
    private Video  recordedVideo;
    private String  date;

    public Lesson(Video recordedVideo, String date) {
        this.recordedVideo = recordedVideo;
        this.date = date;
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
