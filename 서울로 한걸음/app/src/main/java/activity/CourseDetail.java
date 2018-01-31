package activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.seoullo_one.R;
import com.seoullo_one.Util;

import java.util.ArrayList;
import java.util.List;

import DB.DbOpenHelper;
import fragments.Course0Fragment;
import fragments.Course1Fragment;
import fragments.Course2Fragment;
import fragments.Course3Fragment;
import fragments.Course4Fragment;
import fragments.Course5Fragment;
import fragments.Course6Fragment;
import model.Course;
import model.Cultural;

/**
 * Created by dlekd on 2017-10-05.
 */

public class CourseDetail extends BaseActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private DrawerLayout mDrawerLayout;
    static int pageSize;
    public static int position,theme;
    public static String c_name;
    static Course list;
    static Cultural cultural;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        Util.setGlobalFont(this, getWindow().getDecorView());
        final DbOpenHelper dbOpenHelper = new DbOpenHelper(this,"Course.db",null,DbOpenHelper.newVersion);
        if(getIntent().getExtras() == null){
            //position = 0;
            //theme = 0;
            c_name = "";
        }
        else{
            //position = getIntent().getExtras().getInt("position");
            //theme = getIntent().getExtras().getInt("theme");
            c_name = getIntent().getExtras().getString("c_name");

        }
        list = dbOpenHelper.course_detail2(c_name);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        final TextView textView = (TextView) findViewById(R.id.textView2);
        final LinearLayout map = (LinearLayout) findViewById(R.id.map);
        final LinearLayout detail = (LinearLayout) findViewById(R.id.detail);
        final LinearLayout next = (LinearLayout) findViewById(R.id.next);


        map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://seoullo7017.seoul.go.kr/SSF/J/NO/NEList.do"));

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(viewPager.getCurrentItem() != 0){
                    String heritage = list.getHeritage(viewPager.getCurrentItem()-1);
                    cultural = dbOpenHelper.cultural_select(heritage);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(cultural.getCul_url()));
                    startActivity(intent);
                }

            }
        });


        map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(viewPager.getCurrentItem() != 0){
                    String heritage = list.getHeritage(viewPager.getCurrentItem()-1);
                    cultural = dbOpenHelper.cultural_select(heritage);
                    Intent intent = new Intent(CourseDetail.this,MapView.class);
                    intent.putExtra("lat",cultural.getLat());
                    intent.putExtra("lng",cultural.getLng());


                    startActivity(intent);
                }

                return false;
            }
        });



        next.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(viewPager.getCurrentItem() == pageSize-1)
                    onBackPressed();
                else
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                return false;
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(viewPager.getCurrentItem() == 6)
                    textView.setText("목록으로 이동");
                else
                    textView.setText("다음으로");
            }
        });




    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        Fragment course0Fragment = new Course0Fragment();
        Fragment course1Fragment = new Course1Fragment();
        Fragment course2Fragment = new Course2Fragment();
        Fragment course3Fragment = new Course3Fragment();
        Fragment course4Fragment = new Course4Fragment();
        Fragment course5Fragment = new Course5Fragment();
        Fragment course6Fragment = new Course6Fragment();

        Bundle bundle = new Bundle(1);

        bundle.putString("c_name",c_name);



        course0Fragment.setArguments(bundle);
        course1Fragment.setArguments(bundle);
        course2Fragment.setArguments(bundle);
        course3Fragment.setArguments(bundle);
        course4Fragment.setArguments(bundle);
        course5Fragment.setArguments(bundle);
        course6Fragment.setArguments(bundle);

        adapter.addFragment(course0Fragment,"sdkfj");
        adapter.addFragment(course1Fragment,"sdkfj");
        adapter.addFragment(course2Fragment,"sdf");
        adapter.addFragment(course3Fragment,"asdf");
        adapter.addFragment(course4Fragment,"asdf");
        adapter.addFragment(course5Fragment,"sdkfj");
        adapter.addFragment(course6Fragment,"sdkfj");
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
            pageSize = mFragmentList.size();
            return pageSize;
        }

        public void addFragment(Fragment fragment, String title) {
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
            mDrawerLayout.openDrawer(GravityCompat.END);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
