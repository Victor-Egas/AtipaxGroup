package com.atipax.group.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptionData {

    private SecretKey generarClaveSecreta() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // Tamaño de clave, puede ser 128, 192 o 256 bits
        return keyGenerator.generateKey();
    }

    public static byte[] messageEncryption(String originalMessage) throws Exception {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // Tamaño de clave, puede ser 128, 192 o 256 bits

        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.ENCRYPT_MODE, keyGenerator.generateKey());
        byte[] mensajeEncriptado = cifrador.doFinal(originalMessage.getBytes());

        System.out.println("Mensaje Original: " + originalMessage);
        System.out.println("Mensaje Encriptado: " + Base64.getEncoder().encodeToString(mensajeEncriptado));
        return mensajeEncriptado;
    }

    public static String messageDecryptor(byte[] mensajeEncriptado) throws Exception {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // Tamaño de clave, puede ser 128, 192 o 256 bits

        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.DECRYPT_MODE, keyGenerator.generateKey());
        byte[] mensajeDesencriptado = cifrador.doFinal(mensajeEncriptado);

        System.out.println("Mensaje Original: " + new String(mensajeEncriptado));
        System.out.println("Mensaje Desencriptado: " + new String(mensajeDesencriptado));
        return new String(mensajeDesencriptado);
    }
}
