package AplicacionesAES;

import java.util.Base64;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;

import Utils.GenerarKeys;

public class DescifraAESApp {

	public static void main(String[] args) throws Exception {

		String mensaje = null;
		String password = null;

		try {
			mensaje = args[0];

			password = args[1];

			System.out.println("Mensaje: " + args[0]);
			System.out.println("Password: " + args[1]);

			descifrarAES(mensaje, password);

		} catch (Exception e) {
			System.out.println("ERROR: NO SE HAN INTRODUCIDO TODOS LO PARAMETROS");
			e.printStackTrace();
		}
	}

	public static void descifrarAES(String mensaje, String password) throws Exception {

		try {
			SecretKeySpec secretKey = GenerarKeys.crearClave(password);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);

			byte[] mensajeCifrado = Base64.getDecoder().decode(mensaje);
			byte[] descifrado = cipher.doFinal(mensajeCifrado);
			String resultado = new String(descifrado);
			System.out.println("El mensaje descifrado es: " + resultado);
		} catch (Exception e) {
			System.out.println("ERROR: NO SE PUEDO DESCIFRAR EL MENSAJE");
		}

	}
}