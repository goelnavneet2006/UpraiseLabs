package com.upraiselabs.security;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base64;

public abstract class SecurityAlgo {

  private static final String HASHING_ALGO = "SHA-256";
  private static final String CHARSET_NAME = "UTF-8";
  private static final String SALT_HASHING_ALGO = "SHA1PRNG";

  public static String generateHash(String input) {
    String outputStr = null;
    try {
      MessageDigest digest = MessageDigest.getInstance(HASHING_ALGO);
      digest.reset();
      byte[] output = digest.digest(input.getBytes(CHARSET_NAME));
      outputStr = byteToBase64(output);
    } catch (NoSuchAlgorithmException e) {
      System.out.println(Class.class.getName() + ":" + e);
    } catch (UnsupportedEncodingException e) {
      System.out.println(Class.class.getName() + ":" + e);
    }
    return outputStr;
  }

  public static String generateURLEncodedHash(String input) {
    String outputStr = null;
    try {
      MessageDigest digest = MessageDigest.getInstance(HASHING_ALGO);
      digest.reset();
      byte[] output = digest.digest(input.getBytes(CHARSET_NAME));
      outputStr = byteToBase64(output);
      outputStr = URLEncoder.encode(outputStr, CHARSET_NAME);
    } catch (NoSuchAlgorithmException e) {
      System.out.println(Class.class.getName() + ":" + e);
    } catch (UnsupportedEncodingException e) {
      System.out.println(Class.class.getName() + ":" + e);
    }
    return outputStr;
  }

  public static String generateHash(String input, String salt) {
    String outputStr = null;
    try {
      MessageDigest digest = MessageDigest.getInstance(HASHING_ALGO);
      digest.reset();
      digest.update(base64ToByte(salt));
      byte[] output = digest.digest(input.getBytes(CHARSET_NAME));
      outputStr = byteToBase64(output);
    } catch (NoSuchAlgorithmException e) {
      System.out.println(Class.class.getName() + ":" + e);
    } catch (UnsupportedEncodingException e) {
      System.out.println(Class.class.getName() + ":" + e);
    }
    return outputStr;
  }

  public static String generateSalt() {
    String outputSalt = null;
    try {
      SecureRandom random = SecureRandom.getInstance(SALT_HASHING_ALGO);
      // Salt generation 64 bits long
      byte[] bSalt = new byte[8];
      random.nextBytes(bSalt);
      outputSalt = byteToBase64(bSalt);
    } catch (NoSuchAlgorithmException e) {
      System.out.println(Class.class.getName() + ":" + e);
    }
    return outputSalt;
  }

  public static String byteToBase64(byte[] data) {
    return Base64.encodeBase64String(data);
  }

  public static byte[] base64ToByte(String data) {
    return Base64.decodeBase64(data);
  }
}
