package at.fischer.adtools.utility;

/*
 * Copyright © David Fischer
 */

public final class StringUtility {

    public static String toDCString(String domainName) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final String value : domainName.split("\\.")) {
            if (value.length() == 0)
                continue;
            if (stringBuilder.length() > 0)
                stringBuilder.append(",");
            stringBuilder.append("DC=").append(value);
        }
        return stringBuilder.toString();
    }
}
