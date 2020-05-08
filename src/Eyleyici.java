public class Eyleyici implements IEyleyici {

    // true açık -- false kapalı demek default olarak kapalı
    private boolean sogutucuDurumu = false;

    public boolean isSogutucuDurumu() {
        return sogutucuDurumu;
    }

    public void setSogutucuDurumu(boolean sogutucuDurumu) {
        this.sogutucuDurumu = sogutucuDurumu;
    }

    // sogutucu açıldığında sicaklık düşmeye başlamalı
    public void sogutucuAc(IEkran ekran) {
        // sogutucu açılıyor.
        if (sogutucuDurumu == true) {
            ekran.mesajGoruntule("soğutucu hali hazırda zaten açık.");
        } else {
            sogutucuDurumu = true;
            ekran.mesajGoruntule("sogutucu açıldı");
        }
    }

    // sıcaklık burada düşürülüyor publisher.notify burada mı çalışacak ?
    public void sicaklikDusur(ISicaklikAlgilayici sicaklikAlgilayici,IEkran ekran,ISubject publisher) {
        if (sicaklikAlgilayici.getAnlikSicaklik() > -20){

            int anlikSicaklik = sicaklikAlgilayici.getAnlikSicaklik() - 1;
            sicaklikAlgilayici.setAnlikSicaklik(anlikSicaklik);
        }else{
            publisher.notify("sicaklik -20 derecenin altına inemez. Sogutucu sistem tarafından kapatılıyor.",ekran);
            sogutucuDurumu = false;
            // buraya mesaj yazılması için publisher gelicek ve uyarı verilecek en düşük sıcaklığa ulaşıldı diye
        }

    }

    public void sogutucuKapat(IEkran ekran) {
        if (sogutucuDurumu == false) {
            ekran.mesajGoruntule("sogutucu hali hazırda zaten kapalı.");
        } else {
            sogutucuDurumu = false;
            ekran.mesajGoruntule("sogutucu kapatıldı");
        }
    }

}
