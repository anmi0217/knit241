package org.knit.solutions.ClassesSem1.lab1;

//todo create class SimpleUrl()
// SimpleUrl url= new SimpleUrl();
// url.setAddress(address);
// url.setProtocol(protocol)
// System.out.println(url);
public class SimpleUrl {
    private String protocol;
    private String address;
    private String domainZone;
    private String siteName;
    private String webpageName;
    private String webpageExtension;
    private String intParam;
    private String doubleParam;
    private String textParam;

    // Геттеры и сеттеры для каждого поля
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

    public String getWebpageExtension() {
        return webpageExtension;
    }

    public void setWebpageExtension(String webpageExtension) {
        this.webpageExtension = webpageExtension;
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

    public String getTextParam() {
        return textParam;
    }

    public void setTextParam(String textParam) {
        this.textParam = textParam;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "SimpleUrl {" +
                "protocol='" + protocol + '\'' +
                ", address='" + address + '\'' +
                ", domainZone='" + domainZone + '\'' +
                ", siteName='" + siteName + '\'' +
                ", webpageName='" + webpageName + '\'' +
                ", webpageExtension='" + webpageExtension + '\'' +
                ", intParam='" + intParam + '\'' +
                ", doubleParam='" + doubleParam + '\'' +
                ", textParam='" + textParam + '\'' +
                '}';
    }
}
