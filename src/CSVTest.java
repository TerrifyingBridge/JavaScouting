import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVTest {

    private final String fileName = "Match_Scouting.csv";

    public List<String[]> data;

    public String[] junk;

    public CSVTest() throws IOException {
        data = readFromCSV(fileName);
    }

    //F*** this method :)
    public void addData(String name, String match, String team, boolean leftStart, int autonMissSpeaker, int autonMadeSpeaker,
                        int autonMissAmp, int autonMadeAmp, int teleopMissSpeaker, int teleopMadeSpeaker, int teleopMissAmp,
                        int teleopMadeAmp, int teleopMissTrap, int teleopMadeTrap, boolean inStage, boolean isParked,
                        boolean onStageSingle, boolean onStagePlural, boolean spotLit, int driverSkillDef, int driverSkillOff,
                        boolean didBreak, String teamStrat, String otherComments) {
        String[] temp = new String[23];

        //TimeStamp - To Be Implemented If Time
        temp[0] = "N/A";
        //First name
        temp[1] = name;
        //Match Number
        temp[2] = match;
        //Team Number
        temp[3] = team;
        //Did the robot leave the start?
        if (leftStart) {
            temp[4] = "Yes";
        } else {
            temp[4] = "No";
        }
        //Number of Speaker Misses in Auton
        temp[5] = Integer.toString(autonMissSpeaker);
        //Number of Speaker Made in Auton
        temp[6] = Integer.toString(autonMadeSpeaker);
        //Number of Amp Misses in Auton
        temp[7] = Integer.toString(autonMissAmp);
        //Number of Amp Made in Auton
        temp[8] = Integer.toString(autonMadeAmp);
        //Number of Speaker Misses Teleop
        temp[9] = Integer.toString(teleopMissSpeaker);
        //Number of Speaker Made teleop
        temp[10] = Integer.toString(teleopMadeSpeaker);
        //Number of Amp Misses teleop
        temp[11] = Integer.toString(teleopMissAmp);
        //Number of Amp Made teleop
        temp[12] = Integer.toString(teleopMadeAmp);
        //Number of Trap Misses teleop
        temp[13] = Integer.toString(teleopMissTrap);
        //Number of Trap Made teleop
        temp[14] = Integer.toString(teleopMadeTrap);
        //Where did the robot end the match
        if (!inStage) {
            temp[15] = "Not in stage";
        }
        if (isParked) {
            temp[15] = "Parked";
        }
        if (onStageSingle) {
            temp[15] = "Onstage(Hanging)";
        }
        if (onStagePlural) {
            temp[15] = "Onstage(Hanging) with another robot";
        }
        //Was there a SpotLight?
        if (spotLit) {
            temp[16] = "Yes";
        } else {
            temp[16] = "No";
        }
        //Driver Skill Offensive
        temp[17] = Integer.toString(driverSkillOff);
        //Driver Skill Defensive
        temp[18] = Integer.toString(driverSkillDef);
        //Did the robot breakdown
        if (didBreak) {
            temp[19] = "Yes";
        } else {
            temp[19] = "No";
        }
        //Describe the Teams Strategy
        //Sorry, I didn't do this one
        temp[20] = "N/A";
        //Describe the Team's Strategy
        temp[21] = teamStrat;
        //Other Comments
        temp[22] = otherComments;
        data.add(temp);
    }

    public List<String[]> readFromCSV(String filename){
        List<String[]> data = new ArrayList<>();
        Path pathToFile = Paths.get(filename);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                data.add(attributes);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public void writeToCSV(String fileName) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (String[] row: data) {
                for (String element: row) {
                    bw.write(element);
                    bw.write(",");
                }
                bw.write("\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printArray(String[] list) {
        for (String word: list) {
            System.out.println(word + " | ");
        }
    }
}
