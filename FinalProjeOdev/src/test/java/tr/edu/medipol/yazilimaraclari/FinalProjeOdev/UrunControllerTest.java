package tr.edu.medipol.yazilimaraclari.FinalProjeOdev;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tr.edu.medipol.yazilimaraclari.FinalProjeOdev.UrunController.Urun;

public class UrunControllerTest {

    @Test
    public void urunListeleTest() {
        List<Urun> urunListesi = UrunController.listele();

        Assertions.assertEquals(3, urunListesi.size());
        Assertions.assertEquals("Su", urunListesi.get(0).urunIsmi());
        Assertions.assertEquals("Çikolata", urunListesi.get(1).urunIsmi());
        Assertions.assertEquals("Dondurma", urunListesi.get(2).urunIsmi());
    }

    @Test
    public void bulTest() {
        UrunController urunKontrol = new UrunController();
        Urun urun = urunKontrol.bul("1");
        Assertions.assertEquals("Su", urun.urunIsmi());
        Assertions.assertEquals(10.0, urun.fiyat());
    }

    @Test
    public void urunEkleTest() {
        UrunController urunKontrol = new UrunController();
        Urun urun = new Urun("Çikolata", 9.0, "1");

        Urun eklenenUrun = UrunController.ekle(urun);

        Assertions.assertNotNull(eklenenUrun);
        Assertions.assertEquals(4, extracted(urunKontrol).size());
        Assertions.assertEquals("Çikolata", eklenenUrun.urunIsmi());
    }

    private List<Urun> extracted(UrunController urunKontrol) {
        return UrunController.listele();
    }

    @Test
    public void urunSilTest() {
        UrunController urunKontrol = new UrunController();

        boolean urunSilindi = urunKontrol.sil("Su");

        Assertions.assertFalse(urunSilindi);
        Assertions.assertEquals(4, UrunController.listele().size());
    }
}