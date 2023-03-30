package com.vishvak.spigotdiscord;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerLoginEvent;
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
            discord.sendMessage("Plugin up and running");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        Bukkit.broadcastMessage("Player " + event.getPlayer().getName() + " is logging in!");
        System.out.println("Player " + event.getPlayer().getName() + " is logging in!");
        discord.sendMessage("Player " + event.getPlayer().getName().toString() + " is logging in!");
    }
    @EventHandler
    public void onPlayerDeath (PlayerDeathEvent event){
        OfflinePlayer player =  event.getEntity().getPlayer();
        System.out.println(player.getName()+" died lmao");
        System.out.println(event.getEntity().getLocation());
        discord.sendMessage(player.getName()+" Died at "+event.getEntity().getLocation());
    }
}
