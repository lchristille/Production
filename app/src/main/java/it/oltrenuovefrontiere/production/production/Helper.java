package it.oltrenuovefrontiere.production.production;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

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
}
