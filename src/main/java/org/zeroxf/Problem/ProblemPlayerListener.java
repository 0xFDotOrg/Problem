package org.zeroxf.Problem;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author necavi
 * @author gothroach
 */

public class ProblemPlayerListener extends PlayerListener
{
    private static Problem plugin;
    
    public ProblemPlayerListener(Problem problem)
    {
        ProblemPlayerListener.plugin = problem;
    }
    
    @Override
    public void onPlayerLogin(PlayerLoginEvent event)
    {
        Player player = event.getPlayer();
        String name = player.getName();
        
    }

    @Override
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        
    }
}

