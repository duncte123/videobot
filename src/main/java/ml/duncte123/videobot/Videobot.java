package ml.duncte123.videobot;

import ml.duncte123.videobot.utils.Scheduler;
import ml.duncte123.videobot.utils.YoutubeUtil;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Guild;

public class Videobot {

    static JDA jda;

    /*
     * Start settings
     */
    public static String LATEST_VIDEO_ID = "";
    public static Guild GUILD_TO_MSG = null;
    private static String GUILD_ID = "329962158471512075";
    public static String AD_CHANNEL_NAME = "adversitement";
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
        jda = new JDABuilder(AccountType.BOT)
                .setAudioEnabled(false)
                .setBulkDeleteSplittingEnabled(false)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setToken(BOT_TOKEN)
                .buildBlocking();
        jda.setAutoReconnect(true);
        GUILD_TO_MSG = jda.getGuildById(GUILD_ID);
    }

}
