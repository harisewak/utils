package com.techmorphosis.qube.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.techmorphosis.qube.R;
import com.techmorphosis.qube.models.SelectableDataModel;
import com.techmorphosis.qube.ui.activities.HomeActivity;
import com.techmorphosis.qube.utils.interfaces.DialogButtonsListener;

import java.util.List;


/**
 * Created by Kamlesh on 024 24/11/15.
 */
public class UIUtils {
	public static final int MENU_BUTTON = 101;
	public static final int BACK_BUTTON = 99;

	public static void replaceView(ViewGroup containerView, View newView, View oldView) {
		containerView.addView(newView);
		containerView.removeView(oldView);
	}

	public static AlertDialog buildAlertDialog(Context context, String title, String message, String posBtnText, boolean isCancelable) {
		AlertDialog dialog = new AlertDialog.Builder(context).create();
		dialog.setMessage(message);
		dialog.setTitle(title);
		dialog.setCancelable(isCancelable);
		dialog.setButton(DialogInterface.BUTTON_POSITIVE, posBtnText, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		return dialog;
	}

	public static AlertDialog buildAlertDialog(Context context, String title, String message, String posBtnText, String negativeBtnText, boolean isCancelable, final DialogButtonsListener buttonsListener) {
		AlertDialog dialog = new AlertDialog.Builder(context).create();
		dialog.setMessage(message);
		dialog.setTitle(title);
		dialog.setCancelable(isCancelable);
		dialog.setButton(DialogInterface.BUTTON_POSITIVE, posBtnText, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				buttonsListener.onPositiveButtonPress();
			}
		});
		dialog.setButton(DialogInterface.BUTTON_NEGATIVE, negativeBtnText, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				buttonsListener.onNegativeButtonPress();
				dialog.dismiss();
			}
		});
		return dialog;
	}

	public static AlertDialog buildAlertDialog(Context context, String title, String message, String posBtnText, boolean isCancelable, final DialogButtonsListener buttonsListener) {
		AlertDialog dialog = new AlertDialog.Builder(context).create();
		dialog.setMessage(message);
		dialog.setTitle(title);
		dialog.setCancelable(isCancelable);
		dialog.setButton(DialogInterface.BUTTON_POSITIVE, posBtnText, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				buttonsListener.onPositiveButtonPress();
			}
		});
		return dialog;
	}

	public static boolean hideKeyboard(Activity activity) {
		try {
			return ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(activity
					.getCurrentFocus()
					.getWindowToken(), 0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void setupToolbar(Toolbar toolbar, String title) {
		((TextView) toolbar.findViewById(R.id.tv_toolbar_title)).setText(title);
	}

	public static void setupToolbar(final Activity parentActivity, Toolbar toolbar, String title, int flag) {
		((TextView) toolbar.findViewById(R.id.tv_toolbar_title)).setText(title);
		switch (flag) {
			case MENU_BUTTON:
				toolbar.findViewById(R.id.iv_menu).setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						HomeActivity activity = (HomeActivity) parentActivity;
						activity.onMenuIconClicked();
					}
				});
				break;
			case BACK_BUTTON:
				toolbar.findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						parentActivity.onBackPressed();
					}
				});
				break;
		}
	}

	public static void delayAction(Runnable runnable, int delayInMillis) {
		new Handler().postDelayed(runnable, delayInMillis);
	}

	//    public static void setupToolbar(View toolbar, String title) {
//        TextView tv = (TextView) toolbar.findViewById(R.id.tv_title);
//        tv.setText(title);
//    }
//
//    // set title and clickListener based on the type of button used in this toolbar.
//    public static void setupToolbar(View toolbar, String title, BUTTON_TYPE curButton, View.OnClickListener clickListener) {
//        TextView tv = (TextView) toolbar.findViewById(R.id.tv_title);
//        tv.setText(title);
//
//        switch (curButton) {
//            case MENU:
//                toolbar.findViewById(R.id.iv_menu_icon).setOnClickListener(clickListener);
//                break;
//            case BACK:
//                toolbar.findViewById(R.id.iv_back).setOnClickListener(clickListener);
//                break;
//        }
//    }
	public static View getNoInternetView(Context context) {
		ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		View noInternetView = LayoutInflater.from(context).inflate(R.layout.l_no_internet, null);
		noInternetView.setLayoutParams(layoutParams);
		return noInternetView;
	}

	public static View getErrorView(Context context) {
		ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		View noErrorView = LayoutInflater.from(context).inflate(R.layout.l_error, null);
		noErrorView.setLayoutParams(layoutParams);
		return noErrorView;
	}

	public static View getNoShortlistsView(Context context) {
		ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		View noShortlistsView = LayoutInflater.from(context)
		                                      .inflate(R.layout.l_no_shortlists, null);
		noShortlistsView.setLayoutParams(layoutParams);
		return noShortlistsView;
	}

	public static View getNoNotifsView(Context context) {
		ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		View noNotifsView = LayoutInflater.from(context)
		                                      .inflate(R.layout.l_no_notifs, null);
		noNotifsView.setLayoutParams(layoutParams);
		return noNotifsView;
	}

	public static View getNoResultsView(Context context) {
		ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		View noErrorView = LayoutInflater.from(context).inflate(R.layout.l_no_results, null);
		noErrorView.setLayoutParams(layoutParams);
		return noErrorView;
	}

	public static View getNoMatchesView(Context context) {
		ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		View noErrorView = LayoutInflater.from(context).inflate(R.layout.l_no_matches, null);
		noErrorView.setLayoutParams(layoutParams);
		return noErrorView;
	}

	// no results view with custom message text.
	public static View getNoResultsView(Context context, String message) {
		ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		View noResultsView = LayoutInflater.from(context).inflate(R.layout.l_plain_no_result, null);
		((TextView) noResultsView.findViewById(R.id.tv_no_result)).setText(message);
		noResultsView.setLayoutParams(layoutParams);
		return noResultsView;
	}

	public static void setDialogSize(Context context, DialogFragment frag) {
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		Dialog fragDialog = frag.getDialog();
		fragDialog.getWindow().setLayout((6 * width) / 7, (height) / 3);
	}

	public static String getAreasOfInterestAsString(List<SelectableDataModel> areasOfInterestList) {
		String line = "";
		for (int i = 0; i < areasOfInterestList.size(); i++) {
			line += areasOfInterestList.get(i).getName() + ", ";
		}
		if (line.length() > 2) line = line.substring(0, line.length() - 2);
		return line;
	}

	public static int numberOfBlankFields(TextView... fields) {
		int isZero = 0;
		for (TextView field : fields) {
			if (TextValidationUtils.isEmpty(field)) {
				isZero++;
			}
		}
		return isZero;
	}

	// using RelativeLayout.LayoutParams instead of generic ViewGroup.LP because of casting issues.
	public static void setHeight(Context context, View itemView, int heightInDp) {
		RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemView
				.getLayoutParams();
		layoutParams.height = GeneralUtils.convertDpToPixel(heightInDp, context.getApplicationContext());
		itemView.setLayoutParams(layoutParams);
	}
}

