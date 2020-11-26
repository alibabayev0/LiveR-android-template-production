package com.gaan.liver.ui.auth.forgotpassword;

public interface IForgotPasswordNavigator {
    void showViewOnResponse();
    void userNotFoundError(Throwable throwable);

    void passwordSuccefullyChangedResponse();
    void passwordChangingError(Throwable throwable);
}
