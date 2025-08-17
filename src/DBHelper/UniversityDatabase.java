package DBHelper;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class UniversityDatabase {

    public static void main(String[] args) {

        EngineeringStudents db1 = new EngineeringStudents();

        // 1. Add two new rows

        db1.insert(11234, "ISE", "Ashley", "Martinez", 2014, 900);
        db1.insert(11345, "ISE", "Gabriel", "Perez", 2015, 1000);

        // 2. Update three values
        db1.update("EngineeringStudents", "Department", "ECE", "Student_ID", "10215");
        db1.update("EngineeringStudents", "First_Name", "Luna", "Student_ID", "10217");
        db1.update("EngineeringStudents", "UniversityRank", "1500", "Student_ID", "10218");
        System.out.println("\nUpdated 3 values.");

        // 3. Delete two rows by Student_ID
        db1.delete("Student_ID", "10215");
        db1.delete("Student_ID", "10201");
        System.out.println("Deleted 2 rows.");

        // 4. Print database as 2D ArrayList
        ArrayList<ArrayList<Object>> data = db1.getExecuteResult("SELECT * FROM EngineeringStudents;");
        System.out.println("\nDatabase as 2D ArrayList:");
        printDatabase(data);


        // 5. Print database as DefaultTableModel
        DefaultTableModel table = new DefaultTableModel();
        table = db1.selectToTable("Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank",
                "Department",  "ISE", "Last_Name", "ASC");
        String data2 = null;
        System.out.println(" Database as a DefaultTableModel: ");

        for(int row = 0; row < table.getRowCount(); row++) {
            for(int column = 0; column < table.getColumnCount(); column++) {
                System.out.println(table.getValueAt(row, column).toString() + " | ");
            }
            System.out.println();
        }


        // 6. Search for students from 'CSE' department
        ArrayList<ArrayList<Object>> searchResult = db1.getExecuteResult(
                "SELECT * FROM EngineeringStudents WHERE Department = 'CSE';");
        System.out.println("\nSearch Results for Department = CSE:");
        printDatabase(searchResult);
    }

    public static void printDatabase(ArrayList<ArrayList<Object>> data) {
        for (ArrayList<Object> row : data) {
            for (Object col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }
}
