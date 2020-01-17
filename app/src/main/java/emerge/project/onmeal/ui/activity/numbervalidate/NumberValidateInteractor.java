package emerge.project.onmeal.ui.activity.numbervalidate;


import android.content.Context;

import emerge.project.onmeal.utils.entittes.UpdateToken;

/**
 * Created by Himanshu on 4/4/2017.
 */

public interface NumberValidateInteractor {


    interface OnOTPCodeValidationFinishedListener {

        void oTPCodeMissing();
        void oTPCodeInvalid();
        void oTPCodeValid();
        void oTPCodeExpired(String code);
        void oTPCodeServerError(String error);

    }
    void validateOTPCode(String codeFromUserReg, String codeFromSMS, String userId, OnOTPCodeValidationFinishedListener onOTPCodeValidationFinishedListener);



    interface OnNewOTPCodeFinishedListener {
        void newOTPCode(String code);
        void newOTPCodeServerError(String error);

    }
    void getNewOTPCode(String userId, OnNewOTPCodeFinishedListener onNewOTPCodeFinishedListener);



    void messageReceived(String message);

    interface OnUpdatePushTokenAndAppVersionFinishedListener {
        void updateStatus(Boolean status, UpdateToken updateToken);
    }
    void updatePushTokenAndAppVersion(Context con, OnUpdatePushTokenAndAppVersionFinishedListener onUpdatePushTokenAndAppVersionFinishedListener);



}
