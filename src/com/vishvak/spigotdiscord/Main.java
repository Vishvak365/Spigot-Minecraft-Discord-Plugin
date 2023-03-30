package com.vishvak.spigotdiscord;

import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;
public class Main extends JavaPlugin implements Listener {
    DiscordInterface discord;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        System.out.println("I have started the Vishvak Discord Server thing");
        try {
            discord = new DiscordInterface();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        discord.sendMessage("Player " + event.getPlayer().getName().toString() + " is logging in!");
    }
    @EventHandler
    public void onPlayerDeath (PlayerDeathEvent event){
        OfflinePlayer player =  event.getEntity().getPlayer();
        String name = player.getName();
        int locationX = event.getEntity().getLocation().getBlockX();
        int locationY = event.getEntity().getLocation().getBlockY();
        int locationZ = event.getEntity().getLocation().getBlockZ();
        String world = event.getEntity().getWorld().getName().toString();
        StringBuilder discordMessage = new StringBuilder("```\n");
        discordMessage.append(name+" Died in the "+world+" at\n"
                +"X:"+locationX+"\n"
                +"Y:"+locationY+"\n"
                +"Z:"+locationZ+"\n"
                +"```\n");
        PlayerInventory inventory = event.getEntity().getInventory();
        if(inventory.getSize() > 0){
            discordMessage.append("```\nItems Lost:\n");
            for(ItemStack item : inventory){
                if(item!=null){
                    discordMessage.append(item.getType()).append(" X ").append(item.getAmount()).append("\n");
                }
            }
            discordMessage.append("```");
            System.out.println(discordMessage);
        }
        discord.sendMessage(discordMessage.toString());
    }
}
