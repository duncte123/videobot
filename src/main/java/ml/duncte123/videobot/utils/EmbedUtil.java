package ml.duncte123.videobot.utils;

import ml.duncte123.videobot.Video;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;

import java.awt.*;

public class EmbedUtil {
    public static MessageEmbed generateEmbed(Video v) {
        String vidId = v.getID();
        String vidTitle = v.getTitle();
        String vidDes = v.getDescription();
        String vidThumb = v.getThumbUrl();

        EmbedBuilder eb = new EmbedBuilder()
                .setTitle(vidTitle, "https://youtube.oom/watch?v=" + vidId)
                .setColor(Color.RED)
                .setDescription(vidDes)
                .setThumbnail(vidThumb);
        return eb.build();
    }
}
