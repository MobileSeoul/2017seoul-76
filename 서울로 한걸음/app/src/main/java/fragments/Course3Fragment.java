package fragments;

/**
 * Created by dlekd on 2017-10-05.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seoullo_one.R;
import com.seoullo_one.Util;

import DB.DbOpenHelper;
import model.Course;
import model.Cultural;


/**
 * Created by dlekd on 2017-10-05.
 */

public class Course3Fragment extends Fragment {
    static Course list;
    static Cultural list2;
    TextView course_name,TDT,name,add,time,fee,homepage,station,tell,textView;
    ImageView course_map;

    public Course3Fragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course1, container, false);
        course_name = (TextView) view.findViewById(R.id.course_name);
        TDT = (TextView) view.findViewById(R.id.TDT);
        add = (TextView) view.findViewById(R.id.add);
        time = (TextView) view.findViewById(R.id.time);
        fee = (TextView) view.findViewById(R.id.fee);
        homepage = (TextView) view.findViewById(R.id.homepage);
        station = (TextView) view.findViewById(R.id.station);
        tell = (TextView) view.findViewById(R.id.tell);
        TextView name = (TextView) view.findViewById(R.id.name);
        textView = (TextView) view.findViewById(R.id.textView);
        course_map = (ImageView) view.findViewById(R.id.course_map);


        DbOpenHelper dbOpenHelper = new DbOpenHelper(getActivity(),"Course.db",null,DbOpenHelper.newVersion);
        //int position = getArguments().getInt("position");
        //int theme = getArguments().getInt("theme");
        String c_name = getArguments().getString("c_name");
        list = dbOpenHelper.course_detail2(c_name);
        String heritage_name = list.getHeritage(2).toString();

        list2 = dbOpenHelper.cultural_select(heritage_name);
        add.setText(list2.getAdd().toString());
        time.setText(list2.getTime().toString());
        fee.setText(list2.getFee().toString());
        homepage.setText(list2.getHomepage().toString());
        station.setText(list2.getStation().toString());
        tell.setText(list2.getTell().toString());
        course_name.setText(list.getC_name().toString());
        TDT.setText(list.getTDT().toString());
        name.setText(heritage_name);
        textView.setText("3");
        Util.setGlobalFont(getContext(), view);



        String c_map = list.getC_map_png().toString();
        int tmpid = getResources().getIdentifier(c_map,"drawable",getContext().getPackageName());
        course_map.setImageResource(tmpid);

        return view;
    }
}


