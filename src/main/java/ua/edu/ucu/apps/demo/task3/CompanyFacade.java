package ua.edu.ucu.apps.demo.task3;

import java.util.HashMap;
import java.util.Map;

public class CompanyFacade {

    private PDLReader pdlReader;
    private CompanyEnricher companyEnricher;

    public CompanyFacade() {
        this.pdlReader = new PDLReader();
        this.companyEnricher = new CompanyEnricher();
    }

    public CompanyData getCompanyData(String domain) {
        // Extract data from PDL
        Map<String, String> pdlData = pdlReader.extract(domain);

        // Extract data from Web Scraping + Jsoup
        CompanyData webScrapingData = companyEnricher.enrich(domain);

        // Merge the data from both sources
        return mergeData(pdlData, webScrapingData);
    }

    private CompanyData mergeData(Map<String, String> pdlData, CompanyData webScrapingData) {
        Map<String, String> mergedData = new HashMap<>();

        // If PDL data is available, add it to mergedData
        if (pdlData != null) {
            mergedData.putAll(pdlData);
        }

        // If Web Scraping data is available, add it to mergedData
        if (webScrapingData != null) {
            mergedData.put("domain", webScrapingData.getDomain());
            mergedData.put("description", webScrapingData.getDescription());
            mergedData.put("logo", webScrapingData.getLogo());
            // Add other web scraping data if needed
        }

        // Create a CompanyData object from the merged data
        return createCompanyData(mergedData);
    }

    private CompanyData createCompanyData(Map<String, String> data) {
        CompanyData companyData = new CompanyData();
        companyData.setDomain(data.get("domain"));
        companyData.setDescription(data.get("description"));
        companyData.setLogo(data.get("logo"));
        // Add other data if needed

        return companyData;
    }
}
