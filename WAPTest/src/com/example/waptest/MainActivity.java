//  Diary - Personal diary for Android
//  Copyright © 2012  Josep Portella Florit <hola@josep-portella.com>
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

package com.example.waptest;

import com.javacodegeeks.kannel.api.SMSManager;

import android.app.Activity;


public class MainActivity extends Activity {
  
    protected void onCreate() {
    	SMSManager smsManager = SMSManager.getInstance();

    }
    
    protected void onSaveInstanceState() {

    }

    public void onPause() {
      
    }

    protected void onResume(){
    
    }

  

  
}