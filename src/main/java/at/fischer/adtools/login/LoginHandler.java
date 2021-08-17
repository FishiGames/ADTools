package at.fischer.adtools.login;

/*
 * Copyright © David Fischer
 */

import com.sun.jndi.ldap.LdapCtxFactory;
import lombok.Getter;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import java.util.Hashtable;

@Getter
public class LoginHandler {
    private DirContext dirContext;

    private final String server;
    private final String domainName;
    private final String username;

    public LoginHandler(final String server, final String domainName, final String username, final String password) {
        this.server = server;
        this.domainName = domainName;
        this.username = username;

        try {
            final Hashtable<String, String> hashtable = new Hashtable<>();
            final String principalName = username + "@" + domainName;

            hashtable.put(Context.SECURITY_PRINCIPAL, principalName);
            hashtable.put(Context.SECURITY_CREDENTIALS, password);

            this.dirContext = LdapCtxFactory
                    .getLdapCtxInstance("ldap://" + server + "." + domainName + '/', hashtable);
        } catch (final AuthenticationException authenticationException) {
            System.out.println("Authentication failed: " + authenticationException);
            System.exit(1);
        } catch (final NamingException namingException) {
            System.out.println("Failed to bind to LDAP / get account information: " + namingException);
            System.exit(1);
        }
    }
}
