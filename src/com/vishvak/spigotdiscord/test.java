package com.vishvak.spigotdiscord;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;

import java.util.List;
import java.util.Objects;

public class test extends ListenerAdapter {
    public static void main(String[] args) throws InterruptedException  {
        JDA jda = JDABuilder.createDefault(Secret.getToken()).build();
        jda.awaitReady();
        Guild guild = jda.getGuildById("1091032957940150374");
        String player = "bitWIDGET";
        int locationX = 123;
        int locationY = 123;
        int locationZ = 123;
        String world = "Earth";
        MessageCreateData data = new MessageCreateBuilder()
                .setContent(""
                        +"```\n"
                        +player+" Died in the "+world+" at\n"
                        +"X:"+locationX+"\n"
                        +"Y:"+locationY+"\n"
                        +"Z:"+locationZ+"\n"
                        +"```")
                .build();
        guild.getTextChannelsByName("minecraft",true).get(0).sendMessage(data).queue();

    }
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("say")) {
            event.reply(Objects.requireNonNull(event.getOption("content")).getAsString()).queue(); // reply immediately
        }
    }
}
