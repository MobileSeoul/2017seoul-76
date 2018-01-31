package activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.seoullo_one.R;
import com.seoullo_one.Util;

import java.util.ArrayList;
import java.util.List;

import DB.DbOpenHelper;

public class SearchActivity extends BaseActivity {
    Toolbar toolbar;

    private TextView txt_child;
    private TextView txt_friend;
    private TextView txt_love;
    private TextView txt_solo;
    private TextView txt_history;
    private TextView txt_shop;
    private TextView txt_hill;
    private TextView txt_fun;
    private TextView txt_eat;
    private TextView txt_tech;
    private TextView txt_culture;
    private TextView txt_romantic;
    private TextView txt_night;
    private TextView txt_search;
    private TextView txt_refresh;
    private List<String> courseList;
    ArrayList<String> select_tag = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        toolbar = (Toolbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Util.setGlobalFont(this, getWindow().getDecorView());

        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowCustomEnabled(true);
        supportActionBar.setDisplayHomeAsUpEnabled(true);            //액션바 아이콘을 업 네비게이션 형태로 표시합니다.
        supportActionBar.setDisplayShowTitleEnabled(false);

        init();

    }

    private void init() {
        //linear_refresh = (LinearLayout) findViewById(R.id.linear_refresh);
        txt_child = (TextView) findViewById(R.id.txt_child);
        txt_friend = (TextView) findViewById(R.id.txt_friend);
        txt_love = (TextView) findViewById(R.id.txt_love);
        txt_solo = (TextView) findViewById(R.id.txt_solo);
        txt_history = (TextView) findViewById(R.id.txt_history);
        txt_shop = (TextView) findViewById(R.id.txt_shop);
        txt_hill = (TextView) findViewById(R.id.txt_hill);
        txt_fun = (TextView) findViewById(R.id.txt_fun);
        txt_eat = (TextView) findViewById(R.id.txt_eat);
        txt_tech = (TextView) findViewById(R.id.txt_tech);
        txt_culture = (TextView) findViewById(R.id.txt_culture);
        txt_romantic = (TextView) findViewById(R.id.txt_romantic);
        txt_night = (TextView) findViewById(R.id.txt_night);
        txt_search= (TextView) findViewById(R.id.txt_search);
        txt_refresh = (TextView) findViewById(R.id.txt_refresh);

        txt_child.setOnClickListener(onClickListener);
        txt_friend.setOnClickListener(onClickListener);
        txt_love.setOnClickListener(onClickListener);
        txt_solo.setOnClickListener(onClickListener);
        txt_history.setOnClickListener(onClickListener);
        txt_shop.setOnClickListener(onClickListener);
        txt_hill.setOnClickListener(onClickListener);
        txt_fun.setOnClickListener(onClickListener);
        txt_eat.setOnClickListener(onClickListener);
        txt_tech.setOnClickListener(onClickListener);
        txt_culture.setOnClickListener(onClickListener);
        txt_romantic.setOnClickListener(onClickListener);
        txt_night.setOnClickListener(onClickListener);
        txt_search.setOnClickListener(onClickListener);
        txt_refresh.setOnClickListener(onClickListener);

        //linear_refresh.setOnClickListener(onClickListener);

    }
    private void initPanel() {
        txt_child.setSelected(false);
        txt_friend.setSelected(false);
        txt_love.setSelected(false);
        txt_solo.setSelected(false);
        txt_history.setSelected(false);
        txt_shop.setSelected(false);
        txt_hill.setSelected(false);
        txt_fun.setSelected(false);
        txt_eat.setSelected(false);
        txt_tech.setSelected(false);
        txt_culture.setSelected(false);
        txt_romantic.setSelected(false);
        txt_night.setSelected(false);
    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.txt_child) {  //카드뷰안에 글씨색변경
                txt_child.setSelected(!txt_child.isSelected());
                if(txt_child.isSelected()) {
                    select_tag.add("아이와함께");
                }else
                    select_tag.remove("아이와함께");
            }
            if (v.getId() == R.id.txt_friend) {
                txt_friend.setSelected(!txt_friend.isSelected());
                if(txt_friend.isSelected()) {
                    select_tag.add("친구와함께");
                }else
                    select_tag.remove("친구와함께");
            }
            if (v.getId() == R.id.txt_love) {
                txt_love.setSelected(!txt_love.isSelected());
                if(txt_love.isSelected()) {
                    select_tag.add("연인과함께");
                }else
                    select_tag.remove("연인과함께");
            }
            if (v.getId() == R.id.txt_solo) {
                txt_solo.setSelected(!txt_solo.isSelected());
                if(txt_solo.isSelected()) {
                    select_tag.add("나 혼자");
                }else
                    select_tag.remove("나 혼자");
            }
            if (v.getId() == R.id.txt_history) {
                txt_history.setSelected(!txt_history.isSelected());
                if(txt_history.isSelected()) {
                    select_tag.add("역사");
                }else
                    select_tag.remove("역사");
            }
            if (v.getId() == R.id.txt_shop) {
                txt_shop.setSelected(!txt_shop.isSelected());
                if(txt_shop.isSelected()) {
                    select_tag.add("쇼핑");
                }else
                    select_tag.remove("쇼핑");
            }
            if (v.getId() == R.id.txt_hill) {
                txt_hill.setSelected(!txt_hill.isSelected());
                if(txt_hill.isSelected()) {
                    select_tag.add("힐링");
                }else
                    select_tag.remove("힐링");
            }
            if (v.getId() == R.id.txt_fun) {
                txt_fun.setSelected(!txt_fun.isSelected());
                if(txt_fun.isSelected()) {
                    select_tag.add("꿀잼");
                }else
                    select_tag.remove("꿀잼");
            }
            if (v.getId() == R.id.txt_eat) {
                txt_eat.setSelected(!txt_eat.isSelected());
                if(txt_eat.isSelected()) {
                    select_tag.add("먹거리");
                }else
                    select_tag.remove("먹거리");
            }
            if (v.getId() == R.id.txt_tech) {
                txt_tech.setSelected(!txt_tech.isSelected());
                if(txt_tech.isSelected()) {
                    select_tag.add("건축");
                }else
                    select_tag.remove("건축");
            }
            if (v.getId() == R.id.txt_culture) {
                txt_culture.setSelected(!txt_culture.isSelected());
                if(txt_culture.isSelected()) {
                    select_tag.add("문화");
                }else
                    select_tag.remove("문화");
            }
            if (v.getId() == R.id.txt_romantic) {
                txt_romantic.setSelected(!txt_romantic.isSelected());
                if(txt_romantic.isSelected()) {
                    select_tag.add("로맨틱");
                }else
                    select_tag.remove("로맨틱");
            }
            if (v.getId() == R.id.txt_night) {
                txt_night.setSelected(!txt_night.isSelected());
                if(txt_night.isSelected()) {
                    select_tag.add("야경");
                }else
                    select_tag.remove("야경");
            }
            if(v.getId() == R.id.txt_refresh){
                initPanel();
            }
            if(v.getId() == R.id.txt_search){
                select_tag.add("");
                DbOpenHelper dbOpenHelper = new DbOpenHelper(SearchActivity.this,"Course.db",null, DbOpenHelper.newVersion);

                courseList = dbOpenHelper.search(select_tag);

                LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.search_result,null);
                AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);
                //builder.setTitle("검색결과");
                builder.setView(dialogView);
                Util.setGlobalFont(inflater.getContext(), dialogView);


                ListView listView = (ListView) dialogView.findViewById(R.id.c_list);

                ArrayList<String> mDatas = new ArrayList<String>();
                for(int i = 0; i<courseList.size();i++){
                    mDatas.add(courseList.get(i).toString());
                }

                ArrayAdapter adapter = new ArrayAdapter(SearchActivity.this,android.R.layout.simple_list_item_1,mDatas);
                listView.setAdapter(adapter);
                Util.setGlobalFont(adapter.getContext(), listView);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(SearchActivity.this, CourseDetail.class);
                        intent.putExtra("c_name",courseList.get(position).toString());
                        startActivity(intent);

                    }
                });

                Dialog dialog = builder.create();

                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);

                Window window = dialog.getWindow();
                int x = (int)(size.x * 0.7f);
                int y = (int)(size.y * 0.6f);
                dialog.show();
                window.setLayout(x, y);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
        }
    };

}
