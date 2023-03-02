package com.canuc80k.storage;

import java.io.File;

public class ActiveStateConfigFile {
    private static File activeStateConfigFile;
    
    public static void createFile() {
        activeStateConfigFile = new File(
            ProjectDataFolder.getProjectDataFolder().getAbsolutePath() + "/activeStateConfig.cfg"
        );
    }

    public static File getActiveStateConfigFile() {
        return activeStateConfigFile;
    }
}
