import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws SQLException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui.login().setVisible(true);
            }
        });
    }
}
