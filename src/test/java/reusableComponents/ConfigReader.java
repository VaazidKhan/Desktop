package reusableComponents;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Utility class for reading configuration from config.properties and strings.xml.
 * Provides thread-safe access to properties and XML string resources, with error logging via LoggerUtils.
 */
public class ConfigReader {
    /** Properties instance for storing configuration from config.properties. */
    private static final Properties properties = new Properties();

    /** HashMap for storing string resources from strings.xml. */
    private static final HashMap<String, String> stringResources = new HashMap<>();

    /** Path to the default configuration file in the file system. */
    private static final String CONFIG_PATH = "config/config.properties";

    /** Path to the default strings file in the classpath. */
    private static final String STRINGS_PATH = "strings/strings.xml";

    static {
        synchronized (ConfigReader.class) {
            // Load config.properties
            try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
                if (input != null) {
                    properties.load(input);
                    LoggerUtils.info("Loaded config.properties from classpath");
                } else {
                    // Fallback to file system
                    try (InputStream fis = new java.io.FileInputStream(CONFIG_PATH)) {
                        properties.load(fis);
                        LoggerUtils.info("Loaded config.properties from file system: " + CONFIG_PATH);
                    } catch (IOException e) {
                        LoggerUtils.error("Failed to load config.properties from file system: " + CONFIG_PATH, e);
                    }
                }
            } catch (IOException e) {
                LoggerUtils.error("Failed to load config.properties from classpath", e);
            }

            // Load strings.xml
            try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(STRINGS_PATH)) {
                if (input != null) {
                    stringResources.putAll(parseStringXML(input));
                    LoggerUtils.info("Loaded strings.xml from classpath: " + STRINGS_PATH);
                } else {
                    LoggerUtils.warn("strings.xml not found in classpath: " + STRINGS_PATH);
                }
            } catch (IOException e) {
                LoggerUtils.error("Failed to load strings.xml from classpath: " + STRINGS_PATH, e);
            }
        }
    }

    /**
     * Retrieves a property value by key from config.properties.
     *
     * @param key The property key.
     * @return The property value, or null if not found or key is invalid.
     */
    public static String getProperty(String key) {
        if (key == null || key.trim().isEmpty()) {
            LoggerUtils.warn("Property key is null or empty");
            return null;
        }
        String value = properties.getProperty(key);
        if (value == null) {
            LoggerUtils.warn("Property not found for key: " + key);
        } else if (value.trim().isEmpty()) {
            LoggerUtils.warn("Property value is empty for key: " + key);
        }
        return value;
    }

    /**
     * Retrieves a property value by key from config.properties with a default value.
     *
     * @param key The property key.
     * @param defaultValue The default value to return if the key is not found.
     * @return The property value, or the default value if not found or key is invalid.
     */
    public static String getProperty(String key, String defaultValue) {
        String value = getProperty(key);
        return value != null ? value : defaultValue;
    }

    /**
     * Retrieves a string resource value by key from strings.xml.
     *
     * @param key The string resource key (name attribute in strings.xml).
     * @return The string resource value, or null if not found or key is invalid.
     */
    public static String getStringResource(String key) {
        if (key == null || key.trim().isEmpty()) {
            LoggerUtils.warn("String resource key is null or empty");
            return null;
        }
        String value = stringResources.get(key);
        if (value == null) {
            LoggerUtils.warn("String resource not found for key: " + key);
        }
        return value;
    }

    /**
     * Parses an XML input stream (strings.xml) and returns a HashMap of string key-value pairs.
     *
     * @param file The InputStream of the XML file to parse.
     * @return A HashMap containing the name attributes and text content of string elements, or an empty HashMap if parsing fails.
     */
    private static HashMap<String, String> parseStringXML(InputStream file) {
        HashMap<String, String> stringMap = new HashMap<>();
        try {
            // Create DocumentBuilder for XML parsing
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input stream into a Document
            Document document = builder.parse(file);

            // Get the root element and normalize the XML structure
            Element root = document.getDocumentElement();
            root.normalize();

            // Get all <string> elements from the XML
            NodeList nList = document.getElementsByTagName("string");

            // Iterate through each <string> element
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    // Store the element's name attribute and text content in the HashMap
                    stringMap.put(eElement.getAttribute("name"), eElement.getTextContent());
                }
            }
        } catch (Exception e) {
            LoggerUtils.error("Failed to parse strings.xml", e);
        }
        return stringMap;
    }
}