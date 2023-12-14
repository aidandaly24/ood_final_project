package src.state;

import src.facade.DataFetcherFacade;

public class FetchingDataState implements State {

    @Override
    public void handleInput(AppContext context, int[] years_needed) {
        System.out.println("Fetching data for years: " + Arrays.toString(years_needed));
        for (int year : years_needed) {
            DataFetcherFacade facade = new DataFetcherFacade();
            facade.fetchDataForYear(year);
        }

        int[] needed_years = areYearsAllThere(years_needed);
        if (needed_years.length > 0) {
            context.setState(new FetchingDataState);
            context.handleInput(needed_years);
        }

        context.setState(new ReadyForComparisonState());
        context.handleInput();

    }

    public static int[] areYearsAllThere(int[] years_needed) {
        List<Integer> yearsNeedingData = new ArrayList<>();
        File dataFolder = new File("data");

        for (int year : years_needed) {
            File dataFile = new File(dataFolder, "NBA_" + year + "_data.csv");
            if (!dataFile.exists()) {
                yearsNeedingData.add(year);
            }
        }

        return yearsNeedingData.stream().mapToInt(i -> i).toArray();
    }
    
}
