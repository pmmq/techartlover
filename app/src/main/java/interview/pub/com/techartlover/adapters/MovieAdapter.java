package interview.pub.com.techartlover.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;
import java.util.zip.Inflater;

import interview.pub.com.techartlover.R;
import interview.pub.com.techartlover.holders.MovieItemViewHolder;
import interview.pub.com.techartlover.response.PageDetailResponse;

/**
 * Created by Pub on 10/9/2559.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieItemViewHolder> {

    Map<String,String> detailData;
    ArrayList<String> url;
    Context mContext;
    public MovieAdapter(Map<String,String> detailData , Context context) {
        this.detailData = detailData;
        url = new ArrayList<String>(detailData.values());
        mContext = context;
    }

    @Override
    public MovieItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.movie_holder, parent, false);
        return new MovieItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieItemViewHolder holder, int position) {
        Picasso.with(mContext).load(url.get(position)).into(holder.ivMoviePoster);
    }

    @Override
    public int getItemCount() {
        return detailData.size();
    }
}
