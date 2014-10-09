package com.geminisystems.subscription.util;

import java.security.MessageDigest;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 08.11.2011
 * Time: 15:54:03
 * To change this template use File | Settings | File Templates.
 */
public class SubscriptionUtil {

     public static String getHash(String s) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(s.getBytes());
            byte[] hashDigest = algorithm.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hashDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & hashDigest[i]);
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
