package fragments;

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


/**
 * Created by dlekd on 2017-10-05.
 */

public class Course0Fragment extends Fragment {
    static Course list;
    TextView course_name,TDT;
    ImageView course_map,course_detail;
    public Course0Fragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course0, container, false);

        course_name = (TextView) view.findViewById(R.id.course_name);
        TDT = (TextView) view.findViewById(R.id.TDT);
        course_map = (ImageView) view.findViewById(R.id.course_map);
        course_detail = (ImageView) view.findViewById(R.id.course_detail);
        Util.setGlobalFont(getContext(), view);


        DbOpenHelper dbOpenHelper = new DbOpenHelper(getActivity(),"Course.db",null,DbOpenHelper.newVersion);
        //int position = getArguments().getInt("position");
        //int theme = getArguments().getInt("theme");
        String c_name = getArguments().getString("c_name");


        list = dbOpenHelper.course_detail2(c_name);

        //course_name.setText(list.get(0).getHeritage(3).toString());
        //String c_name = list.get(0).getC_name().toString();
        String c_map = list.getC_map_png().toString();
        String c_detail = list.getC_detail_png().toString();

        int tmpid = getResources().getIdentifier(c_map,"drawable",getContext().getPackageName());
        int tmpid2 = getResources().getIdentifier(c_detail,"drawable",getContext().getPackageName());

        course_map.setImageResource(tmpid);
        course_detail.setImageResource(tmpid2);
        TDT.setText(list.getTDT().toString());
        course_name.setText(c_name);

        return view;
    }
}
