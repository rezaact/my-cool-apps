package id.co.hans.sample.server.dao;

import org.springframework.stereotype.Service;

@Service
public class clsPendekatankWh {
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
            if (InputRp.toString().substring(masukan,1) == ","
                || InputRp.toString().substring(masukan,1) == ".") {
                Bronx = Double.parseDouble(InputRp.toString().substring(masukan+1, 1));

                if (Integer.parseInt(Double.toString(InputRp).substring(masukan+1,1)) < 5) {
                    masukan--;
                    InputRp = Double.parseDouble(Double.toString(InputRp).substring(1, masukan));
                } else {
                    masukan--;
                    InputRp = Double.parseDouble(Double.toString(InputRp).substring(1, masukan)) + 1;
                }
            } else {
                masukan--;
            }
        }
        return InputRp;
    }

}
