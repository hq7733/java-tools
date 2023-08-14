package com.htools.encryption;

/**
 * @author hq
 * @date 2023/8/10
 */
public enum SymmetricAlgorithm {
    AES("AES"),
    ARCFOUR("ARCFOUR"),
    Blowfish("Blowfish"),
    DES("DES"),
    DESede("DESede"),
    RC2("RC2"),
    PBEWithMD5AndDES("PBEWithMD5AndDES"),
    PBEWithSHA1AndDESede("PBEWithSHA1AndDESede"),
    PBEWithSHA1AndRC2_40("PBEWithSHA1AndRC2_40");

    private final String value;

    private SymmetricAlgorithm(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
