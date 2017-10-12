package ByCities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class OtherMethods {
    private Scanner scr = null;
    private List spisok = new LinkedList();

    public void OtherMethods() {
        try {
            scr = new Scanner(new File("resources\\ByCities.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while(scr.hasNext()) {
            line = scr.nextLine();
            if(sortCitiesList(line,spisok)){
                spisok.add(line);
            }
        }
        scr.close();
        try {
            FileWriter allWriter = new FileWriter(new File("resources\\NOVOECities.txt"));
            Iterator<String> add = spisok.iterator();
            while(add.hasNext()) {
                allWriter.write(add.next() +"\r\n");
                allWriter.flush();
            }
            allWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String sortCities3 (String city){
        Scanner scan = null;
        double a,b,a1,b1;
        String[] paramCity = city.split(",");
        a=Double.parseDouble(paramCity[5]);
        b=Double.parseDouble(paramCity[6]);
        try {
            scan = new Scanner(new File("resources\\NOVOECities.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line;
        if (!scan.hasNext()){
            try {
                FileWriter noNull = new FileWriter("resources\\NOVOECities.txt", true);
                noNull.write(city + "\r\n");
                noNull.flush();
                noNull.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            scan.close();
            return null;
        }
        while(scan.hasNext()) {
            line = scan.nextLine();
            String[] paramCity1 = line.split(",");
            a1=Double.parseDouble(paramCity1[5]);
            b1=Double.parseDouble(paramCity1[6]);
            if(a==a1 && b==b1){
                scan.close();
                return null;
            }
        }
        if(true){
            try {
                FileWriter noNull = new FileWriter("resources\\NOVOECities.txt", true);
                noNull.write(city + "\r\n");
                noNull.flush();
                noNull.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            scan.close();
            return null;
        }
        scan.close();
        return null;
    }

    private void distanceCities2 (String city){
        Scanner scan = null;
        String[] paramCity = city.split(",");
        try {
            scan = new Scanner(new File("resources\\DistanceCities.txt"));
            if(!scan.equals(null)){
                String line;
                while(scan.hasNext()) {
                    line = scan.nextLine();
                }
            }else if(scan.equals(null)){
                try {
                    FileWriter noNull = new FileWriter("resources\\DistanceCities.txt", true);
                    noNull.write(city + "\r\n");
                    noNull.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            File file = new File("resources\\DistanceCities.txt");
        }
        scan.close();
    }

    private void noNullCities2 (String city){
        String[] paramCity = city.split(",");
        if(!("".equals(paramCity[4]))) {
            try {
                FileWriter noNull = new FileWriter("resources\\NoNullCities.txt", true);
                noNull.write(city + "\r\n");
                noNull.flush();
                noNull.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private String sortCities (String city){
        Scanner scan = null;
        double a,b,a1,b1;
        String[] paramCity = city.split(",");
        a=Double.parseDouble(paramCity[5]);
        b=Double.parseDouble(paramCity[6]);
        try {
            scan = new Scanner(new File("resources\\ByCities.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line;
        if (!scan.hasNext()){
            try {
                FileWriter noNull = new FileWriter("resources\\NOVOECities.txt", true);
                noNull.write(city + "\r\n");
                noNull.flush();
                noNull.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            scan.close();
            return null;
        }
        while(scan.hasNext()) {
            line = scan.nextLine();
            String[] paramCity1 = line.split(",");
            a1=Double.parseDouble(paramCity1[5]);
            b1=Double.parseDouble(paramCity1[6]);
            if(a==a1 && b==b1){
                scan.close();
                return null;
            }
        }
        if(true){
            try {
                FileWriter noNull = new FileWriter("resources\\NOVOECities.txt", true);
                noNull.write(city + "\r\n");
                noNull.flush();
                noNull.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            scan.close();
            return null;
        }
        scan.close();
        return null;
    }


    private boolean sortCitiesList (String city, List list){
        double a,b,a1,b1;
        String[] paramCity = city.split(",");
        a=Double.parseDouble(paramCity[5]);
        b=Double.parseDouble(paramCity[6]);
        Iterator<String> temp = list.iterator();
        if(list.isEmpty()){
            return true;
        }
        while(temp.hasNext()){
            String puk = temp.next();
            String[] city2 = puk.split(",");
            a1=Double.parseDouble(city2[5]);
            b1=Double.parseDouble(city2[6]);
            if(a==a1 && b==b1){
                return false;
            }
        }
        return true;
    }

    private boolean sortCitiesList2 (String city, List list){
        String[] paramCity = city.split(",");
        Iterator<String> temp = list.iterator();
        if(list.isEmpty()){
            return true;
        }
        while(temp.hasNext()){
            String puk = temp.next();
            String[] city2 = puk.split(",");
            if(paramCity[5].equals(city2[5])
                    && paramCity[6].equals(city2[6])){
                return false;
            }
        }
        return true;
    }



}
