package id.sch.smktelkom_mlg.tugas01.xiirpl2004.pendaftaransiswasmktelkom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvH;
    EditText etn, ettl,ettg, ets;
    CheckBox cbr, cbb, cbpsb;
    RadioGroup rgjk;
    Spinner spagama;

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
        rgjk = (RadioGroup) findViewById(R.id.RadioGroup);
        spagama = (Spinner) findViewById(R.id.spinneragama);
        tvH = (TextView) findViewById(R.id.textViewH);

        findViewById(R.id.buttonD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            StringBuilder builder = new StringBuilder();
            String nama = etn.getText().toString();
            String tempat = ettl.getText().toString();
            int tahun = Integer.parseInt(ettg.getText().toString());
            int usia = 2016 - tahun;
            String sekolah = ets.getText().toString();
            String program = "Program yang diplih \t\n";
            int startlen = program.length();
            if (cbr.isChecked()) program += "\t  " + cbr.getText() + "\n";
            if (cbb.isChecked()) program += "\t  " + cbb.getText() + "\n";
            if (cbpsb.isChecked()) program += "\t  " + cbpsb.getText() + "\n";
            if (program.length() == startlen) program = "Tidak ada program yang dipilih";
            String hasil = null;
            if (rgjk.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton) findViewById(rgjk.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }
            builder.append("\nPendaftarn Siswa Baru SMK TELKOM\n");
            builder.append(program);
            builder.append("Nama : " + nama + "\n");
            if (hasil == null) {
                builder.append("Anda belum memilih Jenis Kelamin\n");
            } else {
                builder.append("Jenis Kelamin : " + hasil + "\n");
            }
            builder.append("Tempat Lahir : " + tempat + "\n");
            builder.append("Tanggal Lahir : " + tahun + "\n");
            builder.append("Umur : " + usia + "\n");
            builder.append("Agama : ");
            builder.append(spagama.getSelectedItem().toString() + "\n");
            builder.append("Asal Sekolah : " + sekolah + "\n");


            tvH.setText(builder);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etn.getText().toString();
        String tempat = ettl.getText().toString();
        String tahun = ettg.getText().toString();
        String sekolah = ets.getText().toString();

        if(nama.isEmpty())
        {
            etn.setError("Nama Belum diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            etn.setError("Nama minimal 3 karakter");
            valid = false;
        }
        else
        {
            etn.setError(null);
        }
        if(tempat.isEmpty())
        {
            ettl.setError("Tempat Lahir Belum diisi");
            valid = false;
        }
        else
        {
            ettl.setError(null);
        }
        if(tahun.isEmpty())
        {
            ettg.setError("Tahun belum diisi");
            valid = false;
        }
        else if (tahun.length()!=4)
        {
            ettg.setError("format tahun bukan yyyy");
            valid = false;
        }
        else
        {
            ettg.setError(null);
        }
        if(sekolah.isEmpty())
        {
            ets.setError("Sekolah Belum diisi");
            valid = false;
        }
        else if(sekolah.length()<5)
        {
            ets.setError("Nama Sekolah minimal 5 karakter");
            valid = false;
        }
        else
        {
            ets.setError(null);
        }
        return valid;

    }
}
