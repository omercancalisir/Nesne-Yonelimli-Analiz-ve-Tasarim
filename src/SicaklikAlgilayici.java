import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {

    int anlikSicaklik;

    public SicaklikAlgilayici(){
        Random random = new Random();
        anlikSicaklik = random.nextInt((40 - (-20)) + 1) + (-20);
    }

    public int getAnlikSicaklik() {
        return anlikSicaklik;
    }

    public void setAnlikSicaklik(int anlikSicaklik) {
        this.anlikSicaklik = anlikSicaklik;
    }
}
