package com.miguelcr.a03_realmlist;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by miguelcampos on 8/6/17.
 */

public class Notas extends RealmObject {

    @PrimaryKey
    private long id;
    private long idCategoria;
    private String textoNota;

    public Notas() {
    }

    public Notas(long idCategoria, String textoNota) {
        this.id = MyApp.NotasID.incrementAndGet();
        this.idCategoria = idCategoria;
        this.textoNota = textoNota;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTextoNota() {
        return textoNota;
    }

    public void setTextoNota(String textoNota) {
        this.textoNota = textoNota;
    }
}
