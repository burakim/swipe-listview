# swipe-listview

 [ ![Download](https://api.bintray.com/packages/burakim/maven/swipe-listview/images/download.svg) ](https://bintray.com/burakim/maven/swipe-listview/_latestVersion)
 [![License Apache](https://img.shields.io/badge/license-Apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
## Swipe-ListView Demo
![Demo animation](https://raw.githubusercontent.com/burakim/swipe-listview/master/images/im1.gif)


A customisable android listview that consist of swipeable rows.

  - Fast and easily customizable listview
  - powered by new recycler view
  - Highly optimized for complex row views.
  - Smooth swipe features in each rows

If you are interested in swipe-listview, you can get more information about how I develop it from [my personal website](http://www.yesilyurt.info)


### Version
0.0.1
- Swipe feature implemented.
- Basic scrolling features implemented.

### Installation

You need add dependecy line to your project build.gradle file:

```sh
compile(group: 'com.burakim', name: 'swipelistview', version: '0.0.1', ext: 'pom', ')
```

Sample swipe-listview usage
First you need to add  custom view to your activity xml file
```xml
<com.burakim.swipelistview.SwipeListView
        xmlns:burakim="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:id="@+id/swipelistview"
        burakim:rowheight="120"
        android:layout_height="match_parent">
    </com.burakim.swipelistview.SwipeListView>
```  
At this point, rowheight attribute defines row height of each row in the swipe listview.
Besides, below code should be in where you want to use, i.e activity classes.
```java
        swipeListView = (SwipeListView) findViewById(R.id.swipelist);
        swipeListView.setActionInterface(this);
        swipeListView.setItemSize(50);
        swipeListView.setHasFixedSize(true);
```
setItemSize sets size of item, for example if you want to insert 50 amount rows, you should set 50 in item size. 

Important point is usage of SwipeListViewActions interface. This interface involves only one callback function that named setView and it takes three argument that are ViewGroup container,int position, int side.
Whenever each side of each row starts to create it's view, this callback calls in order to get view from developer. 
To illustrate what I said;
```java
@Override
    public View setView(ViewGroup container,int position, int side) {
        View view = null;
        switch (side)
        {
            case 0:
            {
             view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_firstview,container,false);
                break;
            }
            case 1:
            {
                view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_secondview,container,false);
                break;
            }
        }
        return view;
    }
```

"side" variable represents swipe side and 0 for unswipped row and 1 for swipped row. 

"position" variable represents which row is gonna be created. 

Furthermore, ViewGroup "container" is parent view that stores rows.


That's it, more power to you!

## Copyright Notice ##
``` text
Copyright (C) 2016 Burak Yesilyurt

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 ```

