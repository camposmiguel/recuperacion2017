package com.miguelcr.a03_realmlist;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.prodiel.partesdetrabajo.commons.Constantes;
import com.prodiel.partesdetrabajo.entities.localdb.BrigadaDB;
import com.prodiel.partesdetrabajo.entities.localdb.DesgloseHoraDB;
import com.prodiel.partesdetrabajo.entities.localdb.EncuestaDB;
import com.prodiel.partesdetrabajo.entities.localdb.FotosEncuestaDB;
import com.prodiel.partesdetrabajo.entities.localdb.FotosOtDB;
import com.prodiel.partesdetrabajo.entities.localdb.FotosProcesoDB;
import com.prodiel.partesdetrabajo.entities.localdb.IncidenciaVehiculoDB;
import com.prodiel.partesdetrabajo.entities.localdb.OrdenTrabajoDB;
import com.prodiel.partesdetrabajo.entities.localdb.ProcesoDB;

import java.util.concurrent.atomic.AtomicLong;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by miguelcampos on 24/3/17.
 */

public class MyApp extends Application {

    public static AtomicLong NotasID = new AtomicLong();
    public static AtomicLong CategoriasID = new AtomicLong();


    @Override
    public void onCreate() {
        super.onCreate();

        initRealm();

        Realm realm = Realm.getDefaultInstance();
        NotasID = getIdByTable(realm, Notas.class);
        CategoriasID = getIdByTable(realm, Categorias.class);
        realm.close();

    }

    private void initRealm() {
        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(2)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private <T extends RealmObject> AtomicLong getIdByTable(Realm realm, Class<T> anyClass) {
        // SELECT * FROM anyClass
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicLong(results.max("id").intValue()) : new AtomicLong();
    }

}