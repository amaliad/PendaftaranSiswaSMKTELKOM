package id.sch.smktelkom_mlg.tugas01.xiirpl2004.pendaftaransiswasmktelkom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvH;
    EditText etn, ettl,ettg, ets;
    CheckBox cbr, cbb, cbpsb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etn = (EditText) findViewById(R.id.editTextN);
        ettl = (EditText) findViewById(R.id.editTextTL);
        ettg = (EditText) findViewById(R.id.editTextTG);
        ets = (EditText) findViewById(R.id.editTextS);
        cbr = (CheckBox) findViewById(R.id.checkBoxR);
        cbb = (CheckBox) findViewById(R.id.checkBoxB);
        cbpsb = (CheckBox) findViewById(R.id.checkBoxPSB);
        tvH = (TextView) findViewById(R.id.textViewH);

        findViewById(R.id.buttonD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        StringBuilder builder = new StringBuilder();
        String nama = etn.getText().toString();
        String tempat = ettl.getText().toString();
        String tanggal = ettg.getText().toString();
        String sekolah = ets.getText().toString();
        String program = "\tProgram yang diplih \t\n";
        int startlen = program.length();
        if (cbr.isChecked()) program += "\t\t -> " +cbr.getText() + "\n";
        if (cbb.isChecked()) program += "\t\t -> " +cbb.getText() + "\n";
        if (cbpsb.isChecked()) program += "\t\t -> " +cbpsb.getText() + "\n";
        if (program.length() == startlen) program += "Tidak ada program yang dipilih";
        builder.append("Nama : " + nama + "\n");
        builder.append("Tempat Lahir : " + tempat + "\n");
        builder.append("Tanggal Lahir : " + tanggal + "\n");
        builder.append("Asal Sekolah : " + sekolah + "\n");
        builder.append(program);
        tvH.setText(builder);
    }
}
