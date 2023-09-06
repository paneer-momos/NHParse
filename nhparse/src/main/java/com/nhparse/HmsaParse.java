package com.nhparse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class HmsaParse {
    private File file;

    public HmsaParse(File file){
        this.file = file;
        parseHmsa();
    }
    public String line;

    private  String HEADER="";

    private  String HA_SPS_MODE_INDICATOR="";

    private  String HA_SPS_FIX_STATUS="";

    private  String HA_SPS_DATE="";

    private  String HA_SPS_TIME="";

    private  String HA_SPS_LATITUDE="";

    private  String HA_SPS_LATITUDE_DIRECTION="";

    private  String HA_SPS_LONGITUDE="";

    private  String HA_SPS_LONGITUDE_DIRECTION="";

    private  String HA_SPS_ALTITUDE="";

    private  String HA_SPS_SPEED="";

    private  String HA_SPS_HEADING="";

    private  String HA_SPS_HDOP="";

    private  String HA_SPS_VDOP="";

    private  String HA_SPS_SVS_IN_VIEW="";

    private  String HA_SPS_GEIODAL_SEPARATION="";

    private  String HA_SPS_MAGNETIC_VARIATION="";

    private  String HA_SPS_COURSE_OVER_GROUND="";

    private  String HA_SPS_COURSE_JAMMING_INDICATION="";

    private  String HA_SPS_COURSE_SPOOFING_INDICATION="";

    private  String HA_SPS_ERROR_ESTIMATE="";

    private  String HA_SPS_TRACKING_SVS_COUNT="";

    private ArrayList<sps_satlist> HA_SPS_SAT_LIST = new ArrayList<>() ;

    private  String HA_SPS_RESERVED_1="";

    public String getHA_SPS_SEPERATOR() {

        return HA_SPS_SEPERATOR;

    }

    public void setHA_SPS_SEPERATOR(String HA_SPS_SEPERATOR) {

        this.HA_SPS_SEPERATOR = HA_SPS_SEPERATOR;

    }

    private  String HA_SPS_SEPERATOR="";

    private  String HA_SPS_RESERVED_2="";

    private  String HA_RS_MODE_INDICATOR="";

    private  String HA_RS_FIX_STATUS="";

    private  String HA_RS_DATE="";

    private  String HA_RS_TIME="";

    private  String HA_RS_LATITUDE="";

    private  String HA_RS_LATITUDE_DIRECTION="";

    private  String HA_RS_LONGITUDE="";

    private  String HA_RS_LONGITUDE_DIRECTION="";

    private  String HA_RS_ALTITUDE="";

    private  String HA_RS_SPEED="";

    private  String HA_RS_HEADING="";

    private  String HA_RS_HDOP="";

    private  String HA_RS_VDOP="";

    private  String HA_RS_SVS_IN_VIEW="";

    private  String HA_RS_GEIODAL_SEPARATION="";

    private  String HA_RS_MAGNETIC_VARIATION="";

    private  String HA_RS_COURSE_OVER_GROUND="";

    private  String HA_RS_COURSE_JAMMING_INDICATION="";

    private  String HA_RS_COURSE_SPOOFING_INDICATION="";

    private  String HA_RS_ERROR_ESTIMATE="";

    private  String HA_RS_TRACKING_SVS_COUNT="";

    private ArrayList<rs_satlist> HA_RS_SAT_LIST = new ArrayList<>() ;

    private  String HA_RS_RESERVED_1="";

    private  String HA_RS_SEPERATOR="";

    public String getHA_RS_SEPERATOR() {

        return HA_RS_SEPERATOR;

    }

    public void setHA_RS_SEPERATOR(String HA_RS_SEPERATOR) {

        this.HA_RS_SEPERATOR = HA_RS_SEPERATOR;

    }

    private  String HA_RS_RESERVED_2="";

    public String getHEADER() {

        return HEADER;

    }

    public void setHEADER(String HEADER) {

        this.HEADER = HEADER;

    }


    public String getHA_SPS_MODE_INDICATOR() {

        return HA_SPS_MODE_INDICATOR;

    }
 

    public void setHA_SPS_MODE_INDICATOR(String HA_SPS_MODE_INDICATOR) {

        this.HA_SPS_MODE_INDICATOR = HA_SPS_MODE_INDICATOR;

    }

 

    public String getHA_SPS_FIX_STATUS() {

        return HA_SPS_FIX_STATUS;

    }

 

    public void setHA_SPS_FIX_STATUS(String HA_SPS_FIX_STATUS) {

        this.HA_SPS_FIX_STATUS = HA_SPS_FIX_STATUS;

    }

 

    public String getHA_SPS_DATE() {

        return HA_SPS_DATE;

    }

 

    public void setHA_SPS_DATE(String HA_SPS_DATE) {

        this.HA_SPS_DATE = HA_SPS_DATE;

    }

 

    public String getHA_SPS_TIME() {

        return HA_SPS_TIME;

    }

 

    public void setHA_SPS_TIME(String HA_SPS_TIME) {

        this.HA_SPS_TIME = HA_SPS_TIME;

    }

 

    public String getHA_SPS_LATITUDE() {

        return HA_SPS_LATITUDE;

    }

 

    public void setHA_SPS_LATITUDE(String HA_SPS_LATITUDE) {

        this.HA_SPS_LATITUDE = HA_SPS_LATITUDE;

    }

 

    public String getHA_SPS_LATITUDE_DIRECTION() {

        return HA_SPS_LATITUDE_DIRECTION;

    }

 

    public void setHA_SPS_LATITUDE_DIRECTION(String HA_SPS_LATITUDE_DIRECTION) {

        this.HA_SPS_LATITUDE_DIRECTION = HA_SPS_LATITUDE_DIRECTION;

    }

 

    public String getHA_SPS_LONGITUDE() {

        return HA_SPS_LONGITUDE;

    }

 

    public void setHA_SPS_LONGITUDE(String HA_SPS_LONGITUDE) {

        this.HA_SPS_LONGITUDE = HA_SPS_LONGITUDE;

    }

 

    public String getHA_SPS_LONGITUDE_DIRECTION() {

        return HA_SPS_LONGITUDE_DIRECTION;

    }

 

    public void setHA_SPS_LONGITUDE_DIRECTION(String HA_SPS_LONGITUDE_DIRECTION) {

        this.HA_SPS_LONGITUDE_DIRECTION = HA_SPS_LONGITUDE_DIRECTION;

    }

 

    public String getHA_SPS_ALTITUDE() {

        return HA_SPS_ALTITUDE;

    }

 

    public void setHA_SPS_ALTITUDE(String HA_SPS_ALTITUDE) {

        this.HA_SPS_ALTITUDE = HA_SPS_ALTITUDE;

    }

 

    public String getHA_SPS_SPEED() {

        return HA_SPS_SPEED;

    }

 

    public void setHA_SPS_SPEED(String HA_SPS_SPEED) {

        this.HA_SPS_SPEED = HA_SPS_SPEED;

    }

 

    public String getHA_SPS_HEADING() {

        return HA_SPS_HEADING;

    }

 

    public void setHA_SPS_HEADING(String HA_SPS_HEADING) {

        this.HA_SPS_HEADING = HA_SPS_HEADING;

    }

 

    public String getHA_SPS_HDOP() {

        return HA_SPS_HDOP;

    }

 

    public void setHA_SPS_HDOP(String HA_SPS_HDOP) {

        this.HA_SPS_HDOP = HA_SPS_HDOP;

    }

 

    public String getHA_SPS_VDOP() {

        return HA_SPS_VDOP;

    }

 

    public void setHA_SPS_VDOP(String HA_SPS_VDOP) {

        this.HA_SPS_VDOP = HA_SPS_VDOP;

    }

 

    public String getHA_SPS_SVS_IN_VIEW() {

        return HA_SPS_SVS_IN_VIEW;

    }

 

    public void setHA_SPS_SVS_IN_VIEW(String HA_SPS_SVS_IN_VIEW) {

        this.HA_SPS_SVS_IN_VIEW = HA_SPS_SVS_IN_VIEW;

    }

 

    public String getHA_SPS_GEIODAL_SEPARATION() {

        return HA_SPS_GEIODAL_SEPARATION;

    }

 

    public void setHA_SPS_GEIODAL_SEPARATION(String HA_SPS_GEIODAL_SEPARATION) {

        this.HA_SPS_GEIODAL_SEPARATION = HA_SPS_GEIODAL_SEPARATION;

    }

 

    public String getHA_SPS_MAGNETIC_VARIATION() {

        return HA_SPS_MAGNETIC_VARIATION;

    }

 

    public void setHA_SPS_MAGNETIC_VARIATION(String HA_SPS_MAGNETIC_VARIATION) {

        this.HA_SPS_MAGNETIC_VARIATION = HA_SPS_MAGNETIC_VARIATION;

    }

 

    public String getHA_SPS_COURSE_OVER_GROUND() {

        return HA_SPS_COURSE_OVER_GROUND;

    }

 

    public void setHA_SPS_COURSE_OVER_GROUND(String HA_SPS_COURSE_OVER_GROUND) {

        this.HA_SPS_COURSE_OVER_GROUND = HA_SPS_COURSE_OVER_GROUND;

    }

 

    public String getHA_SPS_COURSE_JAMMING_INDICATION() {

        return HA_SPS_COURSE_JAMMING_INDICATION;

    }

 

    public void setHA_SPS_COURSE_JAMMING_INDICATION(String HA_SPS_COURSE_JAMMING_INDICATION) {

        this.HA_SPS_COURSE_JAMMING_INDICATION = HA_SPS_COURSE_JAMMING_INDICATION;

    }

 

    public String getHA_SPS_COURSE_SPOOFING_INDICATION() {

        return HA_SPS_COURSE_SPOOFING_INDICATION;

    }

 

    public void setHA_SPS_COURSE_SPOOFING_INDICATION(String HA_SPS_COURSE_SPOOFING_INDICATION) {

        this.HA_SPS_COURSE_SPOOFING_INDICATION = HA_SPS_COURSE_SPOOFING_INDICATION;

    }

 

    public String getHA_SPS_ERROR_ESTIMATE() {

        return HA_SPS_ERROR_ESTIMATE;

    }

 

    public void setHA_SPS_ERROR_ESTIMATE(String HA_SPS_ERROR_ESTIMATE) {

        this.HA_SPS_ERROR_ESTIMATE = HA_SPS_ERROR_ESTIMATE;

    }

 

    public String getHA_SPS_TRACKING_SVS_COUNT() {

        return HA_SPS_TRACKING_SVS_COUNT;

    }

 

    public void setHA_SPS_TRACKING_SVS_COUNT(String HA_SPS_TRACKING_SVS_COUNT) {

        this.HA_SPS_TRACKING_SVS_COUNT = HA_SPS_TRACKING_SVS_COUNT;

    }

 

    public ArrayList<sps_satlist> getHA_SPS_SAT_LIST() {

        return HA_SPS_SAT_LIST;

    }

 

    public void setHA_SPS_SAT_LIST(ArrayList<sps_satlist> HA_SPS_SAT_LIST) {

        this.HA_SPS_SAT_LIST.clear();

        this.HA_SPS_SAT_LIST = HA_SPS_SAT_LIST;

    }

 

    public String getHA_SPS_RESERVED_1() {

        return HA_SPS_RESERVED_1;

    }

 

    public void setHA_SPS_RESERVED_1(String HA_SPS_RESERVED_1) {

        this.HA_SPS_RESERVED_1 = HA_SPS_RESERVED_1;

    }

 

    public String getHA_SPS_RESERVED_2() {

        return HA_SPS_RESERVED_2;

    }

 

    public void setHA_SPS_RESERVED_2(String HA_SPS_RESERVED_2) {

        this.HA_SPS_RESERVED_2 = HA_SPS_RESERVED_2;

    }

 

    public String getHA_RS_MODE_INDICATOR() {

        return HA_RS_MODE_INDICATOR;

    }

 

    public void setHA_RS_MODE_INDICATOR(String HA_RS_MODE_INDICATOR) {

        this.HA_RS_MODE_INDICATOR = HA_RS_MODE_INDICATOR;

    }

 

    public String getHA_RS_FIX_STATUS() {

        return HA_RS_FIX_STATUS;

    }

 

    public void setHA_RS_FIX_STATUS(String HA_RS_FIX_STATUS) {

        this.HA_RS_FIX_STATUS = HA_RS_FIX_STATUS;

    }

 

    public String getHA_RS_DATE() {

        return HA_RS_DATE;

    }

 

    public void setHA_RS_DATE(String HA_RS_DATE) {

        this.HA_RS_DATE = HA_RS_DATE;

    }

 

    public String getHA_RS_TIME() {

        return HA_RS_TIME;

    }

 

    public void setHA_RS_TIME(String HA_RS_TIME) {

        this.HA_RS_TIME = HA_RS_TIME;

    }

 

    public String getHA_RS_LATITUDE() {

        return HA_RS_LATITUDE;

    }

 

    public void setHA_RS_LATITUDE(String HA_RS_LATITUDE) {

        this.HA_RS_LATITUDE = HA_RS_LATITUDE;

    }

 

    public String getHA_RS_LATITUDE_DIRECTION() {

        return HA_RS_LATITUDE_DIRECTION;

    }

 

    public void setHA_RS_LATITUDE_DIRECTION(String HA_RS_LATITUDE_DIRECTION) {

        this.HA_RS_LATITUDE_DIRECTION = HA_RS_LATITUDE_DIRECTION;

    }

 

    public String getHA_RS_LONGITUDE() {

        return HA_RS_LONGITUDE;

    }

 

    public void setHA_RS_LONGITUDE(String HA_RS_LONGITUDE) {

        this.HA_RS_LONGITUDE = HA_RS_LONGITUDE;

    }

 

    public String getHA_RS_LONGITUDE_DIRECTION() {

        return HA_RS_LONGITUDE_DIRECTION;

    }

 

    public void setHA_RS_LONGITUDE_DIRECTION(String HA_RS_LONGITUDE_DIRECTION) {

        this.HA_RS_LONGITUDE_DIRECTION = HA_RS_LONGITUDE_DIRECTION;

    }

 

    public String getHA_RS_ALTITUDE() {

        return HA_RS_ALTITUDE;

    }

 

    public void setHA_RS_ALTITUDE(String HA_RS_ALTITUDE) {

        this.HA_RS_ALTITUDE = HA_RS_ALTITUDE;

    }

 

    public String getHA_RS_SPEED() {

        return HA_RS_SPEED;

    }

 

    public void setHA_RS_SPEED(String HA_RS_SPEED) {

        this.HA_RS_SPEED = HA_RS_SPEED;

    }

 

    public String getHA_RS_HEADING() {

        return HA_RS_HEADING;

    }

 

    public void setHA_RS_HEADING(String HA_RS_HEADING) {

        this.HA_RS_HEADING = HA_RS_HEADING;

    }

 

    public String getHA_RS_HDOP() {

        return HA_RS_HDOP;

    }

 

    public void setHA_RS_HDOP(String HA_RS_HDOP) {

        this.HA_RS_HDOP = HA_RS_HDOP;

    }

 

    public String getHA_RS_VDOP() {

        return HA_RS_VDOP;

    }

 

    public void setHA_RS_VDOP(String HA_RS_VDOP) {

        this.HA_RS_VDOP = HA_RS_VDOP;

    }

 

    public String getHA_RS_SVS_IN_VIEW() {

        return HA_RS_SVS_IN_VIEW;

    }

 

    public void setHA_RS_SVS_IN_VIEW(String HA_RS_SVS_IN_VIEW) {

        this.HA_RS_SVS_IN_VIEW = HA_RS_SVS_IN_VIEW;

    }

 

    public String getHA_RS_GEIODAL_SEPARATION() {

        return HA_RS_GEIODAL_SEPARATION;

    }

 

    public void setHA_RS_GEIODAL_SEPARATION(String HA_RS_GEIODAL_SEPARATION) {

        this.HA_RS_GEIODAL_SEPARATION = HA_RS_GEIODAL_SEPARATION;

    }

 

    public String getHA_RS_MAGNETIC_VARIATION() {

        return HA_RS_MAGNETIC_VARIATION;

    }


    public void setHA_RS_MAGNETIC_VARIATION(String HA_RS_MAGNETIC_VARIATION) {

        this.HA_RS_MAGNETIC_VARIATION = HA_RS_MAGNETIC_VARIATION;

    }

 

    public String getHA_RS_COURSE_OVER_GROUND() {

        return HA_RS_COURSE_OVER_GROUND;

    }

 

    public void setHA_RS_COURSE_OVER_GROUND(String HA_RS_COURSE_OVER_GROUND) {

        this.HA_RS_COURSE_OVER_GROUND = HA_RS_COURSE_OVER_GROUND;

    }

 

    public String getHA_RS_COURSE_JAMMING_INDICATION() {

        return HA_RS_COURSE_JAMMING_INDICATION;

    }

 

    public void setHA_RS_COURSE_JAMMING_INDICATION(String HA_RS_COURSE_JAMMING_INDICATION) {

        this.HA_RS_COURSE_JAMMING_INDICATION = HA_RS_COURSE_JAMMING_INDICATION;

    }

 

    public String getHA_RS_COURSE_SPOOFING_INDICATION() {

        return HA_RS_COURSE_SPOOFING_INDICATION;

    }

 

    public void setHA_RS_COURSE_SPOOFING_INDICATION(String HA_RS_COURSE_SPOOFING_INDICATION) {

        this.HA_RS_COURSE_SPOOFING_INDICATION = HA_RS_COURSE_SPOOFING_INDICATION;

    }

 

    public String getHA_RS_ERROR_ESTIMATE() {

        return HA_RS_ERROR_ESTIMATE;

    }

 

    public void setHA_RS_ERROR_ESTIMATE(String HA_RS_ERROR_ESTIMATE) {

        this.HA_RS_ERROR_ESTIMATE = HA_RS_ERROR_ESTIMATE;

    }

 

    public String getHA_RS_TRACKING_SVS_COUNT() {

        return HA_RS_TRACKING_SVS_COUNT;

    }

 

    public void setHA_RS_TRACKING_SVS_COUNT(String HA_RS_TRACKING_SVS_COUNT) {

        this.HA_RS_TRACKING_SVS_COUNT = HA_RS_TRACKING_SVS_COUNT;

    }

 

    public ArrayList<rs_satlist> getHA_RS_SAT_LIST() {

        return HA_RS_SAT_LIST;

    }

 

    public void setHA_RS_SAT_LIST(ArrayList<rs_satlist> HA_RS_SAT_LIST) {

 

        this.HA_RS_SAT_LIST.clear();

        this.HA_RS_SAT_LIST = HA_RS_SAT_LIST;

    }

 

    public String getHA_RS_RESERVED_1() {

        return HA_RS_RESERVED_1;

    }

 

    public void setHA_RS_RESERVED_1(String HA_RS_RESERVED_1) {

        this.HA_RS_RESERVED_1 = HA_RS_RESERVED_1;

    }

 

    public String getHA_RS_RESERVED_2() {

        return HA_RS_RESERVED_2;

    }

 

    public void setHA_RS_RESERVED_2(String HA_RS_RESERVED_2) {

        this.HA_RS_RESERVED_2 = HA_RS_RESERVED_2;

    }

 

 

    static class sps_satlist{

        private  String HA_SPS_SVID="";

        private  String HA_SPS_STATUS="";

        private  String HA_SPS_AZIMUTH="";

        private  String HA_SPS_ELEVATION="";

        private  String HA_SPS_SIGNALSTRENGTH="";

 

        public sps_satlist(String HA_SPS_SVID, String HA_SPS_STATUS, String HA_SPS_AZIMUTH, String HA_SPS_ELEVATION, String HA_SPS_SIGNALSTRENGTH) {

            this.HA_SPS_SVID = HA_SPS_SVID;

            this.HA_SPS_STATUS = HA_SPS_STATUS;

            this.HA_SPS_AZIMUTH = HA_SPS_AZIMUTH;

            this.HA_SPS_ELEVATION = HA_SPS_ELEVATION;

            this.HA_SPS_SIGNALSTRENGTH = HA_SPS_SIGNALSTRENGTH;

        }

    }

 

    static class rs_satlist{

        private  String HA_RS_SVID="";

        private  String HA_RS_STATUS="";

        private  String HA_RS_AZIMUTH="";

        private  String HA_RS_ELEVATION="";

        private  String HA_RS_SIGNALSTRENGTH="";

 

        public rs_satlist(String HA_RS_SVID, String HA_RS_STATUS, String HA_RS_AZIMUTH, String HA_RS_ELEVATION, String HA_RS_SIGNALSTRENGTH) {

            this.HA_RS_SVID = HA_RS_SVID;

            this.HA_RS_STATUS = HA_RS_STATUS;

            this.HA_RS_AZIMUTH = HA_RS_AZIMUTH;

            this.HA_RS_ELEVATION = HA_RS_ELEVATION;

            this.HA_RS_SIGNALSTRENGTH = HA_RS_SIGNALSTRENGTH;

        }

    }

    public void parseHmsa(){
        //String data="$AN,C,3,12082023,091052.00,1257.45543,N,07738.50027,E,00911.5,001.1,039.55,026.6,050.9,-088,,,00,00,,06,03,P,149,77,48,09,P,301,57,46,06,P,257,36,46,02,P,209,35,43,07,V,096,30,,10,V,103,28,,E,,,M,3,12082023,091052.00,1257.44669,N,07738.48241,E,00973.9,001.1,239.46,026.6,050.9,-088,,,00,00,,05,06,P,257,36,48,02,P,209,35,47,03,P,149,77,50,09,P,301,57,47,07,T,,,43,E,,,*5F";

        //HmsaParse HmsaParse=new HmsaParse(filename);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
          while((line = br.readLine())!= null) {
            if(line.startsWith("$") || containsSentence(line)){
                String msg[] = line.split(",");

                int INDEX=0;

                this.setHEADER(msg[INDEX++]);

                this.setHA_SPS_MODE_INDICATOR(msg[INDEX++]);

                this.setHA_SPS_FIX_STATUS(msg[INDEX++]);

                this.setHA_SPS_DATE(msg[INDEX++]);

                this.setHA_SPS_TIME(msg[INDEX++]);

                this.setHA_SPS_LATITUDE(msg[INDEX++]);

                this.setHA_SPS_LATITUDE_DIRECTION(msg[INDEX++]);

                this.setHA_SPS_LONGITUDE(msg[INDEX++]);

                this.setHA_SPS_LONGITUDE_DIRECTION(msg[INDEX++]);

                this.setHA_SPS_ALTITUDE(msg[INDEX++]);

                this.setHA_SPS_SPEED(msg[INDEX++]);

                this.setHA_SPS_HEADING(msg[INDEX++]);

                this.setHA_SPS_HDOP(msg[INDEX++]);

                this.setHA_SPS_VDOP(msg[INDEX++]);

            // this.setHA_SPS_SVS_IN_VIEW(msg[INDEX++]);

                this.setHA_SPS_GEIODAL_SEPARATION(msg[INDEX++]);

                this.setHA_SPS_MAGNETIC_VARIATION(msg[INDEX++]);

                this.setHA_SPS_COURSE_OVER_GROUND(msg[INDEX++]);

                this.setHA_SPS_COURSE_JAMMING_INDICATION(msg[INDEX++]);

                this.setHA_SPS_COURSE_SPOOFING_INDICATION(msg[INDEX++]);

        

                this.setHA_SPS_ERROR_ESTIMATE(msg[INDEX++]);

                this.setHA_SPS_TRACKING_SVS_COUNT(msg[INDEX++]);

        

                int svscount_sps = Integer.parseInt(this.getHA_SPS_TRACKING_SVS_COUNT().isEmpty() ? "0" : this.getHA_SPS_TRACKING_SVS_COUNT());

        

                ArrayList<sps_satlist> satlist = new ArrayList<>();

        

                for(int i=0;i<svscount_sps;i++)

                {

                    String satId = msg[INDEX++] ;

                    String satstatus = msg[INDEX++];String azimuth = msg[INDEX++];

                    String elevation = msg[INDEX++];String signalstrength = msg[INDEX++];

                    satlist.add(new sps_satlist(satId,satstatus,azimuth,elevation,signalstrength));

                }

                this.setHA_SPS_SAT_LIST(satlist);

                this.setHA_SPS_SEPERATOR(msg[INDEX++]);

                this.setHA_SPS_RESERVED_1(msg[INDEX++]);

                this.setHA_SPS_RESERVED_2(msg[INDEX++]);


                this.setHA_RS_MODE_INDICATOR(msg[INDEX++]);

                this.setHA_RS_FIX_STATUS(msg[INDEX++]);

                this.setHA_RS_DATE(msg[INDEX++]);

                this.setHA_RS_TIME(msg[INDEX++]);

                this.setHA_RS_LATITUDE(msg[INDEX++]);

                this.setHA_RS_LATITUDE_DIRECTION(msg[INDEX++]);

                this.setHA_RS_LONGITUDE(msg[INDEX++]);

                this.setHA_RS_LONGITUDE_DIRECTION(msg[INDEX++]);

                this.setHA_RS_ALTITUDE(msg[INDEX++]);

                this.setHA_RS_SPEED(msg[INDEX++]);

                this.setHA_RS_HEADING(msg[INDEX++]);

                this.setHA_RS_HDOP(msg[INDEX++]);

                this.setHA_RS_VDOP(msg[INDEX++]);

            //  this.setHA_RS_SVS_IN_VIEW(msg[INDEX++]);

                this.setHA_RS_GEIODAL_SEPARATION(msg[INDEX++]);

                this.setHA_RS_MAGNETIC_VARIATION(msg[INDEX++]);

                this.setHA_RS_COURSE_OVER_GROUND(msg[INDEX++]);

                this.setHA_RS_COURSE_JAMMING_INDICATION(msg[INDEX++]);

                this.setHA_RS_COURSE_SPOOFING_INDICATION(msg[INDEX++]);

                this.setHA_RS_ERROR_ESTIMATE(msg[INDEX++]);

                this.setHA_RS_TRACKING_SVS_COUNT(msg[INDEX++]);

                int svscount_rs = Integer.parseInt(this.getHA_RS_TRACKING_SVS_COUNT().isEmpty() ? "0" : this.getHA_RS_TRACKING_SVS_COUNT());

                ArrayList<rs_satlist> satlist_rs = new ArrayList<>();

                for(int i=0;i<svscount_rs;i++)

                {

                    String satId = msg[INDEX++] ;String satstatus = msg[INDEX++];

                    String azimuth = msg[INDEX++];String elevation = msg[INDEX++];

                    String signalstrength = msg[INDEX++];

                    satlist_rs.add(new rs_satlist(satId,satstatus,azimuth,elevation,signalstrength));

                }


                this.setHA_RS_SAT_LIST(satlist_rs);

                this.setHA_RS_SEPERATOR(msg[INDEX++]);

                this.setHA_RS_RESERVED_1(msg[INDEX++]);

                this.setHA_RS_RESERVED_2(msg[INDEX]);
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


