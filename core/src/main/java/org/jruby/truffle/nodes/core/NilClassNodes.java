/*
 * Copyright (c) 2013, 2014 Oracle and/or its affiliates. All rights reserved. This
 * code is released under a tri EPL/GPL/LGPL license. You can use it,
 * redistribute it and/or modify it under the terms of the:
 *
 * Eclipse Public License version 1.0
 * GNU General Public License version 2
 * GNU Lesser General Public License version 2.1
 */
package org.jruby.truffle.nodes.core;

import com.oracle.truffle.api.source.*;
import com.oracle.truffle.api.dsl.*;
import org.jruby.truffle.runtime.*;
import org.jruby.truffle.runtime.core.*;

@CoreClass(name = "NilClass")
public abstract class NilClassNodes {

    @CoreMethod(names = "!", needsSelf = false)
    public abstract static class NotNode extends CoreMethodNode {

        public NotNode(RubyContext context, SourceSection sourceSection) {
            super(context, sourceSection);
        }

        public NotNode(NotNode prev) {
            super(prev);
        }

        @Specialization
        public boolean not() {
            return true;
        }
    }

    @CoreMethod(names = {"==", "eql?"}, needsSelf = false, required = 1, optional = 0)
    public abstract static class EqualNode extends CoreMethodNode {

        public EqualNode(RubyContext context, SourceSection sourceSection) {
            super(context, sourceSection);
        }

        public EqualNode(EqualNode prev) {
            super(prev);
        }

        @Specialization
        public boolean equal(Object b) {
            notDesignedForCompilation();

            return b instanceof RubyNilClass || b instanceof RubyNilClass;
        }

    }

    @CoreMethod(names = "!=", needsSelf = false, required = 1, optional = 0)
    public abstract static class NotEqualNode extends CoreMethodNode {

        public NotEqualNode(RubyContext context, SourceSection sourceSection) {
            super(context, sourceSection);
        }

        public NotEqualNode(NotEqualNode prev) {
            super(prev);
        }

        @Specialization
        public boolean equal(Object b) {
            return !(b == getContext().getCoreLibrary().getNilObject() || b instanceof RubyNilClass);
        }

    }

    @CoreMethod(names = "inspect", needsSelf = false)
    public abstract static class InpsectNode extends CoreMethodNode {

        public InpsectNode(RubyContext context, SourceSection sourceSection) {
            super(context, sourceSection);
        }

        public InpsectNode(InpsectNode prev) {
            super(prev);
        }

        @Specialization
        public RubyString inspect() {
            return getContext().makeString("nil");
        }
    }

    @CoreMethod(names = "nil?", needsSelf = false)
    public abstract static class NilNode extends CoreMethodNode {

        public NilNode(RubyContext context, SourceSection sourceSection) {
            super(context, sourceSection);
        }

        public NilNode(NilNode prev) {
            super(prev);
        }

        @Specialization
        public boolean nil() {
            return true;
        }
    }

    @CoreMethod(names = "to_a", needsSelf = false)
    public abstract static class ToANode extends CoreMethodNode {

        public ToANode(RubyContext context, SourceSection sourceSection) {
            super(context, sourceSection);
        }

        public ToANode(ToANode prev) {
            super(prev);
        }

        @Specialization
        public RubyArray toA() {
            return new RubyArray(getContext().getCoreLibrary().getArrayClass(), null, 0);
        }
    }

    @CoreMethod(names = "to_i", needsSelf = false)
    public abstract static class ToINode extends CoreMethodNode {

        public ToINode(RubyContext context, SourceSection sourceSection) {
            super(context, sourceSection);
        }

        public ToINode(ToINode prev) {
            super(prev);
        }

        @Specialization
        public int toI() {
            return 0;
        }
    }

    @CoreMethod(names = "to_s", needsSelf = false)
    public abstract static class ToSNode extends CoreMethodNode {

        public ToSNode(RubyContext context, SourceSection sourceSection) {
            super(context, sourceSection);
        }

        public ToSNode(ToSNode prev) {
            super(prev);
        }

        @Specialization
        public RubyString toS() {
            return getContext().makeString("");
        }
    }

}
