package org.knit.lab1;

public class SimpleUrl {

    protected String protocol;
    protected String address;
    protected String domainZone;
    protected String siteName;
    protected String webpageName;
    protected String webPageExtention;
    protected String intParam;
    protected String doubleParam;
    protected String textParameter;


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

    public String getWebPageExtention() {
        return webPageExtention;
    }

    public void setWebPageExtention(String webPageExtension) {
        this.webPageExtention = webPageExtension;
    }

    public String getIntParam() {
        return intParam;
    }

    public void setIntParam(String intParam) {
        this.intParam = intParam;
    }

    public String getDoubleParam() {
        return doubleParam;
    }

    public void setDoubleParam(String doubleParam) {
        this.doubleParam = doubleParam;
    }

    public String gettextParameter() {
        return textParameter;
    }

    public void settextParameter(String textParameter) {
        this.textParameter = textParameter;
    }

    @Override
    public String toString() {
        return "protocol = " + protocol + "\n" +
                "address = " + address + "\n" +
                "domainZone = " + domainZone + "\n" +
                "siteName = " + siteName + "\n" +
                "webpageName = " + webpageName + "\n" +
                "webPageExtension = " + webPageExtention + "\n" +
                "intParam = " + intParam + "\n" +
                "doubleParam = " + doubleParam + "\n" +
                "textParameter = " + textParameter;
    }

}
