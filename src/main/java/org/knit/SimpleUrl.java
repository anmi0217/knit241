package org.knit;

import java.util.HashMap;

public class SimpleUrl {
    private String protocol;
    private String siteAddress;
    private String siteName;
    private String siteDomain;
    private String pathToWebPage;
    private String webPageName;
    private String webPageExtension;
    private HashMap<String, String> params;

    public SimpleUrl(String url) {;
        String[] addressAndParams = url.split("\\?");
        String[] paramsArray = addressAndParams[1].split("&");
        HashMap<String, String> params = new HashMap<>();
        for (String p : paramsArray) {
            int i = p.indexOf("=");
            params.put(p.substring(0, i), p.substring(i));
        }
        System.out.println(params);
    }
}
