package com.diesgut.simplepgp.core;

import java.io.InputStream;
import java.io.OutputStream;

public interface IKeySigner {
	
	 /**
	   * TODO no implementation present yet
	   *
	   * @param publicKey
	   * @param privateKey
	   * @param targetStream
	   * @return
	   */
	  boolean signKey(InputStream publicKey, InputStream privateKey, OutputStream targetStream);

}
