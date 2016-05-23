package com.techmorphosis.qube.utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.techmorphosis.qube.R;
import com.techmorphosis.qube.models.EnquiringBrokersModel;
import com.techmorphosis.qube.models.NotificationModel;
import com.techmorphosis.qube.models.OtherPriorityModel;
import com.techmorphosis.qube.models.PropertyLocation;
import com.techmorphosis.qube.models.PropertyPicksModel;
import com.techmorphosis.qube.models.SelectableDataModel;
import com.techmorphosis.qube.models.YourListingModel;
import com.techmorphosis.qube.models.YourRequirementsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamlesh on 019 19/1/16.
 */
public class ProjectUtils {

	private static final String TAG = "ProjectUtils";
	public static final String PROPERTY_PICKS_PAGE = "PropertyPicksActivity";
	public static final String SHORTLIST_PAGE = "ShortlistFragment";

	public static ArrayList getInterestAreasList() {
		ArrayList<SelectableDataModel> areasOfInterestList = new ArrayList();
		areasOfInterestList.add(new SelectableDataModel(1, "beyond borivali"));
		areasOfInterestList.add(new SelectableDataModel(2, "beyond worli to prabhadevi"));
		areasOfInterestList.add(new SelectableDataModel(3, "central mumbai"));
		areasOfInterestList.add(new SelectableDataModel(4, "eastern suburbs"));
		areasOfInterestList.add(new SelectableDataModel(5, "extended western suburbs"));
		areasOfInterestList.add(new SelectableDataModel(6, "golden triangle (gamdevi to haji ali)"));
		areasOfInterestList.add(new SelectableDataModel(7, "juhu to oshiwara"));
		areasOfInterestList.add(new SelectableDataModel(8, "south mumbai (colaba to babulnath)"));
		areasOfInterestList.add(new SelectableDataModel(9, "western suburbs"));
		return areasOfInterestList;
	}


	public static void registerWithParse(String userId, List<String> channels) {

//		ParseInstallation installation = ParseInstallation.getCurrentInstallation();
//		installation.put("userId", userId);
//		installation.saveInBackground();
//		for (String channel : channels) {
//			ParsePush.subscribeInBackground(channel);
//		}
	}

	public static void reRegisterWithParse(final String userId, final List<String> channels) {
//		final ParseInstallation installation = ParseInstallation.getCurrentInstallation();
//		ParseObject object = (ParseObject) installation.get(userId);
//		// avoiding NPE, if object does not exist.
//		if (object != null) {
//			object.deleteEventually(new DeleteCallback() {
//				@Override
//				public void done(ParseException e) {
//					if (e == null) {
//						installation.put("userId", userId);
//						installation.saveInBackground();
//						for (String channel : channels) {
//							ParsePush.subscribeInBackground(channel);
//						}
//					}
//				}
//			});
//		}
	}

	public static void unregisterFromParse(String userId) {
//		ParseInstallation installation = ParseInstallation.getCurrentInstallation();
//		ParseObject object = (ParseObject) installation.get(userId);
//		if (object != null) {
//			object.deleteInBackground();
//		}
//		installation.saveInBackground();
	}

	public static List<PropertyPicksModel> getPropertyPicks(String jsonArray) {
		List<PropertyPicksModel> list = new ArrayList<>();
		try {
			JSONArray jArr = new JSONArray(jsonArray);
			for (int i = 0; i < jArr.length(); i++) {
				PropertyPicksModel model = new PropertyPicksModel();
				JSONObject jsonObject = jArr.getJSONObject(i);
				model.setPropertyId(jsonObject.getString("property_id"));
				model.setPurchaseTypeId(jsonObject.getString("purchase_type_id"));
				model.setPurchaseType(jsonObject.getString("purchase_type"));
				model.setPropertyUseId(jsonObject.getString("property_use_id"));
				model.setPropertyUse(jsonObject.getString("property_use"));
				model.setPropertyName(jsonObject.getString("property_name"));
				model.setPropertyTypeId(jsonObject.getString("property_type_id"));
				model.setPropertyType(jsonObject.getString("property_type"));
				model.setAmount(jsonObject.getString("amount"));
				model.setCarpetArea(jsonObject.getString("carpet_area"));
				model.setLocationId(jsonObject.getString("location_id"));
				model.setLocation(jsonObject.getString("location"));
				model.setSubLocation(jsonObject.getString("sub_location"));
				String isShortlist = jsonObject.getString("is_shortlist");
				model.setIsShortlist(isShortlist);
				// retrieve shortlistId when isShortlist is '1'.
				if (isShortlist.equals("1")) {
					model.setShortlistId(jsonObject.getString("shortlist_id"));
				}
				model.setPropertyAmenities(parseAmenities(jsonObject.getString("property_amenities")));
				model.setImageUrl(jsonObject.getString("image_url"));
				list.add(model);
			}
		} catch (JSONException e) {
			Log.e(TAG, "getPropertyPicks: ", e);
		}
		return list;
	}

	public static List<PropertyPicksModel> getShortlistItems(String jsonArray) {
		List<PropertyPicksModel> list = new ArrayList<>();
		try {
			JSONArray jArr = new JSONArray(jsonArray);
			for (int i = 0; i < jArr.length(); i++) {
				PropertyPicksModel model = new PropertyPicksModel();
				JSONObject jsonObject = jArr.getJSONObject(i);
				model.setPropertyId(jsonObject.getString("property_id"));
				model.setShortlistId(jsonObject.getString("shortlist_id"));
				model.setCreatedAt(jsonObject.getString("created_at"));
				model.setPurchaseTypeId(jsonObject.getString("purchase_type_id"));
				model.setPurchaseType(jsonObject.getString("purchase_type"));
				model.setPropertyUseId(jsonObject.getString("property_use_id"));
				model.setPropertyUse(jsonObject.getString("property_use"));
				model.setPropertyName(jsonObject.getString("property_name"));
				model.setPropertyTypeId(jsonObject.getString("property_type_id"));
				model.setPropertyType(jsonObject.getString("property_type"));
				model.setAmount(jsonObject.getString("amount"));
				model.setCarpetArea(jsonObject.getString("carpet_area"));
				model.setLocationId(jsonObject.getString("location_id"));
				model.setLocation(jsonObject.getString("location"));
				model.setSubLocation(jsonObject.getString("sub_location"));
				model.setPropertyAmenities(parseAmenities(jsonObject.getString("property_amenities")));
				model.setImageUrl(jsonObject.getString("image_url"));
				model.setIsSold(jsonObject.getString("is_sold"));
				list.add(model);
			}
		} catch (JSONException e) {
			Log.e(TAG, "getShortlistItems: ", e);
		}
		return list;
	}

	public static List<NotificationModel> getNotificationItems(String jsonArray) {
		List<NotificationModel> list = new ArrayList<>();
		try {
			JSONArray jArr = new JSONArray(jsonArray);
			for (int i = 0; i < jArr.length(); i++) {
				NotificationModel model = new NotificationModel();
				JSONObject jsonObject = jArr.getJSONObject(i);
				model.notificationId = jsonObject.getString("notification_id");
				model.createdAt = jsonObject.getString("created_at");
				model.isRead = jsonObject.getString("is_read");
				model.message = jsonObject.getString("message");
				model.notificationType = Integer.parseInt(jsonObject.getString("notification_type"));
				model.propertyId = jsonObject.getString("property_id");
				model.propertyImage = jsonObject.getString("property_image");
				model.receiverId = jsonObject.getString("receiver_id");
				model.senderId = jsonObject.getString("sender_id");
				model.senderPhoto = jsonObject.getString("sender_photo");
				list.add(model);
			}
		} catch (JSONException e) {
			Log.e(TAG, "getNotificationItems: ", e);
		}
		return list;
	}

	// ignoring last result as it is NOT a property item.
	public static List<PropertyPicksModel> getSearchedListings(String jsonArray) {
		List<PropertyPicksModel> list = new ArrayList<>();
		try {
			JSONArray jArr = new JSONArray(jsonArray);
			for (int i = 0; i < jArr.length(); i++) {
				PropertyPicksModel model = new PropertyPicksModel();
				JSONObject jsonObject = jArr.getJSONObject(i);
				model.setPropertyId(jsonObject.getString("property_id"));
				model.setPurchaseTypeId(jsonObject.getString("purchase_type_id"));
				model.setPurchaseType(jsonObject.getString("purchase_type"));
				model.setPropertyUseId(jsonObject.getString("property_use_id"));
				model.setPropertyUse(jsonObject.getString("property_use"));
				model.setPropertyName(jsonObject.getString("property_name"));
				model.setPropertyTypeId(jsonObject.getString("property_type_id"));
				model.setPropertyType(jsonObject.getString("property_type"));
				model.setAmount(jsonObject.getString("amount"));
				String isShortlist = jsonObject.getString("is_shortlist");
				model.setIsShortlist(isShortlist);
				// retrieve shortlistId when isShortlist is '1'.
				if (isShortlist.equals("1")) {
					model.setShortlistId(jsonObject.getString("shortlist_id"));
				}
				model.setCarpetArea(jsonObject.getString("carpet_area"));
				model.setLocationId(jsonObject.getString("location_id"));
				model.setLocation(jsonObject.getString("location"));
				model.setSubLocation(jsonObject.getString("sub_location"));
				model.setPropertyAmenities(parseAmenities(jsonObject.getString("property_amenities")));
				model.setImageUrl(jsonObject.getString("image_url"));
				list.add(model);
			}
		} catch (JSONException e) {
			Log.e(TAG, "getShortlistItems: ", e);
		}
		return list;
	}

	private static String parseAmenities(String jsonArray) {
		String line = "";
		try {
			JSONArray jsonArr = new JSONArray(jsonArray);
			for (int i = 0; i < jsonArr.length(); i++) {
				line += jsonArr.getJSONObject(i).getString("amenities") + ", ";
			}
			if (line.length() > 2) line = line.substring(0, line.length() - 2);
		} catch (JSONException e) {
			Log.e(TAG, "parseAmenities: ", e);
		}
		return line;
	}

	public static List<String> convertJsonArrayToList(String jsonArrayString) {
		List<String> list = new ArrayList<>();
		try {
			JSONArray jsonArray = new JSONArray(jsonArrayString);
			for (int i = 0; i < jsonArray.length(); i++) {
				list.add(jsonArray.getString(i));
			}
		} catch (JSONException e) {
			Log.e(TAG, "convertJsonArrayToList: ", e);
		}
		return list;
	}

	/*Retrieve a String list from json array embedded with single member, same key json objects */
	public static List<String> convertJsonObjectsArrayToList(String jsonArrayString, String key) {
		List<String> list = new ArrayList<>();
		try {
			JSONArray jsonArray = new JSONArray(jsonArrayString);
			for (int i = 0; i < jsonArray.length(); i++) {
				String value = jsonArray.getJSONObject(i).getString(key);
				list.add(value);
			}
		} catch (JSONException e) {
			Log.e(TAG, "convertJsonArrayToList: ", e);
		}
		return list;
	}

	public static String getStringFromList(List<String> list) {
		String line = "";
		if (list.isEmpty()) {
			return line;
		} else {
			for (String item :
					list) {
				line += item + ", ";
			}
			if (line.length() > 2) line = line.substring(0, line.length() - 2);
		}
		return line;
	}

	public static String getStringFromLocationsList(List<PropertyLocation> list) {
		String line = "";
		if (list.isEmpty()) {
			return line;
		} else {
			for (PropertyLocation item :
					list) {
				line += item.getName() + ", ";
			}
			if (line.length() > 2) line = line.substring(0, line.length() - 2);
		}
		return line;
	}

	public static List<String> getListFromString(String listString) {
		List<String> list = new ArrayList<>();
		String[] names = listString.split(", ");
		for (String name :
				names) {
			list.add(name);
		}
		return list;
	}

	public static void pageOpenedFirstTime(final ViewGroup rootLayout, Context context, String whichPage) {
		int value = SharedPrefUtils.getInt(context, whichPage);
		if (value == -1) {
			switch (whichPage) {
				case PROPERTY_PICKS_PAGE:
					showCoachmark(rootLayout, context, R.drawable.coachmark_swipe);
					break;
				case SHORTLIST_PAGE:
					showCoachmark(rootLayout, context, R.drawable.coachmark_swipe_to_remove);
					break;
			}
			SharedPrefUtils.put(context, whichPage, ++value);
		}
	}

	private static void showCoachmark(final ViewGroup rootLayout, Context context, int coachmark) {
		ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		final ImageView coachMark = new ImageView(context);
		coachMark.setImageResource(coachmark);
		coachMark.setAdjustViewBounds(true);
		coachMark.setScaleType(ImageView.ScaleType.FIT_XY);
		coachMark.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				rootLayout.removeView(coachMark);
			}
		});
		coachMark.setLayoutParams(layoutParams);
		rootLayout.addView(coachMark);
	}

	public static List<YourListingModel> getYourListings(String response) {
		List<YourListingModel> list = new ArrayList<>();
		try {
			JSONArray jArr = new JSONArray(response);
			for (int i = 0; i < jArr.length(); i++) {
				YourListingModel model = new YourListingModel();
				JSONObject jsonObject = jArr.getJSONObject(i);
				model.propertyId = (jsonObject.getString("property_id"));
				model.propertyName = (jsonObject.getString("property_name"));
				model.purchaseType = (jsonObject.getString("purchase_type"));
				model.purchaseTypeId = (jsonObject.getString("purchase_type_id"));
				model.createdAt = (jsonObject.getString("created_at"));
				model.isSold = (jsonObject.getString("is_sold"));
				model.propertyType = (jsonObject.getString("property_type"));
				model.amount = (jsonObject.getString("amount"));
				model.soldOn = (jsonObject.getString("sold_on"));
				model.isStarred = (jsonObject.getString("is_starred"));
				model.enquiryCount = (jsonObject.getString("enq_count"));
				model.isNewEnquiry = (jsonObject.getString("is_new_enquiry"));
				list.add(model);
			}
		} catch (JSONException e) {
			Log.e(TAG, "getYourListings: ", e);
		}
		return list;
	}

	public static List<YourRequirementsModel> getYourRequirements(String response) {
		List<YourRequirementsModel> list = new ArrayList<>();
		try {
			JSONArray jArr = new JSONArray(response);
			for (int i = 0; i < jArr.length(); i++) {
				YourRequirementsModel model = new YourRequirementsModel();
				JSONObject jsonObject = jArr.getJSONObject(i);
				model.requirementId = (jsonObject.getString("requirement_id"));
				model.propertyName = (jsonObject.getString("pname"));
				model.purchaseType = (jsonObject.getString("purchase_type"));
				model.purchaseTypeId = (jsonObject.getString("purchase_type_id"));
				model.propertyUse = (jsonObject.getString("property_use"));
				model.propertyUseId = (jsonObject.getString("property_use_id"));
				model.createdAt = (jsonObject.getString("created_at"));
				model.minPrice = (jsonObject.getString("min_price"));
				model.maxPrice = (jsonObject.getString("max_price"));
				model.isPrice = (jsonObject.getString("is_price"));
				model.isLocation = (jsonObject.getString("is_location"));
				model.propertyType = (jsonObject.getString("property_type"));
				model.propertyTypeId = (jsonObject.getString("property_type_id"));
				model.isStarred = (jsonObject.getString("is_starred"));
				model.matchCount = (jsonObject.getString("match_count"));
				model.isNewMatch = (jsonObject.getString("is_new_match"));
				model.propertyLocations = extractLocations(jsonObject.getString("location_details"));
				model.otherPriorities = extractPriorities(jsonObject.getString("other_priorities"));
				list.add(model);
			}
		} catch (JSONException e) {
			Log.e(TAG, "getYourRequirements: ", e);
		}
		return list;
	}

	public static List<EnquiringBrokersModel> getEnquiringBrokers(String response) {
		List<EnquiringBrokersModel> list = new ArrayList<>();
		try {
			JSONArray jArr = new JSONArray(response);
			for (int i = 0; i < jArr.length(); i++) {
				EnquiringBrokersModel model = new EnquiringBrokersModel();
				JSONObject jsonObject = jArr.getJSONObject(i);
				model.enquiryId = (jsonObject.getString("enq_id"));
				model.firstName = (jsonObject.getString("first_name"));
				model.lastName = (jsonObject.getString("last_name"));
				model.email = (jsonObject.getString("email"));
				model.mobileNo = (jsonObject.getString("mobile_no"));
				model.imageUrl = (jsonObject.getString("profile_photo"));
				model.isResidential = (jsonObject.getString("is_residential"));
				model.isCommercial = (jsonObject.getString("is_commercial"));
				model.areasOfInterest = parseAreasOfInterest((jsonObject.getString("area_of_interest")));
				list.add(model);
			}
		} catch (JSONException e) {
			Log.e(TAG, "getEnquiringBrokers: ", e);
		}
		return list;
	}

	public static List<SelectableDataModel> parseAreasOfInterest(String areaOfInterestJson) {
		List<SelectableDataModel> list = new ArrayList<>();
		try {
			JSONArray jsonArray = new JSONArray(areaOfInterestJson);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				SelectableDataModel model = new SelectableDataModel();
				model.setId(Integer.parseInt(jsonObject.getString("id")));
				model.setName(jsonObject.getString("area"));
				list.add(model);
			}
		} catch (JSONException e) {
			Log.e(TAG, "parseAreasOfInterest: ", e);
		}
		return list;
	}

	public static List<SelectableDataModel> parseSelectableDataItems(String sJsonArray, String key) {
		List<SelectableDataModel> list = new ArrayList<>();
		try {
			JSONArray jsonArray = new JSONArray(sJsonArray);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				SelectableDataModel model = new SelectableDataModel();
				model.setId(Integer.parseInt(jsonObject.getString("id")));
				model.setName(jsonObject.getString(key));
				list.add(model);
			}
		} catch (JSONException e) {
			Log.e(TAG, "parseSelectableDataItems: ", e);
		}
		return list;
	}

	public String removeChar(String oldString, char chr) {
		String newString = "";
		char[] charArray = oldString.toCharArray();
		for (char thisChar :
				charArray) {
			if (thisChar != chr) newString += thisChar;
		}
		return newString;
	}

	public static boolean isMinGreaterThanMax(EditText etMin, EditText etMax) {
		String min = etMin.getText().toString();
		String max = etMax.getText().toString();
		int minArea = Integer.parseInt(min);
		int maxArea = Integer.parseInt(max);
		if (minArea != 0 || maxArea != 0) {
			if (minArea > maxArea) {
				return true;
			}
		}
		return false;
	}


	public static List jsonArrayToList(String sJsonArray, String[] jsonKeys, String className) {
		List list = new ArrayList<>();
		try {
			JSONArray jsonArray = new JSONArray(sJsonArray);
			Class currentClass = Class.forName(className);
			Constructor constructor = currentClass.getConstructor();
			Field[] fields = currentClass.getFields();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				Object myObject = constructor.newInstance();
				for (int k = 0; k < jsonKeys.length; k++) {
					fields[i].set(myObject, jsonObject.getString(jsonKeys[i]));
				}
				list.add(myObject);
			}
		} catch (JSONException e) {
			Log.e(TAG, "jsonArrayToList: ", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static String getStringFromPriorityList(List<OtherPriorityModel> otherPriorities) {
		String line = "";
		if (otherPriorities.isEmpty()) {
			return line;
		} else {
			for (OtherPriorityModel item :
					otherPriorities) {
				line += item.priority + ", ";
			}
			if (line.length() > 2) line = line.substring(0, line.length() - 2);
		}
		return line;
	}

	public static List<OtherPriorityModel> extractPriorities(String sJsonLocArray) {
		List<OtherPriorityModel> list = new ArrayList<>();
		try {
			JSONArray jsonArray = new JSONArray(sJsonLocArray);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				OtherPriorityModel thisPriority = new OtherPriorityModel();
				thisPriority.id = jsonObject.getString("id");
				thisPriority.priority = jsonObject.getString("priority");
				list.add(thisPriority);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<PropertyLocation> extractLocations(String sJsonLocArray) {
		List<PropertyLocation> list = new ArrayList<>();
		try {
			JSONArray jsonArray = new JSONArray(sJsonLocArray);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				PropertyLocation location = new PropertyLocation(Integer.parseInt(jsonObject.getString("loc_id")), jsonObject.getString("location"));
				list.add(location);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return list;
	}

}
