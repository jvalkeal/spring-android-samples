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

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

public class LaunchActivity extends ExpandableListActivity {

    private LaunchListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_demos);
        mAdapter = new LaunchListAdapter(this);
        setListAdapter(mAdapter);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View view, int groupPosition, int childPosition, long id) {
        Demo example = mAdapter.getChild(groupPosition, childPosition);
        startActivity(new Intent(this, example.mClazz));
        return super.onChildClick(parent, view, groupPosition, childPosition, id);
    }

}
