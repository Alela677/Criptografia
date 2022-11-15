package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

public class GenerarClaves {
	public static KeyPair extraerClaves(String ficheroClaves, String alias, String password) {
		KeyPair clavesJuntas = null;
		try {

			File fichero = new File(ficheroClaves);
			InputStream is = new FileInputStream(fichero);
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			ks.load(is, password.toCharArray());

			Key clavePrivada = ks.getKey(alias, password.toCharArray());

			if (clavePrivada instanceof PrivateKey) {

				Certificate certificado = ks.getCertificate(alias);

				PublicKey clavePublica = certificado.getPublicKey();
				clavesJuntas = new KeyPair(clavePublica, (PrivateKey) clavePrivada);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return clavesJuntas;

	}

}
