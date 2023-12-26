package ua.edu.ucu.apps.demo.task3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PDLReader {

    @SneakyThrows
    public static Map<String, String> extract(String domain) {
        URL url = new URL(domain);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        try {
            // Parse HTML content using Jsoup
            Document document = Jsoup.parse(connection.getInputStream(), "UTF-8", domain);

            // Extract relevant information from the HTML
            String name = extractName(document);
            String description = extractDescription(document);
            String logo = extractLogo(document);

            // Create a map to store the extracted information
            Map<String, String> pdlData = new HashMap<>();
            pdlData.put("name", name);
            pdlData.put("description", description);
            pdlData.put("logo", logo);

            return pdlData;
        } finally {
            connection.disconnect();
        }
    }

    private static String extractName(Document document) {
        // Implement logic to extract company name from HTML
        // Example:
        Element nameElement = document.select("meta[property=og:title]").first();
        return (nameElement != null) ? nameElement.attr("content") : "";
    }

    private static String extractDescription(Document document) {
        // Implement logic to extract company description from HTML
        // Example:
        Element descriptionElement = document.select("meta[name=description]").first();
        return (descriptionElement != null) ? descriptionElement.attr("content") : "";
    }

    private static String extractLogo(Document document) {
        // Implement logic to extract company logo from HTML
        // Example:
        Element logoElement = document.select("meta[property=og:image]").first();
        return (logoElement != null) ? logoElement.attr("content") : "";
    }
}
