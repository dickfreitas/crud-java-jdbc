package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Post {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection connect = null;
        PreparedStatement preparedStatement = null;

        try{
            //CRIA A CONEXÃO COM O BANCO DE DADOS
            connect = DB.getConnection();
            /*
            //CRIA E EXECUTA A QUERY PARA O BANCO DE DADOS-INSERIR
            preparedStatement = connect.prepareStatement(
                    "INSERT INTO seller"
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                            +"VALUES"
                            +"(? , ? , ?, ? , ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            AQUI ADICIONA OS VALORES, ONDE O PRIMEIRO PARAMETRO É REFENTE AO QUE VAMOS ADICIONAR
            NESSE CASO DE 1 A 5, E O SEGUNDO PARAMETRO OS VALORES QUE QUEREMOS ADICIONAR AO BANCO DE DADOS


            AQUI ADICIONEI UM NOVO CONTRATADO AO BANCO DE DADOS
            preparedStatement.setString(1 , "Dickson Freitas");
            preparedStatement.setString(2 , "dickson@gmail.com");
            preparedStatement.setDate(3 , new java.sql.Date(sdf.parse("11/02/1999").getTime()));
            preparedStatement.setDouble(4 , 3500.00);
            preparedStatement.setInt(5 , 3);
             */
            /*
            Adicionando um novo departamento a tabela
             */
            preparedStatement = connect.prepareStatement(
                    "INSERT INTO department " +
                            "(Id , Name) " +
                            "VALUES " +
                            "(? , ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setInt(1 , 7);
            preparedStatement.setString(2, "Rh");


            //Executa a query e lança os  dados no banco
            //Essa variavel retorna 1 se deu certo e 0 se deu errado
            int rowsEffect = preparedStatement.executeUpdate();

            //ESSE IF É PARA RETORNAR O ID DO NOVO USUARIO QUE FOI ADICIONADO
            // AO BANCO DE DADOS
            if (rowsEffect > 0){
                ResultSet rs = preparedStatement.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Done!  id = " + id);
                }
            }else {
                System.out.println("Nada foi adicionado ao banco de dados");
            }

        }catch (SQLException e ){
            e.printStackTrace();
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }

    }
}
