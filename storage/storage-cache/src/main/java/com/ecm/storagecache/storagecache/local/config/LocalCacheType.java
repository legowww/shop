package com.ecm.storagecache.storagecache.local.config;

import lombok.Getter;

@Getter
public enum LocalCacheType {

    KEYWORD("KEYWORD", 50, 6);

    private final String name;
    private final int maximumSize;
    private final int refreshAfterWriteHour;

    LocalCacheType(
            String name,
            int maximumSize,
            int refreshAfterWriteHour
    ) {
        this.name = name;
        this.maximumSize = maximumSize;
        this.refreshAfterWriteHour = refreshAfterWriteHour;
    }
}
