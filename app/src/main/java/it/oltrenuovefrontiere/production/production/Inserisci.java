package it.oltrenuovefrontiere.production.production;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;

public class Inserisci extends AppCompatActivity {

    private EditText txtDataCarico;
    private EditText txtOraCarico;
    private EditText txtGrCarico;
    private EditText txtDataScarico;
    private EditText txtOraScarico;
    private EditText txtGrScarico;
    private EditText txtNominativo;
    private EditText txtDesc;
    private EditText txtMatricola;
    private EditText txtGrDiff;
    private EditText txtTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserisci);

        txtDataCarico = (EditText) findViewById(R.id.txtDataCarico);
        txtOraCarico = (EditText) findViewById(R.id.txtOraCarico);
        txtGrCarico = (EditText) findViewById(R.id.txtGrCarico);
        txtDataScarico = (EditText) findViewById(R.id.txtDataScarico);
        txtOraScarico = (EditText) findViewById(R.id.txtOraScarico);
        txtGrScarico = (EditText) findViewById(R.id.txtGrScarico);
        txtNominativo = (EditText) findViewById(R.id.txtNominativo);
        txtDesc = (EditText) findViewById(R.id.txtDesc);
        txtMatricola = (EditText) findViewById(R.id.txtMatricola);
        txtGrDiff = (EditText) findViewById(R.id.txtGrDiff);
        txtTempo = (EditText) findViewById(R.id.txtTempo);
    }

    public void calcola(View v) {
        Lavorazione lav = new Lavorazione();
        lav.setDataCarico(txtDataCarico.getText().toString());
        lav.setOraCarico(txtOraCarico.getText().toString());
        lav.setGrCaricoFromString(txtGrCarico.getText().toString());
        lav.setDataScarico(txtDataScarico.getText().toString());
        lav.setOraScarico(txtOraScarico.getText().toString());
        lav.setGrScaricoFromString(txtGrScarico.getText().toString());
        lav.setNominativo(txtNominativo.getText().toString());
        lav.setDescrizione(txtDesc.getText().toString());
        lav.setMatricola(txtMatricola.getText().toString());

        try {
            txtGrDiff.setText("Gr. " + lav.getDiff().toString());
        } catch (ArithmeticException _arExcept) {
            Helper.returnWarningDialog(this, "Controlla i pesi perché la differenza tra carico e scarico è negativa.").show();
            } catch (IllegalArgumentException _ilExcept) {
            Helper.returnWarningDialog(this, "Controlla i pesi inseriti perché non sono validi").show();
        }

        try {
            txtTempo.setText(lav.getTempo());
        } catch (ArithmeticException _arExcept) {

        } catch (IllegalArgumentException _ilExcept) {

        } catch (ParseException parseExcept) {
            Helper.returnWarningDialog(this, "Controllare il formato delle date").show();
        }
    }
}
