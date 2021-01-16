package com.github.advra.roxas;
import com.github.advra.roxas.commands.CommandExecutor;
import com.github.advra.roxas.commands.PingCommand;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.EventDispatcher;
import org.aeonbits.owner.ConfigFactory;

public class Main {

    public static GatewayDiscordClient client;
    public static String version = "2021.01.16";

    public static void main(String[] args) {

        // load server properties
        ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
        try{
            System.out.println("Roxas Server booted " + cfg.hostname() + ":" + cfg.port() +
                    " will run " + cfg.maxThreads() + " threads with key: " + cfg.token());
            System.out.println("Version: " + version);
        }catch(Exception e){
            e.printStackTrace();
        }

        //Connect to MySQL
//        DatabaseManager.getManager().connectToMySQL(botSettings);
//        DatabaseManager.getManager().createTables();

        //Register commands
        CommandExecutor.registerCommand(new PingCommand());

        // Initiate and Login client instance

//        client =  Client.createClient(cfg.token());
//        if (client == null)
//            throw new NullPointerException("Failed to log in! Client cannot be null!");
//
//        client.onDisconnect().block();

        //Login
        client = Client.create(cfg.token());
        if (client == null)
            throw new NullPointerException("Failed to log in! Client cannot be null!");
    }

}