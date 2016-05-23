package com.techmorphosis.qube.utils.interfaces;

import org.json.JSONObject;

/**
 * Created by Kamlesh on 017 17/10/15.
 */
public interface PushListener {
    public void onPushReceived(JSONObject jPushData);
}
