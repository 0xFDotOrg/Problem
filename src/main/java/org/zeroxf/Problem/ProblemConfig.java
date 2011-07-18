/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zeroxf.Problem;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.bukkit.util.config.Configuration;
import org.bukkit.util.config.ConfigurationNode;

/**
 *
 * @author gothroach
 */
public class ProblemConfig {
    private static Problem plugin;
    
    public ProblemConfig(Problem problem)
    {
        ProblemConfig.plugin = problem;
    }

    public String reload()
    {
        this.load();
        
        return plugin.pluginName + " v" + plugin.pluginVers + " reloaded.";
    }
    
    public void load()
    {
        File confFile = new File(plugin.getDataFolder(), plugin.pluginName + ".yml");
        
        if (!confFile.getParentFile().exists() || !confFile.exists())
            this.create(confFile);
        
        Configuration conf = new Configuration(confFile);
        ArrayList<ConfigurationNode> slotsList;
        
        conf.load();
        
        plugin.conOut("Finished loading configuration.");
    }
    
    public void create(File confFile)
    {
        if (!confFile.getParentFile().exists())
        {
            if (!confFile.getParentFile().mkdirs())
            {
                plugin.conOut("Error creating plugin directory, disabling...");
                plugin.onDisable();
            }
        }
        if (!confFile.exists())
        {
            try {
                confFile.createNewFile();
            } catch (IOException ex) {
                plugin.conOut("Error creating configuration file, disabling...");
                plugin.onDisable();
            } finally {
                plugin.conOut("No configuration found, creating default config file...");
                ClassLoader classLoader = plugin.getClass().getClassLoader();
                InputStream inFile = classLoader.getResourceAsStream(plugin.pluginName + "/" + plugin.pluginName + ".yml");
                BufferedOutputStream outFile = null;
                try
                {
                    outFile = new BufferedOutputStream(new FileOutputStream(plugin.getDataFolder() + "/" + plugin.pluginName + ".yml"));
                    byte[] buffer = new byte[32 * 1024];
                    int bytesRead = 0;
                    while ((bytesRead = inFile.read(buffer)) > 0)
                    {
                        outFile.write(buffer, 0, bytesRead);
                    }
                }
                catch (Exception ex)
                {
                   plugin.conOut(ex.toString());
                   plugin.conOut("Error creating default config file!");
                }
                finally
                {
                    if (inFile != null)
                    {
                        try {
                            inFile.close();
                        } catch (IOException ex) {
                            // Do nothing.
                        }
                    }
                    if (outFile != null)
                    {
                        try {
                            outFile.close();
                        } catch (IOException ex) {
                            // Do nothing.
                        }
                    } 
                }
            }
        }
    }
}
