package application;

import db.DB;

import java.sql.*;

public class Select {
    public static void main(String[] args) {
        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //CRIA A CONEXAO COM O BANCO DE DADOS
            connect = DB.getConnection();
            //INSTANCIA STATMENT PARA PEGAR OS DADOS
            statement = connect.createStatement();
            //CRIA A QUERY
            resultSet = statement.executeQuery("SELECT * FROM department");
            //FAZ O LOOP PARA PEGAR AS INFORMAÇOES DA TABELA
            while (resultSet.next()){
                System.out.println(resultSet.getInt("Id") + "-" + resultSet.getString("Name"));
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }finally {
            //FECHA TODAS AS CONEXOES FEITAS PARA ACESSAR AO BANCO DE DADOS
            DB.closeResultSet(resultSet);
            DB.closeStatement(statement);
            DB.closeConnection();
        }
    }
}
