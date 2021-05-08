/**
 * Copyright (C) 2020 Fernando Cejas Open Source Project
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
package com.example.myapplication.core.platform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.core.extension.inTransaction
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Base Activity class with helper methods for handling fragment transactions and back button
 * events.
 *
 * @see AppCompatActivity
 */
@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        setSupportActionBar(toolbar)
        addFragment(savedInstanceState)
    }

    /** Handling the on-Back pressed  **/
    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    /** Adding a fragment for the screen **/
    private fun addFragment(savedInstanceState: Bundle?) =
        savedInstanceState ?: supportFragmentManager.inTransaction {
            add(
                R.id.fragmentContainer,
                fragment()
            )
        }

    /** This is a abstract class because a activity must have at-least one fragment
     *  Since this is a abstract method in the parent class, The child class must over-ride this
     */
    abstract fun fragment(): BaseFragment
}
