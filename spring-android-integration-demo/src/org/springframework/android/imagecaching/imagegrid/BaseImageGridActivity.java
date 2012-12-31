/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.android.imagecaching.imagegrid;

import java.util.Map;

import org.springframework.android.imagecaching.AppConstants;
import org.springframework.android.imagecaching.R;
import org.springframework.integration.image.BitmapManager;
import org.springframework.integration.image.BitmapObserver;
import org.springframework.integration.image.support.ImageOptions;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public abstract class BaseImageGridActivity extends Activity {

    private LayoutInflater mInflater;
    private BitmapObserver mBitmapObserver;
    private GridView mGridView;
    private Bitmap mLoadingBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        
        String baseUrl = getResources().getString(R.string.base_server_url);
        
        String[] urls = new String[AppConstants.TOTAL_NUMBER_IMAGES];
        for(int i = 0; i<AppConstants.TOTAL_NUMBER_IMAGES; i++) {
            urls[i] = baseUrl + (i+1) + ".png";
        }
        
        mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        mGridView = (GridView) findViewById(R.id.gridView);
        mGridView.setAdapter(new ImageAdapter(urls));        
        mBitmapObserver = new BitmapChangeObserver();
        mLoadingBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.loading);
    }
    
    protected abstract BitmapManager getBitmapManager();
    
    @Override
    protected void onResume() {
        super.onResume();
        getBitmapManager().registerBitmapObserver(mBitmapObserver);
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        getBitmapManager().unregisterBitmapObserver(mBitmapObserver);
    }
    
    public class ImageAdapter extends BaseAdapter {
        
        final String[] mImageUrls;
        
        public ImageAdapter(String[] imageUrls) {
            mImageUrls = imageUrls;
        }
        
        @Override
        public int getCount() {
            return mImageUrls.length;
        }

        @Override
        public String getItem(int position) {
            return mImageUrls[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            
            final ImageView image;
            
            if (convertView == null) {
                image = (ImageView) mInflater.inflate(R.layout.grid_item, parent, false);
            } else {
                image = (ImageView) convertView;
            }
            
            ImageOptions options = new ImageOptions.Builder()
                .withUrl(getItem(position))
                .addTag("position", Integer.toString(position))
                .build();
            
            Bitmap logo = getBitmapManager().requestBitmap(options).get();
            
            if(logo != null) {
                image.setImageBitmap(logo);                
            } else {
                image.setImageBitmap(mLoadingBitmap);
            }

            return image;
        }
        
    }
        
    private class BitmapChangeObserver extends BitmapObserver {
        @Override
        public void onBitmap(final Bitmap bitmap, final Map<String, String> tags) {
            final int position = Integer.parseInt(tags.get("position"));            
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    final int first = mGridView.getFirstVisiblePosition();
                    final int last = mGridView.getLastVisiblePosition();                    
                    if(position >= first && position <= last) {
                        View childAt = mGridView.getChildAt(position-first);
                        ImageView image = (ImageView) childAt.findViewById(R.id.image);
                        image.setImageBitmap(bitmap);
                    }
                }
            });            
        }
    }

}
