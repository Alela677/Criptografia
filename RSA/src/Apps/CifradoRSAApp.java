package Apps;

import java.security.KeyPair;
import java.util.Base64;

import javax.crypto.Cipher;

import Utils.GenerarClaves;

public class CifradoRSAApp {

	// keytool -genkeypair -keyalg RSA -keystore lasclaves -alias ale

	public static void main(String[] args) {

		

		String mensaje = null;
		String alias = null;

		try {
			mensaje = args[0];
			alias = args[1];
			
			cifrarRSA(mensaje, alias);
		} catch (Exception e) {
			System.out.println("ERROR: INTRODUCE BIEN TODOS LOS PARAMETROS");
		
		}
	}
	
	
	
	private static void cifrarRSA(String mensaje , String alias) throws Exception{
	
		KeyPair key = GenerarClaves.extraerClaves("lasclaves", alias, "123456");
		Cipher chiper = Cipher.getInstance("RSA");
		chiper.init(Cipher.ENCRYPT_MODE, key.getPublic());
		
		byte [] mensajeByte = mensaje.getBytes("UTF-8");
		byte [] cifrado = chiper.doFinal(mensajeByte);
		
		String resultado = Base64.getEncoder().encodeToString(cifrado);
		System.out.println("El mensaje cifrado es: ");
		System.out.println(resultado);
		
		
	}
	
}
