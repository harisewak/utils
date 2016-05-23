package com.techmorphosis.qube.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kamlesh on 028 28/11/15.
 */
public class Constants {
	// other variables
	public static final String HAS_RATED = "rateUsFlag";
	public static final String APP_START_COUNTER = "rateUsCounter";
	public static final String USER_DATA = "userData";
	public static final String PACKAGE_NAME = "com.techmorphosis.qube";
//	public static final String BASE_URL = "http://techmorphosis-development.com/qube/mobile1.0/web/";
	public static final String BASE_URL = "http://www.qubesearch.com/mobile1.0/web/";
	public static final int WAITING_FOR_SNACKBAR_TO_DISMISS = 500;
	// used to check whether header for other amenities has been added in Submit Property step 3.
	public static boolean isHeaderForOtherAmenitiesAdded;
	public static int defaultAmenitiesCount;

	// Server side constants
	public static final int PURCHASE_TYPE_ID_SELL = 0, PURCHASE_TYPE_ID_LEASE = 1, PURCHASE_TYPE_ID_BUY = 2,
			PROPERTY_USE_ID_HOME = 0, PROPERTY_USE_ID_OFFICE = 1, PROPERTY_USE_ID_SHOP = 2, PROPERTY_TYPE_ID_1_BHK = 1, PROPERTY_TYPE_ID_2_BHK = 2,
			PROPERTY_TYPE_ID_3_BHK = 3, PROPERTY_TYPE_ID_3_PLUS_BHK = 4, PROPERTY_TYPE_ID_TYPE_A = 5, PROPERTY_TYPE_ID_TYPE_B = 6, PROPERTY_TYPE_ID_TYPE_C = 7,
			PROPERTY_TYPE_ID_SHOWROOM = 8, PROPERTY_TYPE_ID_MALL = 10, PROPERTY_TYPE_ID_RESTAURANT = 9, PROPERTY_TYPE_ID_OTHER = 11;

	// URLs
	public static final String SIGNUP_URL = BASE_URL + "signUp.php";
	public static final String LOGIN_URL = BASE_URL + "login.php";
	public static final String FORGOT_PWD_URL = BASE_URL + "forgotPassword.php";
	public static final String CHANGE_PWD_URL = BASE_URL + "changePassword.php";
	public static final String SUBMIT_EDIT_REQUIREMENT_URL = BASE_URL + "submitRequirements.php";
	public static final String VIEW_PROFILE_URL = BASE_URL + "viewProfile.php";
	public static final String UPDATE_PROFILE_URL = BASE_URL + "editProfile.php";
	public static final String SUBMIT_PROPERTY_IMAGES_URL = BASE_URL + "submitPropertyImages.php";
	public static final String COMMERCIAL_PROPERTY_PICKS_URL = BASE_URL + "commercialPropertyPicks.php";
	public static final String RESIDENTIAL_PROPERTY_PICKS_URL = BASE_URL + "residentialPropertyPicks.php";
	public static final String RETAIL_PROPERTY_PICKS_URL = BASE_URL + "retailPropertyPicks.php";
	public static final String SHORTLIST_RESIDENTIAL_URL = BASE_URL + "residentialShortlist.php";
	public static final String SHORTLIST_RETAIL_URL = BASE_URL + "retailShortlist.php";
	public static final String SHORTLIST_COMMERCIAL_URL = BASE_URL + "commercialShortlist.php";
	public static final String GET_NOTIFS_URL = BASE_URL + "getNotifications.php";
	public static final String SUBMIT_EDIT_PROPERTY_URL = BASE_URL + "submitProperty.php";
	public static final String ADD_TO_SHORTLIST_URL = BASE_URL + "addToShortlist.php";
	public static final String REMOVE_FROM_SHORTLIST_URL = BASE_URL + "removeFromShortlist.php";
	public static final String PROPERTY_DETAILS_URL = BASE_URL + "viewProperty.php";
	public static final String EDIT_PROPERTY_URL = BASE_URL + "editProperty.php";
	public static final String EDIT_REQUIREMENT_URL = BASE_URL + "editRequirements.php";
	public static final String BOOK_SITE_VISIT_URL = BASE_URL + "addBookSiteVisit.php";
	public static final String SEARCH_LISTINGS_URL = BASE_URL + "searchListing.php";
	public static final String YOUR_LISTINGS_URL = BASE_URL + "yourListing.php";
	public static final String SUBMIT_ENQUIRY_URL = BASE_URL + "submitEnquiry.php";
	public static final String PROPERTY_MATCHES_URL = BASE_URL + "matchesProperty.php";
	public static final String RELATED_PROPERTIES_URL = BASE_URL + "relatedProperties.php";
	public static final String MARK_SOLD_URL = BASE_URL + "markSold.php";
	public static final String DELETE_LISTING_URL = BASE_URL + "deleteProperty.php";
	public static final String ENQUIRING_BROKERS_URL = BASE_URL + "enquiryListing.php";
	public static final String STAR_LISTING_URL = BASE_URL + "starredUnstarred.php";
	public static final String YOUR_REQUIREMENTS_URL = BASE_URL + "yourRequirements.php";
	public static final String DELETE_REQUIREMENT_URL = BASE_URL + "deleteRequirement.php";
	public static final String VIEW_REQUIREMENT_URL = BASE_URL + "viewRequirementDetails.php";
	public static final String STAR_REQUIREMENT_URL = BASE_URL + "starredRequirements.php";
	public static final String REGISTER_NOTIFS_URL = BASE_URL + "registerNotification.php";
	public static final String UNREGISTER_NOTIFS_URL = BASE_URL + "unregisterNotification.php";


	public static final String PROFILE_PHOTO = "profilePhoto";
	public static final Map<Integer, String> areasHashMap;
	public static final String CALLED_FROM = "calledFromScreen";
	// persistent variable to remove unshortlisted item when user returns from Property Details
	// to Shortlist screen.
	public static final String UNSHORTLISTED_PROPERTY_ID = "unshortlisted_property_id";
	public static final String IS_DEVICE_REGISTERED = "isDeviceRegistered";
	public static final String DEVICE_TOKEN = "deviceToken";
	public static final String IS_APP_VISIBLE = "IS_APP_VISIBLE";
	public static final String NOTIFS_COUNT = "notifs_count";
	public static final String IS_USER_ON_NOTIF_SCREEN = "is_user_on_notif_screen";
	public static final int YOUR_REQUIREMENTS = 101;
	// these persistent variables are used across the app to track any changes user
	// may have done; based on which data will be refreshed.
	public static final String IS_PROPERTY_CHANGED = "isPropertyChanged";
	public static final String IS_REQUIREMENT_CHANGED = "isReqChanged";

	// screen names for tracking.
	public static final String SCREEN_SPLASH = "Splash Screen";
	public static final String SCREEN_SIGNUP_LOGIN = "Main Screen (Sign Up/Login)";
	public static final String SCREEN_SIGNUP = "Sign Up";
	public static final String SCREEN_LOGIN = "Login";
	public static final String SCREEN_FORGOT_PWD = "Forgot Password";
	public static final String SCREEN_HOME = "Homescreen";
	public static final String SCREEN_PROP_PICKS_RESIDENTIAL = "Property Picks - Residential";
	public static final String SCREEN_PROP_PICKS_COMMERCIAL = "Property Picks - Commercial";
	public static final String SCREEN_PROP_PICKS_RETAIL = "Property Picks - Retail";
	public static final String SCREEN_SHORTLIST_RESIDENTIAL = "Shortlist - Residential";
	public static final String SCREEN_SHORTLIST_COMMERCIAL = "Shortlist - Commercial";
	public static final String SCREEN_SHORTLIST_RETAIL = "Shortlist - Retail";
	public static final String SCREEN_SEARCH = "Search";
	public static final String SCREEN_ADV_SEARCH = "Search - advanced";
	public static final String SCREEN_SEARCH_RESULTS = "Search Results";
	public static final String SCREEN_PROP_DETAILS = "Property Details";
	public static final String SCREEN_RELATED_PROPERTES = "Property Details - Related Properties";
	public static final String SCREEN_SUBMIT_PROP_1 = "Submit Listing - Step 1";
	public static final String SCREEN_SUBMIT_PROP_2 = "Submit Listing - Step 2";
	public static final String SCREEN_SUBMIT_PROP_3 = "Submit Listing - Step 3";
	public static final String SCREEN_SUBMIT_PROP_IMAGES = "Submit Listing - Property Images";
	public static final String SCREEN_SUBMIT_REQ = "Submit requirements";
	public static final String SCREEN_YOUR_LISTINGS = "Your Listings";
	public static final String SCREEN_ENQUIRING_BROKERS = "Your Listings - Enquiries";
	public static final String SCREEN_CONTACT_BROKER = "Your Listings - Enquiries - Contact Broker";
	public static final String SCREEN_YOUR_REQ = "Your Requirements";
	public static final String SCREEN_PROPERTY_MATCHES = "Your Requirements - Matches";
	public static final String SCREEN_NOTIFICATIONS = "Notifications";
	public static final String SCREEN_SETTINGS = "Settings";

	// tracking categories
	public static final String CATEGORY_CS = "Customer Service";
	public static final String CATEGORY_MR = "Marketing";
	public static final String CATEGORY_EXIT = "Exits";
	public static final String CATEGORY_PROP_INTEREST = "Property Interest";
	public static final String CATEGORY_USAGE = "Usage related";
	public static final String CATEGORY_CONVERSIONS = "Conversions";
	public static final String CATEGORY_PROP_ACTIONS = "Property Actions";

	// tracking actions
	public static final String ACTION_PLACE_CALL = "Place call";
	public static final String ACTION_SHARE_APP = "Share App";
	public static final String ACTION_RATE_APP = "Rate App";
	public static final String ACTION_LOG_OUT = "Logout";
	public static final String ACTION_CLOSE_APP = "Close App";
	public static final String ACTION_SHORTLISTED = "Property Shortlisted";
	public static final String ACTION_REMOVE_FROM_SHORTLIST = "Property Removed From Shortlist";
	public static final String ACTION_PROP_VIEWED = "Property Viewed";
	public static final String ACTION_PROP_SEARCHED = "Property Searched";
	public static final String ACTION_SUBMIT_REQ_WHEN_EMPTY_RESULTS = "Submit requirements (empty results)";
	public static final String ACTION_ENQ_SENT = "Enquiry Sent";
	public static final String ACTION_BROKER_CONTACTED = "Broker contacted";
	public static final String ACTION_RELATED_PROP_VIEWED = "Related properties viewed";
	public static final String ACTION_PROP_SUBMITTED = "Listing Submitted";
	public static final String ACTION_REQ_SUBMITTED = "Requirement Submitted";
	public static final String ACTION_PROP_MODIFIED = "Listing Modified";
	public static final String ACTION_PROP_REMOVED = "Listing Removed";
	public static final String ACTION_TXN_COMPLETED = "Transaction completed";
	public static final String ACTION_TXN_REVERSED = "Transaction reversed";
	public static final String ACTION_ENQ_VIEWED = "Enquiries Viewed";
	public static final String ACTION_CONTACT_DETAILS_VIEWED = "Contact Details Viewed";
	public static final String ACTION_PROSPECT_CALLED = "Prospect called";
	public static final String ACTION_PROSPECT_MAILED = "Prospect emailed";
	public static final String ACTION_MATCHES_VIEWED = "Matches viewed";
	public static final String ACTION_REQ_MODIFIED = "Requirement modified";
	public static final String ACTION_REQ_REMOVED = "Requirement removed";

	// tracking labels
	public static final String LABEL_USER_ID = "UserID";
	public static final String LABEL_PROPERTY_ID = "Property ID";

	static {
		Map<Integer, String> hm = new HashMap<>();
		hm.put(1, "beyond borivali");
		hm.put(2, "beyond worli to prabhadevi");
		hm.put(3, "central mumbai");
		hm.put(4, "eastern suburbs");
		hm.put(5, "extended western suburbs");
		hm.put(6, "golden trianle (gamdevi to haji ali)");
		hm.put(7, "juhu to oshiwara");
		hm.put(8, "south mumbai (colaba to babulnath)");
		hm.put(9, "western suburbs");
		areasHashMap = Collections.unmodifiableMap(hm);
	}

	public static final Map<String, String> DEPOSIT_POSSESSION_MAP;

	static {
		Map<String, String> map = new HashMap<>();
		map.put("8", "immediate");
		map.put("1", "<3 months");
		map.put("2", "<6 months");
		map.put("3", "<1 year");
		map.put("4", ">1 year");
		map.put("5", "any");
		map.put("6", "6 months(standard practice)");
		map.put("7", "1 year");
		DEPOSIT_POSSESSION_MAP = Collections.unmodifiableMap(map);
	}

	public static final Map<String, String> CONDITION_CONSTRUCTION_MAP;

	static {
		Map<String, String> map = new HashMap<>();
		map.put("1", "any");
		map.put("2", "new");
		map.put("3", "old");
		map.put("4", "any");
		map.put("5", "furnished");
		map.put("6", "unfurnished");
		map.put("7", "fully furnished with white goods");
		CONDITION_CONSTRUCTION_MAP = Collections.unmodifiableMap(map);
	}
}
