package com.codyfjm.androidlib.net;

/**
 * author：codyfjm on 18/3/26
 * email：CodyFeng@lansion.cn
 * company:MIDONG TECHENOLOGY
 * Copyright © 2018 MIDONG TECHENOLOGY All rights reserved.
 */
public class URLData {

    private String key;
    private long expires;
    private String netType;
    private String url;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
