/*
 * $Header: /home/cvs/jakarta-commons/primitives/src/test/org/apache/commons/collections/primitives/decorators/BaseUnmodifiableFloatListIteratorTest.java,v 1.1 2003/10/29 20:07:54 rwaldhoff Exp $
 * ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights
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
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
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

package org.apache.commons.collections.primitives.decorators;

import org.apache.commons.collections.primitives.ArrayFloatList;
import org.apache.commons.collections.primitives.FloatIterator;
import org.apache.commons.collections.primitives.FloatList;
import org.apache.commons.collections.primitives.FloatListIterator;

/**
 * @version $Revision: 1.1 $ $Date: 2003/10/29 20:07:54 $
 * @author Rodney Waldhoff
 */
public abstract class BaseUnmodifiableFloatListIteratorTest extends BaseUnmodifiableFloatIteratorTest {

    // conventional
    // ------------------------------------------------------------------------

    public BaseUnmodifiableFloatListIteratorTest(String testName) {
        super(testName);
    }
    

    // framework
    // ------------------------------------------------------------------------

    protected abstract FloatListIterator makeUnmodifiableFloatListIterator();

    protected FloatIterator makeUnmodifiableFloatIterator() {
        return makeUnmodifiableFloatListIterator();
    }

    protected FloatIterator makeFloatIterator() {
        return makeFloatListIterator();
    }
    
    protected FloatListIterator makeFloatListIterator() {
        FloatList list = new ArrayFloatList();
        for(float i=0;i<10;i++) {
            list.add(i);
        }
        return list.listIterator();
    }

    // tests
    // ------------------------------------------------------------------------

    public final void testFloatListIteratorNotModifiable() {
        FloatListIterator iter = makeUnmodifiableFloatListIterator();
        assertTrue(iter.hasNext());
        iter.next();
        try {
            iter.remove();
            fail("Expected UnsupportedOperationException");
        } catch(UnsupportedOperationException e) {
            // expected
        }
        try {
            iter.add((float)1);
            fail("Expected UnsupportedOperationException");
        } catch(UnsupportedOperationException e) {
            // expected
        }
        try {
            iter.set((float)3);
            fail("Expected UnsupportedOperationException");
        } catch(UnsupportedOperationException e) {
            // expected
        }
    }

    public final void testIterateFloatListIterator() {        
        FloatListIterator iter = makeUnmodifiableFloatListIterator();
        FloatListIterator expected = makeFloatListIterator();
        
        assertTrue(! iter.hasPrevious());
        
        while( expected.hasNext() ) {
            assertTrue(iter.hasNext());
            assertEquals(expected.nextIndex(),iter.nextIndex());
            assertEquals(expected.previousIndex(),iter.previousIndex());
            assertEquals(expected.next(),iter.next(),(float)0);
            assertTrue(iter.hasPrevious());
            assertEquals(expected.nextIndex(),iter.nextIndex());
            assertEquals(expected.previousIndex(),iter.previousIndex());
        }

        assertTrue(! iter.hasNext() );

        while( expected.hasPrevious() ) {
            assertTrue(iter.hasPrevious());
            assertEquals(expected.nextIndex(),iter.nextIndex());
            assertEquals(expected.previousIndex(),iter.previousIndex());
            assertEquals(expected.previous(),iter.previous(),(float)0);
            assertTrue(iter.hasNext());
            assertEquals(expected.nextIndex(),iter.nextIndex());
            assertEquals(expected.previousIndex(),iter.previousIndex());
        }
        assertTrue(! iter.hasPrevious() );
    }

}