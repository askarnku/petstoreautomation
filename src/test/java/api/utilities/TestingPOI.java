package api.utilities;

import java.io.IOException;
import java.util.Iterator;

public class TestingPOI {
	
	public static void main(String[] args) throws IOException {
		DataProviders dp = new DataProviders();

		String[][] data = dp.getAllData();

        for (String[] it : data) {
            String[] datum = it;
            for (int j = 0; j < data[0].length; j++) {
                System.out.print(" " + datum[j]);
            }
            System.out.println();
        }

	}

}
