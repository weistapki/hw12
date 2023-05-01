public class ArrayValueCalculator {
    private static void validateArraySize(String[][] array) throws ArraySizeException {
        if (array.length != 4) {
            throw new ArraySizeException("The array must have 4 rows");
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new ArraySizeException("The array must have 4 columns");
            }
        }
    }

    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        validateArraySize(array);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < array[i].length; k++) {
                try {
                    sum += Integer.parseInt(array[i][k]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(String.format("Invalid data in cell [%d][%d]", i, k), e);
                }
            }
        }
        return sum;
    }
    public static void handleCalculation() {
        String[][] array = {{"1", "1", "1", "1"},
                            {"2", "2", "2", "2"},
                            {"3", "3", "3", "3"},
                            {"4", "4", "4", "4"}};
        try {
                int result = doCalc(array);
                System.out.println(result);
        } catch (ArraySizeException e) {
                System.err.println("The dimension of the array does not meet the requirements.");
                e.printStackTrace();
        } catch (ArrayDataException e) {
                System.err.println("Cell data error: " + e.getMessage());
                e.printStackTrace();
        } catch (Exception e) {
                System.err.println("Unknown error.");
                e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            handleCalculation();
    }
}
