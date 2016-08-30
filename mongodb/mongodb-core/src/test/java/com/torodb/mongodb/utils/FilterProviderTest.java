/*
 *     This file is part of ToroDB.
 *
 *     ToroDB is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ToroDB is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with ToroDB. If not, see <http://www.gnu.org/licenses/>.
 *
 *     Copyright (c) 2014, 8Kdata Technology
 *     
 */

package com.torodb.mongodb.utils;

import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class FilterProviderTest {
    
    @Test
    public void unfilteredTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of());
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "three"));
    }
    
    @Test
    public void whitelistDatabaseTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(Pattern.compile("test"), ImmutableList.of()), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of());
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "three"));
    }
    
    @Test
    public void blacklistDatabaseTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(Pattern.compile("test"), ImmutableList.of()));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "three"));
    }
    
    @Test
    public void whitelistAndBlacklistSameDatabaseTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(Pattern.compile("test"), ImmutableList.of()), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(Pattern.compile("test"), ImmutableList.of()));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "three"));
    }
    
    @Test
    public void whitelistAndBlacklistTwoDatabasesTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(Pattern.compile("test"), ImmutableList.of()), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(Pattern.compile("test1"), ImmutableList.of()));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "three"));
    }
    
    @Test
    public void whitelistCollectionTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(Pattern.compile("test"), ImmutableList.of(Pattern.compile("one"))), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of());
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "three"));
    }
    
    @Test
    public void blacklistCollectionTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(Pattern.compile("test"), ImmutableList.of(Pattern.compile("one"))));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "three"));
    }
    
    @Test
    public void whitelistAndBlacklistSameCollectionTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(Pattern.compile("test"), ImmutableList.of(Pattern.compile("one"))), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(Pattern.compile("test"), ImmutableList.of(Pattern.compile("one"))));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "three"));
    }
    
    @Test
    public void whitelistCollectionInAllDatabasesTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(Pattern.compile(".*"), ImmutableList.of(Pattern.compile("one"))), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of());
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "three"));
    }
    
    @Test
    public void blacklistCollectionInAllDatabasesTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(Pattern.compile(".*"), ImmutableList.of(Pattern.compile("one"))));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "three"));
    }
    
    @Test
    public void whitelistCollectionInAllDatabasesAndAnotherCollectionTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(
                        Pattern.compile(".*"), ImmutableList.of(Pattern.compile("one")),
                        Pattern.compile("test"), ImmutableList.of(Pattern.compile("two"))), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of());
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "three"));
    }
    
    @Test
    public void blacklistCollectionInAllDatabasesAndAnotherCollectionTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(
                        Pattern.compile(".*"), ImmutableList.of(Pattern.compile("one")),
                        Pattern.compile("test"), ImmutableList.of(Pattern.compile("two"))));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("other", "three"));
    }
    
    
    @Test
    public void whitelistAllInADatabaseAndBlacklistCollectionTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(
                        Pattern.compile("test"), ImmutableList.of(Pattern.compile(".*"))), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(
                        Pattern.compile("test"), ImmutableList.of(Pattern.compile("one"))));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "three"));
    }
    
    @Test
    public void whitelistAllInADatabaseAndBlacklistSomeCollectionsTest() {
        FilterProvider filterProvider = new FilterProvider(
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(
                        Pattern.compile("test"), ImmutableList.of(Pattern.compile(".*"))), 
                ImmutableMap.<Pattern, ImmutableList<Pattern>>of(
                        Pattern.compile("test"), ImmutableList.of(Pattern.compile("t.*"))));
        Assert.assertTrue(filterProvider.getDatabasePredicate().test("test"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("test1"));
        Assert.assertFalse(filterProvider.getDatabasePredicate().test("other"));
        Assert.assertTrue(filterProvider.getCollectionPredicate().test("test", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("test1", "three"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "one"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "two"));
        Assert.assertFalse(filterProvider.getCollectionPredicate().test("other", "three"));
    }
}
