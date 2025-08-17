package DBHelper;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class EngineeringStudents extends DBHelper {
	private final String TABLE_NAME = "EngineeringStudents";
	public static final String Student_ID = "Student_ID";
	public static final String Department = "Department";
	public static final String First_Name = "First_Name";
	public static final String Last_Name = "Last_Name";
	public static final String PassOutYear = "PassOutYear";
	public static final String UniversityRank = "UniversityRank";


	private String prepareSQL(String fields, String whatField, String whatValue, String sortField, String sort) {
		String query = "SELECT ";
		query += fields == null ? " * FROM " + TABLE_NAME : fields + " FROM " + TABLE_NAME;
		query += whatField != null && whatValue != null ? " WHERE " + whatField + " = \"" + whatValue + "\"" : "";
		query += sort != null && sortField != null ? " order by " + sortField + " " + sort : "";
		return query;
	}

	public void insert(Integer Student_ID, String Department, String First_Name, String Last_Name, Integer PassOutYear, Integer UniversityRank) {
		Department = Department != null ? "\"" + Department + "\"" : null;
		First_Name = First_Name != null ? "\"" + First_Name + "\"" : null;
		Last_Name = Last_Name != null ? "\"" + Last_Name + "\"" : null;
		
		Object[] values_ar = {Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank};
		String[] fields_ar = {EngineeringStudents.Student_ID, EngineeringStudents.Department, EngineeringStudents.First_Name, EngineeringStudents.Last_Name, EngineeringStudents.PassOutYear, EngineeringStudents.UniversityRank};
		String values = "", fields = "";
		for (int i = 0; i < values_ar.length; i++) {
			if (values_ar[i] != null) {
				values += values_ar[i] + ", ";
				fields += fields_ar[i] + ", ";
			}
		}
		if (!values.isEmpty()) {
			values = values.substring(0, values.length() - 2);
			fields = fields.substring(0, fields.length() - 2);
			super.execute("INSERT INTO " + TABLE_NAME + "(" + fields + ") values(" + values + ");");
		}
	}

	public void delete(String whatField, String whatValue) {
		super.execute("DELETE from " + TABLE_NAME + " where " + whatField + " = " + whatValue + ";");
	}

	public void update(String engineeringStudents, String whatField, String whatValue, String whereField, String whereValue) {
		super.execute("UPDATE " + TABLE_NAME + " set " + whatField + " = \"" + whatValue + "\" where " + whereField + " = \"" + whereValue + "\";");
	}

	public ArrayList<ArrayList<Object>> select(String fields, String whatField, String whatValue, String sortField, String sort) {
		return super.executeQuery(prepareSQL(fields, whatField, whatValue, sortField, sort));
	}

	public ArrayList<ArrayList<Object>> getExecuteResult(String query) {
		return super.executeQuery(query);
	}

	public void execute(String query) {
		super.execute(query);
	}

	public DefaultTableModel selectToTable(String fields, String whatField, String whatValue, String sortField, String sort) {
		return super.executeQueryToTable(prepareSQL(fields, whatField, whatValue, sortField, sort));
	}

}