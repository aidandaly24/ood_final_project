package src.state;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FetchingYearsState implements State {

    @Override
    public void handleInput(AppContext context) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter the season you would like your data to start from (min: 1950): ");
                String earliest_year = scanner.nextLine();

                System.out.println("Enter the season you would like your data to end (max: 2023): ")
                String latest_year = scanner.nextLine();

                int int_early_year = Integer.parseInt(earliest_year);
                int int_late_year = Integer.parseInt(latest_year);
            } catch (NumberFormatException e) {
                System.out.println("Invalid year input. Please enter a valid year. \n");
            }

            if (int_early_year < 1950 | int_late_year > 2023) {
                System.out.println("One or both of the years you input exceed the bounds of data available. Please try again. \n")
                continue;
            }

            int[] years_needed = getYearsNeedingData(int_early_year, int_late_year);

            context.setState(new FetchingDataState());
            context.handleInput(years_needed);
        }
    }


    public static int[] getYearsNeedingData(int lowerYear, int upperYear) {
        List<Integer> yearsNeedingData = new ArrayList<>();
        File dataFolder = new File("data");

        for (int year = lowerYear; year <= upperYear; year++) {
            File dataFile = new File(dataFolder, "NBA_" + year + "_data.csv");
            if (!dataFile.exists()) {
                yearsNeedingData.add(year);
            }
        }

        return yearsNeedingData.stream().mapToInt(i -> i).toArray();
    }

}
