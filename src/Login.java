import java.sql.*;
import java.util.Scanner;

public class Login implements ILogin {




    public boolean girisDogrula(String kullaniciAdi,String sifre,IEkran ekran,IBilgiSistemi bilgiSistemi) throws SQLException {



        // burada veritabanına bağlanıp doğruluğunu kontrol edicek

        Connection connection = bilgiSistemi.veriTabaninaBaglan(ekran);
/*
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/NYATOdev", "postgres", "Fenerbahce");

            if (connection != null) {
                ekran.mesajGoruntule("Veri Tabanına Bağlandı. \n");
            }
            else {
                ekran.mesajGoruntule("Bağlantı girişimi başarısız! \n");
            }

        } catch (Exception e) {
            ekran.mesajGoruntule("Baglanti Yapilamadı. \n");
            e.printStackTrace();
        }
*/




        ResultSet rs=null;
        PreparedStatement pst=null;
        String sqlKomut = "select * from \"Yetkililer\" where \"kullaniciAdi\"=? and sifre=?";

        pst = connection.prepareStatement(sqlKomut);
        pst.setString(1,kullaniciAdi);
        pst.setString(2,sifre);
        rs = pst.executeQuery();
        connection.close();

        if(rs.next())
        {
            ekran.mesajGoruntule("Kullanıcı Adı ve Şifre Doğrulandı. \n \n");
            return true;
        }
        else
        {
            ekran.mesajGoruntule("Girilen Kullanıcı Adı veya Şifre Hatalı. \n \n");
            return false;
        }


        //System.out.println("giris doğrulanıyor...");
        //System.out.println("veritabanına bağlanıldı..");


    }

}
