package ch.zli.m335.mygrades;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import androidx.room.Room;

import java.text.DecimalFormat;

import ch.zli.m335.mygrades.model.AppDatabase;
import ch.zli.m335.mygrades.model.GradeDao;

/**
 * Implementation of App Widget functionality.
 */
public class MyGradesWidget extends AppWidgetProvider {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    static public float testGrade;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        AppDatabase db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "mygrades").allowMainThreadQueries().build();
        GradeDao gradeDao = db.gradeDao();

        Float mathAverage = gradeDao.getMathAverage();

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_grades_widget);
        if (mathAverage == null) {
            views.setTextViewText(R.id.appwidget_text, widgetText);
        } else {
            views.setTextViewText(R.id.appwidget_text, "Mathematik\n" + String.format("%.2f", mathAverage));
        }

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        AppDatabase db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "mygrades").allowMainThreadQueries().build();
        GradeDao gradeDao = db.gradeDao();

        Float mathAverage = gradeDao.getMathAverage();

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_grades_widget);
        views.setTextViewText(R.id.appwidget_text, "Mathematik\n" + String.format("%.2f", mathAverage));
        AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, MyGradesWidget.class), views);
    }
}