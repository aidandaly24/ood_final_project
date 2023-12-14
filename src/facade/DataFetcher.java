package src.facade;

import src.HTTPClient;

public class DataFetcher {

    public String fetchHtmlContent(int year) {
        HTTPClient client = HTTPClient.getInstance();
        String url = "https://www.basketball-reference.com/leagues/NBA_" + year + "_per_game.html";
        try {
            String htmlContent = client.sendGetRequest(url);
            return extractCsvFromHtml(htmlContent);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String extractCsvFromHtml(String htmlContent) {
        String csvData = "";
        String patternString = "<pre id=\"csv_per_game_stats\">(.*?)</pre>";
        Pattern pattern = Pattern.compile(patternString, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(htmlContent);

        if (matcher.find()) {
            csvData = matcher.group(1).trim();
        }

        return csvData;
    }
}
