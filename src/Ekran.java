public class Ekran implements IEkran {

    private static Ekran instance;
    // singleton için kurucu private yapıldı.
    private Ekran(){

    }

    // nesne yoksa oluşuturuluyor, varsa direkt döndürülüyor.
    public static synchronized Ekran getInstance(){
        if (instance==null){
            instance = new Ekran();
        }
        return instance;
    }

    public void mesajGoruntule(String mesaj){
        System.out.println(mesaj);
    }

}
