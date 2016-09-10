package interview.pub.com.techartlover.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import interview.pub.com.techartlover.R;

/**
 * Created by Pub on 10/9/2559.
 */
public class MovieItemViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_movie_poster)
    public ImageView ivMoviePoster;
    public MovieItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
