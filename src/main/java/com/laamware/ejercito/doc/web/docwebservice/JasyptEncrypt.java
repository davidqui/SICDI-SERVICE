package com.laamware.ejercito.doc.web.docwebservice;

/**
 * Clase para el proceso de encriptación.
 *
 * @author edison.gonzalez@controltechcg.com
 * @since Mar 21, 2018
 * @version 1.0.0 (feature-154).
 */
public class JasyptEncrypt {

    /*
    * Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files.
    * Se reemplazan los archivos: local_policy.jar y US_export_policy.jar, para que
    * genere cifrado mas fuerte.
    */
    public static final String CLAVE_ENCRIPTACION = "QA[H]%S0SwNE$hWpcZ:h,P_#/J[V8?w?FRACaxe9VAVx8?7Sy0<R'lZj{^}'AM^";

    /**
     * "jasypt.encryptor.password": Nombre del atributo de la lLave para
     * descifrar propiedades del archivo de propiedades.
     */
    public static final String KEY_SYSTEM = "jasypt.encryptor.password";


    /**
     * Método de ejecución para setear la variable en el sistema.
     *
     */
    public static void setVariableAmbiente() {
        System.setProperty(KEY_SYSTEM, CLAVE_ENCRIPTACION);
    }
}
