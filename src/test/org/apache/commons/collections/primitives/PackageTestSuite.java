/*
 * $Header: /home/cvs/jakarta-commons/primitives/src/test/org/apache/commons/collections/primitives/PackageTestSuite.java,v 1.7 2003/10/29 20:07:55 rwaldhoff Exp $
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
package org.apache.commons.collections.primitives;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Test this package.
 * 
 * @version $Revision: 1.7 $ $Date: 2003/10/29 20:07:55 $
 * @author Rodney Waldhoff
 */
public class PackageTestSuite extends TestCase {
    public PackageTestSuite(String testName) {
        super(testName);
    }

    public static void main(String args[]) {
        String[] testCaseName = { PackageTestSuite.class.getName() };
        junit.textui.TestRunner.main(testCaseName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();

        suite.addTest(TestByteCollections.suite());
        suite.addTest(TestAbstractByteCollection.suite());
        suite.addTest(TestRandomAccessByteList.suite());
        suite.addTest(TestArrayByteList.suite());

        suite.addTest(TestShortCollections.suite());
        suite.addTest(TestAbstractShortCollection.suite());
        suite.addTest(TestRandomAccessShortList.suite());
        suite.addTest(TestArrayShortList.suite());
        suite.addTest(TestArrayUnsignedByteList.suite());

        suite.addTest(TestCharCollections.suite());
        suite.addTest(TestAbstractCharCollection.suite());
        suite.addTest(TestRandomAccessCharList.suite());
        suite.addTest(TestArrayCharList.suite());

        suite.addTest(TestIntCollections.suite());
        suite.addTest(TestAbstractIntCollection.suite());
        suite.addTest(TestRandomAccessIntList.suite());
        suite.addTest(TestArrayIntList.suite());
        suite.addTest(TestArrayUnsignedShortList.suite());

        suite.addTest(TestLongCollections.suite());
		suite.addTest(TestAbstractLongCollection.suite());
		suite.addTest(TestRandomAccessLongList.suite());
        suite.addTest(TestArrayLongList.suite());
        suite.addTest(TestArrayUnsignedIntList.suite());

        suite.addTest(TestFloatCollections.suite());
        suite.addTest(TestAbstractFloatCollection.suite());
        suite.addTest(TestRandomAccessFloatList.suite());
        suite.addTest(TestArrayFloatList.suite());

        suite.addTest(TestDoubleCollections.suite());
        suite.addTest(TestAbstractDoubleCollection.suite());
        suite.addTest(TestRandomAccessDoubleList.suite());
        suite.addTest(TestArrayDoubleList.suite());

        return suite;
    }
}

