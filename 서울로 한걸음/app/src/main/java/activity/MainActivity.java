package activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.seoullo_one.R;
import com.seoullo_one.Util;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private ImageView childcos, friendcos, lovecos, solocos, search;
    private DrawerLayout mDrawerLayout;
    int position;
    ImageView imageView;
    Bitmap bitmap;
    float ImageRadius = 900.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Util.setGlobalFont(this, getWindow().getDecorView());
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        search = (ImageView) findViewById(R.id.search);
        search.setOnClickListener(this);

        friendcos = (ImageView) findViewById(R.id.friendcos);
        friendcos.setOnClickListener(this);

        childcos = (ImageView) findViewById(R.id.childcos);
        childcos.setOnClickListener(this);

        lovecos = (ImageView) findViewById(R.id.lovecos);
        lovecos.setOnClickListener(this);

        solocos = (ImageView) findViewById(R.id.solocos);
        solocos.setOnClickListener(this);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator
                    = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(),R.color.white,getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            //supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        imageView = (ImageView)findViewById(R.id.imageView);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jandi);

        imageView.setImageBitmap(bitmap);
        RoundedBitmapDrawable RBD = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        RBD.setCornerRadius(ImageRadius);
        RBD.setAntiAlias(true);

        imageView.setImageDrawable(RBD);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ScrollableTabsActivity.class);
        switch (view.getId()) {
            case R.id.childcos:
                intent.putExtra("position",0);
                startActivity(intent);
                break;

            case R.id.friendcos:
                intent.putExtra("position",1);
                startActivity(intent);
                break;

            case R.id.lovecos:
                intent.putExtra("position",2);
                startActivity(intent);
                break;

            case R.id.solocos:
                intent.putExtra("position",3);
                startActivity(intent);
                break;

            case R.id.search:
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
                break;

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



}

