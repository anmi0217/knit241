```java
package org.knit;  
  
import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;  
import org.xml.sax.SAXException;  
  
import javax.imageio.ImageIO;  
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;  
import java.awt.image.BufferedImage;  
import java.io.ByteArrayInputStream;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.util.*;  
  
public class Main {  
  
    public static final String CONTENT_TYPE_ATTRIBUTE_NAME = "content-type";  
    public static final String BINARY_TAG = "binary";  
  
    public static final Map<String, String> attributeMap = new HashMap<>();  
  
    static {  
        attributeMap.put("image/png", "png");  
        attributeMap.put("image/jpeg", "jpeg");  
    }  
  
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {  
        System.out.println("Hello world!");  
  
        File file = new File("misc/out");  
        if (!file.exists()) {  
            boolean mkdir = file.mkdir();  
            if (!mkdir) {  
                throw new RuntimeException("create dir failed");  
            }  
        }  
  
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
        Document document = documentBuilder.parse(new File("misc/6742027.fb2"));  
        document.normalize();  
        List<Element> binaryTagElementList = getElementsByTagName(BINARY_TAG, document);  
        int elementIndex = 0;  
        for (Element element : binaryTagElementList) {  
            String attributeValue = element.getAttribute(CONTENT_TYPE_ATTRIBUTE_NAME);  
            if (attributeMap.containsKey(attributeValue)) {  
                elementIndex++;  
                String encodedImage = element.getTextContent();  
                saveEncodedImage(encodedImage, attributeValue, elementIndex);  
                saveEncodedImageByFileOutput(encodedImage, attributeValue, elementIndex);  
            }  
        }  
  
    }  
  
    public static void saveEncodedImageByFileOutput(String encodedImage, String attributeValue, int elementIndex) {  
  
        String imageName = String.format("misc/out/fImage_%d.%s", elementIndex, attributeMap.get(attributeValue));  
  
        byte[] decodedImage = Base64.getDecoder().decode(encodedImage);  
  
        try (FileOutputStream fileOutputStream = new FileOutputStream(imageName)) {  
            fileOutputStream.write(decodedImage);  
        } catch (IOException e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    public static void saveEncodedImage(String encodedImage, String attributeValue, int elementIndex) {  
        byte[] bytes = encodedImage.getBytes();  
        byte[] decoded = Base64.getDecoder().decode(bytes);  
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decoded);  
        BufferedImage image = null;  
        try {  
            image = ImageIO.read(byteArrayInputStream);  
            if (image != null) {  
  
                ImageIO.write(image, attributeMap.get(attributeValue), new File(  
                        String.format("misc/out/image_%d.%s", elementIndex, attributeMap.get(attributeValue))));  
            }  
        } catch (IOException e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    public static List<Element> getElementsByTagName(String tagName, Document document) {  
        NodeList binaryNodeList = document.getElementsByTagName(tagName);  
        int tagCount = binaryNodeList.getLength();  
        List<Element> elements = new ArrayList<>();  
        for (int i = 0; i < tagCount; i++) {  
            Node item = binaryNodeList.item(i);  
            if (item instanceof Element) {  
                elements.add((Element) item);  
            }  
            System.out.println(item.getClass());  
        }  
        return elements;  
    }  
}
```