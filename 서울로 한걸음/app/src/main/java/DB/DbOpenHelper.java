package DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Cultural;

import static activity.CourseDetail.position;


/**
 * Created by dlekd on 2017-10-07.
 */

public class DbOpenHelper extends SQLiteOpenHelper {
    private Context context;
    private static DbOpenHelper minstace;
    public static int newVersion = 52;

    public DbOpenHelper(Context context, String name,
                        SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    public DbOpenHelper(Context context) {
        super(context, "Course.db", null, 1);
    }


    // 최초 DB를 만들때 한번만 호출된다.
    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(DataBases.CreateDB._CREATE);
        db.execSQL("CREATE TABLE COURSE (c_id INTEGER PRIMARY KEY AUTOINCREMENT, c_name varchar, c_path varchar NOT NULL, png varchar NOT NULL,heritage1 varchar,heritage2 varchar,heritage3 varchar,heritage4 varchar,heritage5 varchar,heritage6 varchar,TDT varchar,c_detail_png varchar,c_map_png varchar);");
        db.execSQL("CREATE TABLE HASHTAG (tag_id varchar NOT NULL, tag_name varchar	NOT NULL, PRIMARY KEY (tag_id));");
        db.execSQL("CREATE TABLE COURSE_TAG (c_id INTEGER NOT NULL, tag_id varchar NOT NULL, PRIMARY KEY (c_id,tag_id), FOREIGN KEY (c_id) REFERENCES COURSE (c_id), FOREIGN KEY (tag_id) REFERENCES HASHTAG (tag_id));");
        db.execSQL("CREATE TABLE CULTURAL (cul_id INTEGER PRIMARY KEY AUTOINCREMENT, cul_name VARCHAR NOT NULL, cul_lat DOUBLE NOT NULL, cul_lng DOUBLE NOT NULL, cul_url VARCHAR,address varchar,time varchar,fee varchar,homepage varchar,station varchar,tell varchar);");



        db.execSQL("INSERT INTO COURSE VALUES (null,'힐링산책코스','','love_course1','서울로','한양도성','남대문시장','서울광장','서울시립미술관','덕수궁','총 1.8km, 2시간','love_course1_detail','love_course1_map');");
        db.execSQL("INSERT INTO COURSE VALUES (null,'알콩달콩코스','','love_course2','명동거리','남산골한옥마을','남산서울타워','남산공원','문화역서울284','서울로','총 2.2km, 2.5시간','love_course2_detail','love_course2_map');");
        db.execSQL("INSERT INTO COURSE VALUES (null,'역사나들이코스','','love_course3','경희궁','서울역사박물관','덕수궁돌담길','서울로','안중근의사기념관','백범광장','총 1.5km, 1.5시간','love_course3_detail','love_course3_map');");
        db.execSQL("INSERT INTO COURSE VALUES (null,'먹고사고코스','','solo_course1','서울로','숭례문','숭례문수입상가','남대문시장','회현쇼핑센터','명동거리','총 1.8km, 2시간','solo_course1_detail','solo_course1_map');");
        db.execSQL("INSERT INTO COURSE VALUES (null,'낭만역사코스','','solo_course2','서울역사박물관','덕수궁','서울시립미술관','숭례문','서울로','문화역서울284','총 2.2km, 2.5시간','solo_course2_detail','solo_course2_map');");
        db.execSQL("INSERT INTO COURSE VALUES (null,'힐링서울코스','','solo_course3','서울로','약현성당','충정각','덕수궁돌담길','서울역사박물관','경희궁','총 1.5km, 1.5시간','solo_course3_detail','solo_course3_map');");
        db.execSQL("INSERT INTO COURSE VALUES (null,'역사소풍코스','','child_course1','서울로','백범광장','안중근의사기념관','남산공원','남산서울타워','남산골한옥마을','총 1.8km, 2시간','child_course1_detail','child_course1_map');");
        db.execSQL("INSERT INTO COURSE VALUES (null,'추억나들이코스','','child_course2','남산골한옥마을','재미로','서울애니메이션센터','숭례문','문화역서울284','서울로','총 2.2km, 2.5시간','child_course2_detail','child_course2_map');");
        db.execSQL("INSERT INTO COURSE VALUES (null,'서울이야기코스','','child_course3','서울역사박물관','덕수궁','서울시립미술관','한양도성','손기정체육공원','서울로','총 1.5km, 1.5시간','child_course3_detail','child_course3_map');");
        db.execSQL("INSERT INTO COURSE VALUES (null,'꿀잼서울코스','','freind_course1','남산골한옥마을','서울애니메이션센터','재미로','남대문시장','한양도성','서울로','총 1.8km, 2시간','friend_course1_detail','friend_course1_map');");
        db.execSQL("INSERT INTO COURSE VALUES (null,'역사산책코스','','freind_course2','서울로','문화역서울284','손기정기념관','효창공원','백범기념관','열정도','총 2.2km, 2.5시간','friend_course2_detail','friend_course2_map');");
        db.execSQL("INSERT INTO COURSE VALUES (null,'서울식도락코스','','freind_course3','서울로','숭례문','신세계본관','명동거리','남대문시장','덕수궁','총 1.5km, 1.5시간','friend_course3_detail','friend_course3_map');");


        db.execSQL("INSERT INTO HASHTAG VALUES ('T001','아이와함께');");
        db.execSQL("INSERT INTO HASHTAG VALUES ('T002','친구와함께');");
        db.execSQL("INSERT INTO HASHTAG VALUES ('T003','연인과함께');");
        db.execSQL("INSERT INTO HASHTAG VALUES ('T004','나 혼자');");
        db.execSQL("INSERT INTO HASHTAG VALUES ('H001','역사');");
        db.execSQL("INSERT INTO HASHTAG VALUES ('H002','문화');");
        db.execSQL("INSERT INTO HASHTAG VALUES ('H003','쇼핑');");
        db.execSQL("INSERT INTO HASHTAG VALUES ('H004','힐링');");
        db.execSQL("INSERT INTO HASHTAG VALUES ('H005','꿀잼');");
        db.execSQL("INSERT INTO HASHTAG VALUES ('H006','먹거리');");
        db.execSQL("INSERT INTO HASHTAG VALUES ('H007','건축');");
        db.execSQL("INSERT INTO HASHTAG VALUES ('H008','로맨틱');");
        db.execSQL("INSERT INTO HASHTAG VALUES ('H009','야경');");


        db.execSQL("INSERT INTO COURSE_TAG VALUES (1,'T003');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (1,'H002');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (1,'H004');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (1,'H009');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (2,'T003');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (2,'H008');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (2,'H003');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (2,'H004');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (2,'H009');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (3,'T003');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (3,'H008');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (3,'H007');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (3,'H001');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (4,'T004');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (4,'H007');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (4,'H003');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (4,'H006');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (5,'T004');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (5,'H002');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (5,'H001');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (5,'H009');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (6,'T004');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (6,'H007');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (6,'H004');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (6,'H001');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (6,'H009');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (7,'T001');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (7,'H001');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (7,'H004');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (8,'T001');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (8,'H002');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (8,'H005');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (8,'H001');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (9,'T001');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (9,'H001');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (9,'H002');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (9,'H009');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (10,'T002');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (10,'H001');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (10,'H005');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (10,'H006');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (10,'H009');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (11,'T002');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (11,'H001');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (11,'H004');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (11,'H006');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (12,'T002');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (12,'H003');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (12,'H006');");
        db.execSQL("INSERT INTO COURSE_TAG VALUES (12,'H009');");


        db.execSQL("INSERT INTO CULTURAL VALUES(null, '서울로', '37.556717', '126.971578', 'http://terms.naver.com/entry.nhn?docId=3596201&cid=42856&categoryId=42856#__datalab','서울특별시 중구 청파로 432(봉래동 2가)','24시간 개방','무료','http://seoullo7017.seoul.go.kr','서울역(1호선, 4호선, 경의중앙선)','다산콜센터 120')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '백범광장', '37.554901', '126.979243', 'http://terms.naver.com/entry.nhn?docId=1999785&cid=42856&categoryId=42856','서울특별시 중구 소파로 46(회현동 1가)\n남산공원 백범광장 내','연중개방','무료','','서울역(1호선, 4호선, 경의중앙선)','공원녹지과 02-3396-5881~3')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '안중근의사기념관', '37.553703', '126.980402', 'http://terms.naver.com/entry.nhn?docId=3337057&cid=42856&categoryId=42856','서울특별시 중구 소월로 91(남대문로 5가)','하절기(3월~10월) 10:00~18:00\n동절기(11~2월) 10:00~17:00\n*종료 1시간전 입장 마감','무료','안중근의사기념관\nhttp://ahnjunggeun.or.kr','서울역(1호선, 4호선, 경의중앙선), 회현(1호선, 4호선)','')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '남산공원', '37.553698', '126.989555', 'http://terms.naver.com/entry.nhn?docId=2031635&cid=42856&categoryId=42856','서울특별시 중구 삼일대로 231(예장동)','하절기(3월~10월) 10:00~18:00\n동절기(11월~2월) 10:00~17:00','무료','남산공원 http://parks.seoul.go.kr','서울역(1호선, 4호선, 경의중앙선)','')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '남산서울타워', '37.551177', '126.988229', 'http://terms.naver.com/entry.nhn?docId=1999677&cid=42856&categoryId=42856','서울특별시 용산구 남산공원길 105(용산동 2가)','월~금, 일 10:00~23:00\n토 10:00~24:00\n*기후상황 및 운영일정에 따라 변경 가능','전망대 - 대인 10,000원 / 소인 8,000원','남산서울타워 http://www.seoultower.co.kr','','')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '남산골한옥마을', '37.559323', '126.994489', 'http://terms.naver.com/entry.nhn?docId=2000118&cid=42856&categoryId=42856','서울특별시 중구 퇴계로34길 28(필동 2가)','하절기(4월~10월) 09:00~21:00\n동절기(11월~3월) 09:00~20:00','무료','남산골 한옥마을\nhttp://hanokmaeul.or.kr ','충무로(3호선, 4호선)','')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '재미로', '37.560698', '126.985553', 'http://terms.naver.com/entry.nhn?docId=3342151&cid=58151&categoryId=58151','서울특별시 중구 충무로2가 110-5','연중개방','무료','','을지로입구(2호선), 명동(4호선), 회현(4호선)','')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '서울애니메이션센터', '37.558260', '126.987916', 'http://terms.naver.com/entry.nhn?docId=3336885&cid=42856&categoryId=42856','서울특별시 중구 소파로 126(예장동)','10:00~18:00','무료(일부 시설과 체험프로그램은 유료)','서울애니메이션센터\nhttp://www.ani.seoul.kr','충무로(3호선, 4호선), 명동(4호선)','02-3455-8341~2')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '숭례문', '37.559964', '126.975295', 'http://terms.naver.com/ entry.nhn?docId=2000083&cid=42856&categoryId=42856','서울특별시 중구 세종대로 40(남대문로 4가)','하절기(6월~8월) 09:00~18:30\n동절기(12월~2월) 09:00~17:30','무료','서울 중구 문화관광\nhttp://www.junggu.seoul.kr/tour/','서울역(1호선, 4호선, 경의중앙선)','')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '문화역서울284', '37.555858', '126.971679', 'http://terms.naver.com/entry.nhn?docId=2029889&cid=42856&categoryId=42856','서울특별시 중구 통일로 1(봉래동 2가)','10:00~19:00(입장마감 18:00)\n*매달 마지막 수요일 <문화가 있는 날>은 21시까지 연장','무료','http://www.seoul284.org','서울역(1호선, 4호선, 경의중앙선)','')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '서울역사박물관', '37.570494', '126.970571', 'http://terms.naver.com/entry.nhn?docId=3336889&cid=42856&categoryId=42856','서울특별시 종로구 새문안로 55(신문로 2가)','[하절기(3월~10월)]\n평일 09:00~20:00 / 토, 일, 공휴일 09:00~19:00\n[동절기(11월~2월)]\n평일 09:00~20:00 / 토, 일, 공휴일 09:00~18:00','무료','서울역사박물관','','')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '덕수궁', '37.565813', '126.975143', 'http://terms.naver.com/entry.nhn?docId=1999898&cid=42856&categoryId=42856','서울특별시 중구 세종대로 99(정동)','09:00~21:00','대인(만 25세~64세) - 개인 1,000원 / 10인 이상 단체 800원','덕수궁 http://www.deoksugung.go.kr','시청(1호선, 2호선), 을지로입구(2호선), 광화문(5호선)','02-771-9951, 02-751-0734')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '서울시립미술관', '37.564027', '126.973779', 'http://terms.naver.com/entry.nhn?docId=3336883&cid=42856&categoryId=42856','서울특별시 중구 덕수궁길 61(서소문동)','[하절기(3월~10월)]\n평일 10:00~20:00 / 토, 일, 공휴일 10:00~19:00\n[동절기(11월~2월)]\n평일 10:00~20:00 / 토, 일, 공휴일 10:00~18:00','전시마다 다름','서울시립미술관\nhttp://sema.seoul.go.kr','시청(1호선, 2호선), 서대문(2호선)', '')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '한양도성', '37.581821', '126.958239', 'http://terms.naver.com/entry.nhn?docId=1111300&cid=40942&categoryId=33383','서울특별시 종로구 옥인6길 26-17(누상동 산 1-3) 외','하절기(4월~10월) 09:00~15:00\n동절기(11~3월) 10:00~15:00','무료','','노인정(08-801), 팔각정(08-823), 명륜3가종점(01-503)','')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '손기정체육공원', '37.555292', '126.964668', 'http://terms.naver.com/entry.nhn?docId=1215247&cid=40942&categoryId=34709','서울특별시 중구 손기정로 101 손기정공원','연중개방','무료','','서울역(1호선, 4호선, 경의중앙선)','02-313-7985')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '남대문시장', '37.559179', '126.977667', 'http://terms.naver.com/entry.nhn?docId=1074967&cid=40942&categoryId=32164','서울특별시 중구 남대문시장4길 21','00:00~23:00\n*품목별로 운영시간이 다름\n*일요일 휴무','무료','http://namdaemunmarket.co.kr/','서울역(1호선), 시청(1호선, 2호선), 회현(4호선)','')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '효창공원', '37.545045', '126.960320', 'http://terms.naver.com/entry.nhn?docId=2031690&cid=42856&categoryId=42856','서울특별시 용산구 효창원로 177-18(효창동) 일대','연중무휴','무료','용산 문화관광 http://munha.yongsan.go.kr','효창공원앞(6호선)','용산구청 주민생활지원과 02-2199-8823')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '백범기념관', '37.544248', '126.959183', 'http://terms.naver.com/entry.nhn?docId=3336708&cid=42856&categoryId=42856','서울특별시 용산구 임정로 26(효창동)','하절기(3월~10월) 10:00~18:00 \n동절기(11월~2월) 10:00~17:00\n*1시간 전까지 입장','무료','백범김구기념관 http://www.kimkoomuseum.org','효창공원앞(6호선), 공덕(6호선, 경의중앙선)','백범김구기념관 02-799-3400')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '열정도', '37.538698', '126.968440', 'https://www.facebook.com/thepassionisland','용산구 백범로87길 50','','','blog.naver.com/official_youngseller','남영(1호선), 효창공원앞(6호선), 삼각지(6호선)','070-8614-6331')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '신세계본관', '37.560889', '126.981133', 'https://store.naver.com/attractions/detail?id=12134149&entry=plt&query=%EC%8B%A0%EC%84%B8%EA%B3%84%EB%B0%B1%ED%99%94%EC%A0%90%20%EB%B3%B8%EC%A0%90','서울 중구 소공로 63','평일 10:30~20:00.\n주말 10:30~20:30\n공휴일 10:30~20:30','','http://department.shinsegae.com','시청(1호선), 을지로입구(2호선), 회현(4호선)','')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '명동거리', '37.563638', '126.982841', 'http://terms.naver.com/entry.nhn?docId=2031333&cid=42856&categoryId=42856','서울특별시 중구 명동길(명동 1가)','','','서울 중구 문화관광\nhttp://www.junggu.seoul.kr/tour/','명동(4호선), 을지로입구(2호선), 을지로3가(2호선)','명동관광안내소 02-774-3238')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '서울광장', '37.565595', '126.978028', 'http://terms.naver.com/entry.nhn?docId=2031728&cid=42856&categoryId=42856','서울특별시 중구 세종대로 110(태평로 1가)','연중개방','무료','서울광장 http://plaza.seoul.go.kr','시청(1호선, 2호선), 을지로입구(2호선), 광화문(5호선)','광화문 안내소 02-735-8688')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '덕수궁돌담길', '37.566247', '126.973491', 'http://terms.naver.com/entry.nhn?docId=2031329&cid=42856&categoryId=42856','서울 중구 정동 덕수궁 정문~경향신문사','연중개방','무료','덕수궁 http://www.deoksugung.go.kr','시청(1호선, 2호선), 을지로입구(2호선)','다산콜센터 120')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '경희궁', '37.571236', '126.968172', 'http://terms.naver.com/entry.nhn?docId=1999896&cid=42856&categoryId=42856','서울특별시 종로구 새문안로 55(신문로)','09:00~18:00','무료','서울역사박물관\nhttp://www.museum.seoul.kr','서대문(5호선)','02-724-0274~6')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '숭례문수입상가', '37.559408', '126.976136', 'http://terms.naver.com/entry.nhn?docId=1929314&cid=40942&categoryId=32164','서울특별시 중구 남창동 51-1','','','','시청(1호선, 2호선), 서울역(1호선), 회현(4호선)','')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '회현쇼핑센터', '37.560675', '126.981794', 'http://map.naver.com/local/siteview.nhn?code=18692813','서울특별시 중구 소공로 58 회현지하쇼핑센터','평일 10:00~20:00.\n토요일 10:00~20:00','무료','','시청(1호선, 2호선), 을지로입구(2호선), 회현(4호선), 명동(4호선)','')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '약현성당', '37.559126', '126.967450', 'http://terms.naver.com/entry.nhn?docId=2030790&cid=42856&categoryId=42856','서울특별시 중구 청파로 447-1(중림동)','','','http://www.yakhyeon.or.kr','서울역(1호선, 경의중앙선), 충정로(2호선, 5호선)','사무실 02-362-1891')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '충정각', '37.560484', '126.963692', 'https://store.naver.com/restaurants/detail?id=18204959&entry=plt&query=%EC%B6%A9%EC%A0%95%EA%B0%81','서울 서대문구 충정로2길 8','매일 10:00~23:00\n*일요일 휴무','','','충정로(2호선, 5호선), 서대문(5호선)','02-313-0424')");
        db.execSQL("INSERT INTO CULTURAL VALUES(null, '손기정기념관', '37.555667', '126.964548', 'https://store.naver.com/attractions/detail?id=18712147&entry=plt&query=%EC%86%90%EA%B8%B0%EC%A0%95%EA%B8%B0%EB%85%90%EA%B4%80','서울 중구 손기정로 101','하절기(4월~10월) 10:00~18:00\n동절기(11~3월) 10:00~17:00','무료','http://www.sonkeechung.com/wordpress/','충정로(2호선, 5호선), 서울역(1호선, 경의중앙선)','02-364-1936')");


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS COURSE");
        db.execSQL("DROP TABLE IF EXISTS HASHTAG");
        db.execSQL("DROP TABLE IF EXISTS COURSE_TAG");
        db.execSQL("DROP TABLE IF EXISTS CULTURAL");
        onCreate(db);
    }




    public Cultural cultural_select(String heritage_name){
        SQLiteDatabase db = getReadableDatabase();


        Cursor cursor = db.rawQuery("select * from CULTURAL where cul_name = '"+heritage_name+"';",null);
        cursor.moveToFirst();
        Cultural cultural = new Cultural();
        cultural.setCul_id(cursor.getInt(0));
        cultural.setCul_name(cursor.getString(1));
        cultural.setLat(cursor.getDouble(2));
        cultural.setLng(cursor.getDouble(3));
        cultural.setCul_url(cursor.getString(4));
        cultural.setAdd(cursor.getString(5));
        cultural.setTime(cursor.getString(6));
        cultural.setFee(cursor.getString(7));
        cultural.setHomepage(cursor.getString(8));
        cultural.setStation(cursor.getString(9));
        cultural.setTell(cursor.getString(10));


        return cultural;
    }


    public List<Course> child_select() {
        SQLiteDatabase db = getReadableDatabase();
        List<Course> courseList = new ArrayList<Course>();

        Cursor cursor = db.rawQuery("select c_name,c_path,png from COURSE_TAG,COURSE,HASHTAG where COURSE.c_id = COURSE_TAG.c_id and HASHTAG.tag_id = COURSE_TAG.tag_id and tag_name in('아이와함께');", null);

        while (cursor.moveToNext()) {
            Course course = new Course();

            //course.setC_id(cursor.getInt(0));
            course.setC_name(cursor.getString(0));
            course.setC_path(cursor.getString(1));
            course.setPng(cursor.getString(2));
            courseList.add(course);

        }
      //  db.close();
        return courseList;
    }


    public List<Course> friend_select() {
        SQLiteDatabase db = getReadableDatabase();
        List<Course> courseList = new ArrayList<Course>();

        Cursor cursor = db.rawQuery("select c_name,c_path,png from COURSE_TAG,COURSE,HASHTAG where COURSE.c_id = COURSE_TAG.c_id and HASHTAG.tag_id = COURSE_TAG.tag_id and tag_name in('친구와함께');", null);

        while (cursor.moveToNext()) {
            Course course = new Course();

            course.setC_name(cursor.getString(0));
            course.setC_path(cursor.getString(1));
            course.setPng(cursor.getString(2));
            courseList.add(course);

        }
     //   db.close();
        return courseList;
    }

    public List<Course> love_select() {
        SQLiteDatabase db = getReadableDatabase();
        List<Course> courseList = new ArrayList<Course>();

        Cursor cursor = db.rawQuery("select c_name,c_path,png from COURSE_TAG,COURSE,HASHTAG where COURSE.c_id = COURSE_TAG.c_id and HASHTAG.tag_id = COURSE_TAG.tag_id and tag_name in('연인과함께');", null);

        while (cursor.moveToNext()) {
            Course course = new Course();


            course.setC_name(cursor.getString(0));
            course.setC_path(cursor.getString(1));
            course.setPng(cursor.getString(2));
            courseList.add(course);


        }
      //  db.close();
        return courseList;
    }
    public List<Course> solo_select() {
        SQLiteDatabase db = getReadableDatabase();
        List<Course> courseList = new ArrayList<Course>();

        Cursor cursor = db.rawQuery("select c_name,c_path,png from COURSE_TAG,COURSE,HASHTAG where COURSE.c_id = COURSE_TAG.c_id and HASHTAG.tag_id = COURSE_TAG.tag_id and tag_name in('나 혼자');", null);

        while (cursor.moveToNext()) {
            Course course = new Course();


            course.setC_name(cursor.getString(0));
            course.setC_path(cursor.getString(1));
            course.setPng(cursor.getString(2));
            courseList.add(course);


        }
       // db.close();
        return courseList;
    }

    public Course course_detail2(String c_name) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        cursor=db.rawQuery("select c_name,c_path,png,heritage1,heritage2,heritage3,heritage4,heritage5,heritage6,TDT,c_detail_png,c_map_png from COURSE where c_name = '"+c_name+"';",null);

        cursor.moveToPosition(position);

        Course course = new Course();

        course.setC_name(cursor.getString(0));
        course.setC_path(cursor.getString(1));
        course.setPng(cursor.getString(2));
        course.setHeritage(cursor.getString(3));
        course.setHeritage(cursor.getString(4));
        course.setHeritage(cursor.getString(5));
        course.setHeritage(cursor.getString(6));
        course.setHeritage(cursor.getString(7));
        course.setHeritage(cursor.getString(8));
        course.setTDT(cursor.getString(9));
        course.setC_detail_png(cursor.getString(10));
        course.setC_map_png(cursor.getString(11));

       // db.close();
        return course;
    }


    public List<Course> course_detail(int position, int theme) {
        SQLiteDatabase db = getReadableDatabase();
        List<Course> courseList = new ArrayList<Course>();
        Cursor cursor = null;
        switch(theme){
            case 0: cursor = db.rawQuery("select c_name,c_path,png,heritage1,heritage2,heritage3,heritage4,heritage5,heritage6,TDT,c_detail_png,c_map_png from COURSE_TAG,COURSE,HASHTAG where COURSE.c_id = COURSE_TAG.c_id and HASHTAG.tag_id = COURSE_TAG.tag_id and tag_name in('아이와함께');", null); break;
            case 1: cursor = db.rawQuery("select c_name,c_path,png,heritage1,heritage2,heritage3,heritage4,heritage5,heritage6,TDT,c_detail_png,c_map_png from COURSE_TAG,COURSE,HASHTAG where COURSE.c_id = COURSE_TAG.c_id and HASHTAG.tag_id = COURSE_TAG.tag_id and tag_name in('친구와함께');", null); break;
            case 2: cursor = db.rawQuery("select c_name,c_path,png,heritage1,heritage2,heritage3,heritage4,heritage5,heritage6,TDT,c_detail_png,c_map_png from COURSE_TAG,COURSE,HASHTAG where COURSE.c_id = COURSE_TAG.c_id and HASHTAG.tag_id = COURSE_TAG.tag_id and tag_name in('연인과함께');", null); break;
            case 3: cursor = db.rawQuery("select c_name,c_path,png,heritage1,heritage2,heritage3,heritage4,heritage5,heritage6,TDT,c_detail_png,c_map_png from COURSE_TAG,COURSE,HASHTAG where COURSE.c_id = COURSE_TAG.c_id and HASHTAG.tag_id = COURSE_TAG.tag_id and tag_name in('나 혼자');", null); break;
        }

        cursor.moveToPosition(position);

        Course course = new Course();

        course.setC_name(cursor.getString(0));
        course.setC_path(cursor.getString(1));
        course.setPng(cursor.getString(2));
        course.setHeritage(cursor.getString(3));
        course.setHeritage(cursor.getString(4));
        course.setHeritage(cursor.getString(5));
        course.setHeritage(cursor.getString(6));
        course.setHeritage(cursor.getString(7));
        course.setHeritage(cursor.getString(8));
        course.setTDT(cursor.getString(9));
        course.setC_detail_png(cursor.getString(10));
        course.setC_map_png(cursor.getString(11));
        courseList.add(course);

       /// db.close();
        return courseList;
    }
    SQLiteDatabase db = getReadableDatabase();

    public List<String> search(ArrayList<String> selected_tag) {
        List<String> searchList = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < selected_tag.size(); i++) {
            sb.append("'" + selected_tag.get(i) + "',");
        }

        String str = sb.toString();
        int length = str.length();
        str = str.substring(0, length - 1);

        Cursor cursor = db.rawQuery("select c_name from COURSE_TAG,COURSE,HASHTAG where COURSE.c_id = COURSE_TAG.c_id and HASHTAG.tag_id = COURSE_TAG.tag_id and tag_name in(" + str + ") group by c_name;", null);
        while (cursor.moveToNext()) {
            //ArrayList<String> search_course = new ArrayList<String>();

            searchList.add(cursor.getString(0));
        }
     //   db.close();
    return searchList;
    }
}



