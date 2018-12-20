package org.rosi.crom.validation;

import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;

public class Utils {
	public static URI getURI(URL resourceURL) throws URISyntaxException{
		java.net.URI uri = resourceURL.toURI();
		URI uriEMF = URI.createURI(uri.toString());
		return uriEMF;
	}
	
}
