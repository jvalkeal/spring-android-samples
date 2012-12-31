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

import org.springframework.android.imagecaching.CustomApp;
import org.springframework.integration.image.BitmapManager;

/**
 * Demonstrates settings where disk cache is limited to 75% of total number of
 * images and memory cache is limited to 50% of total number of images.
 * <p>
 * This should demonstrate that while cache misses from memory cache is
 * considerable high, actual downloads should not happen that frequently because
 * disk cache is able to keep 50% more images on disk that what is kept in
 * memory.
 * 
 * @author Janne Valkealahti
 */
public class LimitedCacheDemo extends BaseImageGridActivity {

    @Override
    protected BitmapManager getBitmapManager() {
        return CustomApp.get().getLimitedCacheBitmapManager();
    }

}
