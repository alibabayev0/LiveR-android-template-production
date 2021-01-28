package com.gaan.liver.ui.auth.login;

public interface ILoginNavigator {
    void openArActivity();
    void openForgotPasswordActivity();
    void changeViewToUserExist(String username,String profilePicPath);
    void handleError(Throwable throwable);
}
