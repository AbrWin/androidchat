package com.abrsoftware.androidchat.domain.useCases;

/**
 * Created by json on 10/06/16.
 */
public interface LoginInteractor {
    void checkSesion();
    void doSignIn(String mail, String password);
    void doSignUp(String mail, String password);
}
