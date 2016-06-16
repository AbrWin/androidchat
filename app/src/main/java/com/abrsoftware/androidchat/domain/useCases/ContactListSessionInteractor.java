package com.abrsoftware.androidchat.domain.useCases;

/**
 * Created by brown on 15/06/16.
 */
public interface ContactListSessionInteractor {
    void signOff();
    String getCurrentUserMail();
    void changeConnectStatus(boolean status);
}
