package com.canuc80k.state;

import com.canuc80k.serialize.SerializeTool;
import com.canuc80k.storage.ActiveStateConfigFile;

public class ActiveState {
    public final static boolean ACTIVE_ON = true;
    public final static boolean ACTIVE_OFF = true;

    private static boolean activeState;
    
    public static void updateActiveState() {
        activeState = !activeState;

        SerializeTool.serialize(ActiveStateConfigFile.activeStateConfigFile, activeState);
    }

    public static boolean getActiveState() {
        return activeState;
    }
}
