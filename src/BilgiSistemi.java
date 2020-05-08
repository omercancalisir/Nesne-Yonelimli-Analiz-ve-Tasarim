import java.sql.Connection;
import java.sql.DriverManager;

public class BilgiSistemi implements IBilgiSistemi {

    private Connection connection =null;

    public Connection veriTabaninaBaglan(IEkran ekran){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/NYATOdev", "postgres", "Fenerbahce");

            if (connection != null) {
                ekran.mesajGoruntule("Veri Tabanına Bağlanıldı. \n");
            }
            else {
                ekran.mesajGoruntule("Bağlantı girişimi başarısız! \n");
            }

        } catch (Exception e) {
            ekran.mesajGoruntule("Baglanti Yapilamadı. \n");
            e.printStackTrace();
        }
        return connection;
    }

}
