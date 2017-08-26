package ml.duncte123.videobot.utils;

import ml.duncte123.videobot.Video;
import ml.duncte123.videobot.Videobot;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.Calendar.DAY_OF_WEEK;

public class Scheduler  {

    public Scheduler() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(13);
        Date aDate = new Date();
        Calendar with = Calendar.getInstance();
        with.setTime(aDate);

        int hour = with.get(Calendar.HOUR_OF_DAY);
        int intDelayInHour = hour < 5 ? 5 - hour : 24 - (hour - 5);

        System.out.println("Current Hour: " + hour);
        System.out.println("Comuted Delay for next 1 PM: " + intDelayInHour);

        Map<Integer, Integer> dayToDelay = new HashMap<>();
        dayToDelay.put(Calendar.FRIDAY, 5);
        dayToDelay.put(Calendar.SATURDAY, 4);
        dayToDelay.put(Calendar.SUNDAY, 3);
        dayToDelay.put(Calendar.MONDAY, 2);
        dayToDelay.put(Calendar.TUESDAY, 1);
        dayToDelay.put(Calendar.WEDNESDAY, 0);
        dayToDelay.put(Calendar.THURSDAY, 6);
        int dayOfWeek = with.get(DAY_OF_WEEK);
        int delayInDays = dayToDelay.get(dayOfWeek);

        scheduler.scheduleAtFixedRate(() -> {
            try {
                Video v = YoutubeUtil.getVideo();
                if(YoutubeUtil.checkNewVideo(v)) {
                    Message m = new MessageBuilder().append("Duncte uploaded a new video").setEmbed(EmbedUtil.generateEmbed(v)).build();
                    Videobot.dhgGuild.getTextChannelsByName(Videobot.AD_CHANNEL_NAME, true)
                            .get(0).sendMessage(m).queue();
                }
            } catch (Exception ex) {
                ex.printStackTrace(); // or loggger would be better
            }
        }, delayInDays, 7, TimeUnit.DAYS);
    }
    }


