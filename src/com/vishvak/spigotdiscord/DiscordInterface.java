package com.vishvak.spigotdiscord;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;

import java.util.List;
public class DiscordInterface {
    //Set this to true to send messages to production server
    Boolean productionDiscordServer = false;
    static Guild guild;
    static JDA jda;

    public DiscordInterface() throws InterruptedException {
        System.out.println("Initializing Discord Interface");
        jda = JDABuilder.createDefault(Secret.getToken()).build();
        jda.awaitReady();
        if(productionDiscordServer) guild = jda.getGuildById("690317027512287640");
        else guild = jda.getGuildById("1091032957940150374");

    }
    public void sendMessage(String message){
        System.out.println("Sending message "+message);
        guild.getTextChannelsByName("minecraft",true).get(0).sendMessage(message).queue();
        System.out.println(guild);
    }
    public void sendMessage(MessageCreateData message){
        System.out.println("Sending message "+message);
        guild.getTextChannelsByName("minecraft",true).get(0).sendMessage(message).queue();
        System.out.println(guild);
    }
}
