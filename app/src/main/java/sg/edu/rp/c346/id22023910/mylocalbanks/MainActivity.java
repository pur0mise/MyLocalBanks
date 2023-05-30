package sg.edu.rp.c346.id22023910.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        if (v == tvDBS) {
            wordClicked = "dbs";
        } else if (v == tvUOB) {
            wordClicked = "uob";
        } else if (v == tvOCBC) {
            wordClicked = "ocbc";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            int id = item.getItemId();
            if (id == R.id.WebsiteSelection) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentWeb);
                return true;
            } else if (id == R.id.BankContactSelection) {
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentContact);
                return true;
            } else if (id == R.id.FavouriteSelection) {
                int color = tvDBS.getCurrentTextColor();
                Log.d("mytag", "" + color);
                if (color == -65536) {
                    Log.d("mytag", "Toggle1");
                    tvDBS.setTextColor(Color.parseColor("#000000"));
                }
                else {
                    Log.d("mytag", "Toggle2");
                    tvDBS.setTextColor(Color.parseColor("#FF0000"));
                }
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            int id = item.getItemId();
            if (id == R.id.WebsiteSelection) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWeb);
                return true;
            } else if (id == R.id.BankContactSelection) {
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentContact);
                return true;
            } else if (id == R.id.FavouriteSelection) {
                int color = tvOCBC.getCurrentTextColor();
                Log.d("mytag", "" + color);
                if (color == -65536) {
                    Log.d("mytag", "Toggle1");
                    tvOCBC.setTextColor(Color.parseColor("#000000"));
                }
                else {
                    Log.d("mytag", "Toggle2");
                    tvOCBC.setTextColor(Color.parseColor("#FF0000"));
                }
            }
        } else if (wordClicked.equalsIgnoreCase("uob")) {
            int id = item.getItemId();
            if (id == R.id.WebsiteSelection) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWeb);
                return true;
            } else if (id == R.id.BankContactSelection) {
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(intentContact);
                return true;
            } else if (id == R.id.FavouriteSelection) {
                int color = tvUOB.getCurrentTextColor();
                Log.d("mytag", "" + color);
                if (color == -65536) {
                    Log.d("mytag", "Toggle1");
                    tvUOB.setTextColor(Color.parseColor("#000000"));
                }
                else {
                    Log.d("mytag", "Toggle2");
                    tvUOB.setTextColor(Color.parseColor("#FF0000"));
                }
            }
        }

        return super.onOptionsItemSelected(item);
    }
}