/*
Copyright 2012 Aphid Mobile

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.aphidmobile.flip.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aphidmobile.flip.FlipViewController;
import com.aphidmobile.flip.FlipViewController.ViewFlipListener;
import com.aphidmobile.flipview.demo.R;

public class FlipCalendarActivity extends Activity {
	public static final String TAG=FlipCalendarActivity.class.getSimpleName();

	LayoutInflater mLayoutInflater;
	/**view content*/
	LinearLayout calender_content;
		
		private FlipViewController flipViewH;
			View item_h1;
				private FlipViewController flipView_h1_vl;
					View item_h1_vl_t;
					View item_h1_vl_d;
				private FlipViewController flipView_h1_vr;
					View item_h1_vr_t;
					View item_h1_vr_d;
			View item_h2;
				private FlipViewController flipView_h2_vl;
					View item_h2_vl_t;
					View item_h2_vl_d;
				private FlipViewController flipView_h2_vr;
					View item_h2_vr_t;
					View item_h2_vr_d;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.filp_calender);
    calender_content=(LinearLayout) findViewById(R.id.calender_contnet);
    mLayoutInflater=LayoutInflater.from(this);

    flipViewH=new FlipViewController(this,FlipViewController.HORIZONTAL);
	    item_h1=mLayoutInflater.inflate(R.layout.calender_column_v2, null);
	    ((TextView)item_h1.findViewById(R.id.big_page)).setText("大页大页大页111111111111111111111111111111111111111111");
		    flipView_h1_vl=(FlipViewController) item_h1.findViewById(R.id.flip_controller1);
			    item_h1_vl_t=mLayoutInflater.inflate(R.layout.calender_item_h_vl_t, null);
//			    ((TextView)item_h1_vl_t.findViewById(R.id.textView1)).setText("第一页左边01");
//			    item_h1_vl_t.setBackgroundColor(0xffff0000);
			    item_h1_vl_d=mLayoutInflater.inflate(R.layout.calender_item_h_vl_t, null);
			    ((TextView)item_h1_vl_d.findViewById(R.id.textView1)).setText("第一页左边02");
			    item_h1_vl_d.setBackgroundColor(0xffffff00);
		    flipView_h1_vr=(FlipViewController) item_h1.findViewById(R.id.flip_controller2);
				item_h1_vr_t=mLayoutInflater.inflate(R.layout.calender_item_h_vl_t, null);
//			    ((TextView)item_h1_vr_t.findViewById(R.id.textView1)).setText("第一页右边01");
//			    item_h1_vr_t.setBackgroundColor(0xff00ff00);
				item_h1_vr_d=mLayoutInflater.inflate(R.layout.calender_item_h_vl_t, null);
			    ((TextView)item_h1_vr_d.findViewById(R.id.textView1)).setText("第一页右边02");
			    item_h1_vr_d.setBackgroundColor(0xff00ffff);
	    
	    item_h2=mLayoutInflater.inflate(R.layout.calender_column_v2, null);
	    ((TextView)item_h2.findViewById(R.id.big_page)).setText("大页大页大页2222222222222222222222222222222222222222222222");
		    flipView_h2_vl=(FlipViewController) item_h2.findViewById(R.id.flip_controller1);
			    item_h2_vl_t=mLayoutInflater.inflate(R.layout.calender_item_h_vl_t, null);
//			    ((TextView)item_h2_vl_t.findViewById(R.id.textView1)).setText("第二页左边01");
//			    item_h2_vl_t.setBackgroundColor(0xff00ffff);
			    item_h2_vl_d=mLayoutInflater.inflate(R.layout.calender_item_h_vl_t, null);
			    ((TextView)item_h2_vl_d.findViewById(R.id.textView1)).setText("第二页左边02");
			    item_h2_vl_d.setBackgroundColor(0xff00ff00);
		    flipView_h2_vr=(FlipViewController) item_h2.findViewById(R.id.flip_controller2);
			    item_h2_vr_t=mLayoutInflater.inflate(R.layout.calender_item_h_vl_t, null);
//			    ((TextView)item_h2_vr_t.findViewById(R.id.textView1)).setText("第二页右边01");
//			    item_h2_vr_t.setBackgroundColor(0xffffff00);
			    item_h2_vr_d=mLayoutInflater.inflate(R.layout.calender_item_h_vl_t, null);
			    ((TextView)item_h2_vr_d.findViewById(R.id.textView1)).setText("第二页右边02");
			    item_h2_vr_d.setBackgroundColor(0xffff0000);

    setTitle(R.string.activity_title);

    initFlip(flipView_h1_vl,item_h1_vl_t,item_h1_vl_d);
    initFlip(flipView_h1_vr,item_h1_vr_d,item_h1_vr_t);
    initFlip(flipView_h2_vl,item_h2_vl_t,item_h2_vl_d);
    initFlip(flipView_h2_vr,item_h2_vr_d,item_h2_vr_t);
    initFlip(flipViewH,item_h2,item_h1);
    calender_content.addView(flipViewH);

    flipView_h1_vl.setSelection(1);
    flipView_h1_vr.setSelection(1);
	flipView_h2_vr.setSelection(1);
	flipView_h1_vr.setSelection(1);
	flipViewH.setSelection(1);


    mHandler.postDelayed(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			flipViewH.onAutoEvent(true);
		}
	}, 3000);

    addmFlipViewController(flipViewH);
//    addmFlipViewController(flipView_h2_vl);
//    addmFlipViewController(flipView_h2_vr);
    addmFlipViewController(flipViewH);
//    addmFlipViewController(flipView_h1_vl);
//    addmFlipViewController(flipView_h1_vr);
  }
  
  Handler mHandler=new Handler(){
	  @Override
	public void handleMessage(Message msg) {
		  if(msg.obj!=null){
			  FlipViewController mFlipViewController=(FlipViewController)msg.obj;
			  if(msg.obj.equals(flipView_h1_vr)||msg.obj.equals(flipView_h2_vr)){
				  mFlipViewController.onAutoEvent(true);
			  }else if(msg.obj.equals(flipViewH)){
				  if(mFlipViewController.getOrientation()==mFlipViewController.HORIZONTAL){
					  flipViewH.onAutoEvent(true);
				  }else{
					  flipViewH.onAutoEvent(false);
				  }
			  } else{
				  mFlipViewController.onAutoEvent(false);
			  }
		  }
		super.handleMessage(msg);
	}
  };
  
  int curent=0;
  List<FlipViewController>mFlipViewControllers=new ArrayList<FlipViewController>();
  
  ViewFlipListener mViewFlipListener=new ViewFlipListener() {
		
		@Override
		public void onViewFlipped(FlipViewController mFlipViewController,View view, int position) {
			if(mFlipViewController.equals(flipViewH)){//左到右 和下到上 交替
				if(flipViewH.getOrientation()==FlipViewController.HORIZONTAL){
					flipViewH.setOrientation(FlipViewController.VERTICAL);
					flipView_h1_vl.setSelection(0);
					flipView_h1_vr.setSelection(1);
				}else{
					flipViewH.setOrientation(FlipViewController.HORIZONTAL);
					flipView_h2_vl.setSelection(0);
					flipView_h2_vr.setSelection(1);
				}
			}
			curent++;
			if(curent>=mFlipViewControllers.size()){
				curent=0;
			}
			Message message=mHandler.obtainMessage();
			if(curent<mFlipViewControllers.size()){
				message.obj=mFlipViewControllers.get(curent);
			}
			mHandler.sendMessageDelayed(message, 2000);
		}
	};
	
	private void addmFlipViewController(FlipViewController mFlipViewController){
		mFlipViewControllers.add(mFlipViewController);
		mFlipViewController.setOnViewFlipListener(mViewFlipListener);
	}

  @Override
  protected void onResume() {
    super.onResume();
    flipViewH.onResume();
    flipView_h2_vl.onResume();
    flipView_h2_vr.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    flipViewH.onPause();
    flipView_h2_vl.onPause();
    flipView_h2_vr.onPause();
  }
  

	public void initFlip(FlipViewController flipView,final View item1,final View item2){

	    flipView.setAdapter(new BaseAdapter() {
	      @Override
	      public int getCount() {
	        return 2;//Integer.MAX_VALUE;
	      }

	      @Override
	      public Object getItem(int position) {
	        return position;
	      }

	      @Override
	      public long getItemId(int position) {
	        return position;
	      }

	      @Override
	      public View getView(int position, View convertView, ViewGroup parent) {
	    	  if(position%2==0){
	    		  convertView= item1;
	    	  }else{
	    		  convertView= item2;
	    	  }
	    	  return convertView;
	      }
	    });

	  }
}
