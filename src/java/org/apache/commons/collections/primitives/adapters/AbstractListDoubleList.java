/*
 * $Header: /home/cvs/jakarta-commons/primitives/src/java/org/apache/commons/collections/primitives/adapters/AbstractListDoubleList.java,v 1.3 2003/10/16 20:49:38 scolebourne Exp $
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

package org.apache.commons.collections.primitives.adapters;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.primitives.DoubleCollection;
import org.apache.commons.collections.primitives.DoubleIterator;
import org.apache.commons.collections.primitives.DoubleList;
import org.apache.commons.collections.primitives.DoubleListIterator;

/**
 *
 * @since Commons Primitives 1.0
 * @version $Revision: 1.3 $ $Date: 2003/10/16 20:49:38 $
 * @author Rodney Waldhoff 
 */
abstract class AbstractListDoubleList extends AbstractCollectionDoubleCollection implements DoubleList {

    public void add(int index, double element) {
        getList().add(index,new Double(element));
    }

    public boolean addAll(int index, DoubleCollection collection) {
        return getList().addAll(index,DoubleCollectionCollection.wrap(collection));
    }

    public double get(int index) {
        return ((Number)getList().get(index)).doubleValue();
    }

    public int indexOf(double element) {
        return getList().indexOf(new Double(element));
    }

    public int lastIndexOf(double element) {
        return getList().lastIndexOf(new Double(element));
    }

    /**
     * {@link ListIteratorDoubleListIterator#wrap wraps} the 
     * {@link DoubleList DoubleList} 
     * returned by my underlying 
     * {@link DoubleListIterator DoubleListIterator},
     * if any.
     */
    public DoubleListIterator listIterator() {
        return ListIteratorDoubleListIterator.wrap(getList().listIterator());
    }

    /**
     * {@link ListIteratorDoubleListIterator#wrap wraps} the 
     * {@link DoubleList DoubleList} 
     * returned by my underlying 
     * {@link DoubleListIterator DoubleListIterator},
     * if any.
     */
    public DoubleListIterator listIterator(int index) {
        return ListIteratorDoubleListIterator.wrap(getList().listIterator(index));
    }

    public double removeElementAt(int index) {
        return ((Number)getList().remove(index)).doubleValue();
    }

    public double set(int index, double element) {
        return ((Number)getList().set(index,new Double(element))).doubleValue();
    }

    public DoubleList subList(int fromIndex, int toIndex) {
        return ListDoubleList.wrap(getList().subList(fromIndex,toIndex));
    }

    public boolean equals(Object obj) {
        if(obj instanceof DoubleList) {
            DoubleList that = (DoubleList)obj;
            if(this == that) {
                return true;
            } else if(this.size() != that.size()) {
                return false;            
            } else {
                DoubleIterator thisiter = iterator();
                DoubleIterator thatiter = that.iterator();
                while(thisiter.hasNext()) {
                    if(thisiter.next() != thatiter.next()) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }
        
    public int hashCode() {
        return getList().hashCode();
    }
    
    final protected Collection getCollection() {
        return getList();
    }
    
    abstract protected List getList();
}
