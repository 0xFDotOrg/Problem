package org.zeroxf.Problem;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.Plugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;

/**
 * @author necavi
 * @author gothroach
 */

public class Problem extends JavaPlugin
{
    protected PermissionHandler perm;
    protected ProblemSQL sql;
    private ProblemPlayerListener handler;
    private ProblemConfig config;
    
    protected String pluginName;
    protected String pluginVers;
    protected String pluginGameTag;
    protected String pluginConTag;
    
    protected enum Status {
        NONE, NEW, SEEN, ASSIGNED, IN_PROGRESS,
        WAIT_USER, WAIT_MOD, WAIT_ADMIN, WAIT_OTHER,
        REPLY_USER, REPLY_ASSIGNEE, REPLY_OTHER,
        CLOSED_NORMAL, CLOSED_SPAM, CLOSED_DUPLICATE,
        CLOSED_OTHER, REOPENED
    }
    
    @Override
    public void onEnable()
    {
        pluginName = this.getDescription().getName();
        pluginVers = this.getDescription().getVersion();

        pluginGameTag = "&5[&6" + pluginName + "&5]&f";
        pluginConTag = "[" + pluginName + "]";

        setupPermissions();
        
        config = new ProblemConfig(this);
        setupConfig();
        
        handler = new ProblemPlayerListener(this); 
        setupListener();
        
        conOut(pluginName + " v" + pluginVers + " loaded." );
    }
    
    @Override
    public void onDisable()
    {
        conOut(pluginName + " v" + pluginVers + " unloaded." );
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        String cmd = command.getName().toLowerCase();
        Player player = null;
        
        if (sender instanceof Player) 
            player = (Player)sender;
        
        if (cmd.equals("problem") || cmd.equals("pe"))
        {
            if (args.length > 0)
            {
                conOut("[PLAYER_COMMAND] " + player.getName() + ": " + cmd + " " + args[0]);

                // Reload
                if (args[0].equals("reload"))
                {
                    if (this.perm.has(player,"reload"))
                        this.msgPlayer(player, this.config.reload());
                // Invalid param.
                } else
                    this.msgPlayer(player, "Invalid operation.");
                
            // No params.
            } else 
                this.msgPlayer(player, "/problem <params>");
            
            return true;
        }
        
        return false;
    }
    
    private void setupConfig()
    {
        conOut("Loading configuration...");
        config.load();
    }
    
    private void setupListener()
    {
        PluginManager pm = getServer().getPluginManager();
        
        pm.registerEvent(Event.Type.PLAYER_LOGIN, this.handler, Priority.Normal, this);
        pm.registerEvent(Event.Type.PLAYER_QUIT, this.handler, Priority.Normal, this);
    }
    
    private void setupPermissions()
    {
        Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");
        String vers = permissionsPlugin.getDescription().getVersion();
        
        if (this.perm == null) {
            if (permissionsPlugin != null) {
                this.conOut("Linked to " + permissionsPlugin.getDescription().getName() + " " + vers + ".");
                this.perm = ((Permissions) permissionsPlugin).getHandler();
            }
        } else {
            this.conOut("Permissions system not detected, disabling...");
            this.onDisable();
        }
    }
    
    protected void conOut(String text)
    {
        System.out.println(pluginConTag + " " + text);
    }
    
    protected void msgPlayer(Player player, String text)
    {
        text = pluginGameTag + " " + text;
        text = makeColour(text);
        player.sendMessage(text);
    }
    
    protected static String makeColour(String text)
    {
        String tmp1;
        String tmp2;
        String[] cSwap = {
            "&0", "&1", "&2", "&3", "&4", "&5", "&6", "&7",
            "&8", "&9", "&a", "&b", "&c", "&d", "&e", "&f"
        };
        ChatColor[] cList = {
            ChatColor.BLACK, ChatColor.DARK_BLUE, ChatColor.DARK_GREEN,
            ChatColor.DARK_AQUA, ChatColor.DARK_RED, ChatColor.DARK_PURPLE,
            ChatColor.GOLD, ChatColor.GRAY,

            ChatColor.DARK_GRAY, ChatColor.BLUE, ChatColor.GREEN,
            ChatColor.AQUA, ChatColor.RED, ChatColor.LIGHT_PURPLE,
            ChatColor.YELLOW, ChatColor.WHITE
        };

        for(int i=0; i < cSwap.length; i++)
        {
            tmp1 = cSwap[i];

            if(text.contains(tmp1))
            {
                tmp2 = text.replace(tmp1, cList[i].toString());
                text = tmp2;
            }
        }
 
        return text;
    }
}
