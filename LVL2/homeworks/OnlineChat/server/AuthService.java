package OnlineChat.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static String getNickByLoginAndPass(String login, String pass) {
        try {
            ResultSet rs = statement.executeQuery("SELECT nickname, password FROM users WHERE login = '" + login + "'");
            int myHash = pass.hashCode();
            // 106438208
            if (rs.next()) {
                String nick = rs.getString(1);
                int dbHash = rs.getInt(2);
                if (myHash == dbHash) {
                    return nick;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NullPointerException("Не верный пароль");
    }

    public static List<String> getBlackList(String userInBlackList) {
        List<String> nickList = new ArrayList<>();
        String sql = String.format("SELECT user_nickname,\n" +
                "       userBL_nickname\n" +
                "  FROM blackList\n" +
                "  where userBL_nickname = '%s'", userInBlackList);
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                nickList.add(resultSet.getString("nickname_bl"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new NullPointerException();
        }
        return nickList;
    }

    public static String addUsersInBL(String thisUserNick, String usersInBlackList) {

        StringBuilder stringBuilder = new StringBuilder();
        String[] usersBL = usersInBlackList.split(" ");
        String sql;
        for (String userBL : usersBL
        ) {
            try {
                if(thisUserNick == userBL){
                    stringBuilder.append("Нельзя добавлять себя в БЛ.\n");
                    continue;
                }
                sql = String.format("INSERT INTO blackList (\n" +
                        "                          user_nickname,\n" +
                        "                          userBL_nickname\n" +
                        "                      )\n" +
                        "                      VALUES (\n" +
                        "                          '%s',\n" +
                        "                          '%s'\n" +
                        "                      );\n", thisUserNick, userBL);

                PreparedStatement ps = connection.prepareStatement(sql);
                ps.executeUpdate();
                stringBuilder.append("Пользователь (" + userBL + ") добавлен в БЛ.\n");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                stringBuilder.append("Ошибка добавления пользователя (" + userBL + ") добавлен в БЛ. Он уже был добавлен ранее.\n");
            }
        }
        return stringBuilder.toString();
    }

    public static String removeUsersInBL(String thisUserNick, String usersInBlackList) {

        StringBuilder nickList = new StringBuilder();
        String[] usersBL = usersInBlackList.split(" ");
        String sql;
        for (String userBL : usersBL
        ) {
            try {
                sql = String.format("DELETE FROM blackList\n" +
                        "      WHERE user_nickname = '%s' AND \n" +
                        "            userBL_nickname = '%s'", thisUserNick, userBL);

                PreparedStatement ps = connection.prepareStatement(sql);
                ps.execute();
                nickList.append("Пользователь (" + userBL + ") удален из вашего БЛ.\n");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                nickList.append(throwables.toString() + "\n");
            }
        }
        return nickList.toString();
    }


    public static void addUser(String login, String pass, String nick) {
        try {
            String query = "INSERT INTO users (login, password, nickname) VALUES (?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, login);
            ps.setInt(2, pass.hashCode());
            ps.setString(3, nick);
            ps.executeUpdate();
        } catch (SQLException e) {

            try {
                throw new Exception("Ошибка записи пользователя");
            } catch (Exception exception) {
                exception.printStackTrace();
            }


        }
    }

    public static void disconnect() {

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
