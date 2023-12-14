package src.facade;

import src.facade.DataFetcher;

import java.io.FileWriter;
import java.io.IOException;

public class DataFetcherFacade {

    private DataFetcher dataFetcher;

    public DataFetcherFacade() {
        this.dataFetcher = new DataFetcher();
    }

    public void fetchAndSaveDataForYear(int year) {
        String csvData = dataFetcher.fetchHtmlContent(year);
        if (csvData != null) {
            saveDataToFile(year, csvData);
        }
    }

    private void saveDataToFile(int year, String data) {
        try (FileWriter fileWriter = new FileWriter("data/NBA_" + year + "_data.csv")) {
            fileWriter.write(data);
            System.out.println("Data for year " + year + " saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
