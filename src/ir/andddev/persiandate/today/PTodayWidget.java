package ir.andddev.persiandate.today;

//http://android-developers.blogspot.com/2009/04/introducing-home-screen-widgets-and.html
	
import ir.javasource.calendartool.CalendarTool;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.format.Time;
import android.widget.RemoteViews;
import android.graphics.Typeface;
import android.widget.TextView;


import ir.javasource.calendartool.*;

public class PTodayWidget  extends AppWidgetProvider {

	 private String[] week_names = { "Monday", "Tuesday",
             "Wednesday", "Thursday", "Friday","Saterday" , "Sunday"};


	@Override
	   public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
	      RemoteViews updateView = buildUpdate(context);
	      appWidgetManager.updateAppWidget(appWidgetIds, updateView);
	      super.onUpdate(context, appWidgetManager, appWidgetIds);
	     
	   }

	   private RemoteViews buildUpdate(Context context) {
		   RemoteViews updateView = null;
		   CalendarTool pcal= new CalendarTool();
		   Time time = new Time();
		   time.setToNow();
		   
		   
		   
		   updateView = new RemoteViews(context.getPackageName(), R.layout.widget);
		   
		   //TextView tv = new TextView(context) ;
		   //tv=(TextView) tv.findViewById(R.id.DayOfWeek); 
		   //Typeface face=Typeface.createFromAsset(context.getAssets(), "FreeFarsi.ttf");
		   //tv.setTypeface(face,1);
		   
 		   	updateView.setTextViewText(R.id.DayOfWeek, week_names[pcal.getDayOfWeek()] );
 		   	updateView.setTextViewText(R.id.Day, new Integer(pcal.getIranianDay()).toString() );
 		    updateView.setTextViewText(R.id.Month, new Integer(pcal.getIranianMonth()).toString() );
 		    updateView.setTextViewText(R.id.Year, new Integer(pcal.getIranianYear()).toString() );
		   
		      //new Integer( time.second).toString()
		   return updateView;		      
	   }	
}

