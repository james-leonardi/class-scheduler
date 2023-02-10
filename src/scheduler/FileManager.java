package scheduler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileManager {

    private final File runDir;
    private File dataFolder;

    public FileManager(boolean attemptAutomatic) throws IOException {
        runDir = new File(System.getProperty("user.dir")); //Returns directory in which jar file was run.
        /* Establish dataFolder */
        File temp = new File(runDir + "/Scheduler_Data");
        if (temp.exists() && attemptAutomatic) {
            dataFolder = temp;
        } else {
            if (attemptAutomatic) {
                String[] options = {"Generate New Data Folder", "Locate Data Folder"};
                int choice = JOptionPane.showOptionDialog(null, "Data folder not found. What would you like to do?", "Load Data",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                switch (choice) {
                    case 0:
                        dataFolder = temp;
                        dataFolder.mkdirs();
                        break;
                    case 1:
                        do {
                            temp = selectFile();
                        } while (!temp.getName().endsWith("Scheduler_Data"));
                        dataFolder = temp;
                        break;
                    case JOptionPane.CLOSED_OPTION:
                        System.exit(0);
                    default:
                        break;
                }
            } else {
                do {
                    temp = selectFile();
                } while (!temp.getName().endsWith("Scheduler_Data"));
                dataFolder = temp;
            }
        }
    }

    private File selectFile() {
        JFileChooser finder = new JFileChooser();
        finder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = finder.showOpenDialog(null);
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                return finder.getSelectedFile();
            case JFileChooser.CANCEL_OPTION:
                System.exit(0);
                break;
            default:
                System.exit(0);
        }
        return null; //Will never reach
    }

    public File getDataFolder() {
        return dataFolder;
    }

    public List<String> listCurrentStudents() {
        List<String> students = new ArrayList<>();
        for (File f : dataFolder.listFiles()) {
            if (!f.getName().startsWith("_")) {
                students.add(f.getName());
            }
        }
        return students;
    }
}
