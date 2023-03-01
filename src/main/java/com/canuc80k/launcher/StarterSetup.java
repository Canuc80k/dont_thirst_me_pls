package com.canuc80k.launcher;

import com.canuc80k.storage.ActiveStateConfigFile;
import com.canuc80k.storage.ProjectDataFolder;

public class StarterSetup {
    public static void init() {
        ProjectDataFolder.createFolder();
        ActiveStateConfigFile.createFile();
    }
}
