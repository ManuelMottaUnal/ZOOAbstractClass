package com.unal.utils;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class Firebase {
    private static Firestore db;
    public static void initializeApp() {
        FileInputStream serviceAccount;
        try {
            serviceAccount = new FileInputStream("zoologico-fe14b-firebase-adminsdk-j634z-04aca10908.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Como que se conectó, creo: ");
            db = FirestoreClient.getFirestore();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Firebase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Firebase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void read() throws InterruptedException, ExecutionException {
        ApiFuture<QuerySnapshot> query = db.collection("zoo").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            System.out.println("Id: " + document.getId());
            System.out.println("Apellido: " + document.getString("apellido"));
            
        }
    }
}
