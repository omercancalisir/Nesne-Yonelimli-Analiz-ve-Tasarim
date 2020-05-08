import java.sql.SQLException;
import java.util.Scanner;

public class MerkeziIslemBirimi {

    private IAgArayuzu agArayuzu;
    private ISicaklikAlgilayici sicaklikAlgilayici;
    private IEyleyici eyleyici;
    private ITusTakimi tusTakimi;
    private IEkran ekran;

/*
    // ana menu seçenekleri
    private static final String SICAKLIK_GORUNTULE = "1";
    private static final String SOGUTUCUYU_ACMA = "2";
    private static final String SOGUTUCUYU_KAPAMA = "3";
    private static final String CIKIS = "4";
*/

    public MerkeziIslemBirimi() {
        agArayuzu = new AgArayuzu();
        sicaklikAlgilayici = new SicaklikAlgilayici();
        eyleyici = new Eyleyici();
        tusTakimi = TusTakimi.getInstance();
        ekran = Ekran.getInstance();
    }


    public void basla() throws SQLException {

        System.out.print("kullanici adi :");
        String kullaniciAdi = tusTakimi.veriAl();
        System.out.print("sifre :");
        String sifre = tusTakimi.veriAl();

        IBilgiSistemi bilgiSistemi = new BilgiSistemi();
        ILogin login = new Login();

        if (login.girisDogrula(kullaniciAdi, sifre,ekran,bilgiSistemi)) {

            // kişi nesnesi oluşurulsa ?(subscriber)

            ekran.mesajGoruntule("giris basarili !!");
            islemSecimi();


        } else {
            ekran.mesajGoruntule("giris basarisiz.");
        }


    }

/*
    private void islemSecimi() {
        String secim = "";
        do {
            secim = agArayuzu.anaMenuyuGoster(ekran, tusTakimi);
            switch (secim) {
                case SICAKLIK_GORUNTULE:
                    ekran.mesajGoruntule("sıcaklık görüntüleme");
                    ekran.mesajGoruntule("" + sicaklikAlgilayici.getAnlikSicaklik());
                    break;
                case SOGUTUCUYU_ACMA:
                    ekran.mesajGoruntule("sogutucu açılıyor.");
                    eyleyici.sogutucuAc();
                    break;
                case SOGUTUCUYU_KAPAMA:
                    ekran.mesajGoruntule("sogutucu kapatılıyr");
                    break;
                case CIKIS:
                    ekran.mesajGoruntule("çıkış yapılıyor.");
                    break;
                default:
                    ekran.mesajGoruntule("lutfen ekrandaki menü içerisinden bir seçim yapınız.");

            }


        } while (!secim.equals("4"));
    }

    private void denemeIslemSecimi2() {
        String secim = "";
        // true açık -- false kapalı demek default olarak kapalı
        //boolean sogutucuDurumu = false;


        while (true) {
            secim = agArayuzu.anaMenuyuGoster(ekran, tusTakimi);
            if (secim.equals("1")) {
                ekran.mesajGoruntule("sıcaklık görüntüleme");
                ekran.mesajGoruntule("" + sicaklikAlgilayici.getAnlikSicaklik());
            }


            if ((secim.equals("3") && eyleyici.isSogutucuDurumu() == true)) {
                ekran.mesajGoruntule("sogutucu kapatılıyor");
                // sogutucu kapatıldı.
                eyleyici.setSogutucuDurumu(false);
            }
            if ((secim.equals("2") && eyleyici.isSogutucuDurumu() == false) || eyleyici.isSogutucuDurumu() == true) {


                ekran.mesajGoruntule("sogutucu açılıyor.");
                eyleyici.sogutucuAc();
                // sogutucu açıldı.

                eyleyici.setSogutucuDurumu(true);
            }
            if (secim.equals("4")) {
                ekran.mesajGoruntule("çıkış yapılıyor.");
                break;
            }
            if (secim.equals("1") && secim.equals("2") && secim.equals("3") && secim.equals("4")) {
                ekran.mesajGoruntule("lutfen ekrandaki menü içerisinden bir seçim yapınız.");
            }
        }
    }
*/



    private void islemSecimi() {
        String secim = "";
        // true açık -- false kapalı demek default olarak kapalı
        //boolean sogutucuDurumu = false;

        // gecici olarak publisher burda olsun
        ISubject publisher = new Publisher();
        IObserver subscriber1 = new SubscriberMerkez();
        publisher.attach(subscriber1);


        while (true) {
            secim = agArayuzu.anaMenuyuGoster(ekran, tusTakimi);

            if (secim.equals("1")) {
                //ekran.mesajGoruntule("sıcaklık görüntüleme");
                ekran.mesajGoruntule("Anlik sicaklik degeri :" + sicaklikAlgilayici.getAnlikSicaklik());
            }

            if (secim.equals("2")) {


                //ekran.mesajGoruntule("sogutucu açıldı.");
                // sogutucu açıldı.
                eyleyici.sogutucuAc(ekran);

            }

            if (secim.equals("3")) {
                //ekran.mesajGoruntule("sogutucu kapatılıyor");
                // sogutucu kapatıldı.
               eyleyici.sogutucuKapat(ekran);
            }
            if (secim.equals("4")) {
                ekran.mesajGoruntule("çıkış yapılıyor.");
                break;
            }
            if (!(secim.equals("1") || secim.equals("2") || secim.equals("3") || secim.equals("4"))) {
                ekran.mesajGoruntule("lutfen ekrandaki menü içerisinden bir seçim yapınız.");
            }


            if (eyleyici.isSogutucuDurumu()==true){
                eyleyici.sicaklikDusur(sicaklikAlgilayici,ekran,publisher);
            }


        }
    }


}
