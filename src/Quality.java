public enum Quality {
    HD("1080P"), SD("720P"), LD("480P"), MD("360P"), XD("270P");

    private final String resolution;

    private Quality(String resolution) {
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }
}
