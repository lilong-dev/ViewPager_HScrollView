## ViewPager_HScrollView
HorizontalScrollView嵌套ViewPager时，ViewPager的滑动失效，默认只有HorizontalScrollView的滑动有效。效果如下：<br>
<img src="viewpager.gif" width=375 height=557 /><br>
解决这种问题可以自定义ViewPager，在ViewPager的dispatchTouchEvent（MotionEvent e）方法中进行设置，
