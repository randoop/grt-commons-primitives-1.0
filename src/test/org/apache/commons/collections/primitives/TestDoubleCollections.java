/*
 * $Header: /home/cvs/jakarta-commons/primitives/src/test/org/apache/commons/collections/primitives/TestDoubleCollections.java,v 1.1 2003/10/29 19:39:13 rwaldhoff Exp $
 * ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2002-2003 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowledgement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgement may appear in the software itself,
 *    if and wherever such third-party acknowledgements normally appear.
 *
 * 4. The names "The Jakarta Project", "Commons", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS DOUBLEERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.commons.collections.primitives;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @version $Revision: 1.1 $ $Date: 2003/10/29 19:39:13 $
 * @author Rodney Waldhoff
 */
public class TestDoubleCollections extends TestCase {

    //------------------------------------------------------------ Conventional

    public TestDoubleCollections(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(TestDoubleCollections.class);
    }

    //---------------------------------------------------------------- Tests

    public void testSingletonDoubleListIterator() {
        DoubleListIterator iter = DoubleCollections.singletonDoubleListIterator((double)17);
        assertTrue(!iter.hasPrevious());        
        assertTrue(iter.hasNext());        
        assertEquals(17,iter.next(),(double)0);        
        assertTrue(iter.hasPrevious());        
        assertTrue(!iter.hasNext());        
        assertEquals(17,iter.previous(),(double)0);        
        try {
            iter.set((double)18);
            fail("Expected UnsupportedOperationException");
        } catch(UnsupportedOperationException e) {
            // expected
        }
    }

    public void testSingletonDoubleIterator() {
        DoubleIterator iter = DoubleCollections.singletonDoubleIterator((double)17);
        assertTrue(iter.hasNext());        
        assertEquals(17,iter.next(),(double)0);        
        assertTrue(!iter.hasNext());        
        try {
            iter.remove();
            fail("Expected UnsupportedOperationException");
        } catch(UnsupportedOperationException e) {
            // expected
        }
    }

    public void testSingletonDoubleList() {
        DoubleList list = DoubleCollections.singletonDoubleList((double)17);
        assertEquals(1,list.size());
        assertEquals(17,list.get(0),(double)0);        
        try {
            list.add((double)18);
            fail("Expected UnsupportedOperationException");
        } catch(UnsupportedOperationException e) {
            // expected
        }
    }

    public void testUnmodifiableDoubleListNull() {
        try {
            DoubleCollections.unmodifiableDoubleList(null);
            fail("Expected NullPointerException");
        } catch(NullPointerException e) {
            // expected
        }
    }

    public void testEmptyDoubleList() {
        assertSame(DoubleCollections.EMPTY_DOUBLE_LIST,DoubleCollections.getEmptyDoubleList());
        assertTrue(DoubleCollections.EMPTY_DOUBLE_LIST.isEmpty());
        try {
            DoubleCollections.EMPTY_DOUBLE_LIST.add((double)1);
            fail("Expected UnsupportedOperationExcpetion");
        } catch(UnsupportedOperationException e) {
            // expected
        }
    }

    public void testUnmodifiableDoubleIteratorNull() {
        try {
            DoubleCollections.unmodifiableDoubleIterator(null);
            fail("Expected NullPointerException");
        } catch(NullPointerException e) {
            // expected
        }
    }

    public void testEmptyDoubleIterator() {
        assertSame(DoubleCollections.EMPTY_DOUBLE_ITERATOR,DoubleCollections.getEmptyDoubleIterator());
        assertTrue(! DoubleCollections.EMPTY_DOUBLE_ITERATOR.hasNext());
        try {
            DoubleCollections.EMPTY_DOUBLE_ITERATOR.remove();
            fail("Expected UnsupportedOperationExcpetion");
        } catch(UnsupportedOperationException e) {
            // expected
        }
    }

    public void testUnmodifiableDoubleListIteratorNull() {
        try {
            DoubleCollections.unmodifiableDoubleListIterator(null);
            fail("Expected NullPointerException");
        } catch(NullPointerException e) {
            // expected
        }
    }

    public void testEmptyDoubleListIterator() {
        assertSame(DoubleCollections.EMPTY_DOUBLE_LIST_ITERATOR,DoubleCollections.getEmptyDoubleListIterator());
        assertTrue(! DoubleCollections.EMPTY_DOUBLE_LIST_ITERATOR.hasNext());
        assertTrue(! DoubleCollections.EMPTY_DOUBLE_LIST_ITERATOR.hasPrevious());
        try {
            DoubleCollections.EMPTY_DOUBLE_LIST_ITERATOR.add((double)1);
            fail("Expected UnsupportedOperationExcpetion");
        } catch(UnsupportedOperationException e) {
            // expected
        }
    }
}

