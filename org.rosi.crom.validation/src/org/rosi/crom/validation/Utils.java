package org.rosi.crom.validation;

import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;

/** URI util methods
 * @author Florian Amberg
 *
 */
public class Utils {
	
	/** Retrieve an URI
	 * @param resourceURL
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI getURI(URL resourceURL) throws URISyntaxException{
		java.net.URI uri = resourceURL.toURI();
		URI uriEMF = URI.createURI(uri.toString());
		return uriEMF;
	}
	
}
