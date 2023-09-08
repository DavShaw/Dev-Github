package org.davshaw.external;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ToSerializer <Generic>
{
    private String filePath;
    private Generic object;

    private FileOutputStream file;
    private ObjectOutputStream serializer;

    private FileInputStream readfile;
    private ObjectInputStream readserializer;

    public ToSerializer(String filePath, Generic object) throws IOException
    {
        this.filePath = filePath;
        this.object = object;
        this.writeObject();
    }

    private void writeObject() throws IOException
    {
        this.file = new FileOutputStream(this.filePath);
        this.serializer = new ObjectOutputStream(file);

        this.serializer.writeObject(object);
        this.serializer.close();
    }

    public Generic readObject() throws IOException, ClassNotFoundException, FileNotFoundException
    {
        this.readfile = new FileInputStream(this.filePath);
        this.readserializer = new ObjectInputStream(this.readfile);
        @SuppressWarnings("unchecked")
        Generic object = (Generic) this.readserializer.readObject();
        return object;
    }
}
