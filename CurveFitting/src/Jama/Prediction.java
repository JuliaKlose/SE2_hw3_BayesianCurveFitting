package Jama;
import java.util.ArrayList;
import java.util.Scanner;

public class Prediction {
    public static void main(String[] argv)
    {
        //String name = new String(argv[0]);
    	//int num=0;
    	//ReadCSV reader;
    	//double absMeanErr = 0.0;	// absolute mean error
		//double relErr = 0.0;	// relative error;
		//double sumErr = 0.0;
		//double sumPrice = 0.0;
        //String cont = "Y";
        ArrayList<Double> predictValue = new ArrayList<Double>();
        ReadCSV dataImport = new ReadCSV();
       
       // while(cont.equals("Y") || cont.equals("y")) {
			String[] symbolList = {"AMZN", "MACYS", "BABA", "FB", "GOOG", "MSFT", "TWITTER", "ITL", "WMT", "APPL"};
			System.out.println("Please choose a stock symbol:");
			for(int i = 0; i < symbolList.length; i++) {
				System.out.println((i + 1) + ". " + symbolList[i]);
			}
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
	   String name = symbolList[choice-1]+".csv";
		while(choice <= 0 || choice > symbolList.length ) {
			System.out.println("Please enter again.");
				choice = sc.nextInt();
		}
		int day = dataImport.readCSV(name).size()-9;
		for(int k=0;k<10;k++)
       {
           ArrayList<Double> price1 = new ArrayList<>();
           for (int i = 0+k; i <=dataImport.readCSV(name).size()-10+k; i++) 
           {
               price1.add(dataImport.readCSV(name).get(i));
           }
           CurveFitting curveFitting1 = new CurveFitting(price1);
           predictValue.add(curveFitting1.predict());
       }
		//double actualPrice = 0.0;
		//if(choice < symbolList.length) {
		//	actualPrice = price1();
		//}
		
		if(choice <= symbolList.length){
        for(int i=0;i<10;i++) {
            System.out.println("The predicted price of day "+ (day+i) + " is: ");
            System.out.println(predictValue.get(i));
          }
        //System.out.println("Continue? (Y/N)");
		//cont = sc.next();
		}

        //System.out.println(price.size());

      }
}
