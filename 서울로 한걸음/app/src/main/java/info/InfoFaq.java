package info;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.seoullo_one.R;
import com.seoullo_one.Util;

import activity.BaseActivity;


/**
 * Created by S on 2017-10-18.
 */

public class InfoFaq extends BaseActivity {
    private RecyclerView infoFaq_View;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter infoFaq_Adapter;
    private DrawerLayout mDrawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_faq);
        toolbar = (Toolbar) findViewById(R.id.faq_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Util.setGlobalFont(this, getWindow().getDecorView());

        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowCustomEnabled(true);
        supportActionBar.setDisplayHomeAsUpEnabled(true);            //액션바 아이콘을 업 네비게이션 형태로 표시합니다.
        supportActionBar.setDisplayShowTitleEnabled(false);


        infoFaq_View = (RecyclerView) findViewById(R.id.infoFaq_VIew);

        String[] faq_title=getResources().getStringArray(R.array.faq_title);
        String[] faq_content=getResources().getStringArray(R.array.faq_content);

        layoutManager = new LinearLayoutManager(this);
        infoFaq_View.setLayoutManager(layoutManager);
        infoFaq_Adapter = new InfoFaqAdapter(this,faq_title,faq_content);
        infoFaq_View.setAdapter(infoFaq_Adapter);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        if(menuItem.getItemId()==R.id.info_seoullo){
                            Intent intent = new Intent(InfoFaq.this, InfoSeoullo.class);
                            // intent.addFlags(intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            startActivity(intent);
                        }
                        if(menuItem.getItemId()==R.id.info_new){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://seoullo7017.seoul.go.kr/SSF/J/NO/NEList.do"));
                            // intent.addFlags(intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            startActivity(intent);
                        }
                        if(menuItem.getItemId()==R.id.info_idea){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://eungdapso.seoul.go.kr/"));
                            // intent.addFlags(intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            startActivity(intent);
                        }
                        if(menuItem.getItemId()==R.id.info_program){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://seoullo7017.seoul.go.kr/SSF/H/ENJ/010/05010.do"));
                            // intent.addFlags(intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            startActivity(intent);
                        }
                        if(menuItem.getItemId()==R.id.info_tour){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://seoullo7017.seoul.go.kr/SSF/H/ENJ/010/06010.do"));
                            // intent.addFlags(intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            startActivity(intent);
                        }

                        //menuItem.setChecked(true);
                        // TODO: handle navigation

                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Util.setGlobalFont(this, getWindow().getDecorView());
        return super.onCreateOptionsMenu(menu);
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            mDrawerLayout.openDrawer(GravityCompat.END);
            Util.setGlobalFont(this, getWindow().getDecorView());
            return true;
        }
        Util.setGlobalFont(this, getWindow().getDecorView());

        return super.onOptionsItemSelected(item);
    }
}
