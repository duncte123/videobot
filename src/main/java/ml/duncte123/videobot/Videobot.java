package ml.duncte123.videobot;

import ml.duncte123.videobot.utils.Scheduler;
import ml.duncte123.videobot.utils.YoutubeUtil;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Videobot extends ListenerAdapter {

    /*
     * Start settings
     */
    public static String LATEST_VIDEO_ID = "";
    public static Guild GUILD_TO_MSG = null;
    private static String GUILD_ID = "329962158471512075";
    public static String AD_CHANNEL_NAME = "advertisement";
    private static String BOT_TOKEN = "";
    public static String YOUTUBE_API_KEY = "";
    public static String YOUTUBE_CHANNEL_ID = "UColI-lvoN08jXBfc1EqDR8g";
    /*
     * End settings
     */

    public static void main(String... args) throws Exception {
        //get the video id
        LATEST_VIDEO_ID = YoutubeUtil.getVideo().getID();
        //Start the timer
        new Scheduler();
        //bot stuffz
        new JDABuilder(AccountType.BOT)
                .setAudioEnabled(false)
                .setBulkDeleteSplittingEnabled(false)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setToken(BOT_TOKEN)
                .buildBlocking();
    }

    @Override
    public void onReady(ReadyEvent event) {
        GUILD_TO_MSG = event.getJDA().getGuildById(GUILD_ID);
    }
}
