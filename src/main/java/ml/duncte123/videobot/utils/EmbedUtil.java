package ml.duncte123.videobot.utils;

import ml.duncte123.videobot.Video;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;

import java.awt.*;

public class EmbedUtil {
    public static MessageEmbed generateEmbed(Video v) {
        return new EmbedBuilder()
                .setTitle(v.getTitle(), "https://youtube.com/watch?v=" + v.getID())
                .setColor(Color.RED)
                .setDescription(v.getDescription())
                .setThumbnail(v.getThumbUrl())
                .build();
    }
}
