package emerge.project.onmeal.ui.activity.favorites;


import android.content.Context;

import java.util.ArrayList;

import emerge.project.onmeal.ui.activity.splash.SplashInteractor;
import emerge.project.onmeal.ui.activity.splash.SplashInteractorImpil;
import emerge.project.onmeal.ui.activity.splash.SplashPresenter;
import emerge.project.onmeal.ui.activity.splash.SplashView;
import emerge.project.onmeal.utils.entittes.HomeFavouriteItems;

/**
 * Created by Himanshu on 4/4/2017.
 */

public class FavPresenterImpli implements FavPresenter,FavInteractor.OnFavouriteItemsLoadFinishedListener,FavInteractor.OnsignOutinishedListener {


    private FavView favView;
    FavInteractor favInteractor;


    public FavPresenterImpli(FavView favview) {
        this.favView = favview;
        this.favInteractor = new FavInteractorImpil();

    }







    @Override
    public void getFavouriteItems(Context appContext) {
        favInteractor.getFavouriteItems( appContext,this);
    }

    @Override
    public void getFavouriteItemsEmpty() {
        favView.getFavouriteItemsEmpty();
    }

    @Override
    public void getFavouriteItemsSuccessful(ArrayList<HomeFavouriteItems> favouriteItemsArrayList) {
        favView.getFavouriteItemsSuccessful(favouriteItemsArrayList);
    }

    @Override
    public void getFavouriteItemsFail(String msg) {
        favView.getFavouriteItemsFail(msg);
    }


    @Override
    public void signOut(Context context) {
        favInteractor.signOut(context,this);
    }


    @Override
    public void signOutSuccess() {
        favView.signOutSuccess();
    }
}
