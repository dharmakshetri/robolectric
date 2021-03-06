package org.robolectric.shadows;

import android.widget.SeekBar;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;
import org.robolectric.shadow.api.Shadow;

/**
 * Shadow for {@link android.widget.SeekBar}.
 */
@Implements(SeekBar.class)
public class ShadowSeekBar extends ShadowAbsSeekBar {

  @RealObject
  private SeekBar realSeekBar;

  private SeekBar.OnSeekBarChangeListener listener;

  @Implementation
  public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener listener) {
    this.listener = listener;
    Shadow.directlyOn(realSeekBar, SeekBar.class).setOnSeekBarChangeListener(listener);
  }

  public SeekBar.OnSeekBarChangeListener getOnSeekBarChangeListener() {
    return this.listener;
  }
}
