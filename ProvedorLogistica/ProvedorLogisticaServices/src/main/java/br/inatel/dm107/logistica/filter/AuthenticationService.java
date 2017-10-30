package br.inatel.dm107.logistica.filter;

import java.io.IOException;
import java.util.Base64;

public class AuthenticationService {

	public boolean authenticate(String credentials) {
//		System.out.println(credentials);
//
//		return true;
		
		
		//implementar no banco com o usuario logado
		if (null == credentials){
			return false;
		}
		// extraindo o valor vindo do header "Basic encodedstring" for Basic
		// Exemplo: "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = credentials.replaceFirst("Basic" + " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final String usernameAndPassSplit[] = usernameAndPassword.split(":");
		final String username = usernameAndPassSplit[0];
		final String password = usernameAndPassSplit[1];

		// Estamos usando um unico usuario e senha, aqui poderia ser feito via
		// banco de dados
		
		
		boolean authenticationStatus = "dm107".equals(username) && "dm107".equals(password);
		return authenticationStatus;
		
	}

}
