package com.vishvak.spigotdiscord;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;

import java.util.List;

public class test {
    public static void main(String[] args) throws InterruptedException {
        JDA jda = JDABuilder.createDefault("Nzk0NzIwMzE5MjI2MjQ5MjU3.Gz5URy.Yz5CP6RQ7eO_prbEG-i8jjmg-kV0klPilEbt00").build();
        jda.awaitReady();
        List<Guild> guilds = jda.getGuilds();
        System.out.println(guilds.size());
        for(Guild guild : guilds){
            guild.getTextChannelsByName("minecraft",true).get(0).sendMessage("MESSAGE").queue();
            System.out.println(guild);
        }
//        TextChannel mc = jda.getTextChannelsByName("Minecraft",true).get(0);
//        mc.sendMessage("asdf");
//        List<ThreadChannel> channels = jda.getThreadChannels();
//        for(int i = 0;i< channels.size();i++){
//            System.out.println(channels.get(i));
//        }
//        List< User > users = jda.getUsers();
//        for(int i = 0;i< users.size();i++){
//            System.out.println(users.get(i));
//        }
    }
}
