package com.vishvak.spigotdiscord;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("I have started the Vishvak Discord Server thing");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
    @EventHandler
    public void onPlayerDeath (PlayerDeathEvent event){
        Bukkit.broadcastMessage("send");
        OfflinePlayer player =  event.getEntity().getPlayer();
//        player.getPlayerProfile().getName().
    }
}
