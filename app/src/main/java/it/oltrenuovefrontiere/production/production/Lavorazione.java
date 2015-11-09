package it.oltrenuovefrontiere.production.production;

import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Utente on 09/11/2015.
 */
public class Lavorazione {
    private String dataCarico;
    private String oraCarico;
    private float grCarico;
    private String dataScarico;
    private String oraScarico;
    private float grScarico;
    private String nominativo;
    private String descrizione;
    private String matricola;

    public String getDataCarico() {
        return dataCarico;
    }

    public void setGrCaricoFromString(String _string) {
        if (!_string.isEmpty()) {
            _string = _string.replaceAll(",", ".");
            this.setGrCarico(Float.parseFloat(_string));
        }
    }

    public void setGrScaricoFromString(String _string) {
        if (!_string.isEmpty()) {
            _string = _string.replaceAll(",", ".");
            this.setGrScarico(Float.parseFloat(_string));
        }
    }

    public void setDataCarico(String dataCarico) {
        if (!dataCarico.isEmpty()) {this.dataCarico = dataCarico; }
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        if (!matricola.isEmpty()) { this.matricola = matricola; }
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        if (!descrizione.isEmpty()) { this.descrizione = descrizione; }
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        if (!nominativo.isEmpty()) { this.nominativo = nominativo; }
    }

    public float getGrScarico() {
        return grScarico;
    }

    public void setGrScarico(float grScarico) {
        if (grScarico != 0.0f)  this.grScarico = grScarico;
    }

    public String getOraScarico() {
        return oraScarico;
    }

    public void setOraScarico(String oraScarico) {
        if (!oraScarico.isEmpty()) { this.oraScarico = oraScarico; }
    }

    public String getDataScarico() {
        return dataScarico;
    }

    public void setDataScarico(String dataScarico) {
        if (!dataScarico.isEmpty()) { this.dataScarico = dataScarico; }
    }

    public float getGrCarico() {
        return grCarico;
    }

    public void setGrCarico(float grCarico) {
        if (grCarico != 0.0f) { this.grCarico = grCarico; }
    }

    public String getOraCarico() {
        return oraCarico;
    }

    public void setOraCarico(String oraCarico) {
        if (!oraCarico.isEmpty()) { this.oraCarico = oraCarico; }
    }

    public Float getDiff() throws ArithmeticException, IllegalArgumentException {
        if (grCarico == 0.0f || grScarico == 0.0f) { throw new IllegalArgumentException(); };
        if (grCarico < grScarico) { throw new ArithmeticException(); };
        float result = getGrCarico() - getGrScarico();
        return result;
    }

    public String getTempo() throws ArithmeticException, IllegalArgumentException, ParseException {
        String result = new String();
        Date _dataCarico;
        Date _dataScarico;
        if (dataCarico.isEmpty() || dataScarico.isEmpty() || oraCarico.isEmpty() || oraScarico.isEmpty()) {
            throw new IllegalArgumentException();
        }
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            _dataCarico = format.parse(dataCarico);
        } catch (ParseException parseExcept) {
            throw parseExcept;
        }
        try {
            _dataScarico = format.parse(dataCarico);
        } catch (ParseException parseExcept) {
            throw parseExcept;
        }
        long millisDiff = _dataScarico.getTime() - _dataCarico.getTime();
        result = String.valueOf(millisDiff) + "millesimi";
        return result;
    }
}
