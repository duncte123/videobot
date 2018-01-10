package ml.duncte123.videobot.utils;

import ml.duncte123.videobot.Video;
import ml.duncte123.videobot.Videobot;
import org.json.JSONObject;

public class YoutubeUtil {

    private static String API_LINK = "https://www.googleapis.com/youtube/v3/search?key=" + Videobot.YOUTUBE_API_KEY + "&channelId=" + Videobot.YOUTUBE_CHANNEL_ID + "&part=snippet,id&order=date&maxResults=1";


    private static String getJSONData() {
        try {
            return URLConnectionReader.getText(API_LINK);
        }
        catch (Exception e) {
            return "{\"ERROR\": \"SOMETHING WENT WRONG\"}";
        }
    }

    public static Video getVideo() {
        JSONObject videoData  = new JSONObject(getJSONData()).getJSONArray("items").getJSONObject(0);

        String video_id = videoData.getJSONObject("id").getString("videoId");
        String video_title = videoData.getJSONObject("snippet").getString("title");
        String video_description = videoData.getJSONObject("snippet").getString("description");

        return new Video(video_id, video_title, video_description);
    }

    public static boolean checkNewVideo(Video v) {
        return !Videobot.LATEST_VIDEO_ID.equals(v.getID());
    }
}
