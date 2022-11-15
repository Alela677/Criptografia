package Apps;

import java.security.KeyPair;
import java.util.Base64;

import javax.crypto.Cipher;

import Utils.GenerarClaves;

public class DescifrarRSAApp {

	public static void main(String[] args) {

		String mensaje = null;
		String alias = null;

		try {
			mensaje = args[0];
			alias = args[1];

			descifrarRSA(mensaje, alias);

		} catch (Exception e) {
			System.out.println("ERROR: INTRODUCE BIEN LOS PARAMETROS");
		}

	}

	public static void descifrarRSA(String mensaje, String alias) throws Exception {

		KeyPair key = GenerarClaves.extraerClaves("lasclaves", alias, "123456");
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, key.getPrivate());

		byte[] mensajeCifrado = Base64.getDecoder().decode(mensaje);
		byte[] descifrado = cipher.doFinal(mensajeCifrado);
		String resultado = new String(descifrado);
		System.out.println("El mensaje descifrado es:\n" + resultado);
	}
}
