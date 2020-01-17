package emerge.project.onmeal.ui.adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import emerge.project.onmeal.R;
import emerge.project.onmeal.service.api.ApiClient;
import emerge.project.onmeal.service.api.ApiInterface;
import emerge.project.onmeal.ui.activity.history.ActivtyHistoryPresenter;
import emerge.project.onmeal.ui.activity.history.ActivtyHistoryPresenterImpli;
import emerge.project.onmeal.ui.activity.history.ActivtyHistorytView;
import emerge.project.onmeal.utils.entittes.OrderHistoryItems;
import emerge.project.onmeal.utils.entittes.v2.Orders.OrdersList;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Himanshu on 4/10/2015.
 */
public class HistoryPastAdapter extends RecyclerView.Adapter<HistoryPastAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<OrdersList> orderHistoryItems;
    Realm realm;
    ActivtyHistoryPresenter activtyHistoryPresenter;

    public HistoryPastAdapter(Context mContext, ArrayList<OrdersList> item,ActivtyHistorytView activtyHistorytView) {
        this.mContext = mContext;
        this.orderHistoryItems = item;
        realm = Realm.getDefaultInstance();

        activtyHistoryPresenter = new ActivtyHistoryPresenterImpli(activtyHistorytView);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_history_past, parent, false);

        return new MyViewHolder(itemView);


    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final OrdersList historyItems =orderHistoryItems.get(position);



        holder.textviewOrdernumber.setText(String.valueOf(historyItems.getOrderID()));

        holder.textviewMenus.setText("");

        holder.textviewOutlet.setText(historyItems.getOutlet());



     //   getMenue(historyItems.getOrderID(),holder);
        String dispatchType = "";
        if(historyItems.getDispatchType().equals("P")){
            dispatchType="Pick Up";
        }else if(historyItems.getDispatchType().equals("T")){
            dispatchType="Dine-In";
        }
        else {
            dispatchType="Delivery";
        }


        holder.textviewDispatchType.setText(dispatchType);


        String sPrice = String.valueOf(historyItems.getOrderTotal());
        String[] priseArray = sPrice.split("\\.");
        holder.textviewTotal.setText(priseArray[0]);
        holder.textviewTotalCents.setText("." + priseArray[1]);


        holder.relativeLayoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activtyHistoryPresenter.getOrderHistoryDetails(historyItems.getMenuItems());
            }
        });





    }



    @Override
    public int getItemCount() {
        return orderHistoryItems.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.textview_ordernumber)
        TextView textviewOrdernumber;

        @BindView(R.id.textview_menus)
        TextView textviewMenus;

        @BindView(R.id.textview_dispatch_type)
        TextView textviewDispatchType;

        @BindView(R.id.textview_total)
        TextView textviewTotal;

        @BindView(R.id.textview_total_cents)
        TextView textviewTotalCents;

        @BindView(R.id.textview_outlet)
        TextView textviewOutlet;


        @BindView(R.id.relativeLayout_main)
        RelativeLayout relativeLayoutMain;
        @BindView(R.id.textview_orderoutletdetails)
        TextView textview_orderoutletdetails;




        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }




}
