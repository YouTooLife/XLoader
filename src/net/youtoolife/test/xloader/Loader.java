package net.youtoolife.test.xloader;

import java.io.File;
import java.util.HashMap;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Loader {

	public static void main(String[] args) {
		
		/*
		System.out.println("-------------");
		System.out.println(XA.a(XA.A));
		System.out.println("-------------");
		System.out.println(XA.a(XA.B));
		System.out.println("-------------");
		System.out.println(XA.a(XA.MA));*/
		System.out.println("-------------");
		String e = XA.a(XA.C);
		System.out.println(e);
		System.out.println("-------------");
		//System.out.println(XA.b(e));
		System.out.println("-------------");
		

		HashMap mappings = new HashMap();

		
		String myJarPath = System.getProperty("java.class.path");
		System.out.println("paths: "+myJarPath);
		String paths[] = myJarPath.split(":");
		if (paths.length > 0) {	
			for (String s:paths)
				System.out.println(s);
		}
		String dir2 = new File(paths[0]).getParent();
		System.out.println(dir2);
		
		String fn = dir2+"/xaa.a";
		XAAA xaaa = new XAAA(dir2+"/SexyClass.class", fn);
		xaaa.a();
		
        mappings.put("sexypackage.SexyClass", fn);



        // Если убрать комментарий - будет больно

        /*

            mappings.put("sexypackage.ISexyInterface",

            "путь\\classes\\sexypackage\\ISexyInterface.class");

        */


/*
        try {
        XLoader xloa = new XLoader(mappings);

        Class sexy_cla = xloa.loadClass("sexypackage.SexyClass");

       
        
        System.out.println("class was loaded");

        System.out.println("begin object creation");

        

        Object sexy_ob = sexy_cla.newInstance();

        System.out.println("object was created");

        System.out.println("invoke: getFoo" + sexy_cla.getMethod("getSimpleFoo").invoke(sexy_ob));
        }
        catch (Exception e) {
			System.out.println(e.getMessage());
			}
			*/
        
	}

}
