package com.ryanfermo.voterregistrationapp;

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter {
    private Activity mContext;
    List<ItemsModel> archiveList;

    public ListAdapter(Activity mContext, List<ItemsModel> archiveList) {
        super(mContext,R.layout.row_items,archiveList);
        this.mContext=mContext;
        this.archiveList=archiveList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.row_items,null,true);

        TextView president1=listItemView.findViewById(R.id.President1);
        TextView president2=listItemView.findViewById(R.id.President2);
        TextView vice1=listItemView.findViewById(R.id.VicePresident1);
        TextView vice2=listItemView.findViewById(R.id.VicePresident2);
        TextView secretary1=listItemView.findViewById(R.id.Secretary1);
        TextView secretary2=listItemView.findViewById(R.id.Secretary2);
        TextView treasurer1=listItemView.findViewById(R.id.Treasurer1);
        TextView treasurer2=listItemView.findViewById(R.id.Treasurer2);
        TextView auditor1=listItemView.findViewById(R.id.Auditor1);
        TextView auditor2=listItemView.findViewById(R.id.Auditor2);
        TextView pro1=listItemView.findViewById(R.id.PRO1);
        TextView pro2=listItemView.findViewById(R.id.PRO2);
        TextView rep1=listItemView.findViewById(R.id.REP1);
        TextView rep2=listItemView.findViewById(R.id.REP2);

        TextView president11=listItemView.findViewById(R.id.PA);
        TextView president21=listItemView.findViewById(R.id.PB);
        TextView vice11=listItemView.findViewById(R.id.VPA);
        TextView vice21=listItemView.findViewById(R.id.VPB);
        TextView secretary11=listItemView.findViewById(R.id.SA);
        TextView secretary21=listItemView.findViewById(R.id.SB);
        TextView treasurer11=listItemView.findViewById(R.id.TA);
        TextView treasurer21=listItemView.findViewById(R.id.TB);
        TextView auditor11=listItemView.findViewById(R.id.OA);
        TextView auditor21=listItemView.findViewById(R.id.OB);
        TextView pro11=listItemView.findViewById(R.id.PRA);
        TextView pro21=listItemView.findViewById(R.id.PRB);
        TextView rep11=listItemView.findViewById(R.id.REPA);
        TextView rep21=listItemView.findViewById(R.id.REPB);
        TextView ardate=listItemView.findViewById(R.id.ARDATE);

        ItemsModel archive = archiveList.get(position);

        president1.setText(Html.fromHtml("President: <b>"+archive.getPresident1()+"</b>"));
        president2.setText(Html.fromHtml("President: <b>"+archive.getPresident2()+"</b>"));
        vice1.setText(Html.fromHtml("Vice: <b>"+archive.getVice1()+"</b>"));
        vice2.setText(Html.fromHtml("Vice: <b>"+archive.getVice2()+"</b>"));
        secretary1.setText(Html.fromHtml("Secretary: <b>"+archive.getSecretary1()+"</b>"));
        secretary2.setText(Html.fromHtml("Secretary: <b>"+archive.getSecretary2()+"</b>"));
        treasurer1.setText(Html.fromHtml("Treasurer: <b>"+archive.getTreasurer1()+"</b>"));
        treasurer2.setText(Html.fromHtml("Treasurer: <b>"+archive.getTreasurer2()+"</b>"));
        auditor1.setText(Html.fromHtml("Auditor: <b>"+archive.getAuditor1()+"</b>"));
        auditor2.setText(Html.fromHtml("Auditor: <b>"+archive.getAuditor2()+"</b>"));
        pro1.setText(Html.fromHtml("PRO: <b>"+archive.getPro1()+"</b>"));
        pro2.setText(Html.fromHtml("PRO: <b>"+archive.getPro2()+"</b>"));
        rep1.setText(Html.fromHtml("Rep: <b>"+archive.getRep1()+"</b>"));
        rep2.setText(Html.fromHtml("Rep: <b>"+archive.getRep2()+"</b>"));

        president11.setText(Html.fromHtml("Tally Votes: <b>"+archive.getPresident11()+"</b>"));
        president21.setText(Html.fromHtml("Tally Votes: <b>"+archive.getPresident21()+"</b>"));
        vice11.setText(Html.fromHtml("Tally Votes: <b>"+archive.getVice11()+"</b>"));
        vice21.setText(Html.fromHtml("Tally Votes: <b>"+archive.getVice21()+"</b>"));
        secretary11.setText(Html.fromHtml("Tally Votes: <b>"+archive.getSecretary11()+"</b>"));
        secretary21.setText(Html.fromHtml("Tally Votes: <b>"+archive.getSecretary21()+"</b>"));
        treasurer11.setText(Html.fromHtml("Tally Votes: <b>"+archive.getTreasurer11()+"</b>"));
        treasurer21.setText(Html.fromHtml("Tally Votes: <b>"+archive.getTreasurer21()+"</b>"));
        auditor11.setText(Html.fromHtml("Tally Votes: <b>"+archive.getAuditor11()+"</b>"));
        auditor21.setText(Html.fromHtml("Tally Votes: <b>"+archive.getAuditor21()+"</b>"));
        pro11.setText(Html.fromHtml("Tally Votes: <b>"+archive.getPro11()+"</b>"));
        pro21.setText(Html.fromHtml("Tally Votes: <b>"+archive.getPro21()+"</b>"));
        rep11.setText(Html.fromHtml("Tally Votes: <b>"+archive.getRep11()+"</b>"));
        rep21.setText(Html.fromHtml("Tally Votes: <b>"+archive.getRep21()+"</b>"));

        ardate.setText(archive.getArdate());

        return listItemView;
    }
}
