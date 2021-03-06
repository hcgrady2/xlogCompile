/*
* Tencent is pleased to support the open source community by making Mars available.
* Copyright (C) 2016 THL A29 Limited, a Tencent company. All rights reserved.
*
* Licensed under the MIT License (the "License"); you may not use this file except in 
* compliance with the License. You may obtain a copy of the License at
* http://opensource.org/licenses/MIT
*
* Unless required by applicable law or agreed to in writing, software distributed under the License is
* distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
* either express or implied. See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.tencent.mars.xlogsample;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tencent.mars.xlog.Xlog;
import com.tencent.mars.xlog.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String logPath = Environment.getExternalStorageDirectory().getPath() + "/logsample/xlog";
        Xlog xlog = new Xlog();
        Log.setLogImp(xlog);
        Log.setConsoleLogOpen(true);
      //  Log.appenderOpen(Xlog.LEVEL_DEBUG, Xlog.AppednerModeAsync, "", logPath, "LOGSAMPLE", 0);

        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText("test");

   //     public static void open(boolean isLoadLib, int level, int mode, String cacheDir, String logDir, String nameprefix, String pubkey) {

            Xlog.open(false,Xlog.LEVEL_DEBUG,Xlog.AppednerModeAsync,"",logPath,"namePreFix","qqwe");

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("c++_shared");
        System.loadLibrary("marsxlog");
    }
}
