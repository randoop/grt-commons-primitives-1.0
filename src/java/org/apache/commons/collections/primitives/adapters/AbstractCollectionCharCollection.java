/*
 * $Header: /home/cvs/jakarta-commons/primitives/src/java/org/apache/commons/collections/primitives/adapters/AbstractCollectionCharCollection.java,v 1.2 2003/10/14 20:04:17 scolebourne Exp $
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

import org.apache.commons.collections.primitives.CharCollection;
import org.apache.commons.collections.primitives.CharIterator;

/**
 * @since Commons Primitives 0.1
 * @version $Revision: 1.2 $ $Date: 2003/10/14 20:04:17 $
 * @author Rodney Waldhoff 
 */
abstract class AbstractCollectionCharCollection implements CharCollection {
    protected AbstractCollectionCharCollection() {
    }

    public boolean add(char element) {
        return getCollection().add(new Character(element));
    }
        
    public boolean addAll(CharCollection c) {
        return getCollection().addAll(CharCollectionCollection.wrap(c));
    }
    
    public void clear() {
        getCollection().clear();
    }

    public boolean contains(char element) {
        return getCollection().contains(new Character(element));
    }
    
    public boolean containsAll(CharCollection c) {
        return getCollection().containsAll(CharCollectionCollection.wrap(c));
    }        
    
    public String toString() {
        return getCollection().toString();
    }

    public boolean isEmpty() {
        return getCollection().isEmpty();
    }
    
    /**
     * {@link IteratorCharIterator#wrap wraps} the 
     * {@link java.util.Iterator Iterator}
     * returned by my underlying 
     * {@link Collection Collection}, 
     * if any.
     */
    public CharIterator iterator() {
        return IteratorCharIterator.wrap(getCollection().iterator());
    }
     
    public boolean removeElement(char element) {
        return getCollection().remove(new Character(element));
    }
    
    public boolean removeAll(CharCollection c) {
        return getCollection().removeAll(CharCollectionCollection.wrap(c));
    }
        
    public boolean retainAll(CharCollection c) {
        return getCollection().retainAll(CharCollectionCollection.wrap(c));
    }
    
    public int size() {
        return getCollection().size();
    }
    
    public char[] toArray() {
        Object[] src = getCollection().toArray();
        char[] dest = new char[src.length];
        for(int i=0;i<src.length;i++) {
            dest[i] = ((Character)(src[i])).charValue();
        }
        return dest;
    }
    
    public char[] toArray(char[] dest) {
        Object[] src = getCollection().toArray();
        if(dest.length < src.length) {
            dest = new char[src.length];
        }
        for(int i=0;i<src.length;i++) {
            dest[i] = ((Character)(src[i])).charValue();
        }
        return dest;
    }
    
    protected abstract Collection getCollection();
    
}
