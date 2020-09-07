package com.diesgut.simplepgp.crypt;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.diesgut.simplepgp.core.IKeyPairGenerator;
import com.diesgut.simplepgp.core.IMessageEncryptor;
import com.diesgut.simplepgp.core.IMessageSigner;

public final class PGPFactory {


	  private PGPFactory() {
	    super();
	  }

	  /**
	   * initializes the security provider
	   */
	  public static void init() {
	    Security.addProvider(new BouncyCastleProvider());
	  }

	  /**
	   *
	   * @return a message encryptor instance
	   */
	  public static IMessageEncryptor getEncyptor() {
	    return new PGPMessageEncryptor();
	  }

	  /**
	   *
	   * @return a key pair generator instance
	   */
	  public static IKeyPairGenerator getKeyPairGenerator() {
	    return new PGPKeyPairGenerator();
	  }

	  /**
	   *
	   * @return a message signer instance
	   */
	  public static IMessageSigner getSigner() {
	    return new PGPMessageSigner();
	  }

}
