package com.abrsoftware.androidchat.aplication;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by json on 9/06/16.
 */
public class FireBaseHelper {
    private Firebase dataReference;
    private String SEPARATOR = "__";
    private String CHATS_PATH = "chats";
    private String USERS_PATH = "users";
    private String CONTACTS_PATH = "contacs";
    private String FIREBASE_URL = "https://mychat-abrsoftware.firebaseio.com/";

    public static class SingletonHolder{
        private static final FireBaseHelper INSTANCE = new FireBaseHelper();
    }

    public static FireBaseHelper getInstance(){
        return  SingletonHolder.INSTANCE;
    }

    public FireBaseHelper(){
        this.dataReference = new Firebase(FIREBASE_URL);
    }

    public Firebase getDataReference(){
        return dataReference;
    }

    public String getUserAuthEmail(){
        AuthData authData = dataReference.getAuth();
        String email = null;
        if(authData != null){
            Map<String, Object> providerData = authData.getProviderData();
            email = providerData.get("email").toString();
        }
        return email;
    }

    public Firebase getUserReference(String mail){
        Firebase userReference = null;
        if(mail != null){
            String keyMail = mail.replace(".", "_");
            userReference = dataReference.getRoot().child(USERS_PATH).child(mail);
        }
        return userReference;
    }

    public Firebase getMyUserReference(){
        return getUserReference(getUserAuthEmail());
    }

    public Firebase getOneContactReference(String mainEmail, String childMail){
        String childKey = childMail.replace(".","_");
        return getUserReference(mainEmail).child(CONTACTS_PATH).child(childKey);
    }

    public Firebase getChatsReference(String receiver) {
        String keySender = getUserAuthEmail().replace(".", "_");
        String keyReceiver = receiver.replace(".", "_");
        String keyChat = keySender + SEPARATOR + keyReceiver;
        if(keySender.compareTo(keyReceiver) > 0){
            keyChat = keyReceiver + SEPARATOR + keySender;
        }
        return dataReference.getRoot().child(CHATS_PATH).child(keyChat);
    }

    public void changeUserStatusConnection(boolean status){
        if(getMyUserReference() != null){
            Map<String, Object> updates = new HashMap<String, Object>();
            updates.put("online",status);
            getMyUserReference().updateChildren(updates);
            notifyOfConnectionsChange(status);
        }

    }

    public void notifyOfConnectionsChange(boolean status) {
        notifyOfConnectionsChange(status, false);
    }

    public void signOff(){
        notifyOfConnectionsChange(false, true);
    }

    private void notifyOfConnectionsChange(boolean status, boolean signOff) {
    }

}
