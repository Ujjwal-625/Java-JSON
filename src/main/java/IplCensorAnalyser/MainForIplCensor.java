package IplCensorAnalyser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class IPLData{
    public int match_id;
    public String team1;
    public String team2;
    public HashMap<String,Integer> score;
    public String winner;
    public String player_of_match;
}

public class MainForIplCensor {
    public static void main(String[] args) {
        ReadAndCensorJsonFile();
        ReadAndCensorCSVFile();
    }

    static void ReadAndCensorJsonFile() {
        try {
            ObjectMapper objectmapper = new ObjectMapper();
            List<IPLData> iplDataList = objectmapper.readValue(
                    new File("src/main/java/IPLCensorAnalyser/Ipldata.json"),
                    new TypeReference<List<IPLData>>() {}
            );

            for(int i=0;i<iplDataList.size();i++) {
                String[] team1 = iplDataList.get(i).team1.split(" ");
                String[] team2 = iplDataList.get(i).team2.split(" ");
                String[] winner = iplDataList.get(i).winner.split(" ");

                String tempteam1[] = iplDataList.get(i).team1.split(" ");;
                String tempteam2[] = iplDataList.get(i).team2.split(" ");;

                team1[team1.length-1] = "****";
                team2[team2.length-1] = "****";
                winner[winner.length-1] = "****";

                HashMap<String,Integer> score = iplDataList.get(i).score;

                score.put(String.join(" ",team1),score.get(String.join(" ",tempteam1)));
                score.put(String.join(" ",team2),score.get(String.join(" ",tempteam2)));

                iplDataList.get(i).score.remove(String.join(" ",String.join(" ",tempteam1)));
                iplDataList.get(i).score.remove(String.join(" ",String.join(" ",tempteam2)));

                iplDataList.get(i).team1 = String.join(" ",team1);
                iplDataList.get(i).team2 = String.join(" ",team2);
                iplDataList.get(i).winner = String.join(" ",winner);
                iplDataList.get(i).player_of_match = "REDACTED";
            }

            objectmapper.writerWithDefaultPrettyPrinter().writeValue(
                    new File("src/main/java/IPLCensorAnalyser/Ipldata_censored.json"),
                    iplDataList
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void ReadAndCensorCSVFile() {
        try {
            ObjectMapper objectmapper = new ObjectMapper();
            CSVReader reader = new CSVReader(new FileReader("src/main/java/IPLCensorAnalyser/ipldata.csv"));
            CSVWriter writer = new CSVWriter(new FileWriter("src/main/java/IPLCensorAnalyser/iplcensore.csv"));
            ArrayList<String[]> ipldatalist = new ArrayList();

            String[] line;
            line = reader.readNext();
            ipldatalist.add(line);

            while((line = reader.readNext()) != null) {
                String[] team1 = line[1].split(" ");
                String[] team2 = line[2].split(" ");
                String[] winner = line[5].split(" ");

                line[6] = "REDACTED";
                team1[team1.length-1] = "***";
                team2[team2.length-1] = "***";
                winner[winner.length-1] = "***";

                line[1] = String.join(" ",team1);
                line[2] = String.join(" ",team2);
                line[5] = String.join(" ",winner);

                ipldatalist.add(line);
            }
            writer.writeAll(ipldatalist);

            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
