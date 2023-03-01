package com.canuc80k.storage;

import java.io.File;

public class ProjectDataFolder {
    private static File projectDataFolder;
    
    public static void createFolder() {
        projectDataFolder = new File(System.getenv("LOCALAPPDATA") + "/dont_thirst_me_pls");
        if (!projectDataFolder.exists()) projectDataFolder.mkdirs();
    }

    public static File getProjectDataFolder() {
        return projectDataFolder;
    }
}
