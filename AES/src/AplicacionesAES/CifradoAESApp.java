package AplicacionesAES;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import Utils.GenerarKeys;

public class CifradoAESApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String mensaje = null;
		String password = null;

		try {
			mensaje = args[0];

			password = args[1];

			System.out.println("Mensaje: " + args[0]);
			System.out.println("Password: " + args[1]);

			cifradoAES(mensaje, password);

		} catch (Exception e) {
			System.out.println("ERROR: NO SE HAN INTRODUCIDO TODOS LO PARAMETROS");

		}
	}

	private static void cifradoAES(String mensaje, String password) throws Exception {
		try {
			SecretKeySpec secretKey = GenerarKeys.crearClave(password);
			Cipher chiper = Cipher.getInstance("AES");
			chiper.init(Cipher.ENCRYPT_MODE, secretKey);

			byte[] mensajeCifrar = mensaje.getBytes("UTF-8");
			byte[] cifrado = chiper.doFinal(mensajeCifrar);
			String resultado = new String(Base64.getEncoder().encode(cifrado));
			System.out.println(resultado);
		} catch (Exception e) {

			System.out.println("ERROR: NO SE PUEDO CIFRAR EL MENSAJE");
		}
		

	}
}
