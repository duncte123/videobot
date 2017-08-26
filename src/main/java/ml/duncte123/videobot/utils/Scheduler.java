package ml.duncte123.videobot.utils;

import ml.duncte123.videobot.Video;
import ml.duncte123.videobot.Videobot;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Timer;
import java.util.TimerTask;

public class Scheduler  {

    public Scheduler() {
        Timer timer = new Timer();


        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    Video v = YoutubeUtil.getVideo();
                    if (YoutubeUtil.checkNewVideo(v)) {
                        Message m = new MessageBuilder().append("Duncte uploaded a new video").setEmbed(EmbedUtil.generateEmbed(v)).build();
                        Videobot.dhgGuild.getTextChannelsByName(Videobot.AD_CHANNEL_NAME, true)
                                .get(0).sendMessage(m).queue();
                        Videobot.latestVideo = v.getID();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace(); // or loggger would be better
                }
            }
        };
        timer.schedule(myTask, DateUtils.MILLIS_PER_HOUR, DateUtils.MILLIS_PER_HOUR);
    }
}


