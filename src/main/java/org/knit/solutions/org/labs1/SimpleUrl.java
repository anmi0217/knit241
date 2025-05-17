package org.knit.solutions.org.labs1;


public class SimpleUrl {

    private String protocol;
    private String address;
    private String domainZone;
    private String siteName;
    private String webpageName;
    private String webPageExtension;

    public SimpleUrl(String url) {
        parseUrl(url);
    }

    private void parseUrl(String url) {
        try {
            java.net.URL parsedUrl = new java.net.URL(url);
            this.protocol = parsedUrl.getProtocol();
            String host = parsedUrl.getHost();
            this.address = host;
            String[] hostParts = host.split("\\.");
            this.siteName = hostParts[0];
            this.domainZone = hostParts[1];
            String[] pathParts = parsedUrl.getPath().split("/");
            this.webpageName = pathParts[pathParts.length - 1].split("\\.")[0];
            this.webPageExtension = pathParts[pathParts.length - 1].split("\\.")[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDomainZone() {
        return domainZone;
    }

    public void setDomainZone(String domainZone) {
        this.domainZone = domainZone;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getWebpageName() {
        return webpageName;
    }

    public void setWebpageName(String webpageName) {
        this.webpageName = webpageName;
    }

    public String getWebPageExtension() {
        return webPageExtension;
    }

    public void setWebPageExtension(String webPageExtension) {
        this.webPageExtension = webPageExtension;
    }

    @Override
    public String toString() {
        return "protocol = " + protocol + "\n" +
                "address = " + address + "\n" +
                "domainZone = " + domainZone + "\n" +
                "siteName = " + siteName + "\n" +
                "webpageName = " + webpageName + "\n" +
                "webPageExtension = " + webPageExtension;
    }
}
