package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> Earthquake) {
        super(context, 0, Earthquake);
    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID magnitude
        TextView magnitudeTextview = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the magnitude from the current Earthquake object and
        // set this text on the name TextView
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(currentEarthquake.getMagnitude());
        magnitudeTextview.setText(output);

        // Find the TextView in the list_item.xml layout with the ID location
        TextView locationTextView1 = (TextView) listItemView.findViewById(R.id.location_offset);
        TextView locationTextView2 = (TextView) listItemView.findViewById(R.id.primary_location);
        // Get the version number from the current Earthquake object and
        // set this text on the number TextView
        if(currentEarthquake.getLocation().contains("km")){
            String str = currentEarthquake.getLocation();
            String [] straftersplit = new String[2];
            straftersplit = str.split("f" , Integer.parseInt("2"));
            locationTextView1.setText(straftersplit[0]+"f");
            locationTextView2.setText(straftersplit[1]);
        }
        else{
            locationTextView1.setText(R.string.near_the);
            locationTextView2.setText(currentEarthquake.getLocation());
        }

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        SimpleDateFormat formatDate = new SimpleDateFormat("LLL dd, yyyy");
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate.format(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        SimpleDateFormat formatTime = new SimpleDateFormat("h:mm a");
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime.format(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextview.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        int magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}

