/*
 *  Copyright (c) 2012-2015 Malhar, Inc.
 *  All Rights Reserved.
 */

package com.datatorrent.lib.appdata.schemas;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 *
 * @author Timothy Farkas: tim@datatorrent.com
 */
public class DataQueryTabularDeserializerTest
{
  @Test
  public void simpleDeserializerTest()
  {
    DataQueryTabularDeserializer deserializer = new DataQueryTabularDeserializer();

    String queryJSON = "{\n"
                       + "   \"id\": \"1\",\n"
                       + "   \"type\": \"dataQuery\",\n"
                       + "   \"data\": {\n"
                       + "      \"fields\": [ \"url\", \"count\" ]\n"
                       + "   }\n"
                       + "}";

    DataQueryTabular gQuery = (DataQueryTabular) deserializer.deserialize(queryJSON, null);

    Assert.assertEquals("The id must equal.", "1", gQuery.getId());
    Assert.assertEquals("The type must equal.", DataQueryTabular.TYPE, gQuery.getType());

    Fields fields = new Fields(Sets.newHashSet("url", "count"));

    Assert.assertEquals("The fields must equal.", fields, gQuery.getFields());
  }


  @Test
  public void simpleDeserializerWithSchemaKeysTest()
  {
    final Map<String, String> expectedSchemaKeys = Maps.newHashMap();
    expectedSchemaKeys.put("publisher", "google");
    expectedSchemaKeys.put("advertiser", "microsoft");
    expectedSchemaKeys.put("location", "CA");

    DataQueryTabularDeserializer deserializer = new DataQueryTabularDeserializer();

    String queryJSON = "{\n"
                       + "   \"id\": \"1\",\n"
                       + "   \"type\": \"dataQuery\",\n"
                       + "   \"data\": {\n"
                       + "      \"schemaKeys\":"
                       + "      {\"publisher\":\"google\",\"advertiser\":\"microsoft\",\"location\":\"CA\"},"
                       + "      \"fields\": [ \"url\", \"count\" ]\n"
                       + "   }\n"
                       + "}";

    DataQueryTabular gQuery = (DataQueryTabular) deserializer.deserialize(queryJSON, null);

    Assert.assertEquals("The id must equal.", "1", gQuery.getId());
    Assert.assertEquals("The type must equal.", DataQueryTabular.TYPE, gQuery.getType());

    Fields fields = new Fields(Sets.newHashSet("url", "count"));

    Assert.assertEquals("The fields must equal.", fields, gQuery.getFields());
    Assert.assertEquals(expectedSchemaKeys, gQuery.getSchemaKeys());
  }
}
