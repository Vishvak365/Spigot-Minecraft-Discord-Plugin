package com.vishvak.spigotdiscord;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;

import java.util.List;

public class DiscordInterface {
    static JDA jda;
    public DiscordInterface() throws InterruptedException {
        System.out.println("Initializing Discord Interface");
        jda = JDABuilder.createDefault(Secret.getToken()).build();
        jda.awaitReady();
    }
    public static void sendMessage(String message){
        System.out.println("Sending message "+message);
        List<Guild> guilds = jda.getGuilds();
        System.out.println(guilds.size());
        for(Guild guild : guilds){
            guild.getTextChannelsByName("minecraft",true).get(0).sendMessage(message).queue();
            System.out.println(guild);
        }
    }
}
