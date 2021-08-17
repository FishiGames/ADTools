package at.fischer.adtools.user;

/*
 * Copyright © David Fischer
 */

import at.fischer.adtools.ADTools;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchResult;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class ADUser {
    private final SearchResult searchResult;
    private final Attributes attributes;

    public ADUser(final SearchResult searchResult) {
        this.searchResult = searchResult;
        this.attributes = searchResult.getAttributes();
    }

    @SneakyThrows
    public String getAttribute(final String attribute) {
        return this.attributes.get(attribute).get().toString();
    }

    public String getFirstname() {
        return this.getAttribute("givenName");
    }

    public String getSurname() {
        return this.getAttribute("sn");
    }

    public Integer getLogonCount() {
        return Integer.valueOf(this.getAttribute("logonCount"));
    }

    public String getMailAddress() {
        return this.getAttribute("mail");
    }

    public String getDistinguishedName() {
        return this.getAttribute("distinguishedName");
    }

    public String getCountry() {
        return this.getAttribute("co");
    }

    public String getCountryShort() {
        return this.getAttribute("c");
    }

    public Integer getCountryCode() {
        return Integer.valueOf(this.getAttribute("countryCode"));
    }

    public Integer getPostalCode() {
        return Integer.valueOf(this.getAttribute("postalCode"));
    }

    public String getStreetAddress() {
        return this.getAttribute("streetAddress");
    }

    public String getPhysicalDeliveryOffice() {
        return this.getAttribute("physicalDeliveryOffice");
    }

    public String getSamAccountName() {
        return this.getAttribute("sAMAccountName");
    }

    @SneakyThrows
    public List<String> getGroups() {
        final List<String> groups = new ArrayList<>();
        final Attribute memberOf = this.attributes.get("memberOf");
        if (memberOf != null) {
            for (int i = 0; i < memberOf.size(); i++) {
                Attributes attributes = ADTools.getLoginHandler().getDirContext().getAttributes(memberOf.get(i).toString(), new String[] {"CN"});
                Attribute attribute = attributes.get("CN");
                groups.add(attribute.get().toString());
            }
        }

        return groups;
    }
}