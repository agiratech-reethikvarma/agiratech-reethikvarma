package Train_reservations;

import java.util.Set;
import java.sql.Date;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.HashMap;
//import java.lang.Iterable;

public class Train_list {

//  List of Trains are Created and Stored in Hashtable.
	public void TrainSList() {

	HashMap<String, String[]> TrainList =new HashMap<String, String[]>();
		String[] TR1, TR2, TR3, TR4, TR5, TR6, TR7, TR8, TR9, TR10;
//		Date date;
		
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat sd = new SimpleDateFormat(pattern);
	
		String date = sd.format(new Date(2020,11,1));
		System.out.println(date);
//		String d=sd.toString();
		System.out.println("date is :"+date);
//		System.out.println("date is :"+d);
		
		TR1 = new String[] { "CHENNAI", "AVADI", "PERAMBUR", "THIRUVALLUR",date};
		TR2 = new String[] { "THIRUVALLUR", "PERAMBUR", "AVADI", "CHENNAI",date };
		TR3 = new String[] { "CHENGALPAT", "MARAIMALLAINAGAR", "KATTANGULATTHUR", "POTHERI", "THAMBARAM" };
		TR4 = new String[] { "BEACH", "MAMBALAM", "CHENNAIPARK", "THAMBARAM" };
		TR5 = new String[] { "GUINDY", "PALAVARAM", "CROMPET", "THAMBARAM",(new Date(2022-1900,12-1,24)).toString() };
		TR6 = new String[] { "BEACH", "CHENNAIPORT", "NUNGAMBAKAM", "SAIDAPET", "CHENGALPAT" };
		TR7 = new String[] { "CENTRAL", "AMBATHUR", "PERAMBUR", "VILLIVAKAM", "AVADI" };
		TR8 = new String[] { "AVADI", "VELACHERI", "PATTRAVAKKAM", "ROIAPURAM" };
		TR9 = new String[] { "CHEPAUK", "MADAVELI", "THARAMANI", "VELACHERI" };
		TR10 = new String[] { "ARAKONAM", "THIRUVALLUR", "AVADI", "VILLIVAKKAM", "CHENNAI" };
		TrainList.put("Train 1", TR1);
		TrainList.put("Train 2", TR2);
		TrainList.put("Train 3", TR3);
		TrainList.put("Train 4", TR4);
		TrainList.put("Train 5", TR5);
		TrainList.put("Train 6", TR6);
		
		TrainList.put("Train 7", TR7);
		TrainList.put("Train 8", TR8);
		TrainList.put("Train 9", TR9);
		TrainList.put("Train 10", TR10);

		Set<String> Trains = TrainList.keySet();
		for (String Key : Trains) {
			System.out.println("## " + Key + " ##");
			for (String train : TrainList.get(Key)) {
				System.out.print(" -" + train + "- ");

			}
			System.out.println();

		}

	}
	public static void main(String[] args) {
		Train_list t=new Train_list();
		t.TrainSList();
	}
}
