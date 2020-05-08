public class SubscriberMerkez implements IObserver {

    public void update(String mesaj,IEkran ekran){
        ekran.mesajGoruntule("Sistem uyarısı ->>> " + mesaj);
    }

}
