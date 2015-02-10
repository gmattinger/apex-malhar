/*
 *  Copyright (c) 2012-2015 Malhar, Inc.
 *  All Rights Reserved.
 */

package com.datatorrent.lib.appdata.schemas.weather;

import com.datatorrent.lib.appdata.schemas.TimeBucket;
import java.util.List;

/**
 *
 * @author Timothy Farkas: tim@datatorrent.com
 */
public class WeatherDataData extends TimeBucket
{
  private List<WeatherValues> values;

  /**
   * @return the values
   */
  public List<WeatherValues> getValues()
  {
    return values;
  }

  /**
   * @param values the values to set
   */
  public void setValues(List<WeatherValues> values)
  {
    this.values = values;
  }
}