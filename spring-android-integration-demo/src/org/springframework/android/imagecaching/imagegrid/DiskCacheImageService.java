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

import java.io.File;

import org.springframework.cache.Cache;
import org.springframework.cache.disk.NoLimitDiskCache;
import org.springframework.cache.disk.core.FileTemplate;
import org.springframework.cache.disk.serializer.BitmapCacheValueSerializer;
import org.springframework.cache.disk.serializer.SimpleHashCacheKeySerializer;
import org.springframework.integration.image.core.NetworkImageService;

import android.graphics.Bitmap;

public class DiskCacheImageService extends NetworkImageService {

    public DiskCacheImageService() {
        super("DiskCacheImageService");
    }
    
    @Override
    protected Cache initCache() {
        // override to define dedicated directory for this demo
        FileTemplate<String, Bitmap> template = new FileTemplate<String, Bitmap>();
        template.setCacheValueSerializer(new BitmapCacheValueSerializer());
        template.setCacheKeySerializer(new SimpleHashCacheKeySerializer());
        File dir = new File(getBaseContext().getCacheDir(), "DiskCacheImageServiceDiskCache");
        NoLimitDiskCache<String, Bitmap> cache = new NoLimitDiskCache<String, Bitmap>("DiskCacheImageServiceDiskCache", dir, template);
        return cache;
    }

}
