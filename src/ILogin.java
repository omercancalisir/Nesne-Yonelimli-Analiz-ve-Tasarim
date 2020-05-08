import java.sql.SQLException;

public interface ILogin {

    public boolean girisDogrula(String kullaniciAdi,String sifre,IEkran ekran,IBilgiSistemi bilgiSistemi) throws SQLException;

}
