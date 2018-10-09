import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import static android.view.View.MeasureSpec.AT_MOST;
import static android.view.View.MeasureSpec.EXACTLY;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * <pre>
 *   author:ASUS
 *   email:775846180@qq.com
 *   time:2018/09/29
 *   desc:
 *   version:1.0
 * </pre>
 */
public class DemoLayout extends ViewGroup {
    public DemoLayout(Context context) {
        super(context);
    }

    int childWidthSpec;
    int usedWidth;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);

            LayoutParams lp = childView.getLayoutParams();
            int selfWidthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
            int selfWidthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
            switch (lp.width) {
                case MATCH_PARENT:
                    if (selfWidthSpecMode == EXACTLY || selfWidthSpecMode == AT_MOST) {
                        childWidthSpec = MeasureSpec.makeMeasureSpec(selfWidthSpecSize - usedWidth, EXACTLY);//可用宽度
                    } else {//UNSPECIFIED
                        childWidthSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    }
                    break;
                case WRAP_CONTENT:
                    if (selfWidthSpecMode == EXACTLY || selfWidthSpecMode == AT_MOST) {
                        childWidthSpec = MeasureSpec.makeMeasureSpec(selfWidthSpecSize - usedWidth, AT_MOST);//可用宽度
                    } else {//UNSPECIFIED
                        childWidthSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    }
                    break;
                default://固定尺寸值
                    childWidthSpec = MeasureSpec.makeMeasureSpec(lp.width, EXACTLY);
                    break;
            }
        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
