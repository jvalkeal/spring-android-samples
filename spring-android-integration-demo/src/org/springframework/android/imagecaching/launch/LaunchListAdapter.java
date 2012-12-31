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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

class LaunchListAdapter extends BaseExpandableListAdapter {

    private static final DemoGroup[] DEMOGROUPS = { DemoGroup.CACHE };

    private final Context mContext;

    public LaunchListAdapter(Context pContext) {
        this.mContext = pContext;
    }

    @Override
    public Demo getChild(int groupPosition, int childPosition) {
        return DEMOGROUPS[groupPosition].mDemos[childPosition];
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return DEMOGROUPS[groupPosition].mDemos.length;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
            ViewGroup parent) {
        View childView;
        if (convertView != null) {
            childView = convertView;
        } else {
            childView = LayoutInflater.from(mContext).inflate(R.layout.listrow_demo, null);
        }

        ((TextView) childView.findViewById(R.id.listrow_demo_name))
                .setText(getChild(groupPosition, childPosition).mNameResId);
        ((TextView) childView.findViewById(R.id.listrow_demo_desc))
                .setText(getChild(groupPosition, childPosition).mDescResId);
        return childView;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View groupView;
        if (convertView != null) {
            groupView = convertView;
        } else {
            groupView = LayoutInflater.from(mContext).inflate(R.layout.listrow_demogroup, null);
        }

        ((TextView) groupView.findViewById(R.id.listrow_demogroup_name))
                .setText(this.getGroup(groupPosition).mNameResId);
        ((TextView) groupView.findViewById(R.id.listrow_demogroup_desc))
                .setText(this.getGroup(groupPosition).mDescResId);
        return groupView;
    }

    @Override
    public DemoGroup getGroup(int groupPosition) {
        return DEMOGROUPS[groupPosition];
    }

    @Override
    public int getGroupCount() {
        return DEMOGROUPS.length;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}