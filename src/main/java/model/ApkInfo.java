package model;

import java.io.File;
import java.text.SimpleDateFormat;

public class ApkInfo {

    private String name;
    private String version;
    private String url;
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static ApkInfo parse(File file) {
        ApkInfo apkInfo = null;
        if (file.exists() && file.isFile()) {
            apkInfo = new ApkInfo();
            apkInfo.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
            apkInfo.setName(file.getName());
            apkInfo.setVersion("url");
            apkInfo.setUrl("/url");
        }
        return apkInfo;
    }

    @Override
    public String toString() {
        return "name=" + name + " url=" + url;
    }
}
