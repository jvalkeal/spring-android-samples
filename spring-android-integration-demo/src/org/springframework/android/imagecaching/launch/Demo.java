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

package org.springframework.android.imagecaching.launch;

import org.springframework.android.imagecaching.R;
import org.springframework.android.imagecaching.imagegrid.DiskCacheDemo;
import org.springframework.android.imagecaching.imagegrid.LimitedCacheDemo;
import org.springframework.android.imagecaching.imagegrid.MemCacheDemo;
import org.springframework.android.imagecaching.imagegrid.MemDiskCacheDemo;
import org.springframework.android.imagecaching.imagegrid.NoCacheDemo;

public enum Demo {

    IMAGEGRIDNOCACHE(NoCacheDemo.class, R.string.demo_imagegrid_nocache_name, R.string.demo_imagegrid_nocache_desc),
    IMAGEGRIDMEMCACHE(MemCacheDemo.class, R.string.demo_imagegrid_memcache_name, R.string.demo_imagegrid_memcache_desc),
    IMAGEGRIDDISCKCACHE(DiskCacheDemo.class, R.string.demo_imagegrid_diskcache_name, R.string.demo_imagegrid_diskcache_desc),
    IMAGEGRIDMEMDISKCACHE(MemDiskCacheDemo.class, R.string.demo_imagegrid_memdiskcache_name, R.string.demo_imagegrid_memdiskcache_desc),
    IMAGEGRIDLIMITEDMEMDISKCACHE(LimitedCacheDemo.class, R.string.demo_imagegrid_limitedmemdiskcache_name, R.string.demo_imagegrid_limitedmemdiskcache_desc);

    public Class<?> mClazz;
    public int mNameResId;
    public int mDescResId;

    private Demo(final Class<?> clazz, int nameResId, int descResId) {
        this.mClazz = clazz;
        mNameResId = nameResId;
        mDescResId = descResId;
    }

}
