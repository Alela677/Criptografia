package Utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

public class GenerarKeys {

	public static SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		byte[] claveEncriptacion = clave.getBytes("UTF-8");

		MessageDigest sha = MessageDigest.getInstance("SHA-1");

		claveEncriptacion = sha.digest(claveEncriptacion);
		claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);

		SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, "AES");

		return secretKey;
	}
}
