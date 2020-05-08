public interface IEyleyici {

    public boolean isSogutucuDurumu();
    public void setSogutucuDurumu(boolean sogutucuDurumu);

    public void sicaklikDusur(ISicaklikAlgilayici sicaklikAlgilayici,IEkran ekran,ISubject publisher);
    public void sogutucuAc(IEkran ekran);
    public void sogutucuKapat(IEkran ekran);

}
