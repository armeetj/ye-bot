package listeners;

import api.KanyeRestAPIWrapper;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.sql.Timestamp;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class MainListener extends ListenerAdapter
{

    /**
     * on guild message
     * @param event
     */
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event)
    {
        // exit if bot message
        if(event.getAuthor().isBot()) return;


        String[] rawMessage = event.getMessage().getContentRaw().split(" ");
        if (rawMessage.length > 0 && rawMessage[0].equalsIgnoreCase("!ye"))
        {
            System.out.println("[EVENT]: !ye command recieved in guild: " + event.getGuild().getId());
            String kanyeQuote = KanyeRestAPIWrapper.get();
            MessageEmbed embed = new EmbedBuilder()
                    .setColor(new Color(193, 128, 91))
                    .setAuthor("Kanye Says", "https://twitter.com/kanyewest", "https://pbs.twimg.com/profile_images/1276461929934942210/cqNhNk6v_400x400.jpg")
                    .setDescription(kanyeQuote)
                    .setFooter("Created by @ArmeetJatyani")
                    .setTimestamp(new Date().toInstant())
                    .build();
            event.getChannel().sendMessage(embed).queue();
        } else
        {
            return;
        }

        super.onGuildMessageReceived(event);
    }

}
