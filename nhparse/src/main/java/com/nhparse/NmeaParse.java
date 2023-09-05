package com.nhparse;

import java.io.*;
import java.util.*;
//abstract class which must be extended by every sentence type class
abstract class NMEASentence {
    abstract void parse(String[] tokens);
    abstract void printDetails();
}
//GGA SENTENCE CLASS
class GGA extends NMEASentence {
    private String talker;
    private String time;
    private String latitude;
    private String longitude;
    private double altitude;

    @Override
    void parse(String[] tokens) {
        talker = tokens[0];
        time = tokens[1];
        latitude = tokens[2] + " " + tokens[3];
        longitude = tokens[4] + " " + tokens[5];
        altitude = Double.parseDouble(tokens[9].replace(" M", ""));

    }

    @Override
    void printDetails() {
        System.out.println(talker);
        System.out.println("Time: " + time);
        System.out.println("Latitude: " + latitude);
        System.out.println("Longitude: " + longitude);
        System.out.println("Altitude: " + altitude);
    }

    public double getAltitude() {
        return altitude;
    }
}
//RMC SENTENCE CLASS
class RMC extends NMEASentence {
    private String talker;
    private String time;
    private String status;
    private String latitude;
    private String longitude;
    private String speed;
    private String date;

    @Override
    void parse(String[] tokens) {
        talker = tokens[0];
        time = tokens[1];
        status = tokens[2];
        latitude = tokens[3] + " " + tokens[4];
        longitude = tokens[5] + " " + tokens[6];
        speed = tokens[7];
        date = tokens[9];
    }

    @Override
    void printDetails() {
        System.out.println(talker);
        System.out.println("Time: " + time);
        System.out.println("Status: " + status);
        System.out.println("Latitude: " + latitude);
        System.out.println("Longitude: " + longitude);
        System.out.println("Speed: " + speed);
    }

}
//GSA SENTENCE CLASS
class GSA extends NMEASentence {
    private String talker;
    private String mode;
    private String fixType;
    private String[] satellitePRNs;
    private String pdop;
    private String hdop;
    private String vdop;

    @Override
    void parse(String[] tokens) {
        talker = tokens[0];
        mode = tokens[1];
        fixType = tokens[2];
        satellitePRNs = new String[12];
        for (int i = 0; i < 12; i++) {
            if (i < tokens.length - 3) {
             satellitePRNs[i] = tokens[i + 3];}
            else {
             satellitePRNs[i] = ""; // Empty string for missing PRNs
        }
        }
        try{
        pdop = tokens[15];
        hdop = tokens[16];
        vdop = tokens[17];
        } catch(ArrayIndexOutOfBoundsException e){
            if(pdop==null){
                pdop = hdop = vdop ="";
            }
            else if(hdop==null){
                hdop = vdop = "";
            }
            else{
                vdop = "";
            }
        }
    }

    @Override
    void printDetails() {
        System.out.println(talker);
        System.out.println("Mode: " + mode);
        System.out.println("Fix Type: " + fixType);
        System.out.println("Satellite PRNs: " + Arrays.toString(satellitePRNs));
        System.out.println("PDOP: " + pdop);
        System.out.println("HDOP: " + hdop);
        System.out.println("VDOP: " + vdop);
    }
}

// GSV SENTENCE CLASS
class GSV extends NMEASentence {
    private String talker;
    private int totalMessages;
    private int messageNumber;
    private int totalSatellites;
    private List<SatelliteInfo> satellites;

    @Override
    void parse(String[] tokens) {
        talker = tokens[0];
        totalMessages = Integer.parseInt(tokens[1]);
        messageNumber = Integer.parseInt(tokens[2]);
        totalSatellites = Integer.parseInt(tokens[3]);

        satellites = new ArrayList<>();
        int startIndex = 4;
        while (startIndex +3 < tokens.length) {
            int prn = tryParseInt(tokens[startIndex]);
            int elevation = tryParseInt(tokens[startIndex + 1]);
            int azimuth = tryParseInt(tokens[startIndex + 2]);
            int snr = tryParseInt(tokens[startIndex + 3]);
            
            if (prn != Integer.MIN_VALUE && elevation != Integer.MIN_VALUE &&
                azimuth != Integer.MIN_VALUE && snr != Integer.MIN_VALUE) {
                satellites.add(new SatelliteInfo(prn, elevation, azimuth, snr));
            }
    
            startIndex += 4;
            
        }
    }
        private int tryParseInt(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return Integer.MIN_VALUE; // Return a sentinel value indicating parsing failure
            }
    }


    @Override
    void printDetails() {
        System.out.println(talker);
        System.out.println("Total Messages: " + totalMessages);
        System.out.println("Message Number: " + messageNumber);
        System.out.println("Total Satellites: " + totalSatellites);
        for (SatelliteInfo satellite : satellites) {
            System.out.println(satellite);
        }
    }

    public List<SatelliteInfo> getSatellites() {
        return satellites;
    }
}

class SatelliteInfo {
    private int prn;
    private int elevation;
    private int azimuth;
    private int snr;

    public SatelliteInfo(int prn, int elevation, int azimuth, int snr) {
        this.prn = prn;
        this.elevation = elevation;
        this.azimuth = azimuth;
        this.snr = snr;
    }
}

public class NmeaParse{
    private String filePath;
    private List<Map<String, Object>> segments;
    public String line;
    public NmeaParse(String filePath) {
        this.filePath = filePath;
        this.segments = new ArrayList<>();
        parseNmeaFile();
    }
    
    public void parseNmeaFile(){

        Map<String, Class<? extends NMEASentence>> sentenceTypeMap = new HashMap<>();
        Map<String, Object> currentSegment = null;
        //String currentSentenceType = null;
        
        sentenceTypeMap.put("GGA", GGA.class);
        sentenceTypeMap.put("RMC", RMC.class);
        sentenceTypeMap.put("GSA", GSA.class);
        sentenceTypeMap.put("GSV", GSV.class);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            
           // List<String> segment = new ArrayList<>();
            //boolean insideSegment = false;

            while ((line = br.readLine()) != null) {
                if(line.startsWith("$") || containsSentence(line)){
                    String[] tokens = line.split(",");
                    String sentenceType = tokens[0].substring(3); // Extract the sentence type
                    Class<? extends NMEASentence> sentenceClass = sentenceTypeMap.get(sentenceType);

                    if (sentenceClass != null) {
                        if("RMC".equals(sentenceType)){
                            currentSegment = new HashMap<>();
                            segments.add(currentSegment);
                        }
                        if (currentSegment != null) {
                            // Create an instance of the sentence class and parse
                            NMEASentence nmeaSentence = sentenceClass.getDeclaredConstructor().newInstance();
                            nmeaSentence.parse(tokens);

                            // Store the parsed data in the current segment's dictionary
                            currentSegment.put(sentenceType, nmeaSentence);

                            if ("GLL".equals(sentenceType)) {
                                // End of the current segment, set currentSegment to null
                                currentSegment = null;
                            }
                        }
                    }
                }   
            }
        }catch(Exception e){
            e.printStackTrace();
        }  
    }

    private boolean containsSentence(String line) {
        if(line.contains("$")){
            String[] parts = line.split("\\$");
            line = parts[1];
            return true; 
        }
        return false;
    }

    public static void main(String[] args){
        NmeaParse obj1 = new NmeaParse("C:\\Users\\02rak\\OneDrive\\Documents\\NHParse\\nhparse\\src\\main\\java\\com\\nhparse\\sample_nmea.log");
    }
}