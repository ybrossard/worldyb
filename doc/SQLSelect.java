import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.Date;

public class SQLSelect
{
 Connection con;
 DatabaseMetaData basemeta;
 ResultSetMetaData rsmetadata;
 String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
 String nl = System.getProperty("line.separator");

 public SQLSelect()
 {
  createConnection();
  executeQuery();
 }

 private void createConnection()
 {
  Properties props = new Properties();
  props.put("user", "sa");
  props.put("password", "plato17");

  try
  {
   Class.forName(driver);
   con = DriverManager.getConnection(
                                     "jdbc:microsoft:sqlserver://linda-a7agpelgn:1051;databasename=master",
                                     props
                                    );
  }
  catch (java.lang.ClassNotFoundException e)
  {
   System.out.println(e.getMessage());
  }
  catch (SQLException e)
  {
   System.out.println(e.getMessage());
  }

  setLog();
  printDate();
  printMetaData();
  printLevel();
 }

 private void printDate()
 {
  Date date = new Date();
  Timestamp time = new Timestamp(date.getTime());
  System.out.println("Timestamp: " + time);
 }

 private void printMetaData()
 {
  try
  {
   basemeta = con.getMetaData();

   ResultSet rsmeta = basemeta.getCatalogs();

   rsmetadata = rsmeta.getMetaData();

   System.out.println("DB-Name: " + basemeta.getDatabaseProductName());
   System.out.println("DB-Version: " + basemeta.getDatabaseProductVersion());
   System.out.println("Driver-Name: " + basemeta.getDriverName());
   System.out.println("Driver-Version: " + basemeta.getDriverVersion());
   System.out.println("===============================");

   if (rsmetadata == null)
   {
    System.out.println("No Database Meta Data");
    return;
   }

   rsmeta.close();
  }
  catch (SQLException ec)
  {
   System.err.println(ec.toString());
  }
 }

  /* Supported ANSI level */
 private void printLevel()
 {
  try
  {
   basemeta = con.getMetaData();

   /* Supported ANSI level */
   if (basemeta.supportsANSI92FullSQL())
   {
    System.out.println("ANSI92 full SQL grammar is supported.");
   }
   else if (basemeta.supportsANSI92IntermediateSQL())
   {
    System.out.println("ANSI92 intermediate SQL grammar is supported.");
   }
   else if (basemeta.supportsANSI92EntryLevelSQL())
   {
    System.out.println("ANSI92 Entry Level SQL grammar is supported.");
   }
   else
   {
    System.out.println("ANSI92 SQL grammar is not supported.");
   }

   /* Supported SQL Grammer level */
   if (basemeta.supportsExtendedSQLGrammar())
   {
    System.out.println("ODBC Extended SQL grammar is supported.");
   }
   else if (basemeta.supportsCoreSQLGrammar())
   {
    System.out.println("ODBC Core SQL grammar is supported.");
   }
   else if (basemeta.supportsMinimumSQLGrammar())
   {
    System.out.println("ODBC Minimum SQL grammar is supported.");
   }
   else
   {
    System.out.println("ODBC SQL grammar is not supported.");
   }

   //  rsmeta.close();
  }
  catch (SQLException ec)
  {
   System.err.println(ec.toString());
  }
 }

 private void setLog()
 {
  try
  {
   DriverManager.setLogWriter(new PrintWriter(new FileOutputStream("sqllog.txt")));
  }
  catch (FileNotFoundException e)
  {
   System.err.println(e.toString());
  }
 }

 private void executeQuery()
 {
  try
  {
   Statement st = con.createStatement();
   ResultSet rs = st.executeQuery("SELECT * FROM Databases");

   while (rs.next())
   {
    System.out.println(rs.getString(1) + ", " + rs.getString(2));
   }

   System.out.println(nl);
   rs.close();
   st.close();
   printAllTables();
   printAllColumns();
  }
  catch (SQLException e)
  {
   System.err.println(e.toString());
  }
  finally
  {
   try
   {
    con.close();
   }
   catch (Throwable t)
   {
   }
  }
 }

 private void printAllTables()
 {
  try
  {
   basemeta = con.getMetaData();

   /* get all tables in the database */
   ResultSet rstable = basemeta.getTables("master", null, null, null);

   while (rstable.next())
   {
    System.out.println("Table: " + rstable.getString("TABLE_NAME"));
   }

   rstable.close();
   System.out.println(nl); 
  }
  catch (SQLException e)
  {
   System.err.println(e.toString());
  }
 }

 private void printAllColumns()
 {
  try
  {
   ResultSet rscol = basemeta.getColumns(null,null,"Databases","%");

   while (rscol.next())
   {
    String colname = rscol.getString("COLUMN_NAME");
    System.out.println("Column: " + colname);
   }

   rscol.close();
  }
  catch (SQLException e)
  {
   System.err.println(e.toString());
  }
 }

 public static void main(String[] args)
 {
  new SQLSelect();
 }
}