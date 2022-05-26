package Train_reservations;

import java.util.Set;
import java.util.*;
import java.util.HashMap;

public class Train_list {

//  List of Trains are Created and Stored in Hashtable.
	public Train_list(String as, String ds, String rd) {

		HashMap<String, String[]> TrainList = new HashMap<String, String[]>();
		String[] TR1, TR2;
		
//		ArrayList <Train_list> mappinglist = new ArrayList<Train_list>();
		
//		TR3, TR4, TR5, TR6, TR7, TR8, TR9, TR10;
//Created the list of trains.
		TR1 = new String[] { "CHENNAI", "AVADI", "PERAMBUR", "THIRUVALLUR", "2022-12-10" };
		TR2 = new String[] { "THIRUVALLUR", "PERAMBUR", "AVADI", "CHENNAI", "2022-12-11" };
//		TR3 = new String[] { "CHENGALPAT", "MARAIMALLAINAGAR", "KATTANGULATTHUR", "THAMBARAM", "2022-12-10" };
//		TR4 = new String[] { "BEACH", "MAMBALAM", "CHENNAIPARK", "THAMBARAM", "2022-12-10" };
//		TR5 = new String[] { "GUINDY", "PALAVARAM", "CROMPET", "THAMBARAM", "2022-12-10" };
//		TR6 = new String[] { "BEACH", "CHENNAIPORT", "NUNGAMBAKAM", "SAIDAPET", "CHENGALPAT", "2022-12-10" };
//		TR7 = new String[] { "CENTRAL", "AMBATHUR", "PERAMBUR", "VILLIVAKAM", "AVADI", "2022-12-11" };
//		TR8 = new String[] { "AVADI", "VELACHERI", "PATTRAVAKKAM", "ROYAPURAM", "2022-12-09" };
//		TR9 = new String[] { "CHEPAUK", "MADAVELI", "CHENNAI", "THARAMANI", "VELACHERI", "2022-12-09" };
//		TR10 = new String[] { "ARAKONAM", "THIRUVALLUR", "AVADI", "VILLIVAKKAM", "CHENNAI", "2022-12-10" };

		TrainList.put("Train 1", TR1);
		TrainList.put("Train 2", TR2);
//		TrainList.put("Train 3", TR3);
//		TrainList.put("Train 4", TR4);
//		TrainList.put("Train 5", TR5);
//		TrainList.put("Train 6", TR6);
//		TrainList.put("Train 7", TR7);
//		TrainList.put("Train 8", TR8);
//		TrainList.put("Train 9", TR9);
//		TrainList.put("Train 10", TR10);
		
		
		as = as.toUpperCase();
		ds = ds.toUpperCase();

		System.out.println("Available trains from " + as + " to " + ds + " for date " + rd + " is given below...");
		Set<String> Trains = TrainList.keySet();
		int st1 = 0, st2 = 0;
		int st3 = 0;
		System.out.println("\n");
		for (String Key : Trains) {
			for (String train : TrainList.get(Key)) {
				if (train.equals(as)) {
					st1 = 1;

				}
				if (train.equals(ds)) {
					st2 = 1;

				}
				if (train.equals(rd)) {
					st3 = 1;

				}
			}

			if (st1 == 1 && st2 == 1 && st3 == 1) {
				System.out.print(Key);

				for (String train : TrainList.get(Key)) {
					System.out.print(" -" + train + "-");
				}
				System.out.println();
			}

			st1 = 0;
			st2 = 0;
			st3 = 0;

		}


	}

}
