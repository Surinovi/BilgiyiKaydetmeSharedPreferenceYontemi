package ab2016.ctis.com.bilgiyikaydetmesharedpreferenceyontemi;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class IkinciActivity extends ActionBarActivity {


    private SharedPreferences mSharedPreferences;
    private TextView tvAd, tvSoyad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinci);


        mSharedPreferences = getSharedPreferences("kisiselbilgiler", MODE_PRIVATE);

        String ad = mSharedPreferences.getString("ad", "xyz");
        String soyad = mSharedPreferences.getString("soyad", "abc");

        tvAd = (TextView) findViewById(R.id.tvAd);
        tvSoyad = (TextView) findViewById(R.id.tvSoyad);

        tvAd.setText(ad);
        tvSoyad.setText(soyad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ikinci, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
