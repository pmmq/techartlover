package interview.pub.com.techartlover.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Pub on 11/9/2559.
 */
public class PageDetailResponse {
    String name;
    String image_url;
    String title;
    int engagement;
    int followers;
    int expert_in;
    float compatibility;
    int shared;
    boolean following;
    HashMap<String,String> recently_rated;

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getTitle() {
        return title;
    }

    public int getEngagement() {
        return engagement;
    }

    public int getFollowers() {
        return followers;
    }

    public int getExpert_in() {
        return expert_in;
    }

    public float getCompatibility() {
        return compatibility;
    }

    public int getShared() {
        return shared;
    }

    public boolean isFollowing() {
        return following;
    }

    public HashMap<String, String> getRecently_rated() {
        return recently_rated;
    }
}
