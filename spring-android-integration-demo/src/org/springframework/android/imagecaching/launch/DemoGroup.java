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

public enum DemoGroup {

    CACHE(R.string.demogroup_cache_name, R.string.demogroup_cache_desc, 
            Demo.IMAGEGRIDNOCACHE, Demo.IMAGEGRIDMEMCACHE, Demo.IMAGEGRIDDISCKCACHE, Demo.IMAGEGRIDMEMDISKCACHE, Demo.IMAGEGRIDLIMITEDMEMDISKCACHE);

    public Demo[] mDemos;
    public int mNameResId;
    public int mDescResId;

    private DemoGroup(int nameResId, int descResId, Demo ... demos) {
        mNameResId = nameResId;
        mDescResId = descResId;
        mDemos = demos;
    }

}