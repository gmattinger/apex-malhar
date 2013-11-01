/*
 * Copyright (c) 2013 DataTorrent, Inc. ALL Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datatorrent.contrib.frauddetect;

/**
 * POJO to capture transaction data related to min, max, sma, std-dev, variance.
 *
 */
public class TransactionStatsData
{
  public String merchantId;
  public int terminalId;
  public int zipCode;
  public MerchantTransaction.MerchantType merchantType;
  public long min;
  public long max;
  public double sma;
  public long time;
}