package com.techmorphosis.qube.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.techmorphosis.qube.utils.interfaces.DialogButtonsListener;
import com.techmorphosis.qube.utils.interfaces.OnAlertDialogListener;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Kamlesh on 8/22/2015.
 */
public class GeneralUtils {
    static Location mLocation;

    public static void print(String log) {
        Log.d("MyLogs", log);
    }

    public static void toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static ProgressDialog makeProgressDialog(Context context, String message, Boolean isCancelable) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage(message);
        dialog.setCancelable(isCancelable);
        return dialog;
    }


    public static AlertDialog showDialog(Activity currentActivity, String message, boolean isCancelable, String positiveBtnTxt) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(currentActivity);
        builder.setMessage(message);
        builder.setCancelable(isCancelable);
        builder.setPositiveButton(positiveBtnTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.show();
        // set message text in center
        TextView messageView = (TextView) dialog.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER);
        return dialog;
    }

    // overloaded to contain title
    public static AlertDialog showDialog(Activity currentActivity, String title, String message, boolean isCancelable, String positiveBtnTxt) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(currentActivity);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(isCancelable);
        builder.setPositiveButton(positiveBtnTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.show();
        // set message text in center
        TextView messageView = (TextView) dialog.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER);
        // set Title text in center
        TextView titleView = (TextView) dialog.findViewById(currentActivity.getResources().getIdentifier("alertTitle", "id", "android"));
        if (titleView != null) {
            titleView.setGravity(Gravity.CENTER);
        }
        return dialog;
    }

    // overloaded to contain dialog listener
    public static AlertDialog showDialog(Activity currentActivity, String title, String message, boolean isCancelable, String positiveBtnTxt, final OnAlertDialogListener mAlertDialogListener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(currentActivity);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(isCancelable);
        builder.setPositiveButton(positiveBtnTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mAlertDialogListener.onPositiveButtonPress();
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.show();
        // set message text in center
        TextView messageView = (TextView) dialog.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER);
        // set Title text in center
        TextView titleView = (TextView) dialog.findViewById(currentActivity.getResources().getIdentifier("alertTitle", "id", "android"));
        if (titleView != null) {
            titleView.setGravity(Gravity.CENTER);
        }
        return dialog;
    }

    // superloaded to contain but positive and negative button listener
    public static AlertDialog showDialog(Activity currentActivity, String title, String message, boolean isCancelable, String positiveBtnTxt, String negativeBtnTxt, final DialogButtonsListener mDialogButtonsListener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(currentActivity);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(isCancelable);
        builder.setPositiveButton(positiveBtnTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mDialogButtonsListener.onPositiveButtonPress();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(negativeBtnTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mDialogButtonsListener.onNegativeButtonPress();
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.show();
        // set message text in center
        TextView messageView = (TextView) dialog.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER);
        // set Title text in center
        TextView titleView = (TextView) dialog.findViewById(currentActivity.getResources().getIdentifier("alertTitle", "id", "android"));
        if (titleView != null) {
            titleView.setGravity(Gravity.CENTER);
        }
        return dialog;
    }

    // superloaded to contain both positive and negative buttons
    public static AlertDialog showDialog(Activity currentActivity, String title, String message, boolean isCancelable, String positiveBtnTxt, String negativeBtnTxt, final OnAlertDialogListener mAlertDialogListener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(currentActivity);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(isCancelable);
        builder.setPositiveButton(positiveBtnTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mAlertDialogListener.onPositiveButtonPress();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(negativeBtnTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.show();
        // set message text in center
        TextView messageView = (TextView) dialog.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER);
        // set Title text in center
        TextView titleView = (TextView) dialog.findViewById(currentActivity.getResources().getIdentifier("alertTitle", "id", "android"));
        if (titleView != null) {
            titleView.setGravity(Gravity.CENTER);
        }
        return dialog;
    }


    public static String getFromSharedPref(Context appContext, String sharedPrefName, String sharedPrefKey) {
        SharedPreferences preferences = appContext.getSharedPreferences(sharedPrefName, 0);
        String sharedPrefValue = preferences.getString(sharedPrefKey, null);
        return sharedPrefValue;
    }

    public static void putInSharedPref(Context appContext, String sharedPrefName, String sharedPrefKey, String sharedPrefValue) {
        SharedPreferences preferences = appContext.getSharedPreferences(sharedPrefName, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(sharedPrefKey, sharedPrefValue);
        editor.commit();
    }

    public static void clearSharedPrefData(Context appContext, String sharedPrefName) {
        SharedPreferences preferences = appContext.getSharedPreferences(sharedPrefName, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }


    public static boolean isLocationON(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            return true;
        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            return true;
        } else {
            return false;
        }
    }


    public static void deletePicture(String picName) {
        File root = new File(Environment.getExternalStorageDirectory() + File.separator + "Commect" + File.separator);
        File fPic = new File(root, picName);
        if (fPic.exists()) {
            fPic.delete();
        }
    }


    public static void startActivityWithoutBackstack(Activity thisActivity, Class<?> nextActivity) {
        Intent intent = new Intent(thisActivity, nextActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        thisActivity.startActivity(intent);
    }

    public static int convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int px = (int) (dp * (metrics.densityDpi / 160f));
        return px;
    }


    public static String formatTime(long timeToFormat) {
        String sFormattedTime = "";
        try {
            Calendar serverCal = Calendar.getInstance();
            serverCal.setTime(new Date(timeToFormat));
            int month = serverCal.get(Calendar.MONTH);
            String sMonth = "";
            switch (month) {
                case 0:
                    sMonth = "Jan";
                    break;
                case 1:
                    sMonth = "Feb";
                    break;
                case 2:
                    sMonth = "Mar";
                    break;
                case 3:
                    sMonth = "Apr";
                    break;
                case 4:
                    sMonth = "May";
                    break;
                case 5:
                    sMonth = "Jun";
                    break;
                case 6:
                    sMonth = "Jul";
                    break;
                case 7:
                    sMonth = "Aug";
                    break;
                case 8:
                    sMonth = "Sep";
                    break;
                case 9:
                    sMonth = "Oct";
                    break;
                case 10:
                    sMonth = "Nov";
                    break;
                case 11:
                    sMonth = "Dec";
                    break;
            }
            int year = serverCal.get(Calendar.YEAR);
            int day = serverCal.get(Calendar.DAY_OF_MONTH);
            int hour = serverCal.get(Calendar.HOUR_OF_DAY);
            int mins = serverCal.get(Calendar.MINUTE);
            Date date = new Date();
            Calendar todayCal = Calendar.getInstance();
            todayCal.setTime(date);
            int thisYear = todayCal.get(Calendar.YEAR);
            int thisMonth = todayCal.get(Calendar.MONTH);
            int thisDay = todayCal.get(Calendar.DAY_OF_MONTH);
            int thisHour = todayCal.get(Calendar.HOUR_OF_DAY);
            int thisMins = todayCal.get(Calendar.MINUTE);
            // same year?
            if (year == thisYear) {
                // same month?
                if (month == thisMonth) {
                    // same day?
                    if (thisDay == day) {
                        sFormattedTime += "Today | ";
                        // is it less than an hour ago?
                        if (thisHour == hour) {
                            // show minutes
                            sFormattedTime += mins + " minutes ago";
                        } else if (thisHour == hour + 1) {
                            // check if mins are less or equals to 60.
                            int prevHourMins = 60 - mins;
                            int thisHourMins = thisMins;
                            int minsDiff = prevHourMins + thisHourMins;
                            if (minsDiff >= 60) {
                                //  show time as 9.45 pm
                                String sTime = timeIn12Hformat(hour, mins);
                                sFormattedTime += sTime;
                            } else {
                                //  show minutes
                                sFormattedTime += minsDiff + " minutes ago";
                            }
                        } else {
                            //  show time as 9.45 pm
                            String sTime = timeIn12Hformat(hour, mins);
                            sFormattedTime += sTime;
                        }
                    } else if (thisDay == day + 1) {
                        sFormattedTime = "Yesterday | ";
                        String sTime = timeIn12Hformat(hour, mins);
                        sFormattedTime += sTime;
                    } else {
                        sFormattedTime = day + " " + sMonth + " | ";
                        String sTime = timeIn12Hformat(hour, mins);
                        sFormattedTime += sTime;
                    }
                } else {
                    sFormattedTime = day + " " + sMonth + " | ";
                    String sTime = timeIn12Hformat(hour, mins);
                    sFormattedTime += sTime;
                }
            }

        } catch (Exception e) {
            GeneralUtils.print("GeneralUtils ParseException " + e);
        }
        return sFormattedTime;
    }

    public static String formatTime(String timeToFormat) {
        String sFormattedTime = "";
        try {
            Date time = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").parse(timeToFormat);
            Calendar serverCal = Calendar.getInstance();
            serverCal.setTime(time);
            int month = serverCal.get(Calendar.MONTH);
            String sMonth = "";
            switch (month) {
                case 0:
                    sMonth = "Jan";
                    break;
                case 1:
                    sMonth = "Feb";
                    break;
                case 2:
                    sMonth = "Mar";
                    break;
                case 3:
                    sMonth = "Apr";
                    break;
                case 4:
                    sMonth = "May";
                    break;
                case 5:
                    sMonth = "Jun";
                    break;
                case 6:
                    sMonth = "Jul";
                    break;
                case 7:
                    sMonth = "Aug";
                    break;
                case 8:
                    sMonth = "Sep";
                    break;
                case 9:
                    sMonth = "Oct";
                    break;
                case 10:
                    sMonth = "Nov";
                    break;
                case 11:
                    sMonth = "Dec";
                    break;
            }
            int year = serverCal.get(Calendar.YEAR);
            int day = serverCal.get(Calendar.DAY_OF_MONTH);
            int hour = serverCal.get(Calendar.HOUR_OF_DAY);
            int mins = serverCal.get(Calendar.MINUTE);
            Date date = new Date();
            Calendar todayCal = Calendar.getInstance();
            todayCal.setTime(date);
            int thisYear = todayCal.get(Calendar.YEAR);
            int thisMonth = todayCal.get(Calendar.MONTH);
            int thisDay = todayCal.get(Calendar.DAY_OF_MONTH);
            int thisHour = todayCal.get(Calendar.HOUR_OF_DAY);
            int thisMins = todayCal.get(Calendar.MINUTE);
            // same year?
            if (year == thisYear) {
                // same month?
                if (month == thisMonth) {
                    // same day?
                    if (thisDay == day) {
                        sFormattedTime += "Today | ";
                        // is it less than an hour ago?
                        if (thisHour == hour) {
                            //  show minutes
                            sFormattedTime += mins + " minutes ago";
                        } else if (thisHour == hour + 1) {
                            //  check if mins are less or equals to 60.
                            int prevHourMins = 60 - mins;
                            int thisHourMins = thisMins;
                            int minsDiff = prevHourMins + thisHourMins;
                            if (minsDiff >= 60) {
                                //  show time as 9.45 pm
                                String sTime = timeIn12Hformat(hour, mins);
                                sFormattedTime += sTime;
                            } else {
                                //  show minutes
                                sFormattedTime += minsDiff + " minutes ago";
                            }
                        } else {
                            //  show time as 9.45 pm
                            String sTime = timeIn12Hformat(hour, mins);
                            sFormattedTime += sTime;
                        }
                    } else if (thisDay == day + 1) {
                        sFormattedTime = "Yesterday | ";
                        String sTime = timeIn12Hformat(hour, mins);
                        sFormattedTime += sTime;
                    } else {
                        sFormattedTime = day + " " + sMonth + " | ";
                        String sTime = timeIn12Hformat(hour, mins);
                        sFormattedTime += sTime;
                    }
                } else {
                    sFormattedTime = day + " " + sMonth + " | ";
                    String sTime = timeIn12Hformat(hour, mins);
                    sFormattedTime += sTime;
                }
            }

        } catch (ParseException e) {
            GeneralUtils.print("GeneralUtils ParseException " + e);
        }
        return sFormattedTime;
    }

    public static String timeIn12Hformat(int hour, int mins) {
        String sTime = "";
        // show PM
        if (hour > 11) {
            hour = hour - 12;
            if (mins < 10) {
                sTime = hour + "." + "0" + mins + " PM";
            } else {
                sTime = hour + "." + mins + " PM";
            }
        } else {
            // show AM
            if (hour == 0) {
                if (mins < 10) {
                    sTime = "12" + "." + "0" + mins + " AM";
                } else {
                    sTime = "12" + "." + mins + " AM";
                }
            } else {
                if (mins < 10) {
                    sTime = hour + "." + "0" + mins + " AM";
                } else {
                    sTime = hour + "." + mins + " AM";
                }
            }
        }
        return sTime;
    }

    public static HashMap<Character, Integer> buildIndexCharsHashMap(List<String> contactsList) {
        HashMap<Character, Integer> hm = new HashMap<>();
        List<Character> indexCharList = new ArrayList<>();
        for (int i = 0; i < contactsList.size(); i++) {
            String contactName = contactsList.get(i);
            char fChar = Character.toLowerCase(contactName.charAt(0));
            if (indexCharList.isEmpty()) {
                indexCharList.add(fChar);
                hm.put(fChar, i);
            } else {
                if (!isExistingIndexChar(fChar, indexCharList)) {
                    indexCharList.add(fChar);
                    hm.put(fChar, i);
                }
            }
        }
        return hm;
    }

    public static boolean isExistingIndexChar(char fChar, List<Character> indexCharList) {
        boolean exists = false;
        for (Character ch : indexCharList) {
            if (fChar == ch) {
                exists = true;
            }
        }
        return exists;
    }


    public static String getBestProvider(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            return LocationManager.NETWORK_PROVIDER;
        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            return LocationManager.GPS_PROVIDER;
        } else {
            return null;
        }
    }
}
