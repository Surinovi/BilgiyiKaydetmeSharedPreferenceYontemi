package ab2016.ctis.com.bilgiyikaydetmesharedpreferenceyontemi;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.content.SharedPreferences;
import android.content.Intent;

// Değeri Kaydetme Yöntemleri
/*
1. Shared Preferences: Anahtar ve değer çifti
2. Internal Storage: Düzensiz bilgi
3. External Storage: SDCard
4. SQLite Databases: Yapılandırılmış Veri var ise
5. Network Baglantısı ile bilgi farklı bir sisteme aktarılır.
*/


public class MainActivity extends ActionBarActivity {

    EditText etAd, etSoyad;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAd = (EditText) findViewById(R.id.etAd);
        etSoyad = (EditText) findViewById(R.id.etSoyad);
    }

    private void displayToast(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }


    public void onClick(View v){


        // Kaydedilen değer uygulamanın tüm Activitelerinde kullanılabilir
        //dosyanın adı kisiselbilgiler.xml olur
        mSharedPreferences = getSharedPreferences("kisiselbilgiler",MODE_PRIVATE);

        //Kaydedilen değer Sadece  değerin kaydedildiği aktivite tarafından ulaşılabilir
        ///SharedPreference ismi verilmedigi. Dosya adı
        //mSharedPreferences = getPreferences(MODE_PRIVATE);


        //SharedPreference değer kaydetmek  Editor objesi ile yapılır. Dosyanın adı aktiviteninadı.xml olur.
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        // EditText içindeki degeri al ve sharedPreference içine kaydeder.
        editor.putString("ad", etAd.getText().toString());
        editor.putString("soyad", etSoyad.getText().toString());


        // SharedPreference içindeki degerler kaydedilir
        editor.commit();

        //editor.remove("soyad"); //kaydedilen değeri siler
        //editor.commit(); // commit ile yapılan değişiklik kalıcı olur

        // Display file saved message
        displayToast("Kaydedildi");

    }

    public void ikinciActiviteyeGit(View v){
        Intent intent = new Intent(this, IkinciActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
