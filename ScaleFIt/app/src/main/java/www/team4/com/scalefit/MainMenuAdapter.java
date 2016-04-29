package www.team4.com.scalefit;


import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.ViewHolder> {

    private final static String TAG = Activity.class.getSimpleName();
    private static final boolean On = true;
    private static final boolean Off = false;
    private static final int TYPE_HEADER = 0;  // Declaring Variable to Understand which View is being worked on
    // IF the view under inflation and population is header or Item
    private static final int TYPE_ITEM = 1;

    private String mNavTitles[]; // String Array to store the passed titles Value from MainActivity.java
    private int mIcons[];       // Int Array to store the passed icons resource value from MainActivity.java

    private String name;        //String Resource for header View Name
    private int profile;        //int Resource for header view profile picture
    private String email;       //String Resource for header view email
    Context context;


    // Creating a ViewHolder which extends the RecyclerView View Holder
    // ViewHolder are used to to store the inflated views in order to recycle them


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        int Holderid;

        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView Name;
        TextView email;
        Context contxt;


        public ViewHolder(View itemView,int ViewType, Context c) {
            super(itemView);
            contxt = itemView.getContext();
            itemView.setClickable(true);
            itemView.setOnClickListener(this);

            if(ViewType == TYPE_ITEM) {
                textView = (TextView) itemView.findViewById(R.id.rowText);
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);
                Holderid = 1;
            }
            else{


                Name = (TextView) itemView.findViewById(R.id.name);
                email = (TextView) itemView.findViewById(R.id.email);
                profile = (ImageView) itemView.findViewById(R.id.circleView);
                Holderid = 0;
            }
        }

        @Override
        public void onClick(View v) {
            if (On) Log.i(TAG, "On Click Called");
            Toast.makeText(contxt,"The Item Clicked is: "+getAdapterPosition(), Toast.LENGTH_SHORT)
                    .show();

           /*Intent intent = null;
            switch(getAdapterPosition())
            {
                case 0:
                    intent = new Intent(contxt, MainActivity.class);
                    break;
                case 1:
                    intent = new Intent(contxt, ProfileActivity.class);
                    break;
                case 2:
                    intent = new Intent(contxt, weightScreenActivity.class);
                    break;
                case 3:
                    intent = new Intent(contxt, Team4Activity.class);
                    break;
                case 4:
                    intent = new Intent(contxt, Settings.class);
                    break;

                default:
                    break;
            }*/

        }

    }



    MainMenuAdapter(String Titles[], int Icons[], String Name, String Email, int Profile,Context passedContext){

        mNavTitles = Titles;
        mIcons = Icons;
        name = Name;
        email = Email;
        profile = Profile;
        this.context = passedContext;



    }


    @Override
    public MainMenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,
                    false);

            ViewHolder vhItem = new ViewHolder(v,viewType,context);

            return vhItem;

        } else if (viewType == TYPE_HEADER) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header,parent,false);

            ViewHolder vhHeader = new ViewHolder(v,viewType,context);

            return vhHeader;


        }
        return null;

    }


    @Override
    public void onBindViewHolder(MainMenuAdapter.ViewHolder holder, int position) {
        if(holder.Holderid ==1) {
            holder.textView.setText(mNavTitles[position - 1]);
            holder.imageView.setImageResource(mIcons[position -1]);
        }
        else{

            holder.profile.setImageResource(profile);
            holder.Name.setText(name);
            holder.email.setText(email);
        }
    }

    @Override
    public int getItemCount() {

        return mNavTitles.length+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {

        return position == 0;
    }

}