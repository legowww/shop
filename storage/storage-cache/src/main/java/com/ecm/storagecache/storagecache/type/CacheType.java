package com.ecm.storagecache.storagecache.type;

import lombok.Getter;

@Getter
public enum CacheType {

    KEYWORD("KEYWORD", 500, 5);

    private final String name;
    private final int maximumSize;
    private final int expireAfterWriteHour;

    CacheType(
            String name,
            int maximumSize,
            int expireAfterWriteHour
    ) {
        this.name = name;
        this.maximumSize = maximumSize;
        this.expireAfterWriteHour = expireAfterWriteHour;
    }
}
