// @author ArmeetJatyani
// YeBot

import listeners.MainListener;
import lombok.SneakyThrows;
import net.dv8tion.jda.api.JDABuilder;
import sun.applet.Main;

public class YeBot
{
    public static String yeToken;

    @SneakyThrows
    public static void main(String[] args)
    {
        // get discord bot token
        yeToken = System.getenv("YEBOT_TOKEN");
        System.out.println("TOKEN: " + yeToken);
        if(yeToken.length() == 0) System.exit(1);

        JDABuilder builder = JDABuilder.createDefault(yeToken)
                .addEventListeners(
                        new MainListener()

                );

        builder.build();

    }
}
