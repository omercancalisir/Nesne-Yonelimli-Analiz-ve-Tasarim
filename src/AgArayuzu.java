import java.sql.SQLOutput;

public class AgArayuzu implements IAgArayuzu {



    public String anaMenuyuGoster(IEkran ekran, ITusTakimi tusTakimi){

        // ekran klavye buraya gelicek


        ekran.mesajGoruntule("******************************************");
        ekran.mesajGoruntule("Ana Menu");
        ekran.mesajGoruntule("1-Sicaklik Goruntule");
        ekran.mesajGoruntule("2-Sogutucu Acma");
        ekran.mesajGoruntule("3-Sogutucu Kapatma");
        ekran.mesajGoruntule("4-Cikis");
        ekran.mesajGoruntule("******************************************");

        return tusTakimi.veriAl();
    }



}
