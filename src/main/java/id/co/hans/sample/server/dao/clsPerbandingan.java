package id.co.hans.sample.server.dao;

import org.springframework.stereotype.Service;

@Service
public class clsPerbandingan {
    public Double InputRp;

    public Double MasukanKwh() {
        return InputRp;
    }

    public void MasukanKwh(Double inputRp) {
        InputRp = inputRp;
    }

    public Double Keluarankwh() {
        Integer masukan;
        String acho;
        Integer AUrut = 0;
        Double Bronx;

        masukan = InputRp.toString().length();

        while (masukan > 0) {
            AUrut++;
            acho = InputRp.toString().substring(masukan,1);
            if (InputRp.toString().substring(masukan,1) == ".") {
                Bronx = Double.parseDouble(InputRp.toString().substring(masukan+1, AUrut-1));
                masukan--;
            } else {
                masukan--;
            }
        }

        return InputRp;
    }
}
