import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new gui.login().setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
