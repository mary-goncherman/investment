package com.invest.analitics.domain;

public class AssetStorageException extends Exception {
    public AssetStorageException(String message) {
        super(message);
    }

    public AssetStorageException(Throwable cause) {
        super(cause);
    }
}
