package com.canuc80k.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTool {
    public static void serializeActiveState(File savedFile, Object object) {
        try {
            ObjectOutputStream configFileObjectOutputStream = new ObjectOutputStream(new FileOutputStream(savedFile));
            configFileObjectOutputStream.writeObject(object);
            configFileObjectOutputStream.flush();
            configFileObjectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserializeActiveState(File savedFile) {
        try {
            ObjectInputStream configFileObjectInputStream = new ObjectInputStream(new FileInputStream(savedFile));
            Object object = configFileObjectInputStream.readObject();
            configFileObjectInputStream.close();
            return object;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
