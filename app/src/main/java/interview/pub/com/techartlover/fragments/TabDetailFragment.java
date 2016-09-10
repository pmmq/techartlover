package interview.pub.com.techartlover.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import interview.pub.com.techartlover.R;
import interview.pub.com.techartlover.adapters.MovieAdapter;
import interview.pub.com.techartlover.response.PageDetailResponse;

/**
 * Created by Pub on 10/9/2559.
 */
public class TabDetailFragment extends Fragment {

    @BindView(R.id.rv_movie)
    RecyclerView recyclerView;
    PageDetailResponse pageDetailResponse;

    public static String RESPONSE_DATA_KEY = "response_data";

    public static TabDetailFragment create(PageDetailResponse data){

        TabDetailFragment instance = new TabDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(RESPONSE_DATA_KEY,data.getRecently_rated());
        instance.setArguments(bundle);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_layout,container,false);
        ButterKnife.bind(this,rootView);

        HashMap<String,String> data =  (HashMap<String, String>) getArguments().getSerializable(RESPONSE_DATA_KEY);

        LinearLayoutManager lm = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(new MovieAdapter(data,getContext()));

        return rootView;
    }
}
