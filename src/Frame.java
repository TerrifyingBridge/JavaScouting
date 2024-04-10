import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Frame extends JFrame implements ActionListener {

    private CSVTest csv;
    private JFrame frame;

    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;

    private JCheckBox startingZoneCheck;

    private JSlider miss1Slider;
    private JSlider miss2Slider;
    private JSlider miss3Slider;
    private JSlider miss4Slider;
    private JSlider miss5Slider;

    private JSlider made1Slider;
    private JSlider made2Slider;
    private JSlider made3Slider;
    private JSlider made4Slider;
    private JSlider made5Slider;

    private JCheckBox endMatch1;
    private JCheckBox endMatch2;
    private JCheckBox endMatch3;
    private JCheckBox endMatch4;
    private JCheckBox spotCheck;

    private JSlider offSlider;
    private JSlider defSlider;

    private JCheckBox robBreakCheck;

    private JTextField stratDes;
    private JTextField otherCom;

    private String name = "N/A";
    private String match = "N/A";
    private String team = "N/A";

    private boolean leftStart = false;

    private int autonMissSpeaker = 0;
    private int autonMadeSpeaker = 0;
    private int autonMissAmp = 0;
    private int autonMadeAmp = 0;

    private int teleopMissSpeaker = 0;
    private int teleopMadeSpeaker = 0;
    private int teleopMissAmp = 0;
    private int teleopMadeAmp = 0;
    private int teleopMissTrap = 0;
    private int teleopMadeTrap = 0;

    private boolean inStage = false;
    private boolean isParked = false;
    private boolean onstageSingle = false;
    private boolean onstagePlural = false;
    private boolean spotLit = false;

    private int driverSkillOff = 0;
    private int driverSkillDef = 0;

    private boolean didBreak = false;

    private String teamStrat = "N/A";
    private String otherComments = "N/A";

    @Override
    public void actionPerformed(ActionEvent e) {
        name = tf1.getText();
        name = name.replace(",", " ");
        match = tf2.getText();
        match = match.replace(",", " ");
        team = tf3.getText();
        team = team.replace(",", " ");

        leftStart = startingZoneCheck.isSelected();

        autonMissSpeaker = miss1Slider.getValue();
        autonMadeSpeaker = made1Slider.getValue();
        autonMissAmp = miss2Slider.getValue();
        autonMadeAmp = made2Slider.getValue();

        teleopMissSpeaker = miss3Slider.getValue();
        teleopMadeSpeaker = made3Slider.getValue();
        teleopMissAmp = miss4Slider.getValue();
        teleopMadeAmp = made4Slider.getValue();
        teleopMissTrap = miss5Slider.getValue();
        teleopMadeTrap = made5Slider.getValue();

        inStage = endMatch1.isSelected();
        isParked = endMatch2.isSelected();
        onstageSingle = endMatch3.isSelected();
        onstagePlural = endMatch4.isSelected();
        spotLit = spotCheck.isSelected();

        driverSkillOff = offSlider.getValue();
        driverSkillDef = defSlider.getValue();

        didBreak = robBreakCheck.isSelected();

        teamStrat = stratDes.getText();
        teamStrat = teamStrat.replace(",", " ");
        otherComments = otherCom.getText();
        otherComments = otherComments.replace(",", " ");

        csv.addData(name, match, team, leftStart, autonMissSpeaker, autonMadeSpeaker, autonMissAmp, autonMadeAmp, teleopMissSpeaker, teleopMadeSpeaker, teleopMissAmp, teleopMadeAmp, teleopMissTrap, teleopMadeTrap, inStage, isParked, onstageSingle, onstagePlural,
                spotLit, driverSkillOff, driverSkillDef, didBreak, teamStrat, otherComments);
        //csv.printArray(csv.data.get(csv.data.size()-1));

        try {
            csv.writeToCSV("Match_Scouting.csv");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        System.exit(0);
    }

    public Frame(CSVTest csv) {
        this.csv = csv;
        frame = new JFrame("Scouting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel1.setLayout(new GridLayout(33,2));

        frame.setSize(new Dimension(900, 900));
        frame.setLocationRelativeTo(null);

        JLabel name = new JLabel("Your First Name");
        JButton submit = new JButton("Submit");

        tf1 = new JTextField("Name");
        tf1.setBounds(50, 50, 50, 300);

        JLabel matchLabel = new JLabel("Match Number");
        tf2 = new JTextField("Match");

        JLabel teamLabel = new JLabel("Team Number");
        tf3 = new JTextField("Number");

        JLabel auton = new JLabel("Auton");
        JLabel below1 = new JLabel("Below");

        JLabel startingZone = new JLabel("Did the robot leave the ROBOT STARTING ZONE?");
        startingZoneCheck = new JCheckBox("Starting Zone");

        JLabel ringLabel = new JLabel("How many rings are scored into the SPEAKER?");
        JLabel below2 = new JLabel("Answer Below");

        JLabel missed1 = new JLabel("Missed");
        miss1Slider = new JSlider(JSlider.HORIZONTAL, 0, 8, 0);
        miss1Slider.setMajorTickSpacing(1);
        miss1Slider.setPaintLabels(true);
        miss1Slider.setSnapToTicks(true);

        JLabel made1 = new JLabel("Made");
        made1Slider = new JSlider(JSlider.HORIZONTAL, 0, 8, 0);
        made1Slider.setMajorTickSpacing(1);
        made1Slider.setPaintLabels(true);
        made1Slider.setSnapToTicks(true);

        JLabel ringLabel2 = new JLabel("How many rings are scored into the AMP?");
        JLabel below3 = new JLabel("Answer Below");

        JLabel missed2 = new JLabel("Missed");
        miss2Slider = new JSlider(JSlider.HORIZONTAL, 0, 8, 0);
        miss2Slider.setMajorTickSpacing(1);
        miss2Slider.setPaintLabels(true);
        miss2Slider.setSnapToTicks(true);

        JLabel made2 = new JLabel("Made");
        made2Slider = new JSlider(JSlider.HORIZONTAL, 0, 8, 0);
        made2Slider.setMajorTickSpacing(1);
        made2Slider.setPaintLabels(true);
        made2Slider.setSnapToTicks(true);

        JLabel teleop = new JLabel("Tele-Op");
        JLabel below4 = new JLabel("Below");

        JLabel ringLabel3 = new JLabel("How many rings are scored into the SPEAKER?");
        JLabel below5 = new JLabel("Answer Below");

        JLabel missed3 = new JLabel("Missed");
        miss3Slider = new JSlider(JSlider.HORIZONTAL, 0, 16, 0);
        miss3Slider.setMajorTickSpacing(1);
        miss3Slider.setPaintLabels(true);
        miss3Slider.setSnapToTicks(true);

        JLabel made3 = new JLabel("Made");
        made3Slider = new JSlider(JSlider.HORIZONTAL, 0, 16, 0);
        made3Slider.setMajorTickSpacing(1);
        made3Slider.setPaintLabels(true);
        made3Slider.setSnapToTicks(true);

        JLabel ringLabel4 = new JLabel("How many rings are scored into the AMP?");
        JLabel below6 = new JLabel("Answer Below");

        JLabel missed4 = new JLabel("Missed");
        miss4Slider = new JSlider(JSlider.HORIZONTAL, 0, 16, 0);
        miss4Slider.setMajorTickSpacing(1);
        miss4Slider.setPaintLabels(true);
        miss4Slider.setSnapToTicks(true);

        JLabel made4 = new JLabel("Made");
        made4Slider = new JSlider(JSlider.HORIZONTAL, 0, 16, 0);
        made4Slider.setMajorTickSpacing(1);
        made4Slider.setPaintLabels(true);
        made4Slider.setSnapToTicks(true);

        JLabel ringLabel5 = new JLabel("How many rings did THIS TEAM score into the TRAP?");
        JLabel below7 = new JLabel("Answer Bellow");

        JLabel missed5 = new JLabel("Missed");
        miss5Slider = new JSlider(JSlider.HORIZONTAL, 0, 4, 0);
        miss5Slider.setMajorTickSpacing(1);
        miss5Slider.setPaintLabels(true);
        miss5Slider.setSnapToTicks(true);

        JLabel made5 = new JLabel("Made");
        made5Slider = new JSlider(JSlider.HORIZONTAL, 0, 4, 0);
        made5Slider.setMajorTickSpacing(1);
        made5Slider.setPaintLabels(true);
        made5Slider.setSnapToTicks(true);

        JLabel endOfMatch = new JLabel("Where did the robot end the match?");
        endMatch1 = new JCheckBox("Not in Stage Area");

        JLabel empty = new JLabel();
        endMatch2 = new JCheckBox("Parked");

        JLabel empty2 = new JLabel();
        endMatch3 = new JCheckBox("Onstage (Hanging)");

        JLabel empty3 = new JLabel();
        endMatch4 = new JCheckBox("Onstage (Handing) with another robot");

        JLabel spotlit = new JLabel("If the robot hung, was it spotlit? (High note of microphone)");
        spotCheck = new JCheckBox("Yes/No");

        JLabel driverSkill = new JLabel("Driver Skill: 1 is worst, 5 is best");
        JLabel below8 = new JLabel("Answer Below");

        JLabel off = new JLabel("Offensive");
        offSlider = new JSlider(JSlider.HORIZONTAL, 0, 4, 0);
        offSlider.setMajorTickSpacing(1);
        offSlider.setPaintLabels(true);
        offSlider.setSnapToTicks(true);

        JLabel def = new JLabel("Defensive");
        defSlider = new JSlider(JSlider.HORIZONTAL, 0, 4, 0);
        defSlider.setMajorTickSpacing(1);
        defSlider.setPaintLabels(true);
        defSlider.setSnapToTicks(true);

        JLabel robBreak = new JLabel("Did this robot break?");
        robBreakCheck = new JCheckBox("Yes/No");

        JLabel strat = new JLabel("Describe the team's strategy");
        stratDes = new JTextField("Describe here");

        JLabel empty4 = new JLabel();
        JLabel empty5 = new JLabel();

        JLabel other = new JLabel("Any other comments about this team");
        otherCom = new JTextField("Describe here");

        panel1.add(name);
        panel1.add(tf1);

        panel1.add(matchLabel);
        panel1.add(tf2);

        panel1.add(teamLabel);
        panel1.add(tf3);

        panel1.add(auton);
        panel1.add(below1);

        panel1.add(startingZone);
        panel1.add(startingZoneCheck);

        panel1.add(ringLabel);
        panel1.add(below2);

        panel1.add(missed1);
        panel1.add(miss1Slider);

        panel1.add(made1);
        panel1.add(made1Slider);

        panel1.add(ringLabel2);
        panel1.add(below3);

        panel1.add(missed2);
        panel1.add(miss2Slider);

        panel1.add(made2);
        panel1.add(made2Slider);

        panel1.add(teleop);
        panel1.add(below4);

        panel1.add(ringLabel3);
        panel1.add(below5);

        panel1.add(missed3);
        panel1.add(miss3Slider);

        panel1.add(made3);
        panel1.add(made3Slider);

        panel1.add(ringLabel4);
        panel1.add(below6);

        panel1.add(missed4);
        panel1.add(miss4Slider);

        panel1.add(made4);
        panel1.add(made4Slider);

        panel1.add(ringLabel5);
        panel1.add(below7);

        panel1.add(missed5);
        panel1.add(miss5Slider);

        panel1.add(made5);
        panel1.add(made5Slider);

        panel1.add(endOfMatch);
        panel1.add(endMatch1);

        panel1.add(empty);
        panel1.add(endMatch2);

        panel1.add(empty2);
        panel1.add(endMatch3);

        panel1.add(empty3);
        panel1.add(endMatch4);

        panel1.add(spotlit);
        panel1.add(spotCheck);

        panel1.add(driverSkill);
        panel1.add(below8);

        panel1.add(off);
        panel1.add(offSlider);

        panel1.add(def);
        panel1.add(defSlider);

        panel1.add(robBreak);
        panel1.add(robBreakCheck);

        panel1.add(strat);
        panel1.add(stratDes);

        panel1.add(empty4);
        panel1.add(empty5);

        panel1.add(other);
        panel1.add(otherCom);

        submit.addActionListener(this);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(submit, BorderLayout.SOUTH);
        frame.add(BorderLayout.CENTER, new JScrollPane(panel1));
        //frame.pack();
        frame.setFocusable(true);
        frame.setVisible(true);
    }
}
