package application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void main(String[] args) {
        Connection connect = null;
        PreparedStatement preparedStatement = null;

        try{
            connect = DB.getConnection();

            preparedStatement = connect.prepareStatement(
                    "UPDATE seller " + //Necessario colocar os espaços no final das ""
                            "SET BaseSalary = BaseSalary + ? "+ //Necessario colocar os espaços no final das ""
                            "WHERE " + //Necessario colocar os espaços no final das ""
                            "(DepartmentId = ?)");

            preparedStatement.setDouble(1 , 200.0);
            preparedStatement.setInt(2 , 2);

            int rowsAffect = preparedStatement.executeUpdate();
            System.out.println("Done!! Rows Affect" + rowsAffect);
        }catch (SQLException e ){
            e.printStackTrace();
        }finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }

    }
}

