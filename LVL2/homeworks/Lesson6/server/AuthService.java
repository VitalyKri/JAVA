package Lesson6.server;

import java.sql.*;

public class AuthService {
    private static Connection connection; // соединение
    private static Statement statement; // передача в БД и возврат

    public static void connect() {
        // обращение к драйверу, для его инициализации
        try {
            Class.forName("org.sqlite.JDBC"); // инициализация драйвера
            connection = DriverManager.getConnection("jdbc:sqlite:LVL2/homeworks/Lesson6/main.db"); // инициализация соединения
            statement = connection.createStatement(); // инстанс стейтмента
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getNickByLoginAndPass(String login, String pass){
        String sql = String.format("Select nickname from users WHERE login = '%s' and password = '%s'",
                login,pass);
        try {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()){ // позиционирует на строке
                return rs.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new NullPointerException("Не верный пароль");
    }

    public static void disconnect(){

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
