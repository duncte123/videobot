package ml.duncte123.videobot;

public class Video {

    private final String VIDEO_ID;
    private final String VIDEO_TITLE;
    private final String VIDEO_DESCRIPTION;
    private final String VIDEO_THUMB;

    public Video(String video_id, String video_title, String video_description) {
        this.VIDEO_ID = video_id;
        this.VIDEO_TITLE = video_title;
        this.VIDEO_DESCRIPTION = video_description;
        this.VIDEO_THUMB = "https://i.ytimg.com/vi/" + video_id + "/mqdefault.jpg";
    }

    public String getID() {
        return VIDEO_ID;
    }
    public String  getTItle() {
        return VIDEO_TITLE;
    }

    public String getDesdciption() {
        return VIDEO_DESCRIPTION;
    }
    public String getThumbUrl() {
        return VIDEO_THUMB;
    }
}
