
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SinhVienModify {

    public static String str_connection = "jdbc:sqlserver://127.0.0.1:1433;databaseName=DinhHoangGia; username=sa; password=12345678;TrustServerCertificate=true;";

    public static List<SinhVien> findAll() {
        List<SinhVien> studentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            // lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection(str_connection);

            // query
            String sql = "select * from student";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                SinhVien std = new SinhVien(resultSet.getInt("id"),
                        resultSet.getString("fullname"), resultSet.getString("gender"),
                        resultSet.getString("email"), resultSet.getString("phone_number"),
                        resultSet.getInt("age"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // ket thuc.

        return studentList;
    }

    public static void insert(SinhVien std) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection(str_connection);

            // query
            String sql = "insert into student(fullname, gender, age, email, phone_number) values(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, std.getFullname());
            statement.setString(2, std.getGender());
            statement.setInt(3, std.getAge());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhoneNumber());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // ket thuc.
    }

    public static void update(SinhVien std) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection(str_connection);

            // query
            String sql = "update student set fullname=?,gender=?,age=?,email=?,phone_number=? where id = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, std.getFullname());
            statement.setString(2, std.getGender());
            statement.setInt(3, std.getAge());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhoneNumber());
            statement.setInt(6, std.getId());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // ket thuc.
    }

    public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection(str_connection);

            // query
            String sql = "delete from student where id = ?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // ket thuc.
    }

    public static List<SinhVien> findByFullname(String fullname) {
        List<SinhVien> studentList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection(str_connection);

            // query
            String sql = "select * from student where fullname like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%" + fullname + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SinhVien std = new SinhVien(resultSet.getInt("id"),
                        resultSet.getString("fullname"), resultSet.getString("gender"),
                        resultSet.getString("email"), resultSet.getString("phone_number"),
                        resultSet.getInt("age"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SinhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // ket thuc.

        return studentList;
    }
}
