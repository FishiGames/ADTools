package at.fischer.adtools.user;

/*
 * Copyright © David Fischer
 */

import at.fischer.adtools.ADTools;
import at.fischer.adtools.exception.ADUserNotFoundException;
import at.fischer.adtools.utility.StringUtility;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import static javax.naming.directory.SearchControls.SUBTREE_SCOPE;

@Getter
public class ADUserHandler {
    private final SearchControls searchControls;

    public ADUserHandler() {
        this.searchControls = new SearchControls();
        this.searchControls.setSearchScope(SUBTREE_SCOPE);
    }

    @SneakyThrows
    public final ADUser findADUser(final String samAccountName) {
        final String principalName = samAccountName + "@" + ADTools.getLoginHandler().getDomainName();

        try {
            final NamingEnumeration<SearchResult> namingEnumeration =
                    ADTools.getLoginHandler().getDirContext().
                            search(StringUtility.toDCString(ADTools.getLoginHandler().getDomainName()),
                                    "(& (userPrincipalName=" + principalName + ")(objectClass=user))", searchControls);

            final SearchResult searchResult = namingEnumeration.next();
            return new ADUser(searchResult);
        } catch (final NamingException namingException) {
            throw new ADUserNotFoundException("The user \"" + samAccountName + "\" couldn't be found!");
        }
    }
}