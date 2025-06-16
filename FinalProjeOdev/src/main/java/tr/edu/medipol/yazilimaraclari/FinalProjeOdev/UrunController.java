package tr.edu.medipol.yazilimaraclari.FinalProjeOdev;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urun")
public class UrunController {

    public record Urun(String urunIsmi, double fiyat, String urunKod) {}

    private static final List<Urun> URUN_LISTESI = new ArrayList<>();
    static {
        URUN_LISTESI.add(new Urun("Su", 10.0, "1"));
        URUN_LISTESI.add(new Urun("Çikolata", 9.0, "2"));
        URUN_LISTESI.add(new Urun("Dondurma", 20.0, "3"));
    }

    @GetMapping("/")
    public static List<Urun> listele() {
        return URUN_LISTESI;
    }

    @GetMapping("/{urunKod}")
    Urun bul(String urunKod) {
        for (Urun urun : URUN_LISTESI) {
            if (urun.urunKod().equalsIgnoreCase(urunKod)) {
                return urun;
            }
        }
        return null;
    }

    @PostMapping("/ekle")
    public static Urun ekle(@RequestBody Urun urun) {
        URUN_LISTESI.add(urun);
        return urun;
    }

    @DeleteMapping("/{urunKod}")
    public boolean sil(@PathVariable String urunKod) {
        Urun urun = bul(urunKod);
        if (urun != null) {
            URUN_LISTESI.remove(urun);
            return true;
        }
        return false;
    }
}