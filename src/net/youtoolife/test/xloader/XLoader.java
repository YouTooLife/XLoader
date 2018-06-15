package net.youtoolife.test.xloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

class XLoader extends ClassLoader

{

    // карта отображения имен классов на файлы .class, где хранятся их определения

    HashMap mappings;



    XLoader(HashMap mappings)

    {

        this.mappings = mappings;

    }



    public synchronized Class loadClass(String name) throws ClassNotFoundException

    {

        try

        {

            System.out.println("loadClass (" + name + ")");

           

            // важно! 

            // приоритет отдан именно загрузке с помощью встроенного загрузчика

            if (!mappings.containsKey(name))

            {

                return super.findSystemClass(name);

            }

            

            
            
            String fileName = (String) mappings.get(name);
            XAAA xaaa = new XAAA(fileName, fileName);
            /*
            FileInputStream fin = new FileInputStream(fileName);            

            byte[] bbuf = new byte[(int)(new File(fileName).length())];

            fin.read(bbuf);

            fin.close();
             */
            byte[] bbuf = xaaa.b();
            
            return defineClass(name, bbuf, 0, bbuf.length);

        }

        catch (Exception e)
        {
            e.printStackTrace();
            throw new ClassNotFoundException(e.getMessage(), e);
        }

    }

}
