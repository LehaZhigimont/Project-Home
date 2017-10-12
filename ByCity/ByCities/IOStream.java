package ByCities;

import java.io.*;
import java.util.*;

public class IOStream{
    private File file = new File("resources\\NoNullCities.txt");
    private List<String> AllCities = new ArrayList<>();
    private List<String> NoNullCities = new LinkedList();
    private List<String> DistancesCitiesIt = new LinkedList();
    private List<String> DistancesCitiesBy = new LinkedList();
    boolean createdByDistancesCities = true;
    private String[] paramCity;
    private Scanner scr;
    private String line;


    public void IOStream() {
        readByCities();
        browseList();
    }

    private void bigCitiesBy (String city){
        if(paramCity[0].equals("by")){
                int i = Integer.parseInt(paramCity[4]);
                if(i>50000){
                    System.out.println(city);
                }
        }
    }

    private void noNullCities (String city){
        NoNullCities.add(city);
        writesFiles(file);
    }

    private void distanceCities (String city){
        double minNorth = 0;
        double maxNorth = 0;
        if("it".equals(paramCity[0]) && createdByDistancesCities){
            DistancesCitiesBy.addAll(DistancesCitiesIt);
            DistancesCitiesIt.clear();
            createdByDistancesCities = false;
        }
        if (!DistancesCitiesIt.isEmpty()) {
            minNorth = parsDouble(DistancesCitiesIt.get(0)); //текущий параметр
        }
        double inputNorth = Double.parseDouble(paramCity[5]); //пришедший параметр
        if(DistancesCitiesIt.size()<2){
            if (DistancesCitiesIt.isEmpty()){
                DistancesCitiesIt.add(city);
            }else if (minNorth>inputNorth){
                DistancesCitiesIt.add(0, city);
            }else{
                DistancesCitiesIt.add(1,city);
            }
        }else {
            maxNorth = parsDouble(DistancesCitiesIt.get(1));
            if(minNorth>inputNorth){
                DistancesCitiesIt.remove(0);
                DistancesCitiesIt.add(0,city);
            }else if (maxNorth<inputNorth){
                DistancesCitiesIt.remove(1);
                DistancesCitiesIt.add(1,city);
            }
        }
    }

    private double parsDouble(String stroka){
        String[] dist = stroka.split(",");
        return Double.parseDouble(dist[5]);
    }

    private void readByCities (){
        try {
            scr = new Scanner(new File("resources\\ByCities.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("WTF?! Where file?");
        }
        while(scr.hasNext()) {
            line = scr.nextLine();
            AllCities.add(line);
        }
        scr.close();
    }

    private void writesFiles (File file){
        FileWriter noNull = null;
        try {
             noNull = new FileWriter(file, true);
            noNull.write(NoNullCities.toString());
            noNull.flush();
        } catch (IOException e) {
            //do not
        }finally {
            try {
                if(!(noNull.equals(null))) {
                    noNull.close();
                }
            } catch (IOException e) {
                //do not
            }
        }
    }

    private void browseList(){
        Iterator<String> city = AllCities.iterator();
        while (city.hasNext()) {
            line = city.next();
            paramCity = line.split(",");
            if(!paramCity[4].isEmpty()) {
                noNullCities(line);
                bigCitiesBy(line);
            }
            distanceCities(line);
        }
    }
}
