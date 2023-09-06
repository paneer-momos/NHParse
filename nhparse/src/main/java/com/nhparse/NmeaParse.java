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
    private String altitude;
    private String gga_satellites;
    private String gga_alt_msl;
    private String gga_geo_sep;
    private static final int GGA_SATTELLITES_IN_USE = 7;
    private static final int GGA_ALT_MSL = 9 ;
    private static final int GGA_GEOIDAL_SEPARATION = 11;
    @Override
    void parse(String[] tokens) {
        talker = tokens[0];
        time = tokens[1];
        latitude = tokens[2] + " " + tokens[3];
        longitude = tokens[4] + " " + tokens[5];
        altitude = tokens[9].replace(" M", "");
        gga_satellites = tokens[GGA_SATTELLITES_IN_USE];
        gga_alt_msl = tokens[GGA_ALT_MSL];
        gga_geo_sep = tokens[GGA_GEOIDAL_SEPARATION];
    }

    @Override
    void printDetails() {
        System.out.println(talker);
        System.out.println("Time: " + time);
        System.out.println("Latitude: " + latitude);
        System.out.println("Longitude: " + longitude);
        System.out.println("Altitude: " + altitude);
    }

    public String getAltitude() {
        return altitude;
    }

    public String getSatellitesInUse(){
        return gga_satellites;
    }

    public String getALT_MSL(){
        return gga_alt_msl;
    }

    public String getGeoSep(){
        return gga_geo_sep;
    }
}
//RMC SENTENCE CLASS
class RMC extends NMEASentence {
    private String talker;
    private String time;
    private static final int UTC_TIME = 1;
    private String RMC_LATTITUDE;
    private String RMC_LONGITUDE;
    private int RMC_SPEED = 7;
    private String rmc_cogh;
    private String rmc_date;
    private String rmc_speed;
    private static final int RMC_DATE = 9;
    private static final int RMC_COURSE_OVER_GROUND_HEADING = 8;

    @Override
    void parse(String[] tokens) {
        talker = tokens[0];
        time = tokens[1];
        //status = tokens[2];
        RMC_LATTITUDE = tokens[3] + " " + tokens[4];
        RMC_LONGITUDE = tokens[5] + " " + tokens[6];
        rmc_speed = tokens[RMC_SPEED];
        rmc_cogh = tokens[RMC_COURSE_OVER_GROUND_HEADING];
        rmc_date = tokens[RMC_DATE];
        }

    @Override
    void printDetails() {
        System.out.println(talker);
        System.out.println("Time: " + UTC_TIME);
        System.out.println("Latitude: " + RMC_LATTITUDE);
        System.out.println("Longitude: " + RMC_LONGITUDE);
        System.out.println("Speed: " + RMC_SPEED);
        System.out.println("Date: " + RMC_DATE);
        System.out.println("Course over ground heading: " + RMC_COURSE_OVER_GROUND_HEADING);
    }

    public String getTime(){
        return time;
    }

    public String getDate(){
        return rmc_date;
    }

    public String getRMCLattitude(){
        return RMC_LATTITUDE;
    }

    public String getRMCLongitude(){
        return RMC_LONGITUDE;
    }

    public String getRMCSpeed(){
        return rmc_speed;
    }

    public String getRMC_COURSE_OVER_GROUND(){
        return rmc_cogh;
    }

}
//GSA SENTENCE CLASS
class GSA extends NMEASentence {
    private String talker;
    private String mode;
    private int GSA_FIX_QUALITY_FACTOR = 2;
    private String[] satellitePRNs;
    private static final int GSA_PDOP = 15;
    private static final int GSA_HDOP = 16;
    private static final int GSA_VDOP = 17;
    private String pdop, hdop, vdop;
    private String gsa_fix;

    @Override
    void parse(String[] tokens) {
        talker = tokens[0];
        mode = tokens[1];
        gsa_fix = tokens[GSA_FIX_QUALITY_FACTOR];
        satellitePRNs = new String[12];
        for (int i = 0; i < 12; i++) {
            if (i < tokens.length - 3) {
             satellitePRNs[i] = tokens[i + 3];}
            else {
             satellitePRNs[i] = ""; // Empty string for missing PRNs
        }
        }
        
            pdop = tokens[GSA_PDOP];
            hdop = tokens[GSA_HDOP];
            vdop = tokens[GSA_VDOP];
    }

    @Override
    void printDetails() {
        System.out.println(talker);
        System.out.println("Mode: " + mode);
        System.out.println("Fix Type: " + GSA_FIX_QUALITY_FACTOR);
        System.out.println("Satellite PRNs: " + Arrays.toString(satellitePRNs));
        System.out.println("PDOP: " + pdop);
        System.out.println("HDOP: " + hdop);
        System.out.println("VDOP: " + vdop);
    }

    public String getFix(){
        return gsa_fix;
    }

    public String getPDOP(){
        return pdop;
    }

    public String getHDOP(){
        return hdop;
    }

    public String getVDOP(){
        return vdop;
    }
      
}

// GSV SENTENCE CLASS
class GSV extends NMEASentence {
    private String talker;
    private String totalMessages;
    private String messageNumber;
    private String totalSatellites;
    private List<SatelliteInfo> satellites;

    @Override
    void parse(String[] tokens) {
        talker = tokens[0];
        totalMessages = tokens[1];
        messageNumber = tokens[2];
        totalSatellites = tokens[3];

        satellites = new ArrayList<>();
        int startIndex = 4;
        while (startIndex + 3 < tokens.length) {
            String prn = tokens[startIndex];
            String elevation = tokens[startIndex + 1];
            String azimuth = tokens[startIndex + 2];
            String snr = tokens[startIndex + 3];

            satellites.add(new SatelliteInfo(prn, elevation, azimuth, snr));

            startIndex += 4;
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

    public String getTotalSatellitesInView() {
        return totalSatellites;
    }

    public List<String> getAzimuthValues() {
        List<String> azimuthValues = new ArrayList<>();
        for (SatelliteInfo satellite : satellites) {
            azimuthValues.add(satellite.getAzimuth());
        }
        return azimuthValues;
    }

    public List<String> getElevationValues() {
        List<String> elevationValues = new ArrayList<>();
        for (SatelliteInfo satellite : satellites) {
            elevationValues.add(satellite.getElevation());
        }
        return elevationValues;
    }

    public List<String> getSignalStrengthValues() {
        List<String> signalStrengthValues = new ArrayList<>();
        for (SatelliteInfo satellite : satellites) {
            signalStrengthValues.add(satellite.getSignalStrength());
        }
        return signalStrengthValues;
    }
}

class SatelliteInfo {
    private String prn;
    private String elevation;
    private String azimuth;
    private String snr;

    public SatelliteInfo(String prn, String elevation, String azimuth, String snr) {
        this.prn = prn;
        this.elevation = elevation;
        this.azimuth = azimuth;
        this.snr = snr;
    }

    public String getPrn() {
        return prn;
    }

    public String getElevation() {
        return elevation;
    }

    public String getAzimuth() {
        return azimuth;
    }

    public String getSignalStrength() {
        return snr;
    }
}


public class NmeaParse{
    private File file;
    private List<Map<String, Object>> segments;
    public String line;
    public NmeaParse(File file) {
        this.file = file;
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

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            
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

}