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
    public static String latestVideo = "";
    public static Guild dhgGuild = null;
    private static String GUILD_ID = "329962158471512075";
    public static String AD_CHANNEL_NAME = "adversitement";
    private static String TOKEN = "";

    public static void main(String... args) throws Exception {
        //get the video id
        latestVideo = YoutubeUtil.getVideo().getID();
        //Start the timer
        new Scheduler();
        //bot stuffz
        jda = new JDABuilder(AccountType.BOT)
                .setAudioEnabled(false)
                .setBulkDeleteSplittingEnabled(false)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setToken(TOKEN)
                .buildBlocking();
        jda.setAutoReconnect(true);
        dhgGuild = jda.getGuildById(GUILD_ID);
    }

}
