package fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seoullo_one.R;

import java.util.List;

import DB.DbOpenHelper;
import activity.CourseDetail;
import model.Course;

/**
 * Created by S on 2017-09-30.
 */

public class FriendFragment extends Fragment {

    RecyclerView recyclerView;
    static List<Course> list;
    public FriendFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_recyclerview, container, false);

        DbOpenHelper dbOpenHelper = new DbOpenHelper(getActivity(),"Course.db",null,DbOpenHelper.newVersion);
        list = dbOpenHelper.friend_select();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext(), list);

        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public ImageView imageView;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card2, parent, false));
            //picture = (ImageView) itemView.findViewById(R.id.card_image);
            name = (TextView) itemView.findViewById(R.id.card_title);
            description = (TextView) itemView.findViewById(R.id.card_text);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    //int theme = 0;
                    String c_name = list.get(position).getC_name().toString();
                    Context context = v.getContext();
                    Intent intent = new Intent(context, CourseDetail.class);
                    //intent.putExtra("theme",theme);
                    intent.putExtra("c_name",c_name);
                    //intent.putExtra("position",position);
                    context.startActivity(intent);
                }
            });


        }
    }

    /**
     * Adapter to display recycler view.
     */
    public class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Card in RecyclerView.

        List<Course> list;
        Context context;





        public ContentAdapter(Context context, List<Course> list) {
            this.list = list;
            this.context = context;



        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }



        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            String png = list.get(position).getPng().toString();
            int tmpId = getResources().getIdentifier(png,"drawable",context.getPackageName());
            holder.imageView.setImageResource(tmpId);
        }



        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}

