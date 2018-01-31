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

public class LoveFragment extends Fragment {

    RecyclerView recyclerView;
    static List<Course> list;
    public LoveFragment(){

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
        list = dbOpenHelper.love_select();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext(), list);

        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // public ImageView picture;
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

            // Adding Snackbar to Action Button inside card
           /* Button button = (Button)itemView.findViewById(R.id.action_button);
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Action is pressed",
                            Snackbar.LENGTH_LONG).show();
                }
            });*/

            /*ImageButton favoriteImageButton =
                    (ImageButton) itemView.findViewById(R.id.favorite_button);
            favoriteImageButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Added to Favorite",
                            Snackbar.LENGTH_LONG).show();
                }
            });

            ImageButton shareImageButton = (ImageButton) itemView.findViewById(R.id.share_button);
            shareImageButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Share article",
                            Snackbar.LENGTH_LONG).show();
                }
            });
            */
        }
    }

    /**
     * Adapter to display recycler view.
     */
    public class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Card in RecyclerView.

        List<Course> list;
        Context context;



        //private final String[] mPlaces;
        //private final String[] mPlaceDesc;
        //private final Drawable[] mPlacePictures;

        public ContentAdapter(Context context, List<Course> list) {
            this.list = list;
            this.context = context;

            /*Resources resources = context.getResources();
            mPlaces = resources.getStringArray(R.array.places);
            mPlaceDesc = resources.getStringArray(R.array.place_desc);
            TypedArray a = resources.obtainTypedArray(R.array.places_picture);
            mPlacePictures = new Drawable[a.length()];
            for (int i = 0; i < mPlacePictures.length; i++) {
                mPlacePictures[i] = a.getDrawable(i);
            }
            a.recycle();
            */

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }



        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            //holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
            //holder.name.setText(list.get(position).getC_name());
            //holder.description.setText(list.get(position).getC_path());
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
