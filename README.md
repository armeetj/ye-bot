# YeBot 😎
`@armeetjatyani` `2021` `JDA` `discord-bot`
A discord bot that tweets Kanye's tweets every 6 hours!

## Description
- by this point I had made some basic discord bots with discord.js (JavaScript) and discordpy (Python)
- I wanted to try out JDA (Java Discord API)
- Made a simple meme bot, that responds to the `!ye` command with a random Kanye tweet!

## Demo
![image](https://user-images.githubusercontent.com/38377327/132275555-33a785d2-d96a-4f51-ad93-6dec3e21945a.png)<br>
![image](https://user-images.githubusercontent.com/38377327/132275596-6a8c20d0-3bd2-4313-95f3-bdaf87d41169.png)

Full Demo: https://youtu.be/7V1mJanghhc

## Code Snippets
### `.../java/api/KanyeRestAPIWrapper.java`
```java
/**
 * https://api.kanye.rest
 * @return
 */
@SneakyThrows
public static String get()
{
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url("https://api.kanye.rest?format=text")
            .build(); // defaults to GET

    Response response = client.newCall(request).execute();
    return response.body().string();
}
```

### `.../java/YeBot.java`
```java
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
```

