/**
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.rhealabs.keyboard.dictionarypack;

import com.rhealabs.keyboard.latin.utils.FragmentUtils;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Preference screen.
 */
public final class DictionarySettingsActivity extends PreferenceActivity {
    private static final String DEFAULT_FRAGMENT = DictionarySettingsFragment.class.getName();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Intent getIntent() {
        final Intent modIntent = new Intent(super.getIntent());
        modIntent.putExtra(EXTRA_SHOW_FRAGMENT, DEFAULT_FRAGMENT);
        modIntent.putExtra(EXTRA_NO_HEADERS, true);
        // Important note : the original intent should contain a String extra with the key
        // DictionarySettingsFragment.DICT_SETTINGS_FRAGMENT_CLIENT_ID_ARGUMENT so that the
        // fragment can know who the client is.
        return modIntent;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public boolean isValidFragment(String fragmentName) {
        return FragmentUtils.isValidFragment(fragmentName);
    }
}
