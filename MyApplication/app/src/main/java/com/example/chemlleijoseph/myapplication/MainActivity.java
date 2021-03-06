package com.example.chemlleijoseph.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.chemlleijoseph.myapplication.fragments.DemoFragment;
import com.example.chemlleijoseph.myapplication.fragments.WorkFragment;
import com.example.chemlleijoseph.myapplication.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    //@BindView(R.id.profileButton) Button picButton;

    @OnClick(R.id.profileButton)
    public void submit(View view){

        shortToast("PIC");
    }

    private DemoFragment demoFragment;
    private WorkFragment workFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toast.makeText(this, "Hello, Android!", Toast.LENGTH_LONG).show();
        demoFragment = new DemoFragment();
        workFragment = new WorkFragment();

        final Button workButton = (Button)findViewById(R.id.workButton);
        final Button demoButton = (Button)findViewById(R.id.demoButton);
        //final Button picButton = (Button)findViewById(R.id.profileButton);

        workButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workButton.setTextColor(Color.RED);
                demoButton.setTextColor(Color.BLACK);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_layout, workFragment).commit();
            }
        });

        demoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                demoButton.setTextColor(Color.RED);
                workButton.setTextColor(Color.BLACK);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_layout, demoFragment).commit();
            }
        });

        /*picButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "PictureButton", Toast.LENGTH_SHORT);
                goToActivity(NinePatchActivity.class,"TEST", "test");
                UtilLog.d("TEST", "test");
            }
        });*/





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
