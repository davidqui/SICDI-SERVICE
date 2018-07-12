package com.laamware.ejercito.doc.web.docwebservice.util;

import java.util.UUID;

public class GeneralUtils {

    public final static String newId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * Genera un arreglo de UUIDs.
     *
     * @param quantity Cantidad de UUIDs a generar.
     * @return Arreglo de UUIDs.
     */
    /*
     * 2018-04-13 jgarcia@controltechcg.com Issue #156 (SICDI-Controltech)
     * feature-156: Método de apoyo.
     */
    public final static String[] generateUUIDs(final int quantity) {
        final String[] array = new String[quantity];

        for (int i = 0; i < array.length; i++) {
            array[i] = newId();
        }

        return array;
    }

}
