package activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.seoullo_one.R;
import com.seoullo_one.Util;

import java.util.ArrayList;
import java.util.List;

import fragments.ChildFragment;
import fragments.FriendFragment;
import fragments.LoveFragment;
import fragments.SoloFragment;
import info.InfoFaq;
import info.InfoSeoullo;


/**
 * Created by S on 2017-09-30.
 */

public class ScrollableTabsActivity extends BaseActivity {


    private Button childcos, friendcos, lovecos, solocos;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DrawerLayout mDrawerLayout;
    int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);
        Util.setGlobalFont(this, getWindow().getDecorView());

        toolbar = (Toolbar) findViewById(R.id.scroll_toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       if(getIntent().getExtras() == null){
           position = 0;
       }
       else {
           position = getIntent().getExtras().getInt("position");
       }

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        viewPager.setCurrentItem(position);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowCustomEnabled(true);
        supportActionBar.setDisplayHomeAsUpEnabled(true);            //액션바 아이콘을 업 네비게이션 형태로 표시합니다.
        supportActionBar.setDisplayShowTitleEnabled(false);        //액션바에 표시되는 제목의 표시유무를 설정합니다.
        //supportActionBar.setDisplayShowHomeEnabled(false);

        /*if (supportActionBar != null) {
            VectorDrawableCompat indicator
                    = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(),R.color.white,getTheme()));
            //supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }*/
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        if(menuItem.getItemId()==R.id.info_seoullo){
                            Intent intent = new Intent(ScrollableTabsActivity.this, InfoSeoullo.class);
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
                        if(menuItem.getItemId()==R.id.info_faq){
                            Intent intent = new Intent(ScrollableTabsActivity.this, InfoFaq.class);
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


    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new ChildFragment(), "아이와 함께");
        adapter.addFrag(new FriendFragment(), "친구와 함께");
        adapter.addFrag(new LoveFragment(), "연인과 함께");
        adapter.addFrag(new SoloFragment(), "나 혼자");
        viewPager.setAdapter(adapter);
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentTitleList.size();
        }

        public void addFrag(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Util.setGlobalFont(this, getWindow().getDecorView());
        return super.onCreateOptionsMenu(menu);
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mDrawerLayout.openDrawer(GravityCompat.END);
            Util.setGlobalFont(this, getWindow().getDecorView());
            return true;
        }
        Util.setGlobalFont(this, getWindow().getDecorView());

        return super.onOptionsItemSelected(item);
    }

}

