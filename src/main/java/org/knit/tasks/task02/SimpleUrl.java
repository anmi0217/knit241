package org.knit.tasks.task02;

import java.util.HashMap;

public class SimpleUrl {
    private String protocol;
    private String siteAddress;
    private String siteName;
    private String siteDomain;
    private String pathToPage;
    private String pageName;
    private String pageExtension;
    private HashMap<String, String> params;

    public SimpleUrl(String url) {;
        String[] addressAndParams = url.split("\\?");
        String[] protocolAndAddress = addressAndParams[0].split("://");
        String protocol = protocolAndAddress[0];
        String address = protocolAndAddress[1];
        String siteAddress = address.substring(0, address.indexOf("/"));
        String siteName = siteAddress.substring(0, siteAddress.indexOf("."));
        String siteDomain = siteAddress.substring(siteAddress.indexOf(".") + 1);
        String pathToPage = address.substring(address.indexOf("/"), address.lastIndexOf("/") + 1);
        String pageName = address.substring(address.lastIndexOf("/") + 1);
        String pageExtension = pageName.substring(pageName.indexOf(".") + 1);
        String[] paramsArray = addressAndParams[1].split("&");
        HashMap<String, String> params = new HashMap<>();
        for (String p : paramsArray) {
            int i = p.indexOf("=");
            params.put(p.substring(0, i), p.substring(i));
        }
        this.protocol = protocol;
        this.siteAddress = siteAddress;
        this.siteName = siteName;
        this.siteDomain = siteDomain;
        this.pathToPage = pathToPage;
        this.pageName = pageName;
        this.pageExtension = pageExtension;
        this.params = params;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteDomain() {
        return siteDomain;
    }

    public void setSiteDomain(String siteDomain) {
        this.siteDomain = siteDomain;
    }

    public String getPathToPage() {
        return pathToPage;
    }

    public void setPathToPage(String pathToPage) {
        this.pathToPage = pathToPage;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageExtension() {
        return pageExtension;
    }

    public void setPageExtension(String pageExtension) {
        this.pageExtension = pageExtension;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "protocol = " + protocol + "\n" +
                "siteAddress = " + siteAddress + "\n" +
                "siteName = " + siteName + "\n" +
                "siteDomain = " + siteDomain + "\n" +
                "pathToPage = " + pathToPage + "\n" +
                "pageName = " + pageName + "\n" +
                "pageExtension = " + pageExtension + "\n" +
                "params = " + params;
    }
}
