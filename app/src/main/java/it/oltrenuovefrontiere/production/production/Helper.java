package it.oltrenuovefrontiere.production.production;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Utente on 09/11/2015.
 */
public class Helper {
    static public Float calcDiff(Lavorazione _lav) {
        float result = _lav.getGrCarico() - _lav.getGrScarico();
        return result;
    }

    static public AlertDialog returnWarningDialog(Context c, String _message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("Attenzione");
        builder.setMessage(_message);
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        return dialog;
    }

    static public long dayDifferenceWithLavorativi (Date dataInizio, Date dataFine) {
        final long ONE_HOUR = 60 * 60 * 1000L;
        Calendar inizio = Calendar.getInstance();
        inizio.setTime(dataInizio);
        Calendar fine = Calendar.getInstance();
        long totali = (dataFine.getTime() - dataInizio.getTime() + ONE_HOUR) / (ONE_HOUR * 24);
        long festivi = 0;
        for (int i = 1; i <= totali; i++){
            inizio.add(Calendar.DAY_OF_MONTH,1);
            if(inizio.get(Calendar.DAY_OF_WEEK) == 1 || inizio.get(Calendar.DAY_OF_WEEK) == 7){
                festivi++;
            }
        }
        long lavorativi = totali - festivi;
        return lavorativi;
    }
}
