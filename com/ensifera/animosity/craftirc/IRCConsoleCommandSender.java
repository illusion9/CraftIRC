/**
 * 
 */
package com.ensifera.animosity.craftirc;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.permissions.Permission;
/**
 * @author Animosity
 *
 */
public class IRCConsoleCommandSender extends ConsoleCommandSender {
    //private Boolean op = false;
    private RelayedMessage ircConCmd = null;
    
 
    /**
     * 
     * @param server  - Server
     * @param ircConCmdMsg - RelayedMessage
     * @param isOp - Boolean
     */
    public IRCConsoleCommandSender(Server server, RelayedMessage ircConCmd, Boolean isOp) {
        super(server);
        this.ircConCmd = ircConCmd;
    }
    
    public boolean isOp() { return true; }
    
    public boolean hasPermission(String permission) { return true; }
    
    public boolean hasPermission(Permission permission) { return true; }
    
    @Override
    public boolean isPlayer() { return false; }
    
    @Override
    public void sendMessage(String message) {
        try {
            //ircConCmd.getPlugin().sendMessageToTag(">> " + message, ircConCmd.srcChannelTag);
            ircConCmd.getPlugin().instances.get(0).sendMessage("#"+ircConCmd.srcChannelTag, ">> " + ChatColor.stripColor(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
