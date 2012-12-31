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

package org.springframework.android.imagecaching;

import org.springframework.android.imagecaching.imagegrid.DiskCacheBitmapManager;
import org.springframework.android.imagecaching.imagegrid.LimitedCacheBitmapManager;
import org.springframework.android.imagecaching.imagegrid.MemCacheBitmapManager;
import org.springframework.android.imagecaching.imagegrid.MemDiskCacheBitmapManager;
import org.springframework.android.imagecaching.imagegrid.NoCacheBitmapManager;

import android.app.Application;

public class CustomApp extends Application {

    private static CustomApp sInstance;
    private NoCacheBitmapManager mNoCacheBitmapManager;
    private MemCacheBitmapManager mMemCacheBitmapManager;
    private DiskCacheBitmapManager mDiskCacheBitmapManager;
    private MemDiskCacheBitmapManager mMemDiskCacheBitmapManager;
    private LimitedCacheBitmapManager mLimitedCacheBitmapManager;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
    
    public static CustomApp get() {
        return sInstance;
    }

    public NoCacheBitmapManager getNoCacheBitmapManager() {
        if (mNoCacheBitmapManager == null) {
            mNoCacheBitmapManager = new NoCacheBitmapManager(getBaseContext());
        }
        return mNoCacheBitmapManager;
    }

    public MemCacheBitmapManager getMemCacheBitmapManager() {
        if (mMemCacheBitmapManager == null) {
            mMemCacheBitmapManager = new MemCacheBitmapManager(getBaseContext());
        }
        return mMemCacheBitmapManager;
    }

    public DiskCacheBitmapManager getDiskCacheBitmapManager() {
        if (mDiskCacheBitmapManager == null) {
            mDiskCacheBitmapManager = new DiskCacheBitmapManager(getBaseContext());
        }
        return mDiskCacheBitmapManager;
    }

    public MemDiskCacheBitmapManager getMemDiskCacheBitmapManager() {
        if (mMemDiskCacheBitmapManager == null) {
            mMemDiskCacheBitmapManager = new MemDiskCacheBitmapManager(getBaseContext());
        }
        return mMemDiskCacheBitmapManager;
    }

    public LimitedCacheBitmapManager getLimitedCacheBitmapManager() {
        if (mLimitedCacheBitmapManager == null) {
            mLimitedCacheBitmapManager = new LimitedCacheBitmapManager(getBaseContext());
        }
        return mLimitedCacheBitmapManager;
    }

}
