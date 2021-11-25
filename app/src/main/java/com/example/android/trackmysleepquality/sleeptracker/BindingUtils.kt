/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.sleeptracker

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight

@BindingAdapter("sleepDurationFormatted")
fun TextView.setSleepDuration(item: SleepNight?){
    item?.let {
        text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, context.resources)
    }
}

@BindingAdapter("sleepQualityString")
fun TextView.setSleepQualityString(item: SleepNight?){
    item?.let {
        text = convertNumericQualityToString(item.sleepQuality, context.resources)
    }
}

@BindingAdapter("sleepImage")
fun ImageView.setSleepImage(item: SleepNight?){
    item?.let {
        setImageResource(
            when (item.sleepQuality) {
                0 -> com.example.android.trackmysleepquality.R.drawable.ic_sleep_0
                1 -> com.example.android.trackmysleepquality.R.drawable.ic_sleep_1
                2 -> com.example.android.trackmysleepquality.R.drawable.ic_sleep_2
                3 -> com.example.android.trackmysleepquality.R.drawable.ic_sleep_3
                4 -> com.example.android.trackmysleepquality.R.drawable.ic_sleep_4
                5 -> com.example.android.trackmysleepquality.R.drawable.ic_sleep_5
                else -> com.example.android.trackmysleepquality.R.drawable.ic_sleep_active
            })
    }
}
