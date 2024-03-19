package application;

import db.DB;
import db.DbIntegrityExceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public static void main(String[] args) {
        Connection connect = null;
        PreparedStatement preparedStatement = null;

        try {
            connect = DB.getConnection();

            preparedStatement = connect.prepareStatement(
                    "DELETE FROM department " +
                            "WHERE " +
                            "Id = ?"
            );
            preparedStatement.setInt(1 , 9);

            int rowsAffect = preparedStatement.executeUpdate();
            System.out.println("Done!! Rows Affected" + rowsAffect);

        }catch (SQLException e ){
            /*
            Para deletar é necessario criar uma excessao por causa da
            integridade dos dados que existe entre as tabelas, e as chaves
            estrangeiras
             */
            throw new DbIntegrityExceptions(e.getMessage());
        }finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }
}
