package at.fischer.adtools;

/*
 * Copyright © David Fischer
 */

import at.fischer.adtools.login.LoginHandler;
import at.fischer.adtools.user.ADUserHandler;
import lombok.Getter;

@Getter
public class ADTools {
    private static ADUserHandler adUserHandler;
    private static LoginHandler loginHandler;

    public static void activate(final String domainController, final String domainName, final String username, final String password) {
        loginHandler = new LoginHandler(domainController, domainName, username, password);
        adUserHandler = new ADUserHandler();
    }

    public static ADUserHandler getADUserHandler() {
        return adUserHandler;
    }

    public static LoginHandler getLoginHandler() {
        return loginHandler;
    }
}